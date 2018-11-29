/**
 * 
 */
package com.openpmoapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-28
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

	@Configuration
	@EnableWebSecurity
	@EnableResourceServer
	public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

		@Autowired
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("teste").password(passwordEncoder().encode("123")).roles("ADMIN").and()
					.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/office").permitAll()
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
		static PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	
}
