package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.ProjectConverter;
import ru.zolotarev.portfolio.dto.ProjectDto;
import ru.zolotarev.portfolio.repository.ProjectRepository;
import ru.zolotarev.portfolio.sevice.ProjectService;

import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectConverter projectConverter;

	@Override
	public List<ProjectDto> getOrderedProjects() {
		return projectConverter.convert(projectRepository.findAllByOrderByIndex());
	}

	@Override
	public ProjectDto getProjectByName(String projectName) {
		return projectConverter.convert(projectRepository.findByName(projectName));
	}
}
