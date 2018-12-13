/**
 * 
 */
package com.openpmoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-06
*/


@Profile("oauth-security")
@Configuration
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

	 	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/person").permitAll()
				.anyRequest().authenticated()
				.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(true);
	}
	
	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
	
	
	
//	 	@Autowired
//		private UserDetailsService userDetailsService;
//	 	
//	 	@Autowired
//	 	private MethodSecurityConfig methodSecurityConfig;
//	 	
//
//	 	
//	    @Autowired
//	    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
//	        // @formatter:off
//	       // auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("USER");
//	    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	    	
//	    }
//
//	    @Override
//	    @Bean
//	    public AuthenticationManager authenticationManagerBean() throws Exception {
//	        return super.authenticationManagerBean();
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests().antMatchers("/api/person").permitAll().anyRequest().authenticated().and()
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
//
//	    }
//
//	    @Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers("/api/person");
//	    }
//
//	
//	
//	    @Bean
//	    public BCryptPasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	    
//	    @Bean
//		public MethodSecurityExpressionHandler createExpressionHandler() {
//			return new OAuth2MethodSecurityExpressionHandler();
//	    }
//	    
//	
	  
}
