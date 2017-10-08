package ru.zolotarev.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//TODO Сделать полноценные страницы ошибок
@Controller
public class ErrorPageController {

	@GetMapping(value = "/access_deny")
	public void accessDenyPage() throws IllegalAccessException {
		throw new IllegalAccessException("You do not have sufficient permissions to access this page.");
	}

	@GetMapping(value = "/error")
	public void errorPage(@RequestParam("class") String clazz, @RequestParam String message) throws Exception {
		throw new Exception(String.format("[%s]: %s", clazz, message));
	}
}
