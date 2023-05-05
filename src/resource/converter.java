package resource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class converter {
	public static java.sql.Date toSQLDate(java.util.Date date) {
		String temp = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return Date.valueOf(temp);
	}
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodehash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder hexString = new StringBuilder(2*encodehash.length);
        for(int i = 0; i< encodehash.length; i++) {
        	String hex = Integer.toHexString(0xff & encodehash[i]);
        	if (hex.length() == 1) {
				hexString.append('0');
			}
        	hexString.append(hex);
        }
        return hexString.toString();
    }
}
