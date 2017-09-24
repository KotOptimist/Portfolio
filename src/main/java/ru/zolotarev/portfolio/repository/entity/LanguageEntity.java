package ru.zolotarev.portfolio.repository.entity;

import ru.zolotarev.portfolio.repository.entity.enums.LanguageLevel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "languages", schema = "public", catalog = "portfolio")
public class LanguageEntity {

	private int id;
	private String name;
	private LanguageLevel level;
	private int index;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "level", nullable = false)
	public LanguageLevel getLevel() {
		return level;
	}

	public void setLevel(LanguageLevel level) {
		this.level = level;
	}

	@Basic
	@Column(name = "index", nullable = false)
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LanguageEntity that = (LanguageEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				level == that.level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, level, index);
	}
}
