
package com.openpmoapi.event.listener;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.openpmoapi.event.FeatureCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
* This is a class to create the resource listener
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Component
public class ResourceCreateListener implements ApplicationListener<FeatureCreatedEvent> {

	
	/**
	 * @param featureCreatedEvent
	 * 			This is a 
	 */
	@Override
	public void onApplicationEvent(FeatureCreatedEvent resourceCreatedEvent) {
		HttpServletResponse response = resourceCreatedEvent.getResponse();
		Long code = resourceCreatedEvent.getCode();
		
		addHeaderLocation(response, code);
	}

	private void addHeaderLocation(HttpServletResponse response, Long code) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
				.buildAndExpand(code).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
	
}


