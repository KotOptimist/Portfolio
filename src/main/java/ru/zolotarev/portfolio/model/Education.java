package ru.zolotarev.portfolio.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "educations")
public final class Education extends Model {

	@Column(name = "title", nullable = false)
	private String title;

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "experience_id",
			referencedColumnName = "id",
			nullable = false
	)
	@Fetch(FetchMode.JOIN)
	private Experience experience;

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "certificate_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private File certificate;
}
