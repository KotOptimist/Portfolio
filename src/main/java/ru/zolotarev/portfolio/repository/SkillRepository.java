package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.SkillEntity;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {
	List<SkillEntity> findAllByOrderByIndex();
}
