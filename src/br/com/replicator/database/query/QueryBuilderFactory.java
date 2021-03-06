package br.com.replicator.database.query;

import br.com.replicator.database.query.contracts.IQueryBuilder;
import br.com.replicator.enums.SupportedTypes;
import br.com.replicator.exceptions.InvalidDatabaseTypeException;

abstract public class QueryBuilderFactory {
	public static IQueryBuilder getQueryBuilder(SupportedTypes dbType) throws InvalidDatabaseTypeException {
		switch (dbType) {
			case POSTGRESQL:
				return new PostgreSqlQueryBuilder();
			case MYSQL:
				return new MySqlQueryBuilder();
			default:
				throw new InvalidDatabaseTypeException("Invalid database type");
		}
	}
}
