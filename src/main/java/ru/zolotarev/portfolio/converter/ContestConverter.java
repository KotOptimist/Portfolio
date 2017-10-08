package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.ContestDto;
import ru.zolotarev.portfolio.repository.entity.ContestEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = FileConverter.class)
public interface ContestConverter {

	ContestDto convert(ContestEntity contestEntity);

	List<ContestDto> convert(List<ContestEntity> contestEntities);
}
