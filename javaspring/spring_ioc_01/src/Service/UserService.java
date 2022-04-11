package Service;

import UserDao.UserDao;

public interface UserService {
	void getUser();
	//void setUserDao();

	void setUserDao(UserDao userdao);
}
