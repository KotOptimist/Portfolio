package ru.zolotarev.portfolio.sevice;

import ru.zolotarev.portfolio.dto.ContestDto;

import java.util.List;

public interface ContestService {
	List<ContestDto> getOrderedContests();
}
