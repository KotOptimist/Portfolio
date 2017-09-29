package ru.zolotarev.portfolio.dto;

import lombok.Data;
import ru.zolotarev.portfolio.enums.LanguageLevel;

@Data
public class LanguageDto {

	private String name;
	private LanguageLevel level;
}
