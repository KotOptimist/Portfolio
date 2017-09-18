package ru.zolotarev.portfolio.repository.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contacts")
public final class Contacts extends Model {

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "vkontakte", nullable = false)
	private String vkontakte;

	@Column(name = "facebook", nullable = false)
	private String facebook;

	@Column(name = "twitter", nullable = false)
	private String twitter;

	@Column(name = "linkedin", nullable = false)
	private String linkedin;

	@Column(name = "github", nullable = false)
	private String github;

	@Column(name = "skype", nullable = false)
	private String skype;
}
