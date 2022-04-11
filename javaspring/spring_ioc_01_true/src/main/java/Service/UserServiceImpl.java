package Service;

import UserDao.UserDao;
import UserDao.UserDaoImpl;
import UserDao.UserDaoMysql;

public class UserServiceImpl implements UserService{
	private UserDao userdao;
	
	public void getUser() {
		//UserDao user01=new UserDaoImpl();
		userdao.getUser();
	}
	

	public void setUserDao(UserDao userdao) {
		//this 代表其所在方法的当前对象的引用
		this.userdao=userdao;
	}

}
