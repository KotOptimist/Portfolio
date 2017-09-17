package ru.zolotarev.portfolio.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "information")
public final class Information extends Model {

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "text", nullable = false)
	private String text;

	@Column(name = "keywords", nullable = false)
	private String keywords;

	@Column(name = "position", nullable = false)
	private String position;

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "logo_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private File logo;

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "slide_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private File slide;
}
