package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "contests", schema = "public", catalog = "portfolio")
public class ContestEntity {

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
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FileEntity logo;
	@OneToMany(mappedBy = "groupId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FileEntity> files;
	@Column(name = "index", nullable = false)
	private int index;
}
