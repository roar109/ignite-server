package org.rage.ignite.server.validator;

import org.rage.ignite.server.constant.Constants;

/**
 * Validator of Apache Ignite needed configuration.
 * 
 * @author hector.mendoza
 * 
 * */
public class IgniteParameterValidator {
	final static String INVALID_PROPERTY_VALUE_MESSAGE = "Property %s is missing or value is not correct.";
	final static String[] systemIgniteProperties = {Constants.APACHE_IGNITE_HOME, 
			Constants.IGNITE_MULTICAST_ADDRESS_PROPERTY, 
			Constants.IGNITE_MULTICAST_PORT_PROPERTY};
	
	/**
	 * Validate that the war have the needed Apache Ignite variables before start up.
	 * 
	 * */
	public static void validateApacheIgniteConfig(){
		for(String systemIgniteProperty : systemIgniteProperties){
			final String systemIgniteValue = System.getProperty(systemIgniteProperty);
			if(systemIgniteValue ==  null || "".equals(systemIgniteValue)){
				throw new IllegalArgumentException(formatErrorMessage(INVALID_PROPERTY_VALUE_MESSAGE, systemIgniteProperty));
			}			
		}
	}
	
	/**
	 * Returns formatted message.
	 * 
	 * @param message
	 * @param values
	 * 
	 * @return formatedMessage
	 * */
	private static String formatErrorMessage(final String message, final Object... values){
		return String.format(message, values);
	}
}
