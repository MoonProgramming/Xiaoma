package com.MoonLikeCats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MoonLikeCats.dao.UserDAO;
import com.MoonLikeCats.model.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDao;
	
//	@Transactional
//	@Override
//	public void create(User user) {
//		userDao.create(user);
//	}

	@Transactional
	@Override
	public User retrieve(String email, String password) {
		return userDao.retrieve(email, password);
	}

//	@Transactional
//	@Override
//	public void update(User user) {
//		userDao.update(user);
//	}

//	@Transactional
//	@Override
//	public void delete(User user) {
//		userDao.delete(user);
//	}

}
