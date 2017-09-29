package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skills", schema = "public", catalog = "portfolio")
public class SkillEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FileEntity logo;
	@Column(name = "index", nullable = false)
	private int index;
}
