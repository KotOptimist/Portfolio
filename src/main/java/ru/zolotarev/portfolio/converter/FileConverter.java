package ru.zolotarev.portfolio.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.zolotarev.portfolio.dto.FileDto;
import ru.zolotarev.portfolio.repository.entity.FileEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface FileConverter {

	FileDto convert(FileEntity fileEntity);

	List<FileDto> convert(List<FileEntity> fileEntities);
}
