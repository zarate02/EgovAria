package com.winitech.cs;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.logging.Logger;

import egovframework.rte.fdl.cryptography.impl.ARIACipher;


public class Main {
    private final static Logger LOG = Logger.getGlobal();
    
    public static void main(String[] args) throws UnsupportedEncodingException {

    	String msg = "한국";
    	String key = "sdfgsdfgsdfgsdfgsdfgsdfgsdf";
    	
    	ARIACipher a = new ARIACipher();
    	a.setPassword(key);    	
    	byte[] a1 = a.encrypt(msg.getBytes("UTF-8"));
    	String f = Base64.getEncoder().encodeToString(a1);
    	
    	LOG.info(f);

    	ARIACipher b = new ARIACipher();
    	b.setPassword(key);    	
    	byte[] b1 = Base64.getDecoder().decode(f);
    	byte[] b2 = b.decrypt(b1);
    	String f2 = new String(b2);
    	
    	LOG.info(f2);
    	
    	
    }
}
