package ru.zolotarev.portfolio.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("security")
public class SecurityProperties {

	private Page page;
	private DefaultSuccess defaultSuccess;
	private User admin;
	private User user;

	@Getter
	@Setter
	public static class Page {
		private String admin;
		private String login;
		private String accessDeny;
	}

	@Getter
	@Setter
	public static class DefaultSuccess {
		private String page;
		private boolean alwaysUse;
	}

	@Getter
	@Setter
	public static class User {
		private String login;
		private String password;
	}
}
