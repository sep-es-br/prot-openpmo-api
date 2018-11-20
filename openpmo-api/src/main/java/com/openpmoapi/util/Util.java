/**
 * 
 */
package com.openpmoapi.util;

import java.text.Normalizer;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-24
*/
public class Util {

	public static String retiraCaracteresEspeciais(String string){
		
		if(string != null) {
			
			string = Normalizer.normalize(string, Normalizer.Form.NFD);
	        string = string.replaceAll("[^\\p{ASCII}]", "");
	        string = string.replaceAll(" ", "");
	        string = string.toLowerCase();
	       
		}
		
		return string;
	
	}
	
	
	
	
	
	
}
