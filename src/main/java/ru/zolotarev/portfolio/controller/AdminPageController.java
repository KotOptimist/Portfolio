package ru.zolotarev.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AdminPageController {

	@GetMapping("/admin")
	public ModelAndView adminPageView(final ModelAndView modelAndView){
		return null;
	}

	@GetMapping("/login")
	public ModelAndView loginPageView(final ModelAndView modelAndView) {
		return null;
	}
}
