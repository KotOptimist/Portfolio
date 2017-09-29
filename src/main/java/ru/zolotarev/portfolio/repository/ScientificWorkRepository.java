package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.ScientificWorkEntity;

import java.util.List;

@Repository
public interface ScientificWorkRepository extends JpaRepository<ScientificWorkEntity, Integer> {
	List<ScientificWorkEntity> findAllByOrderByIndex();
}
