package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.EducationDto;
import ru.zolotarev.portfolio.repository.entity.EducationEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = FileConverter.class)
public interface EducationConverter {

	EducationDto convert(EducationEntity educationEntity);

	List<EducationDto> convert(List<EducationEntity> educationEntities);
}
