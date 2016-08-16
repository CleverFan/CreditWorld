package com.credit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.credit.domain.Company;

public class CompanyDao {
private SessionFactory sessionFactory;
	
	public void insertCompany(Company company){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(company);
		
		session.getTransaction().commit();
		session.close();
	}
	public Company selectInfo(int id){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from Company where id=:id";
		Query q = session.createQuery(hql);
		q.setInteger("id", id);
		Company c = (Company) q.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public Company selectInfoByLoginName(String loginName){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from Company where loginName=:loginName";
		Query q = session.createQuery(hql);
		q.setString("loginName", loginName);
		Company c = (Company) q.uniqueResult();
		
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
