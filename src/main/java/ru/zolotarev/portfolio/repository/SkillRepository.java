package ru.zolotarev.portfolio.repository;


public interface SkillRepository extends DataRepository<Skill> {

    Skill findByTitle(final String title);

    void deleteByTitle(final String title);
}
