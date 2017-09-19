package com.MoonLikeCats.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MoonLikeCats.model.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Client client) {

		System.out.println("inside ClientDAOImpl create");
		sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void update(Client client) {

		System.out.println("inside ClientDAOImpl update");
		sessionFactory.getCurrentSession().update(client);
	}

	@Override
	public void delete(Client client) {
		
		System.out.println("inside ClientDAOImpl delete");
		sessionFactory.getCurrentSession().delete(client);
	}

}
