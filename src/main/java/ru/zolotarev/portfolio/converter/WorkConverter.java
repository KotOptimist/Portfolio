package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.WorkDto;
import ru.zolotarev.portfolio.repository.entity.WorkEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface WorkConverter {

	WorkDto convert(WorkEntity workEntity);

	List<WorkDto> convert(List<WorkEntity> workEntities);
}
