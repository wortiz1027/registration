package co.com.registration.application.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utils {
	
	public static String generateClientInformation(String clientId){
		int numero = 0;
		try {
			Random codigo = new Random();
			numero = codigo.nextInt(1000) * 50;
		} catch (Exception e) {
				 e.printStackTrace();
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(clientId);
		sb.append("-");
		sb.append(numero);
		
		return sb.toString();
	}
	
	public static String generateClientSecret(String secret){
		SecureRandom random = null;
		int numero = 0;
		
		try {
			random = SecureRandom.getInstance(Constants.ALGOM_INSTANCE);
			
			Random codigo = new Random();

		    numero = codigo.nextInt(1000) * 10;		    
			
		} catch (NoSuchAlgorithmException e) {
				 e.printStackTrace();
		}
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10, random);
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(numero);
		sb.append(encoder.encode(secret));
		
		return sb.toString();
	}
	
}