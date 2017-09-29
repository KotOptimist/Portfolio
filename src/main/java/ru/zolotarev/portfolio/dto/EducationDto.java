package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.EducationStatus;

import java.time.LocalDate;
import java.util.List;

@Data
public class EducationDto {

	private String name;
	private String description;
	private EducationStatus status;
	private LocalDate startDate;
	private LocalDate endDate;
	private FileDto logo;
	private List<FileDto> files;
}
