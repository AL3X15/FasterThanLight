package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.UserDAO;
import com.spring.henallux.javawebproject.model.User;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {
	private final UserDAO dao;
	private final TestModel<User> testUser;

	@Autowired
	public UserServices(UserDAO dao, TestModel<User> testUser) {
		this.dao = dao;
		this.testUser = testUser;
	}

	public User findUser(String username) throws Exception {
		return dao.findUser(username);
	}

	public User saveUser(User user) throws Exception {
		testUser.setObjectToTest(user);
		if (testUser.hasError()) throw new Exception();

		return dao.saveUser(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
	}
}
