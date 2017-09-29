package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.ContestConverter;
import ru.zolotarev.portfolio.dto.ContestDto;
import ru.zolotarev.portfolio.repository.ContestRepository;
import ru.zolotarev.portfolio.sevice.ContestService;

import java.util.List;

@Slf4j
@Service
public class ContestServiceImpl implements ContestService {

	@Autowired
	private ContestRepository contestRepository;

	@Autowired
	private ContestConverter contestConverter;

	@Override
	public List<ContestDto> getOrderedContests() {
		return contestConverter.convert(contestRepository.findAllByOrderByIndex());
	}
}
