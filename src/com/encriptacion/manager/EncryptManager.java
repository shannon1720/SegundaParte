package com.encriptacion.manager;

import com.encriptacion.objects.FactoryEncrypt;
import com.encriptacion.objects.FactoryManager;
import com.encriptacion.objects.TypeEncript;

public class EncryptManager {
	
	FactoryManager fm;
	

public void initEncrypt(TypeEncript ptype) {	
 fm=FactoryEncrypt.createEncrypt(ptype);
}
	
public void createKey(String name) throws Exception {	
	fm.createKey(name);
}

public void encryptMessage(String messageName, String message, String name) throws Exception {
	fm.encryptMessage(messageName, message, name);
	}

public void decryptMessage(String messageName, String keyName) throws Exception {
	fm.decryptMessage(messageName, keyName);
	}
	
}






