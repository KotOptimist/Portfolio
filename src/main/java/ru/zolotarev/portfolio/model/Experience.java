package ru.zolotarev.portfolio.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "experiences")
public final class Experience extends Model {

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "company_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private Company company;

	@Column(name = "position", nullable = false)
	private String position;

	@Column(name = "start_month", nullable = false)
	private int startMonth;

	@Column(name = "start_year", nullable = false)
	private int startYear;

	@Column(name = "end_month", nullable = false)
	private int endMonth;

	@Column(name = "end_year", nullable = false)
	private int endYear;

	@Column(name = "is_now", nullable = false)
	private boolean isNow;
}
