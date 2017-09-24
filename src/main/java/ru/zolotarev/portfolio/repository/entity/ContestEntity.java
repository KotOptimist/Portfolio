package ru.zolotarev.portfolio.repository.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contests", schema = "public", catalog = "portfolio")
public class ContestEntity {

	private int id;
	private String name;
	private String description;
	private String link;
	private Integer logo;
	private Integer files;
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
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "description", length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "link", length = 50)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
	@Column(name = "files")
	public Integer getFiles() {
		return files;
	}

	public void setFiles(Integer files) {
		this.files = files;
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
		ContestEntity that = (ContestEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				Objects.equals(link, that.link) &&
				Objects.equals(logo, that.logo) &&
				Objects.equals(files, that.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, link, logo, files, index);
	}
}
