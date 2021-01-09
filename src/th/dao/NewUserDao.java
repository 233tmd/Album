package th.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import th.dao.NewUserImpl;
//用户注册
public class NewUserDao {
	NewUserImpl newuser=new NewUserImpl();
	/**
	 * 用户注册功能
	 */
	public boolean Create(String name,String pwd){
		boolean flag=false;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		con=newuser.getConnection();
		
		try {
			stmt=con.createStatement();//预定义语句
			//数据库插入语句
			String sql="insert * from user where UserName='"+name+"' and Password='"+pwd+"'";
			rs=stmt.executeQuery(sql);//执行查询语句
			//rs中有数据，则将标记改为true
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		    newuser.close();
		}
		return flag;
	}
}
