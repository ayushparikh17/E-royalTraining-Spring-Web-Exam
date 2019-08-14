package com.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.examBean;
import com.bean.questionBean;

@Repository
public class examDAO {

	@Autowired
	SessionFactory factory;
	
	public void insert(examBean bean) {
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
	
	public List<examBean> getExam(){
		Session s=factory.openSession();
			List<examBean> ls=s.createQuery("from examBean").list();
			s.close();
			return ls;
	}
	
	public examBean getExambyId(int id){
		Session s=factory.openSession();
		examBean bean=s.get(examBean.class, id);
		return bean;
	}
	
	public void update(examBean bean) {
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		try {
			s.update(bean);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			s.close();
		}
		
	}
	
	public void delete(examBean bean) {
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		try {
			s.delete(bean);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			s.close();
		}
	}
	
	public List<questionBean> searchquestion(int id) {
		Session s=factory.openSession();
		List<questionBean> qlist=s.createQuery("from questionBean where examId='"+id+"'").list();
		return qlist;
	}
	
	public examBean getExambyCode(String ecode) {
		Session s=factory.openSession();
		List<examBean> bean=s.createQuery("from examBean where ecode like '"+ecode+"'").list();
		if (bean.size()==0) {
			return null;
		} else {
			return bean.get(0);
		}
	}
}
