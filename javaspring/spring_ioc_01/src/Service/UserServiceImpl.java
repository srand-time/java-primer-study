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
		//this ���������ڷ����ĵ�ǰ���������
		this.userdao=userdao;
	}

}
