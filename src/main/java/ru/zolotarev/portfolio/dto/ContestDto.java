package ru.zolotarev.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContestDto {

	private String name;
	private String description;
	private String link;
	private FileDto logo;
	private List<FileDto> files;
}
