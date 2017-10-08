package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.InformationDto;
import ru.zolotarev.portfolio.repository.entity.InformationEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = FileConverter.class)
public interface InformationConverter {

	InformationDto convert(InformationEntity informationEntity);

	List<InformationDto> convert(List<InformationEntity> informationEntities);
}
