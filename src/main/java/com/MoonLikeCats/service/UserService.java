package com.MoonLikeCats.service;

import com.MoonLikeCats.model.User;

public interface UserService {

	//public void create(User user);
	public User retrieve(String email, String password);
	//public void update(User user);
	//public void delete(User user);
}
