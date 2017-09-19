package com.MoonLikeCats.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.MoonLikeCats.conn.HibernateConn;
import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.model.User;

public class DBUtils {
	
	public static Client registerUser(Connection conn, String email, String userName, String phone, String address, Date childBirthdate, String password) throws SQLException {
		
		 String sqlScript = "Insert into User_Account(email, user_Name, phone, address, childBirthdate, password) values (?,?,?,?,?,?)";
		 
	     PreparedStatement pstm = conn.prepareStatement(sqlScript);
	 
	     pstm.setString(1, email);
	     pstm.setString(2, userName);
	     pstm.setString(3, phone);
	     pstm.setString(4, address);
	     pstm.setDate(5, childBirthdate);
	     pstm.setString(6, password);
	 
	     if (pstm.executeUpdate() >0) {
	    	 System.out.println("user registered in database");
	    	 
	    	 Client currentUser = new Client();
	            currentUser.setEmail(email);
	            currentUser.setDisplayName(userName);
	            currentUser.setPhone(phone);
	            currentUser.setAddress(address);
	            currentUser.setChildBirthdate(childBirthdate);
	            currentUser.setPassword(password);
	            
	            System.out.println("user logged in: " + currentUser);
	            return currentUser;
	     }
	     System.out.println("register user failed");
	     return null;
	}
	
	public static Client findUser(Connection conn, String email, String password) throws SQLException {
		
		String sqlScript = "Select * from User_Account a "
                + " where a.email = ? and a.password= ?";
		
		PreparedStatement pstm = conn.prepareStatement(sqlScript);
        pstm.setString(1, email);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        
        if (rs.next()) {
            int userId = rs.getInt("USER_ID");
            String userName = rs.getString("USER_NAME");
            String phone = rs.getString("phone");
            String address = rs.getString("address");
            Date childBirthdate = rs.getDate("childBirthdate");
            
            Client currentUser = new Client();
            currentUser.setUserId(userId);
            currentUser.setEmail(email);
            currentUser.setDisplayName(userName);
            currentUser.setPhone(phone);
            currentUser.setAddress(address);
            currentUser.setChildBirthdate(childBirthdate);
            currentUser.setPassword(password);
            
            System.out.println("found user: " + currentUser);
            return currentUser;
        }
        System.out.println("no user found, email or password maybe wrong");
        return null;
	}

	public static Client registerClient(String email, String userName, String phone, String address, Date childBirthdate, String password) {
        Session session = HibernateConn.getSession();
        Transaction transaction = null;
 
        try {
            transaction = session.beginTransaction();
            
            Client client = new Client();
            client.setEmail(email);
            client.setDisplayName(userName);
            client.setPhone(phone);
            client.setAddress(address);
            client.setChildBirthdate(childBirthdate);
            client.setPassword(password);
            client.setRole("Client");
            java.util.Date date =  new java.util.Date();
            Timestamp dateCreated = new Timestamp(date.getTime());
            client.setDateCreated(dateCreated);
            
            session.save(client);
            transaction.commit();
            System.out.println("Client registered in database");
            return client;
            
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("register client failed");
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println("Hibernate session closed");
        }
        return null;
    }
 
    public static User retrieveUser(String email, String password) {
 
        Session session = HibernateConn.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from User s where s.email = :email and s.password = :password";
            List result = session.createQuery(hql)
            .setParameter("email", email)
            .setParameter("password", password)
            .list();
            
            if (result.iterator().hasNext()) {
                User currentUser = (User) result.iterator().next();
                System.out.println("found user: " + currentUser);
                transaction.commit();
                return currentUser;
            }
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Retrive User failed");
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println("Hibernate session closed");
        }
		return null;     
    }
 
    public static void updateUser(User user) {
 
        Session session = HibernateConn.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //String queryString = "from Employee where sal = :sal";
            //Query query = session.createQuery(queryString);
            //query.setInteger("sal", 50000);
            //Employee employee = (Employee) query.uniqueResult();
            
            session.update(user);
            transaction.commit();
            System.out.println("client records updated!");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            System.out.println("Hibernate session closed");
        }
    }
    
    public static void deleteUser(User user) {
    	
    	Session session = HibernateConn.getSession();
    	Transaction transaction = null;
    	try {
    		transaction = session.beginTransaction();
    		//String hql = "from User s where s.email = :email and s.password = :password";
            //List result = session.createQuery(hql)
            //.setParameter("email", email)
            //.setParameter("password", password)
            //.list();
            
//            if (result.iterator().hasNext()) {
//                User currentUser = (User) result.iterator().next();
//                System.out.println("found user: " + currentUser);
//                session.delete(currentUser);
//            }
    		session.delete(user);
            transaction.commit();
    		System.out.println("User records deleted!");
    	} catch (HibernateException e) {	
    		transaction.rollback();	
    		System.out.println("delete user failed");
    		e.printStackTrace(); 		
    	} finally {  		
    		session.close();
    		System.out.println("Hibernate session closed");
    	}
    }
}
