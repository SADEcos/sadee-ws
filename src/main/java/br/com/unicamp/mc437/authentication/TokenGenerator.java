package br.com.unicamp.mc437.authentication;

import java.security.SecureRandom;
import java.math.BigInteger;

public class TokenGenerator {
	private static SecureRandom random = new SecureRandom();
	
	
	public static String newSessionId(){
		return new BigInteger(130, random).toString(32);
	}
}
