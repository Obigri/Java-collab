import java.security.Key;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SimpleCrypt {

	private Key key = null;
	private String method = null;

	public SimpleCrypt(Key key, String method) {
		this.key = key;
		this.method = method;
	}
	
	
	public String encrypt(String text) throws Exception{
		isValid();
		
		Cipher cipher = Cipher.getInstance(method);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encrypted = cipher.doFinal(text.getBytes());
		BASE64Encoder myEncoder = new BASE64Encoder();
		String secret = myEncoder.encode(encrypted);
		return secret;
	}
	
	public String decrypt(String secret) throws Exception{
		isValid();
		
		BASE64Decoder myDecoder = new BASE64Decoder();
		byte[] crypted = myDecoder.decodeBuffer(secret);
		Cipher cipher = Cipher.getInstance(method);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] cipherData = cipher.doFinal(crypted);
		return new String(cipherData);
	}
	
	private boolean isValid() throws Exception{
		if(method == null)
			throw new NullPointerException("no method given!");
		if(key == null)
			throw new NullPointerException("no key given!");
		if(method.isEmpty())
			throw new NullPointerException("no method given!");
		return true;
	}
	
	public Key getKey(){
		return key;
	}
	
	public void setKey(Key key){
		this.key = key;
	}
	
	public String getMethod(){
		return method;
	}
	
	public void setMethod(String method){
		this.method = method;
	}
}
