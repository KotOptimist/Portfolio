package ru.zolotarev.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.zolotarev.portfolio.sevice.*;

@Slf4j
@Controller
public class MainPageController {

	@Autowired
	private ContestService contestService;
	@Autowired
	private EducationService educationService;
	@Autowired
	private InformationService informationService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ScientificWorkService scientificWorkService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private WorkService workService;
	@Autowired
	private FileService fileService;

	@GetMapping(value = {"", "/", "/index", "/home"})
	public ModelAndView mainPageView(final ModelAndView modelAndView) {
		log.info("Opening main page");
		modelAndView.addObject("information", informationService.getInformation());
		modelAndView.addObject("contests", contestService.getOrderedContests());
		modelAndView.addObject("educations", educationService.getOrderedEducations());
		modelAndView.addObject("languages", languageService.getOrderedLanguages());
		modelAndView.addObject("projects", projectService.getOrderedProjects());
		modelAndView.addObject("scientificWorks", scientificWorkService.getOrderedScientificWorks());
		modelAndView.addObject("skills", skillService.getOrderedSkills());
		modelAndView.addObject("works", workService.getOrderedWorks());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping(value = "/project/{name}")
	public ModelAndView projectPageViewByName(@PathVariable(value = "name") String projectName, final ModelAndView modelAndView) {
		log.debug("Opening project page for: {}", projectName);
		modelAndView.addObject("project", projectService.getProjectByName(projectName));
		modelAndView.setViewName("project");
		return modelAndView;
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		log.warn("Main page exception. Reason[{}]: {}", ex.getClass(), ex.getMessage());
		return "redirect:error";
	}
}
