package com.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.ListUserExamBean;
import com.bean.UserExamBean;
import com.bean.questionBean;

@Repository
public class UserExamDao {
		@Autowired
		SessionFactory factory;
		
		public ListUserExamBean insertUserExam(ListUserExamBean userExams) {
			Session s=factory.openSession();
			Transaction tx=s.beginTransaction();
			try {
			for (UserExamBean userexam : userExams.getListuserexam()) {
				questionBean qb=s.get(questionBean.class,userexam.getQbean().getQuestionId());
				if(qb.getAns().equals(userexam.getUseranswer())) {
					userexam.setStatus(1);
				}else {
					userexam.setStatus(0);
				}
				s.save(userexam);
				
				tx.commit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}finally {
			s.close();
			
		}
			return userExams;
			
			
}
		
}
