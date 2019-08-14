package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.userBean;


@Repository
public class userDAO {
	
	@Autowired
	SessionFactory factory;
	
	public void insert(userBean bean) {
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		try {
			s.save(bean);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tx.rollback();
		}finally {
			s.close();
		}
		
	}
	
	public List<userBean> getUser(){
		Session s=factory.openSession();
		List<userBean> ls=s.createQuery("from userBean").list();
		return ls;
	}
	
}
