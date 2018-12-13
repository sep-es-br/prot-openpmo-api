/**
 * 
 */
package com.openpmoapi.config.token;


import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.openpmoapi.security.UsuarioSistema;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-11
*/
public class CustomTokenEnhancer implements TokenEnhancer{

	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
		
		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("name", usuarioSistema.getPerson().getName());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}
	
	

	
}
