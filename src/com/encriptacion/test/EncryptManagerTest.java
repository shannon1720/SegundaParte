package com.encriptacion.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.encriptacion.manager.EncryptManager;
import com.encriptacion.objects.FactoryManager;
import com.encriptacion.objects.TypeEncript;

public class EncryptManagerTest {

	
	
	
	EncryptManager eM=new EncryptManager();
	@Test
	public void iniciarObjeto() {
		FactoryManager m=eM.initEncrypt(TypeEncript.RC2);
		
		assertEquals(eM.initEncrypt(TypeEncript.AES),m);
		
		
	}

}
