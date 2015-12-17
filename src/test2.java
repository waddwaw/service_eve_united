import com.Eveunited.bean.ChatBean;
import com.Eveunited.dao.DaoImpl;
import com.Eveunited.dao.InterfaceDao;
import com.google.gson.Gson;


public class test2 {

	public static void main(String[] args) {
		InterfaceDao dao = new DaoImpl();
//		User user = new User(0, "test","测试", "123", "13142010478", "男", "长沙民政学院", "/hah/photo", "waddwaw@qq.com", "我是测试人员", new Date().getTime()+"");
//		int reslut=dao.AddUser(user);
//		System.out.println(reslut+"");
		
//		User user =dao.QueryUserByUserPwd("test", "202cb962ac59075b964b07152d234b70");
//		if(user!=null){
//			Gson gson = new Gson();  
//	        String result = gson.toJson(user);  
//	        System.out.println(result);  
//		}else {
//			System.out.println("用户名密码错误");
//		}
		
		ChatBean chat = new ChatBean("test", "1", "哈哈哈哈");
		Gson gson = new Gson();  
        String result = gson.toJson(chat);  
        System.out.println(result);  
	}

}
