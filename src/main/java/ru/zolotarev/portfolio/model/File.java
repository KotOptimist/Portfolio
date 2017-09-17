package ru.zolotarev.portfolio.model;

import lombok.Data;
import ru.zolotarev.portfolio.enums.FileType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "files")
public final class File extends Model {

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "url", nullable = false, unique = true)
	private String url;

	@Column(name = "with_title", nullable = false)
	private boolean withTitle;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private FileType type;
}
