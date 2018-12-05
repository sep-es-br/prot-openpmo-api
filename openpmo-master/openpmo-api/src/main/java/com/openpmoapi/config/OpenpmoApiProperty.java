/**
 * 
 */
package com.openpmoapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("openpmo")
public class OpenpmoApiProperty {

	private String originAllowed = "http://localhost:8000";

	private final Security security = new Security();
	
	private final Mail mail = new Mail();
	
	private final S3 s3 = new S3();
	
	public S3 getS3() {
		return s3;
	}
	
	public Mail getMail() {
		return mail;
	}

	public Security getSecurity() {
		return security;
	}

	public String getOriginAllowed() {
		return originAllowed;
	}

	public void setOriginAllowed(String originAllowed) {
		this.originAllowed = originAllowed;
	}
	
	public static class S3 {
		
		private String accessKeyId;
		
		private String secretAccessKey;
		
		private String bucket = "aw-algamoney-arquivos";
		
		public String getBucket() {
			return bucket;
		}
		
		public void setBucket(String bucket) {
			this.bucket = bucket;
		}

		public String getAccessKeyId() {
			return accessKeyId;
		}

		public void setAccessKeyId(String accessKeyId) {
			this.accessKeyId = accessKeyId;
		}

		public String getSecretAccessKey() {
			return secretAccessKey;
		}

		public void setSecretAccessKey(String secretAccessKey) {
			this.secretAccessKey = secretAccessKey;
		}
	}

	public static class Security {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	}

	public static class Mail {
		
		private String host;
		
		private Integer port;
		
		private String username;
		
		private String password;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
