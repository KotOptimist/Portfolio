package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.InformationDto;

import java.util.List;

public interface InformationService {
	List<InformationDto> getInformation();
}
