package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.ProjectStatus;

import java.util.List;

@Data
public class ProjectDto {

	private String name;
	private String description;
	private ProjectStatus status;
	private String keywords;
	private String source;
	private String link;
	private FileDto logo;
	private List<FileDto> files;

}
