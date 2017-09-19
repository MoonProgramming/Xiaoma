package com.MoonLikeCats.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MoonLikeCats.model.ServiceProvider;

@Repository
public class ServiceProviderDAOImpl implements ServiceProviderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(ServiceProvider serviceProvider) {
		System.out.println("inside ServiceProviderDAOImpl create");
		sessionFactory.getCurrentSession().save(serviceProvider);
	}

	@Override
	public void update(ServiceProvider serviceProvider) {
		System.out.println("inside ServiceProviderDAOImpl update");
		sessionFactory.getCurrentSession().update(serviceProvider);
	}

	@Override
	public void delete(ServiceProvider serviceProvider) {
		System.out.println("inside ServiceProviderDAOImpl delete");
		sessionFactory.getCurrentSession().delete(serviceProvider);
	}

}
