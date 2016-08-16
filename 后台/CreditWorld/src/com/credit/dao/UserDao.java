package com.credit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.credit.domain.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public void insertUser(User user){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public User selectUserByLoginName(String loginName){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "from User where loginName=:loginName";
		Query q = session.createQuery(hql);
		q.setString("loginName", loginName);
		User u = (User) q.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return u;
	}

	public void selectUserByPhone(String phone){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
