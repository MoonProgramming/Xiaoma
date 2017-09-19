package com.MoonLikeCats.conn;


import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoonLikeCats.config.AppConfig;
import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.model.SP_Gallery;
import com.MoonLikeCats.model.SP_Language;
import com.MoonLikeCats.model.SP_PublicInfo;
import com.MoonLikeCats.model.ServiceProvider;
import com.MoonLikeCats.model.User;
import com.MoonLikeCats.service.ClientService;
import com.MoonLikeCats.service.ServiceProviderService;
import com.MoonLikeCats.service.UserService;
import com.MoonLikeCats.utils.DBUtils;


public class App {

    public static void main (String...args){

    	AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

          UserService userService = context.getBean(UserService.class);
          ClientService clientService = context.getBean(ClientService.class);
          ServiceProviderService serviceProviderService = context.getBean(ServiceProviderService.class);
          
          ServiceProvider user = new ServiceProvider();
          user.setEmail("bbb@bbb.com");
          user.setPassword("bbbbbb");
          user.setRole("ServiceProvider");
          user.setFullName("fullName");
          user.setIcNumber("icNumber");
          
          serviceProviderService.create(user);
          
    	User retrievedUser = userService.retrieve("bbb@bbb.com", "bbbbbb");
    	
    	ServiceProvider sp = (ServiceProvider)retrievedUser;
    	SP_PublicInfo info = new SP_PublicInfo();
    	info.setCountryISO("MY");
    	info.setExperience("experience");
    	sp.setSp_publicInfo(info);
    	info.setServiceProvider(sp);
    	serviceProviderService.update(sp);
//    	serviceProviderService.delete(sp);
//    	
//    	retrievedUser.setAddress("some addess");
//    	userService.update(retrievedUser);
//    	
//    	userService.delete(retrievedUser);
          
    	
//    	Client client = new Client();
//    	client.setEmail("ccc@ccc.com");
//    	client.setPassword("cccccc");
//    	client.setRole("Client");
//    	client.setDisplayName("ccc");
//    	client.setPhone("0167788990");
//    	clientService.create(client);
    	
//    	client.setAddress("some address");
//    	clientService.update(client);
//    	clientService.delete(client);
    	
//        Session session = HibernateConn.getSession();
//        Transaction tx = session.beginTransaction();
//
//        ServiceProvider user1 = new ServiceProvider();
//        user1.setEmail("user21@dsfsd.com");
//        user1.setPassword("password");
//        user1.setRole("SP");
//        user1.setFullName("Cibai");
//        user1.setIcNumber("65468765468");
//        java.util.Date date =  new Date();
//        Timestamp dateCreated = new Timestamp(date.getTime());
//        user1.setDateCreated(dateCreated);
//        
//        SP_PublicInfo a = new SP_PublicInfo();
//        a.setNickName("HULUO");
//        
//        SP_Language language = new SP_Language();
//        language.setMandarin("mandarin");
//        a.setSp_language(language);
//        language.setSp_publicInfo(a);
//        
//        Gallery gallery = new Gallery();
//        gallery.setGalleryPic1(null);
//        a.setGallery(gallery);
//        gallery.setSp_publicInfo(a);
//        
//        user1.setSp_publicInfo(a);
//        a.setServiceProvider(user1);
//
//        session.save(user1);
//        tx.commit();

//        List<Person> activities = (List<Person>)session.createQuery("from Person").list();
//        System.out.println(Arrays.toString(activities.toArray()));

//        session.close();
    	
    	//DBUtils.retrieveUser("user2@dsfsd.com", "password");
        
        
//        System.out.println(user1.getUserId());
//        System.out.println(user1.getLastModified());
//        System.out.println(user1.getSp_publicInfo().getSp_language().getMandarin());
//        System.out.println(user1.getSp_publicInfo().getGallery().getGalleryPic1());
    }
}
