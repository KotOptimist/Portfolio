package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;
import ru.zolotarev.portfolio.enums.FileType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "files", schema = "public", catalog = "portfolio")
public class FileEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "path", nullable = false, unique = true, length = 50)
	private String path;
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private FileType type;
	@Column(name = "group_id")
	private Integer groupId;
}
