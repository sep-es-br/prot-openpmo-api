/**
 * 
 */
package com.openpmoapi.util;

import java.text.Normalizer;

/**
* This is a class of utility methods, like remove special characters.
*
* @author marcos.santos  
* @since 2018-08-24
*/
public class Util {

	public static String removeSpecialCharacters(String string){
		
		if(string != null) {
			
			string = Normalizer.normalize(string, Normalizer.Form.NFD);
	        string = string.replaceAll("[^\\p{ASCII}]", "");
	        string = string.replaceAll(" ", "");
	        string = string.toLowerCase();
	       
		}
		
		return string;
	
	}
	
	
	
	
	
	
}
