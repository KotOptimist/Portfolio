package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.LanguageConverter;
import ru.zolotarev.portfolio.dto.LanguageDto;
import ru.zolotarev.portfolio.repository.LanguageRepository;
import ru.zolotarev.portfolio.sevice.LanguageService;

import java.util.List;

@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private LanguageConverter languageConverter;

	@Override
	public List<LanguageDto> getOrderedLanguages() {
		return languageConverter.convert(languageRepository.findAllByOrderByIndex());
	}
}
