package com.hardik.seaminaction.model.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.util.Hex;

/**
 * Created by IntelliJ IDEA.
 * User: hardik
 * Date: Sep 15, 2009
 * Time: 9:38:52 PM
 * To change this template use File | Settings | File Templates.
 */

@Name("passwordManager")
public class PasswordManager {

	private String digestAlgorithm;
	private String charset;
	
	
    public String getDigestAlgorithm() {
		return digestAlgorithm;
	}


	public void setDigestAlgorithm(String digestAlgorithm) {
		this.digestAlgorithm = digestAlgorithm;
	}


	public String getCharset() {
		return charset;
	}


	public void setCharset(String charset) {
		this.charset = charset;
	}


	public String hash(String password) {
		
		String passwordHash = "";
       
		try {
			MessageDigest digest = MessageDigest.getInstance(digestAlgorithm);
			digest.update(password.getBytes(charset));
			byte[] rowHash = digest.digest();
			
			passwordHash = new String(Hex.encodeHex(rowHash));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwordHash;
    }
}
