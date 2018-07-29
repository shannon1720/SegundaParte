package com.encriptacion.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import com.encriptacion.objects.ManagerAsymmetric;

public class ManagerAsymmetricTest {

ManagerAsymmetric ma=new ManagerAsymmetric();
	
	
	@Test(expected = Exception.class)
	public void noexisteArchivo() throws Exception {
		
	
		File test=new File("C:/encrypt/symetric/aria.key");
		File file=test;		
		assertFalse(file.exists());
		file.delete();
	}
	
	
	@Test
	public void encriptarsomeThing() throws Exception {
		ma.createKey("test");
		ma.encryptMessage("tests", "eso, si se puede", "test");
		File pruebita=new File("C:/encrypt/asymetric/tests.encript");
//		File kp = new File("C:/encrypt/asymetric/testspublic.key");
//		File kepv= new File("C:/encrypt/asymetric/testsprivate.key");
		assertTrue(pruebita.exists());
	}
	
	
	@Test
	public void desencriptarsomthing() throws Exception {
		File pruebita=new File("C:/encrypt/asymetric/tests.encript");
		File kepv= new File("C:/encrypt/asymetric/testsprivate.key");
		String pruebita2="The message was: eso, si se puede";
		assertEquals(pruebita2,ma.decryptMessage("tests", "test"));
		
		
	}

}
