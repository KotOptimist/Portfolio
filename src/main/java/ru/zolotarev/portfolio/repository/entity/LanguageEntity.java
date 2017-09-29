package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;
import ru.zolotarev.portfolio.enums.LanguageLevel;

import javax.persistence.*;

@Data
@Entity
@Table(name = "languages", schema = "public", catalog = "portfolio")
public class LanguageEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "level", nullable = false)
	private LanguageLevel level;
	@Column(name = "index", nullable = false)
	private int index;

}
