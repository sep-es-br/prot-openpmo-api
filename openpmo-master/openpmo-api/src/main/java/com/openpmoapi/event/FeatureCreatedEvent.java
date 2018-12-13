
package com.openpmoapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
public class FeatureCreatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long code;

	/**
	 * 
	 * @param source
	 * 			This is the objec that will be changed
	 * @param response
	 * 			This is the answer of the server
	 * @param code
	 * 			
	 */
	public FeatureCreatedEvent(Object source, HttpServletResponse response, Long code) {
		super(source);
		this.response = response;
		this.code = code;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCode() {
		return code;
	}
	
}