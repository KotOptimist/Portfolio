package ru.zolotarev.portfolio.repository;

import com.salimov.yurii.entity.Company;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface CompanyRepository extends DataRepository<Company> {

    Company findByTitle(final String title);

    void deleteByTitle(final String title);

    Company findByUrl(final String url);

    void deleteByUrl(final String url);
}
