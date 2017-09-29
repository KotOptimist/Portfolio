package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.EducationConverter;
import ru.zolotarev.portfolio.dto.EducationDto;
import ru.zolotarev.portfolio.repository.EducationRepository;
import ru.zolotarev.portfolio.sevice.EducationService;

import java.util.List;

@Slf4j
@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private EducationConverter educationConverter;

	@Override
	public List<EducationDto> getOrderedEducations() {
		return educationConverter.convert(educationRepository.findAllByOrderByIndex());
	}
}
