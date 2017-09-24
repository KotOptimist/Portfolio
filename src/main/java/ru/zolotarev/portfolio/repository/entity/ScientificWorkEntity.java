package ru.zolotarev.portfolio.repository.entity;

import ru.zolotarev.portfolio.repository.entity.enums.ScientificWorkStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scientific_works", schema = "public", catalog = "portfolio")
public class ScientificWorkEntity {

	private int id;
	private String name;
	private String description;
	private String link;
	private ScientificWorkStatus status;
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
	@Column(name = "status", nullable = false)
	public ScientificWorkStatus getStatus() {
		return status;
	}

	public void setStatus(ScientificWorkStatus status) {
		this.status = status;
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
		ScientificWorkEntity that = (ScientificWorkEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				Objects.equals(link, that.link) &&
				status == that.status &&
				Objects.equals(files, that.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, link, status, files, index);
	}
}
