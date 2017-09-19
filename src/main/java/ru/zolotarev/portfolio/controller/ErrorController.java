package ru.zolotarev.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {


	@GetMapping(value = "/illegal_access")
	public void getIllegalAccessException() throws IllegalAccessException {
		throw new IllegalAccessException("You do not have sufficient permissions to access this page.");
	}
}
