package ru.zolotarev.portfolio.repository.model;

import lombok.Data;
import ru.zolotarev.portfolio.enums.LanguageLevel;

import javax.persistence.*;


@Data
@Entity
@Table(name = "languages")
public final class Language extends Model {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private LanguageLevel level;
}
