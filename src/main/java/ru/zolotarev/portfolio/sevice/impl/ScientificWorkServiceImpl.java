package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.ScientificWorkConverter;
import ru.zolotarev.portfolio.dto.ScientificWorkDto;
import ru.zolotarev.portfolio.repository.ScientificWorkRepository;
import ru.zolotarev.portfolio.sevice.ScientificWorkService;

import java.util.List;

@Slf4j
@Service
public class ScientificWorkServiceImpl implements ScientificWorkService {

	@Autowired
	private ScientificWorkRepository scientificWorkRepository;

	@Autowired
	private ScientificWorkConverter scientificWorkConverter;

	@Override
	public List<ScientificWorkDto> getOrderedScientificWorks() {
		return scientificWorkConverter.convert(scientificWorkRepository.findAllByOrderByIndex());
	}
}
