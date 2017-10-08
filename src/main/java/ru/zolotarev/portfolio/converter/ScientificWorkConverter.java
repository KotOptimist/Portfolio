package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.ScientificWorkDto;
import ru.zolotarev.portfolio.repository.entity.ScientificWorkEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = FileConverter.class)
public interface ScientificWorkConverter {

	ScientificWorkDto convert(ScientificWorkEntity scientificWorkEntity);

	List<ScientificWorkDto> convert(List<ScientificWorkEntity> scientificWorkEntities);
}
