package com.credit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.credit.domain.UserDet;

public class UserDetDao {
	private SessionFactory sessionFactory;
	
	public void insertInfo(UserDet userDet){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(userDet);
		
		session.getTransaction().commit();
		session.close();
	}
	public UserDet selectInfo(String userid){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from UserDet where userid=:userid";
		Query q = session.createQuery(hql);
		q.setString("userid", userid);
		UserDet u = (UserDet) q.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return u;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
