package ru.zolotarev.portfolio.repository.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills", schema = "public", catalog = "portfolio")
public class SkillEntity {

	private int id;
	private String name;
	private Integer logo;
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
	@Column(name = "logo")
	public Integer getLogo() {
		return logo;
	}

	public void setLogo(Integer logo) {
		this.logo = logo;
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
		SkillEntity that = (SkillEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(logo, that.logo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, logo, index);
	}
}
