package co.ayu.service;

import co.ayu.dao.StudentDetails;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Register {

	public static ApiResponse doRegister(ApiRequest request) {
		ApiResponse registerRes=null;
		  //we need to use criteria and other features.
		//this is just for test ..it must get changed for better.
		Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentDetails.class);
		SessionFactory sf= con.buildSessionFactory();
		Session se= sf.openSession();
		Transaction tx=se.beginTransaction();
		
		StudentDetails sd= new StudentDetails();
		sd.setStudentID(request.getRollno());
		sd.setStudentAdd(request.getStudentAdd());
		sd.setStudentName(request.getName());
		sd.setStudentPhone(request.getPhone());
		se.save(sd);
		tx.commit();
		
		se.close();
		System.out.println("data saved");
		
		//registerRes-->populate the response.
		return registerRes;
	}

}
