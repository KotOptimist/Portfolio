package ru.zolotarev.portfolio.repository;


public interface LanguageRepository extends DataRepository<Language> {

    Language findByName(final String name);

    void deleteByName(final String name);
}
