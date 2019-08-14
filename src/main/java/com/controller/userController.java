package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.ListUserExamBean;
import com.bean.UserExamBean;
import com.bean.examBean;
import com.bean.questionBean;
import com.bean.userBean;
import com.dao.examDAO;
import com.dao.userDAO;

@Controller
public class userController {
	
	@Autowired
	userDAO userdao;
	
	@Autowired
	examDAO examdao;
	
	@RequestMapping(value="/loadsignup",method = RequestMethod.GET)
	public String signup(Model model) {
		userBean bean=new userBean();
		model.addAttribute("bean",bean);
		return "Registration";
	}
	
	@RequestMapping(value = "/loadlogin",method = RequestMethod.GET)
	public String loadlogin(Model model,userBean ubean) {
		model.addAttribute("bean",ubean);
		return "Login";
	}
	
	@RequestMapping(value = "/insertuser",method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") userBean userbean,Model model) {
		userdao.insert(userbean);
		model.addAttribute("user",userbean);
		return "user";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(userBean userbean,Model model,examBean ebean,HttpSession session) {
		String email=userbean.getEmail();
		String password=userbean.getPassword();
		if(email.equals("admin@admin.com")&&password.equals("admin")) {
			return "redirect:/admin";
		}
		List<userBean> ls=userdao.getUser();
			for (userBean userBean2 : ls) {
				if(userBean2.getEmail().equals(email) && userBean2.getPassword().equals(password)) {
					int uid=userBean2.getUserId();
					session.setAttribute("uid", uid);
					model.addAttribute("exam",ebean);
					return "Home";
			}			
		}
			return "redirect:/loadlogin";
	}
	
	@RequestMapping(value = "/exam",method = RequestMethod.POST)
	public String exam(examBean ebean,Model model,HttpSession session) {
		examBean exambean=examdao.getExambyCode(ebean.getEcode());
		if (exambean==null) {
			model.addAttribute("exam", ebean);
			return "Home";
		} else {
			ListUserExamBean userexamlist=new ListUserExamBean();
			List<UserExamBean> userExams=new ArrayList<UserExamBean>();
			userBean userbean=new userBean();
			userbean.setUserId((Integer)session.getAttribute("uid"));
			for (questionBean q : exambean.getQuestions()) {
				UserExamBean userexam=new UserExamBean();
				userexam.setEbean(exambean);
				userexam.setQbean(q);
				userexam.setUbean(userbean);
				userExams.add(userexam);
			}
			userexamlist.setListuserexam(userExams);
			model.addAttribute("userexams", userexamlist);
			return "UserExam";
 		}
		
	}
	
}
