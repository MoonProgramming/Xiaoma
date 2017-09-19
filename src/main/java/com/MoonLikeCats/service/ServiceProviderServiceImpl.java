package com.MoonLikeCats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MoonLikeCats.dao.ServiceProviderDAO;
import com.MoonLikeCats.model.ServiceProvider;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	private ServiceProviderDAO serviceProviderDao;
	
	@Transactional
	@Override
	public void create(ServiceProvider serviceProvider) {
		serviceProviderDao.create(serviceProvider);
	}

	@Transactional
	@Override
	public void update(ServiceProvider serviceProvider) {
		serviceProviderDao.update(serviceProvider);
	}

	@Transactional
	@Override
	public void delete(ServiceProvider serviceProvider) {
		serviceProviderDao.delete(serviceProvider);
	}

}
