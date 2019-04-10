package co.ayu.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.ayu.to.ApiRequest;
import co.ayu.to.StudentDetails;
import co.ayu.util.HibernateUtil;


public class DaoImpl implements Serializable{
private static final long serialVersionUID = 1L;

public static void saveData(StudentDetails req) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
            
			session.save(req);
			tx.commit();
			session.close();  
		}

public static List<StudentDetails> getStudentList(ApiRequest request){
	Session session = HibernateUtil.getSessionFactory().openSession();
   Criteria criteria= session.createCriteria(StudentDetails.class);
	criteria.add(Restrictions.eq("emailID", request.getEmailID()));
	List<StudentDetails> list= criteria.list();
	return list;
}
		
}
