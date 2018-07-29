package com.encriptacion.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.encriptacion.objects.ManagerSymmetric;

public class ManagerSymmetricTest {
	 ManagerSymmetric ms=new  ManagerSymmetric();
	
	@Test
	public void existeArchivo() throws Exception {
		
		ms.createKey("mario");
		File test=new File("C:/encrypt/symetric/mario.key");
		File file=test;		
		assertTrue(file.exists());
		file.delete();
	}
	
	@Test(expected = Exception.class)
	public void noexisteArchivo() throws Exception {
		
		ms.createKey("mario");
		File test=new File("C:/encrypt/symetric/aria.key");
		File file=test;		
		assertTrue(file.exists());
		file.delete();
	}
	
	
	@Test
	public void encriptarsomeThing() throws Exception {
		ms.createKey("mario");
		ms.encryptMessage("profe", "hola k ac", "mario");
		File pruebita=new File("C:/encrypt/symetric/profe.encript");
		assertTrue(pruebita.exists());
	}
	
	
	@Test
	public void desencriptarsomthing() throws Exception {
		File pruebita=new File("C:/encrypt/symetric/profe.encript");
		String pruebita2="The message was: hola k ac";
		assertEquals(pruebita2,ms.decryptMessage("profe", "mario"));
		
		
	}

}
