package com.MoonLikeCats.dao;

import com.MoonLikeCats.model.User;

public interface UserDAO {

	//public void create(User user);
	public User retrieve(String email, String password);
	//public void update(User user);
	//public void delete(User user);
}
