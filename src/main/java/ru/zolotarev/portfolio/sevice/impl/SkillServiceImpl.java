package ru.zolotarev.portfolio.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zolotarev.portfolio.converter.SkillConverter;
import ru.zolotarev.portfolio.dto.SkillDto;
import ru.zolotarev.portfolio.repository.SkillRepository;
import ru.zolotarev.portfolio.sevice.SkillService;

import java.util.List;

@Slf4j
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SkillConverter skillConverter;

	@Override
	public List<SkillDto> getOrderedSkills() {
		return skillConverter.convert(skillRepository.findAllByOrderByIndex());
	}
}
