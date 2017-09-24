package ru.zolotarev.portfolio.repository.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "information", schema = "public", catalog = "portfolio")
public class InformationEntity {

	private int id;
	private String firstName;
	private String secondName;
	private String description;
	private Date dob;
	private String phoneNumber;
	private String email;
	private String github;
	private String skype;
	private String linkedin;
	private String vk;
	private Integer photo;
	private Integer files;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "first_name", nullable = false, length = 15)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "second_name", nullable = false, length = 15)
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Basic
	@Column(name = "description", length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Basic
	@Column(name = "phone_number", unique = true, length = 20)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Basic
	@Column(name = "email", unique = true, length = 25)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "github", length = 50)
	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	@Basic
	@Column(name = "skype", length = 30)
	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@Basic
	@Column(name = "linkedin", length = 50)
	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	@Basic
	@Column(name = "vk", length = 50)
	public String getVk() {
		return vk;
	}

	public void setVk(String vk) {
		this.vk = vk;
	}

	@Basic
	@Column(name = "photo")
	public Integer getPhoto() {
		return photo;
	}

	public void setPhoto(Integer photo) {
		this.photo = photo;
	}

	@Basic
	@Column(name = "files")
	public Integer getFiles() {
		return files;
	}

	public void setFiles(Integer files) {
		this.files = files;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InformationEntity that = (InformationEntity) o;
		return id == that.id &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(secondName, that.secondName) &&
				Objects.equals(description, that.description) &&
				Objects.equals(dob, that.dob) &&
				Objects.equals(phoneNumber, that.phoneNumber) &&
				Objects.equals(email, that.email) &&
				Objects.equals(github, that.github) &&
				Objects.equals(skype, that.skype) &&
				Objects.equals(linkedin, that.linkedin) &&
				Objects.equals(vk, that.vk) &&
				Objects.equals(photo, that.photo) &&
				Objects.equals(files, that.files);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, secondName, description, dob, phoneNumber, email, github, skype, linkedin, vk, photo, files);
	}
}
