package test;

import Service.UserService;
import Service.UserServiceImpl;
import UserDao.UserDaoMysql;

public class main {
	public static void main(String args[]) {
		UserService user01=new UserServiceImpl();
		user01.setUserDao(new UserDaoMysql());
		user01.getUser();
	}
}
