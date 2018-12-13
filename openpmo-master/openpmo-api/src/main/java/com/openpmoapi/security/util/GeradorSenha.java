/**
 * 
 */
package com.openpmoapi.security.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-12-11
*/
public class GeradorSenha {

	
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
	
	
}
