package ru.zolotarev.portfolio.repository;

import com.salimov.yurii.entity.Skill;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface SkillRepository extends DataRepository<Skill> {

    Skill findByTitle(final String title);

    void deleteByTitle(final String title);
}
