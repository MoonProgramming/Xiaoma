package com.MoonLikeCats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MoonLikeCats.dao.ClientDAO;
import com.MoonLikeCats.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDao;
	
	@Transactional
	@Override
	public void create(Client client) {
		clientDao.create(client);
	}

	@Transactional
	@Override
	public void update(Client client) {
		clientDao.update(client);
	}

	@Transactional
	@Override
	public void delete(Client client) {
		clientDao.delete(client);
	}

}
