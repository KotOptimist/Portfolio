package ru.zolotarev.portfolio.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "skills")
public final class Skill extends Model {

	@Column(name = "title", nullable = false)
	private String title;
}
