package ru.zolotarev.portfolio.repository;


import ru.zolotarev.portfolio.repository.model.Company;

public interface CompanyRepository extends DataRepository<Company> {

    Company findByTitle(final String title);

    void deleteByTitle(final String title);

    Company findByUrl(final String url);

    void deleteByUrl(final String url);
}
