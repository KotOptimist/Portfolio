package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.WorkDto;

import java.util.List;

public interface WorkService {
	List<WorkDto> getOrderedWorks();
}
