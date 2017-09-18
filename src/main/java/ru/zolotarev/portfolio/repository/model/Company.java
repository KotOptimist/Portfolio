package ru.zolotarev.portfolio.repository.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public final class Company extends Model {

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "url", nullable = false)
	private String url;

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

	@Column(name = "index", nullable = false)
	private int index;
}
