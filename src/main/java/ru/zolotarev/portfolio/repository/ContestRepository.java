package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.ContestEntity;

import java.util.List;

@Repository
public interface ContestRepository extends JpaRepository<ContestEntity, Integer> {
	List<ContestEntity> findAllByOrderByIndex();
}
