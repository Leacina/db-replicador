package br.com.replicator.database.query.contracts;

import java.util.List;

import br.com.replicator.exceptions.InvalidQueryAttributesException;

public interface IQueryBuilder {
	public IQuery insert(String tableName, String[] columns, String[] values, int[] types) throws InvalidQueryAttributesException;
	
	public IQuery update(String tableName, String[] columns, String[] values, int[] types, String identifierColumn, String identifierValue) throws InvalidQueryAttributesException;
	
	public IQuery delete(String tableName, String identifierColumn, String identifierValue) throws InvalidQueryAttributesException;
	
	public IQuery find(String tableName, String identifierColumn, String operator, String identifierValue, String columns) throws InvalidQueryAttributesException;
	
	public IQuery findNotIn(String tableName, String identifierColumn, List<String> identifierValues, String columns) throws InvalidQueryAttributesException
;
	public IQuery select(String tableName, String columns) throws InvalidQueryAttributesException;
}
