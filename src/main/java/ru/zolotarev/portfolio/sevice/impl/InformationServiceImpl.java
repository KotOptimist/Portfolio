package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.InformationConverter;
import ru.zolotarev.portfolio.dto.InformationDto;
import ru.zolotarev.portfolio.repository.InformationRepository;
import ru.zolotarev.portfolio.sevice.InformationService;

import java.util.List;

@Slf4j
@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private InformationRepository informationRepository;

	@Autowired
	private InformationConverter informationConverter;

	@Override
	public List<InformationDto> getInformation() {
		return informationConverter.convert(informationRepository.findAll());
	}
}
