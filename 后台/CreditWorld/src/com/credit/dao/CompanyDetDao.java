package com.credit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.credit.domain.ComDet;
import com.credit.domain.UserDet;

public class CompanyDetDao {
	private SessionFactory sessionFactory;
	
	public void insertInfo(ComDet comDet){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(comDet);
		
		session.getTransaction().commit();
		session.close();
	}
	public ComDet selectInfo(String id){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from ComDet where id=:id";
		Query q = session.createQuery(hql);
		q.setString("id", id);
		ComDet c = (ComDet) q.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
