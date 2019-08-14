package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "User_Exam")
public class UserExamBean {
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userexamId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	userBean ubean;
	
	@ManyToOne
	@JoinColumn(name = "examId")
	examBean ebean;
	
	@ManyToOne
	@JoinColumn(name = "questionId")
	questionBean qbean;
	
	private String useranswer;
	
	private int status;

	public int getUserexamId() {
		return userexamId;
	}

	public void setUserexamId(int userexamId) {
		this.userexamId = userexamId;
	}

	public userBean getUbean() {
		return ubean;
	}

	public void setUbean(userBean ubean) {
		this.ubean = ubean;
	}

	public examBean getEbean() {
		return ebean;
	}

	public void setEbean(examBean ebean) {
		this.ebean = ebean;
	}

	public questionBean getQbean() {
		return qbean;
	}

	public void setQbean(questionBean qbean) {
		this.qbean = qbean;
	}


	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUseranswer() {
		return useranswer;
	}

	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}
	
	

	
	
}
