package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.questionBean;

@Repository
public class questionDAO {
		@Autowired
		SessionFactory factory;
		
		public void insert(questionBean bean) {
			Session s=factory.openSession();
			Transaction tx=s.beginTransaction();
			try {
				s.save(bean);
				tx.commit();
			} catch (Exception e) {
				// TODO: handle exception
				tx.rollback();
			}finally {
				s.close();
			}
		}
		
		public questionBean getAns(int id) {
			Session s=factory.openSession();
			questionBean bean=s.get(questionBean.class, id);
			return bean;
		}
}
