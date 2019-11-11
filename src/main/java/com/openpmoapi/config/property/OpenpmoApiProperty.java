/**
 * 
 */
package com.openpmoapi.config.property;


import org.springframework.boot.context.properties.ConfigurationProperties;



/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-12
*/
@ConfigurationProperties("openpmo")
public class OpenpmoApiProperty {

	
	private String allowedOrigin = "http://ss07.planejamento.es.gov.br";
			//"http://localhost:4200";

	private final Security security = new Security();

	public Security getSecurity() {
		return security;
	}

	public String getAllowedOrigin() {
		return allowedOrigin;
	}

	public void setAllowedOrigin(String allowedOrigin) {
		this.allowedOrigin = allowedOrigin;
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
	
	
}
