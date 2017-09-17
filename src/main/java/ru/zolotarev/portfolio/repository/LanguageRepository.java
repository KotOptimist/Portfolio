package ru.zolotarev.portfolio.repository;

import com.salimov.yurii.entity.Language;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface LanguageRepository extends DataRepository<Language> {

    Language findByName(final String name);

    void deleteByName(final String name);
}
