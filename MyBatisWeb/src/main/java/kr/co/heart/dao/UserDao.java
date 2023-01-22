package kr.co.heart.dao;

import kr.co.heart.domain.User;

public interface UserDao {
	
	User selectUser(String id);
	void deleteAll() throws Exception;
	int insertUser(User user);
	int UpdateUser(User user);
}
