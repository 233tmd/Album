package th.dao;

import java.sql.*;

public class UserDaoImpl {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/albumdb?useSSL=false" ;
	private static final String DBUSER = "root" ;
	private static final String PASSWORD = "123456" ;
	private Connection conn = null ;
	/**
	 * 在构造方法调用时将进行数据库连接对象的取得
	 */
	public UserDaoImpl() {
		try {
			Class.forName(DBDRIVER) ;	// 加载数据库驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 取得数据库连接对象
	 * @return 实例化的Connection对象，如果返回null，表示没有连接成功
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * 进行数据库的关闭操作
	 */
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
	}
}
