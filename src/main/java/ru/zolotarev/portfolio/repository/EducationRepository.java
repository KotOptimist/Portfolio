package ru.zolotarev.portfolio.repository;

import ru.zolotarev.portfolio.repository.model.Education;

public interface EducationRepository extends DataRepository<Education> {

    Education findByTitle(final String title);

    void deleteByTitle(final String title);
}
