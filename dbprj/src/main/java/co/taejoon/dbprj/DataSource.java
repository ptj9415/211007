package co.taejoon.dbprj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private String driver;
	private String url;
	private String user;
	private String password;

	public Connection conn;

	public DataSource() {
		getDbproperties();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}

	private void getDbproperties() {
		File path = new File("src/main/resources/Wallet_YD02/db.properties");
		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(path);
			properties.load(file);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
