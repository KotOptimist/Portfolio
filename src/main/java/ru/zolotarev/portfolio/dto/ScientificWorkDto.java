package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.ScientificWorkStatus;

import java.util.List;

@Data
public class ScientificWorkDto {

	private String name;
	private String description;
	private String link;
	private ScientificWorkStatus status;
	private List<FileDto> files;
}
