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
	/**
	 * This method change the special characters,<br> by setting a pattern to all strings of InOut
	 * @param string
	 * 		This is the <code>String</code> that will be changed
	 * @return
	 * 		String in the pattern
	 */
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
