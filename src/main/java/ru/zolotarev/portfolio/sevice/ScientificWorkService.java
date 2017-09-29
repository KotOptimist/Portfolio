package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.ScientificWorkDto;

import java.util.List;

public interface ScientificWorkService {
	List<ScientificWorkDto> getOrderedScientificWorks();
}
