package vivian.jsash.kernal.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {

	public static String encode(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] md5source = md5.digest(source.getBytes("UTF-8"));
			
			StringBuffer sb = new StringBuffer();
			for( byte bt : md5source ) {
				int unsigned = bt & 0xff;
				String hex = Integer.toHexString(unsigned);
				if( unsigned < 16 ) {
					sb.append( "0" );
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
