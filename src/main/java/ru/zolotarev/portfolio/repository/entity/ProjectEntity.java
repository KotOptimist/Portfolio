package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;
import ru.zolotarev.portfolio.enums.ProjectStatus;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "projects", schema = "public", catalog = "portfolio")
public class ProjectEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "description", length = -1)
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private ProjectStatus status;
	@Column(name = "keywords", length = -1)
	private String keywords;
	@Column(name = "source", length = 50)
	private String source;
	@Column(name = "link", length = 50)
	private String link;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FileEntity logo;
	@OneToMany(mappedBy = "groupId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FileEntity> files;
	@Column(name = "index", nullable = false)
	private int index;

}
