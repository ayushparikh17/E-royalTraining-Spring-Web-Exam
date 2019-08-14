package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ListUserExamBean;
import com.bean.UserExamBean;
import com.bean.examBean;
import com.bean.questionBean;
import com.bean.userBean;
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
			model.addAttribute("userexams",userexams);
			
			return "Result";
		}
	
}
