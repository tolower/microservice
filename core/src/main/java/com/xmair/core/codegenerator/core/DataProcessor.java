package com.xmair.core.codegenerator.core;

import com.xmair.core.codegenerator.model.Column;
import com.xmair.core.codegenerator.model.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class DataProcessor {

	private Connection connection;

	public  DataProcessor(Connection con){
		connection=con;
	}
	/**
	 * 表预处理
	 * 
	 * @param tableInfos
	 */
	public void prepareProcessTableInfos(List<Table> tableInfos) {

		try {
			for (Table table : tableInfos) {
				//设置主键列表
				List<String> primaryKeys=new ArrayList<String>();
			    ResultSet keysSet=	connection.getMetaData().getPrimaryKeys(null, null, table.getTableName());
				while(keysSet.next()) {
					String primaryKey = keysSet.getString("COLUMN_NAME");
					primaryKeys.add(primaryKey);
				}
				table.setPrimaryKeys(primaryKeys);
			    table.setBeanName(StringUtils.underLineToCamel(StringUtils.toUpperCaseFirst(table.getTableName())));


			    prepareProcessColumns(table.getColumns());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			//connectionFactory.close(connection);
		}

	}

	/**
	 * 列预处理
	 * 
	 * @param columns
	 */
	public void prepareProcessColumns(List<Column> columns) {
		for (Column column : columns) {

			String lowerProperty = StringUtils.underLineToCamel(column.getColumn().toLowerCase());
			column.setLowerProperty(lowerProperty);
			column.setProperty(StringUtils.toUpperCaseFirst(StringUtils.underLineToCamel(lowerProperty)));
		}

	}

	public List<Table> convertToTableInfos(Map<String, Map<String, Map<String, Object>>> tables) {
		List<Table> tableInfos = new ArrayList<Table>();
		Table table = null;
		Column column = null;
		List<Column> columns = null;

		for (Entry<String, Map<String, Map<String, Object>>> e : tables.entrySet()) {
			table = new Table();
			columns = new ArrayList<Column>();
			table.setColumns(columns);

			tableInfos.add(table);
			String tableName = e.getKey();
			table.setTableName(tableName);

			Map<String, Map<String, Object>> rows = e.getValue();
			for (Entry<String, Map<String, Object>> row : rows.entrySet()) {
				column = new Column();
				column.setColumn(row.getKey());
				Map<String, Object> rowInfo = row.getValue();
				String jdbcType=(String) rowInfo.get("jdbcType");
				column.setJdbcType(jdbcType);
				column.setRemark((String) rowInfo.get("remark"));
				column.setDataType((int) rowInfo.get("dataType"));
				column.setMaxLength((int)rowInfo.get("length"));
				int isnull=(int)rowInfo.get("isnull");
				if(isnull==0){
					column.setAllowNull(false);
				}
				else{
					column.setAllowNull(true);
				}

				String javaType=TypeUtils.getJavaType(column.getDataType());
				column.setType(javaType);
				if("Date".equals(javaType)){
					table.setHasDate(true);
				}else if("BigDecimal".equals(javaType)){
					table.setHasBigdecimal(true);
				}
				columns.add(column);
			}
		}
		//connectionFactory.close(connection);
		return tableInfos;
	}

	private  String getSchema() {
		String schema=null;
		try {
			schema = connection.getMetaData().getUserName();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

		return schema.toUpperCase().toString();

	}

	public Map<String, Map<String, Map<String, Object>>> getTableInfo( String tableNamePattern) {
		Map<String, Map<String, Map<String, Object>>> tables = new HashMap<>();

		try {
			DatabaseMetaData meta = connection.getMetaData();
			ResultSet rs = meta.getColumns(null, null, tableNamePattern, null);
			//ResultSet rs = meta.getColumns(null, getSchema(), tableNamePattern, null);

			while (rs.next()) {

				String tableName = rs.getString("TABLE_NAME").toLowerCase();

				String colName = rs.getString("COLUMN_NAME");
				String jdbcType = rs.getString("TYPE_NAME");
				if(jdbcType.equals("DATETIME"))
				{
					jdbcType="DATE";
				}
				if(jdbcType.equals("INT") )
				{
					jdbcType="INTEGER";
				}
				if(jdbcType.equals("VARCHAR2") )
				{
					jdbcType="VARCHAR";
				}
				if(jdbcType.equals("NUMBER") )
				{
					jdbcType="DECIMAL";
				}

				Integer dataType = rs.getInt("DATA_TYPE");
				String remarks = rs.getString("REMARKS");
				Map<String, Map<String, Object>> table = tables.get(tableName);
				if (table == null) {
					table = new HashMap<>();
					tables.put(tableName, table);
				}
				Map<String, Object> row = new HashMap<>();
				// row.put("columnName", colName);
				row.put("jdbcType", jdbcType);
				row.put("remark", remarks);
				row.put("dataType", dataType);
				row.put("length",rs.getInt("COLUMN_SIZE"));
				row.put("isnull",rs.getInt("NULLABLE"));
				table.put(colName, row);

			}

			for (Entry<String, Map<String, Map<String, Object>>> e : tables.entrySet()) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//connection.close();
		}
		return tables;
	}

	public List<Table> getTableInfos( String tableNamePattern) {
		Map<String, Map<String, Map<String, Object>>> tables = getTableInfo(tableNamePattern);

		List<Table> tableInfos = convertToTableInfos(tables);

		prepareProcessTableInfos(tableInfos);
		return tableInfos;
	}

	public static void main(String[] args) {
		String tableNamePattern = "%";
		//DataProcessor t = new DataProcessor();

	}
}
