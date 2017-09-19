package com.MoonLikeCats.dao;

import com.MoonLikeCats.model.Client;

public interface ClientDAO {
	
	public void create(Client client);
	//public Client retrieve(String email, String password);
	public void update(Client client);
	public void delete(Client client);

}
