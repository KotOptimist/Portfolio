package ru.zolotarev.portfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InformationDto {

	private String firstName;
	private String secondName;
	private String description;
	private LocalDate dob;
	private String phoneNumber;
	private String email;
	private String github;
	private String skype;
	private String linkedin;
	private String vk;
	private FileDto photo;
	private List<FileDto> files;
}
