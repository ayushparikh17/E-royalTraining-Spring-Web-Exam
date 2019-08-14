package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.examBean;
import com.bean.questionBean;
import com.dao.examDAO;
import com.dao.questionDAO;

@Controller
public class questionsController {
	
	@Autowired
	questionDAO quedao;
	
	@Autowired
	examDAO examdao;
	
	@RequestMapping(value="/loadquestion",method = RequestMethod.GET)
	public String loadquestion(questionBean bean,Model model) {
		List<examBean> list=examdao.getExam();
		model.addAttribute("examlist",list);
		model.addAttribute("bean",bean);
		
		return "QuestionInsert";
	}
	
	@RequestMapping(value = "/insertquestion",method = RequestMethod.POST)
	public String insertQuestion(questionBean bean,Model model) {
		quedao.insert(bean);
		return "redirect:/admin";
	}
}
