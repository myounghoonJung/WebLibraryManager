package library.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value = "";
		
		if(key != null && "password".equals(key)) {
			value = getSha512(super.getParameter(key));
		}
		else {
			value = super.getParameter(key);
		}
		
		return value;
	}

	private String getSha512(String password) {
		String encPwd = null;
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("sha-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] bytes = password.getBytes(Charset.forName("utf-8"));
		
		md.update(bytes);
		
		byte[] encBytes = md.digest();
		
		encPwd = Base64.getEncoder().encodeToString(encBytes);
		
		return encPwd;
	}

}
