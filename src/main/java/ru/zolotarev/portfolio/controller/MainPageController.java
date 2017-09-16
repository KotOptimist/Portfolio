package ru.zolotarev.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

	private final UserService userService;
	private final ProjectService projectService;
	private final FileService fileService;
	private final SkillService skillService;
	private final EducationService educationService;
	private final ExperienceService experienceService;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public MainPageController(
			final UserService userService,
			final ProjectService projectService,
			final FileService fileService,
			final SkillService skillService,
			final EducationService educationService,
			final ExperienceService experienceService) {
		this.userService = userService;
		this.projectService = projectService;
		this.fileService = fileService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.experienceService = experienceService;
	}

	@RequestMapping(value = {"", "/", "/index", "/home"}, method = RequestMethod.GET)
	public ModelAndView getHomePage(final ModelAndView modelAndView) {
		modelAndView.addObject("admin", this.userService.getAuthenticatedUser() != null);
		final User user = this.userService.getMainUserByEager();
		modelAndView.addObject("user", user);
		modelAndView.addObject("experiences", this.experienceService.sortByNumber(user.getExperiences()));
		modelAndView.addObject("educations", this.educationService.sortByNumber(user.getEducations()));
		modelAndView.addObject("courses", this.educationService.sortByNumber(user.getCourses()));
		modelAndView.addObject("skills", this.skillService.sortByNumber(user.getSkills()));
		modelAndView.addObject("languages", user.getLanguages());
		modelAndView.addObject("projects", this.projectService.getAndSortByIndex());
		modelAndView.addObject("slide", this.fileService.getRandomByFileType(FileType.SLIDE));
		modelAndView.setViewName("client/home/index");
		return modelAndView;
	}

	@RequestMapping(value = "/project/{url}", method = RequestMethod.GET)
	public ModelAndView getProjectByUrlPage(@PathVariable(value = "url") final String url, final ModelAndView modelAndView) {
		modelAndView.addObject("user", this.userService.getMainUser());
		modelAndView.addObject("project", this.projectService.getByUrl(url));
		modelAndView.addObject("admin", this.userService.getAuthenticatedUser() != null);
		modelAndView.setViewName("client/project/one");
		return modelAndView;
	}
}
