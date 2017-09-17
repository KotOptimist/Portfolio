package ru.zolotarev.portfolio.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.zolotarev.portfolio.enums.UserRole;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public final class User extends Model {

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

	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JoinColumn(
			name = "contacts_id",
			referencedColumnName = "id"
	)
	@Fetch(FetchMode.JOIN)
	private Contacts contacts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_experiences",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "experience_id")
	)
	private Set<Experience> experiences;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_educations",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "education_id")
	)
	private Set<Education> educations;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_courses",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private Set<Education> courses;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_skills",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "skill_id")
	)
	private Set<Skill> skills;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_languages",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "language_id")
	)
	private Set<Language> languages;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "login", nullable = false)
	private String encryptedLogin;

	@Column(name = "password", nullable = false)
	private String encryptedPassword;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;
}
