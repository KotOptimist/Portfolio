package ru.zolotarev.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zolotarev.portfolio.repository.entity.InformationEntity;

@Repository
public interface InformationRepository extends JpaRepository<InformationEntity, Integer> {
}
