package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.EducationEntity;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {
	List<EducationEntity> findAllByOrderByIndex();
}
