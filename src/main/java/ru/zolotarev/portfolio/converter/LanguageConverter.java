package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.LanguageDto;
import ru.zolotarev.portfolio.repository.entity.LanguageEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface LanguageConverter {

	LanguageDto convert(LanguageEntity languageEntity);

	List<LanguageDto> convert(List<LanguageEntity> languageEntities);
}
