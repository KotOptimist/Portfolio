package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
	List<ProjectDto> getOrderedProjects();

	ProjectDto getProjectByName(String projectName);
}
