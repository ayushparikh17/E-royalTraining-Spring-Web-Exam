package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.examBean;
import com.bean.questionBean;
import com.dao.examDAO;
import com.dao.questionDAO;

@Controller
public class examController {
	@Autowired
	examDAO examdao;
	
	@Autowired
	questionDAO quedao;
	
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String loadAdmin() {
		return "Admin";
	}
	
	@RequestMapping(value="/loadexam",method = RequestMethod.GET)
	public String loadexam(examBean bean,Model model) {
		model.addAttribute("bean",bean);
		return "Exam";
	}
	
	@RequestMapping(value = "/insertexam",method = RequestMethod.POST)
	public String insertExam(examBean bean,Model model) {
		examdao.insert(bean);
		return "redirect:/listexam";
	}
	
	@RequestMapping(value="/listexam",method = RequestMethod.GET)
	public String listExam(examBean bean,Model model){
		List<examBean> ls=examdao.getExam();
		model.addAttribute("list",ls);
		return "listExam";
	}
	
	@RequestMapping(value = "/editexam/{id}",method = RequestMethod.GET)
	public String editExam(@PathVariable("id")int id,Model model) {
		examBean bean=examdao.getExambyId(id);
		model.addAttribute("bean",bean);
		return "UpdateExam";
	}
	
	@RequestMapping(value = "/updateexam",method = RequestMethod.POST)
	public String updateExam(@ModelAttribute("bean")examBean bean,Model model) {
		examdao.update(bean);
		return "redirect:/listexam";
	}
	
	@RequestMapping(value = "/deleteexam/{id}",method = RequestMethod.GET)
	public String deleteExam(@PathVariable("id")int id) {
		examBean bean=examdao.getExambyId(id);
		examdao.delete(bean);
		return "redirect:/listexam";
	}
	
	
}
