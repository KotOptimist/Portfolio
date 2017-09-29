package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.WorkStatus;

import java.time.LocalDate;
import java.util.List;

@Data
public class WorkDto {

	private String name;
	private String description;
	private WorkStatus status;
	private String position;
	private LocalDate startDate;
	private LocalDate endDate;
	private String link;
	private FileDto logo;
	private List<FileDto> files;
}
