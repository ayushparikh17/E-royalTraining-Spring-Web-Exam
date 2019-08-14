package com.bean;



import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "Exam_Table")
public class examBean {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examId;
	
	@Column(name="Exam_Title")
	private String title;
	
	@Column(name = "Exam_Date")
	private String edate;
	
	
	@Column(name = "Exam_Duration")
	private String duration;
	
	@Column(name = "Total_Marks")
	private int tmarks;
	
	
	@Column(name = "Exam_Code")
	private String ecode;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "examId")
	List<questionBean> questions;
	
	
	public List<questionBean> getQuestions() {
		return questions;
	}
	public void setQuestions(List<questionBean> questions) {
		this.questions = questions;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public int getTmarks() {
		return tmarks;
	}
	public void setTmarks(int tmarks) {
		this.tmarks = tmarks;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	
}
