package th.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import th.dao.UserDaoImpl;
//用户登陆
public class UserDao {
	UserDaoImpl user=new UserDaoImpl();
	/**
	 * 用户登录功能
	 * */
	public boolean Login(String name,String pwd){
		boolean flag=false;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		con=user.getConnection();
		
		try {
			stmt=con.createStatement();//预定义语句
			//数据库查询语句(根据用户名和密码)
			String sql="select * from user where UserName='"+name+"' and Password='"+pwd+"'";
			rs=stmt.executeQuery(sql);//执行查询语句
			//rs中有数据，则将标记改为true
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		    user.close();
		}
		return flag;
	}
}
