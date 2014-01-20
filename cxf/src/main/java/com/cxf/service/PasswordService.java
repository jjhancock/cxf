package com.cxf.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

@Service("passwordService")
public final class PasswordService
{

	public PasswordService()
	{
		super();
	}

	public synchronized String encryptSHA(String plaintext)
	{
		MessageDigest md = null;
		try
		{
			md = MessageDigest.getInstance("SHA"); // step 2
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		try
		{
			md.update(plaintext.getBytes("UTF-8")); // step 3
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		byte raw[] = md.digest(); // step 4
		String hash = Base64.encode(raw).toString();
		return hash; // step 6
	}

	public synchronized String encryptMd5(String plaintext)
	{
		StringBuffer hexString = new StringBuffer();
		MessageDigest md = null;

		try
		{
			md = MessageDigest.getInstance("MD5");
			md.update(plaintext.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++)
			{
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			// convert the byte to hex format method 2

			for (int i = 0; i < byteData.length; i++)
			{
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			
		}

		catch (NoSuchAlgorithmException nsae)
		{
			System.out.println("fuck");
		}

		return hexString.toString();

	}

}
