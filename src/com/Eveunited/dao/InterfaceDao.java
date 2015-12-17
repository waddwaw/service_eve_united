package com.Eveunited.dao;


import com.Eveunited.bean.UserBean;

public interface InterfaceDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int AddUser(UserBean user);
	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	public int DeleteUser(UserBean user);
	/**
	 * 根据用户user查询用户信息
	 * @return
	 */
	public UserBean QueryUserByUser(String user);
	/**
	 * 根据手机号查询用户信息
	 * @return
	 */
	public UserBean QueryUserByNubmer(String nubmer);
	
	/**
	 * 验证用户名密码返回用户信息
	 * @return
	 */
	public UserBean QueryUserByUserPwd(String user,String pwd);
	/**
	 * 根据user来更新用户信息
	 * @param newInfo
	 * @param id
	 * @return
	 */
	public int UpdateUser(UserBean newInfo,String user);
	/**
	 * 添加情侣绑定
	 * @param user
	 * @param touser
	 * @return
	 */
	public int AddBind(String user,String touser);
	
	/**
	 * 检测是否已经进行绑定
	 * @param user
	 * @param touser
	 * @return
	 */
	public boolean CheckBind(String user);
}
