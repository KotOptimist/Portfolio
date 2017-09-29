package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;
import ru.zolotarev.portfolio.enums.ScientificWorkStatus;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "scientific_works", schema = "public", catalog = "portfolio")
public class ScientificWorkEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "description", length = -1)
	private String description;
	@Column(name = "link", length = 50)
	private String link;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private ScientificWorkStatus status;
	@OneToMany(mappedBy = "groupId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FileEntity> files;
	@Column(name = "index", nullable = false)
	private int index;
}
