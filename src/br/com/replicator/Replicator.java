package br.com.replicator;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.replicator.contracts.IReplicator;
import br.com.replicator.contracts.IReplicatorProvider;
import br.com.replicator.database.ConnectionInfo;
import br.com.replicator.database.query.contracts.IQuery;
import br.com.replicator.exceptions.InvalidDatabaseTypeException;
import br.com.replicator.exceptions.InvalidQueryAttributesException;

public class Replicator implements IReplicator {
	private ConnectionInfo originConnInfo;
	private ConnectionInfo destinationConnInfo;
	
	private IReplicatorProvider originProvider;
	private IReplicatorProvider destinationProvider;
	
	public Replicator(ConnectionInfo originConnInfo, ConnectionInfo destinationConnInfo) throws SQLException, InvalidDatabaseTypeException {
		this.originConnInfo = originConnInfo;
		this.destinationConnInfo = destinationConnInfo;
		
		originProvider = new ReplicatorProvider(this.originConnInfo);
		destinationProvider = new ReplicatorProvider(this.destinationConnInfo);
	}
	
	public List<IQuery> getQueriesForReplication(
			String originTableName,
			String destinationTableName,
			String tableUniqueKey,
			String replicationColumnControl,
			Object replicationControlValue
	) throws InvalidQueryAttributesException, SQLException {
		List<IQuery> queries = new ArrayList<IQuery>();
		
		//INSERT AND UPDATE QUERIES
		//Baseado na coluna de controle de replica��o,
		//busca todos os registro com valor maior que "replicationControlValue"
		IQuery queryFindNewestRecords = originProvider.getQueryBuilder().find(
				originTableName,
				replicationColumnControl,
				">",
				replicationControlValue.toString(),
				"*"
		);
		ResultSet rstFindNewestRecords = originProvider.getProcessor().execute(queryFindNewestRecords);
		
		while (rstFindNewestRecords.next()) {
			//Faz consulta no banco de destino atrav�s "replicationControlValue",
			//para verificar se o registro j� existe
			IQuery queryFindRecord = destinationProvider.getQueryBuilder().find(destinationTableName, tableUniqueKey, "=", rstFindNewestRecords.getString(tableUniqueKey), "*");
			ResultSet rstFindRecord = destinationProvider.getProcessor().execute(queryFindRecord);
			
			//Metadados da consulta de origem
			ResultSetMetaData rstmdFindNewestRecords = rstFindNewestRecords.getMetaData();
			
			//Crias as listas com colunas e valores que ser�o usados para gerar as queries de resposta
			String[] columns = new String[rstmdFindNewestRecords.getColumnCount()];
			String[] values = new String[rstmdFindNewestRecords.getColumnCount()];
			int[] types = new int[rstmdFindNewestRecords.getColumnCount()];
			
			for (int i = 1; i <= rstmdFindNewestRecords.getColumnCount(); i++) {
				columns[i-1] = rstmdFindNewestRecords.getColumnName(i);
				types[i-1] = rstmdFindNewestRecords.getColumnType(i);
				values[i-1] = rstFindNewestRecords.getString(i);
			}
			
			//Se o registro j� existe na tabela de destino, uma query "update" � criada
			if (rstFindRecord.next()) {
				//Update
				queries.add(destinationProvider.getQueryBuilder()
						.update(destinationTableName, columns, values, types, tableUniqueKey, rstFindNewestRecords.getString(tableUniqueKey))
				);
			} else {
				queries.add(destinationProvider.getQueryBuilder()
						.insert(destinationTableName, columns, values, types)
				);
			}
		}
		
		//DELETE QUERIES
		//Recupera todos "tableUniqueKey" da tabela de origem
		IQuery querySelectUniqueKeys = originProvider.getQueryBuilder().select(originTableName, tableUniqueKey);
		ResultSet rstSelectUniqueKeys = originProvider.getProcessor().execute(querySelectUniqueKeys);
		
		List<String> originUniqueKeys = new ArrayList<String>();
		while (rstSelectUniqueKeys.next()) {
			originUniqueKeys.add(rstSelectUniqueKeys.getString(tableUniqueKey));
		}
		
		//Faz uma consulta na tabela de destino procurando por tableUniqueKey removidos
		if (originUniqueKeys.size() > 0) {
			IQuery querySelectUnexistentUniqueKeys = destinationProvider.getQueryBuilder()
					.findNotIn(destinationTableName, tableUniqueKey, originUniqueKeys, tableUniqueKey);
			ResultSet rstSelectUnexistentUniqueKeys = destinationProvider.getProcessor().execute(querySelectUnexistentUniqueKeys);
			
			while (rstSelectUnexistentUniqueKeys.next()) {
				queries.add(destinationProvider.getQueryBuilder()
						.delete(destinationTableName, tableUniqueKey, rstSelectUnexistentUniqueKeys.getString(tableUniqueKey))
				);
			}
		}

		//Fecha conex�es ativas, as mesmas ser�o reativadas no processamento das queries
		originProvider.getConn().close();
		destinationProvider.getConn().close();
		
		return queries;
	}

	public IReplicatorProvider getOriginProvider() {
		return originProvider;
	}

	public IReplicatorProvider getDestinationProvider() {
		return destinationProvider;
	}
}
