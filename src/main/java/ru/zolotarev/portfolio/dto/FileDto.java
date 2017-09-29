package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.FileType;

@Data
public class FileDto {

	private String name;
	private String path;
	private FileType type;
}
