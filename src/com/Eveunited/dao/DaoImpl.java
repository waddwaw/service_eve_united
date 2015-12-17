package com.Eveunited.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.Eveunited.bean.UserBean;
import com.Eveunited.db.ConnectionManager;
import com.Eveunited.utils.TimeUtils;

public class DaoImpl implements InterfaceDao{
	
	private Connection conn = ConnectionManager.getConnection();
	
	@Override
	public int AddUser(UserBean user) {
		PreparedStatement stmt=null;
		int result=0;
		try {
			String sql="insert into user(user,nickname,pwd,number,sex,address,portrait,email,introduce,time)values(?,?,?,?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user.getUser());
			stmt.setString(2, user.getNickname());
			stmt.setString(3, user.getPwd());
			stmt.setString(4, user.getNumber());
			stmt.setString(5, user.getSex());
			stmt.setString(6, user.getAddress());
			stmt.setString(7, user.getPortrait());
			stmt.setString(8, user.getEmail());
			stmt.setString(9, user.getIntroduce());
			stmt.setString(10,user.getTime());
			result=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

	@Override
	public int DeleteUser(UserBean user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserBean QueryUserByUser(String user) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		UserBean rsuser=null;
		String sql="select * from user where user= ?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user);
			rs=stmt.executeQuery();
			if(rs.next()){
				rsuser=new UserBean();
				rsuser.setUser(rs.getString("user"));
				rsuser.setNickname(rs.getString("nickname"));
				rsuser.setPwd(rs.getString("pwd"));
				rsuser.setNumber(rs.getString("number"));
				rsuser.setSex(rs.getString("sex"));
				rsuser.setAddress(rs.getString("address"));
				rsuser.setPortrait(rs.getString("portrait"));
				rsuser.setEmail(rs.getString("email"));
				rsuser.setIntroduce(rs.getString("introduce"));
				rsuser.setTime(rs.getString("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsuser;
	}
	@Override
	public UserBean QueryUserByNubmer(String nubmer) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		UserBean rsuser=null;
		String sql="select * from user where number= ?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, nubmer);
			rs=stmt.executeQuery();
			if(rs.next()){
				rsuser=new UserBean();
				rsuser.setUser(rs.getString("user"));
				rsuser.setNickname(rs.getString("nickname"));
				rsuser.setPwd(rs.getString("pwd"));
				rsuser.setNumber(rs.getString("number"));
				rsuser.setSex(rs.getString("sex"));
				rsuser.setAddress(rs.getString("address"));
				rsuser.setPortrait(rs.getString("portrait"));
				rsuser.setEmail(rs.getString("email"));
				rsuser.setIntroduce(rs.getString("introduce"));
				rsuser.setTime(rs.getString("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsuser;
	}

	@Override
	public UserBean QueryUserByUserPwd(String user, String pwd) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		UserBean rsuser=null;
		String sql="select * from user where user= ? and pwd = ?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, pwd);
			rs=stmt.executeQuery();
			if(rs.next()){
				rsuser=new UserBean();
				rsuser.setUser(rs.getString("user"));
				rsuser.setNickname(rs.getString("nickname"));
				rsuser.setPwd(rs.getString("pwd"));
				rsuser.setNumber(rs.getString("number"));
				rsuser.setSex(rs.getString("sex"));
				rsuser.setAddress(rs.getString("address"));
				rsuser.setPortrait(rs.getString("portrait"));
				rsuser.setEmail(rs.getString("email"));
				rsuser.setIntroduce(rs.getString("introduce"));
				rsuser.setTime(rs.getString("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rsuser;
	}
	
	@Override
	public int AddBind(String user, String touser) {
		PreparedStatement stmt=null;
		int result=0;
		try {
			String sql="insert into bindi(user,touser,time)values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, touser);
			stmt.setString(3, new Date().getTime()+"");
			result=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	@Override
	public int UpdateUser(UserBean newInfo, String user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean CheckBind(String user) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from bindi where user= ? ";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user);
			rs=stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.close(null, stmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
