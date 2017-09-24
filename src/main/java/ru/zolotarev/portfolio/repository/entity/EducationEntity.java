package ru.zolotarev.portfolio.repository.entity;

import ru.zolotarev.portfolio.repository.entity.enums.EducationStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "education", schema = "public", catalog = "portfolio")
public class EducationEntity {

	private int id;
	private String name;
	private String description;
	private EducationStatus status;
	private Date startDate;
	private Date endDate;
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
	public EducationStatus getStatus() {
		return status;
	}

	public void setStatus(EducationStatus status) {
		this.status = status;
	}

	@Basic
	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Basic
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
		EducationEntity that = (EducationEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(description, that.description) &&
				status == that.status &&
				Objects.equals(startDate, that.startDate) &&
				Objects.equals(endDate, that.endDate) &&
				Objects.equals(logo, that.logo) &&
				Objects.equals(files, that.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, status, startDate, endDate, logo, files, index);
	}
}
