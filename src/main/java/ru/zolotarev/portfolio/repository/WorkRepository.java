package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.WorkEntity;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Integer> {
	List<WorkEntity> findAllByOrderByIndex();
}
