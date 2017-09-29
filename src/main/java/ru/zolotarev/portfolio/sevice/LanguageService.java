package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.LanguageDto;

import java.util.List;

public interface LanguageService {
	List<LanguageDto> getOrderedLanguages();
}
