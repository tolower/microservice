package com.xmair.core.codegenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.xmair.core.CoreApplication;
import com.xmair.core.codegenerator.core.Configure;
import com.xmair.core.codegenerator.core.DataProcessor;
import com.xmair.core.codegenerator.model.Table;


@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public class MysqlGenerator {
	private static String url = "jdbc:mysql://11.4.74.51:800/booking";

	private static String driver="com.mysql.jdbc.Driver";

	private static String user = "root";
	private static String password = "wuzuquan";

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection;
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public static String getProjectPath() throws  Exception {

		java.net.URL url = CoreApplication.class .getProtectionDomain().getCodeSource().getLocation();

		String filePath =  java.net.URLDecoder.decode (url.getPath(), "utf-8") ;
		filePath=filePath.substring(1,filePath.length()-("/target/classes/").length());

		System.out.println(filePath);
		return 	filePath;

	}
	public static void main(String[] args) throws  Exception {
		Configure config = new Configure();
		config.setTargetDir(getProjectPath()+"/src/main/java/");
		config.setModelPackage("com.xmair.core.entity");
		//config.setExamplePackage("com.xmair.core.domain.example");
		config.setMapperPackage("com.xmair.core.mapper.test1");
		config.setXmlPackage("com.xmair.core.mapper.test1.xml");
		config.setRestControllerPackage("com.xmair.restapi.controller");
		config.setControllerPackage("com.xmair.webapp.controller");

		Generator generator = new Generator(config);

		String tableNamePattern = "%";
		Connection connection=getConnection();
		DataProcessor t = new DataProcessor(connection);

		List<Table> tableInfos = t.getTableInfos(tableNamePattern);
        connection.close();
		try {
			for (Table table : tableInfos) {
				generator.generateModel(config.getTargetDir(), table);
				//generateExample(table);
				generator.generateMapper(config.getTargetDir(),table);
				generator.generateXml(config.getTargetDir(),table);
				//restcontroller生成到restapi模块的controller目录
				String restControllerDir=config.getTargetDir().replace("/core/src","/restapi/src");
				generator.generateRestAPI(restControllerDir,table);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
