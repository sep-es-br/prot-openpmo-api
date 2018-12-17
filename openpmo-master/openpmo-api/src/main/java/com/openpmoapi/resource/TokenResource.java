/**
 * 
 */
package com.openpmoapi.resource;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.config.property.OpenpmoApiProperty;



/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-12
*/
@RestController
@RequestMapping("/tokens")
public class TokenResource {

	@Autowired
	private OpenpmoApiProperty openpmoApiProperty;
	
	
	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(openpmoApiProperty.getSecurity().isEnableHttps()); // TODO: Em producao sera true
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}
	
	
}
