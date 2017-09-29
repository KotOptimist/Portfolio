package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.ProjectDto;
import ru.zolotarev.portfolio.repository.entity.ProjectEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ProjectConverter {

	ProjectDto convert(ProjectEntity projectEntity);

	List<ProjectDto> convert(List<ProjectEntity> projectEntities);
}
