package ru.zolotarev.portfolio.repository.entity;

import ru.zolotarev.portfolio.repository.entity.enums.ProjectStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "public", catalog = "portfolio")
public class ProjectEntity {

	private int id;
	private String name;
	private String description;
	private ProjectStatus status;
	private String keywords;
	private String source;
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
	@Column(name = "status", nullable = false)
	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	@Basic
	@Column(name = "keywords", length = -1)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Basic
	@Column(name = "source", length = 50)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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
		ProjectEntity that = (ProjectEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				status == that.status &&
				Objects.equals(keywords, that.keywords) &&
				Objects.equals(source, that.source) &&
				Objects.equals(link, that.link) &&
				Objects.equals(logo, that.logo) &&
				Objects.equals(files, that.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, status, keywords, source, link, logo, files, index);
	}
}
