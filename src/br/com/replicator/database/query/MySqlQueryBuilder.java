package br.com.replicator.database.query;

import java.sql.Types;
import java.util.TreeMap;

import br.com.replicator.database.query.contracts.IQueryBuilder;

public class MySqlQueryBuilder extends AbstractQueryBuilder implements IQueryBuilder {

	@Override
	protected TreeMap<String, String> parseColumnsValuesPairs(String[] columns, String[] values, int[] types) {
		TreeMap<String, String> columnsValuesPairs = new TreeMap<String, String>();
		
		for (int i = 0; i < columns.length; i++) {
			if(values.length > i && values[i] != null) {
				switch(types[i]) {
					case Types.TIMESTAMP:
					case Types.TIMESTAMP_WITH_TIMEZONE:
						columnsValuesPairs.put(columns[i], "'" + values[i].substring(0, 19) + "'");
					break;
					case Types.INTEGER:
					case Types.TINYINT:
					case Types.SMALLINT:
					case Types.BIGINT:
						columnsValuesPairs.put(columns[i], values[i]);
					break;
					default:
						columnsValuesPairs.put(columns[i], "'" + values[i].toString().replaceAll("'", "''") + "'");
					break;
				}
			}
        }
		
		return columnsValuesPairs;
	}
}
