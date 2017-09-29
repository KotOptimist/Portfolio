package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.EducationDto;

import java.util.List;

public interface EducationService {
	List<EducationDto> getOrderedEducations();
}
