package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.WorkConverter;
import ru.zolotarev.portfolio.dto.WorkDto;
import ru.zolotarev.portfolio.repository.WorkRepository;
import ru.zolotarev.portfolio.sevice.WorkService;

import java.util.List;

@Slf4j
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private WorkConverter workConverter;

	@Override
	public List<WorkDto> getOrderedWorks() {
		return workConverter.convert(workRepository.findAllByOrderByIndex());
	}
}
