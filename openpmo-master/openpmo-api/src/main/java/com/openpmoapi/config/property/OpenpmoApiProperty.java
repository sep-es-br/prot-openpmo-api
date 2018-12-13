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

	
	private String originPermitida = "http://localhost:4200";

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public static class Seguranca {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}
	
	
}
