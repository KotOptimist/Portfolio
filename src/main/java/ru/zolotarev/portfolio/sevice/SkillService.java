package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.SkillDto;

import java.util.List;

public interface SkillService {
	List<SkillDto> getOrderedSkills();
}
