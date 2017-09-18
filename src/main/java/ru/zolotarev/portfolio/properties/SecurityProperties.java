package ru.zolotarev.portfolio.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties("security")
public class SecurityProperties {

	private Page page;
	private DefaultSuccess defaultSuccess;
	private User admin;
	private User user;

	@Getter
	public static class Page {
		private String admin;
		private String login;
		private String accessDeny;
	}

	@Getter
	public static class DefaultSuccess {
		private String page;
		private boolean alwaysUse;
	}

	@Getter
	public static class User {
		private String login;
		private String password;
	}
}
