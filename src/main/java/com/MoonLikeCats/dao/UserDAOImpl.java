package com.MoonLikeCats.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MoonLikeCats.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
//	@Override
//	public void create(User user) {
//		
//		System.out.println("inside UserDAOImpl create");
//		sessionFactory.getCurrentSession().save(user);
//	}

	@Override
	public User retrieve(String email, String password) {
		
		System.out.println("inside UserDAOImpl retrieve");
		
		String hql = "from User s where s.email = :email and s.password = :password";
        List result = sessionFactory.getCurrentSession().createQuery(hql)
        .setParameter("email", email)
        .setParameter("password", password)
        .list();
        
        if (result.iterator().hasNext()) {
            User currentUser = (User) result.iterator().next();
            System.out.println("found user: " + currentUser);
            return currentUser;
        }
		return null;
	}

//	@Override
//	public void update(User user) {
//		
//		System.out.println("inside UserDAOImpl update");
//		sessionFactory.getCurrentSession().update(user);
//	}

//	@Override
//	public void delete(User user) {
//		
//		System.out.println("inside UserDAOImpl delete");
//		sessionFactory.getCurrentSession().delete(user);
//	}

}
