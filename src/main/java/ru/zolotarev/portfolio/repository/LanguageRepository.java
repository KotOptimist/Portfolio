package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.LanguageEntity;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer>{
	List<LanguageEntity> findAllByOrderByIndex();
}
