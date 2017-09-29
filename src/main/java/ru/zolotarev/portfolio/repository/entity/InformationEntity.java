package ru.zolotarev.portfolio.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "information", schema = "public", catalog = "portfolio")
public class InformationEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name", nullable = false, length = 15)
	private String firstName;
	@Column(name = "second_name", nullable = false, length = 15)
	private String secondName;
	@Column(name = "description", length = -1)
	private String description;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "phone_number", unique = true, length = 20)
	private String phoneNumber;
	@Column(name = "email", unique = true, length = 25)
	private String email;
	@Column(name = "github", length = 50)
	private String github;
	@Column(name = "skype", length = 30)
	private String skype;
	@Column(name = "linkedin", length = 50)
	private String linkedin;
	@Column(name = "vk", length = 50)
	private String vk;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FileEntity photo;
	@OneToMany(mappedBy = "groupId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FileEntity> files;
}
