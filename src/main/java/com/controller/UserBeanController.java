package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bean.ListUserExamBean;
import com.bean.UserExamBean;
import com.dao.UserExamDao;
import com.dao.questionDAO;

@Controller
public class UserBeanController {
	
	@Autowired
	questionDAO qdao;
	
	@Autowired
	UserExamDao uedao;
	
	@Autowired
	HttpSession session;
	
		
		@RequestMapping(value = "/submitexam",method = RequestMethod.POST)
		public String insertuserexam(ListUserExamBean userexamlist,Model model) {
			System.out.println("Size=====>"+userexamlist.getListuserexam().size());
			ListUserExamBean userexams=uedao.insertUserExam(userexamlist);
			int truecount=0;
			for (UserExamBean userexam : userexams.getListuserexam()) {
				if(userexam.getStatus()==1) {
					truecount++;
				}
				if (truecount>=2) {
					session.setAttribute("msg", "Congrats!You Successfully Passed the Exam");
				}else {
					session.setAttribute("msg", "Sorry!You are not Successfully Passed the Exam");
				}
			}
			model.addAttribute("userexams",userexams);
			
			return "Result";
		}
	
}
