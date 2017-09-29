package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;
import ru.zolotarev.portfolio.enums.EducationStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "education", schema = "public", catalog = "portfolio")
public class EducationEntity {

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
	private EducationStatus status;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FileEntity logo;
	@OneToMany(mappedBy = "groupId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FileEntity> files;
	@Column(name = "index", nullable = false)
	private int index;
}
