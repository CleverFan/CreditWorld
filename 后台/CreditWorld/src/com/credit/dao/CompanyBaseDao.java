package com.credit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.credit.domain.ComBase;

public class CompanyBaseDao {
private SessionFactory sessionFactory;
	
	public void insertInfo(ComBase comBase){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(comBase);
		
		session.getTransaction().commit();
		session.close();
	}
	public ComBase selectInfo(String id){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from ComBase where id=:id";
		Query q = session.createQuery(hql);
		q.setString("id", id);
		ComBase c = (ComBase) q.uniqueResult();
		
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
