package com.encriptacion.manager;

import com.encriptacion.objects.FactoryEncrypt;
import com.encriptacion.objects.FactoryManager;
import com.encriptacion.objects.TypeEncript;

public class EncryptManager {
	
	FactoryManager fm;
	

public FactoryManager initEncrypt(TypeEncript ptype) {	
 return this.fm=FactoryEncrypt.createEncrypt(ptype);
}
	
public void createKey(String name) throws Exception {	
	fm.createKey(name);
}

public void encryptMessage(String messageName, String message, String name) throws Exception {
	fm.encryptMessage(messageName, message, name);
	}

public String decryptMessage(String messageName, String keyName) throws Exception {
	return fm.decryptMessage(messageName, keyName);
	}
	
}






