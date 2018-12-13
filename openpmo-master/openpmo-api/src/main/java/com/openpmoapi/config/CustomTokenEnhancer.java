package com.openpmoapi.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
* This class configure the token of the api
*
* @author marcos.santos  
* @since 2018-12-06
*/
public class CustomTokenEnhancer implements TokenEnhancer {
	
	
	/**
	 * @param accessToken
	 * 			This is the access token provide by the OAuth 
	 * @param authentication
	 * 			This is the authentication token provide by the OAuth
	 * 
	 * @return this method will return a access token for the api
	 */
	@Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("organization", " Token Custom ");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
	
	
}
