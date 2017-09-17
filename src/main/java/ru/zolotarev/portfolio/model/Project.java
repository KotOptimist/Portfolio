package ru.zolotarev.portfolio.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "projects")
public final class Project extends Model {

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "information_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private Information information;

	@Column(name = "url", nullable = false, unique = true)
	private String url;

	@Column(name = "source", nullable = false)
	private String source;

	@Column(name = "link", nullable = false)
	private String link;
}
