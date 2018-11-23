/**
 * 
 */
package com.openpmoapi.event.listener;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.openpmoapi.event.FeatureCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-02
*/
@Component
public class ResourceCreateListener implements ApplicationListener<FeatureCreatedEvent> {

	
	@Override
	public void onApplicationEvent(FeatureCreatedEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		
		adicionarHeaderLocation(response, codigo);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
	
}


