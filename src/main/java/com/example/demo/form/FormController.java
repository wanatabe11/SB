package com.example.demo.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SampleDao;
import com.example.demo.entity.EntForm;


@Controller
public class FormController {
	@RequestMapping("/sample")
	//”/sample”の注文がきたときの処理
	public String top(Model model) {
		model.addAttribute("message", "トップページ");
		return "index";
	}

	@RequestMapping("/form")
	public String form(Model model, Form form) {
		model.addAttribute("title","サンプルフォーム");
		return "form/input";
	}
	
	@RequestMapping("/confirm")
	public String confirm(@Validated Form form, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "入力ページ");
			return "form/input";
		}
		model.addAttribute("title", "確認ページ");
		return "form/confirm";
	}
	
	//SampleDaoの用意
		private final SampleDao sampledao;

		@Autowired
		public FormController(SampleDao sampledao) {
			this.sampledao = sampledao;
		}

		//完了の処理
		@RequestMapping ("/complete")
		public String complete(Form form, Model model){
			EntForm entform = new EntForm();
			entform.setName(form.getName1());
			entform.setAge(form.getAge1());
			sampledao.insertDb(entform);
			return "form/complete";
		}
	
	
	
}
