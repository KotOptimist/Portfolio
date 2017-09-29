package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.SkillDto;
import ru.zolotarev.portfolio.repository.entity.SkillEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface SkillConverter {

	SkillDto convert(SkillEntity skillEntity);

	List<SkillDto> convert(List<SkillEntity> skillEntities);
}
