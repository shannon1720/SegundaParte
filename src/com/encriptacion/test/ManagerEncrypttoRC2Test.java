package com.encriptacion.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.encriptacion.objects.ManagerEncrypttoRC2;

public class ManagerEncrypttoRC2Test {
	ManagerEncrypttoRC2 rc=new ManagerEncrypttoRC2();
	
	
	@Test
	public void existeArchivo() throws Exception {
		
		rc.createKey("Strella");
		File pruebita=new File("C:/encrypt/RC2/Strella.key");
		File file=pruebita;		
		assertTrue(file.exists());
		file.delete();
	}
	
	@Test
	public void encriptarsomeThing() throws Exception {
		rc.createKey("lallama");
		rc.encryptMessage("llama", "lallamaquellama", "lallama");
		File pruebita=new File("C:/encrypt/RC2/llama.encript");
		assertTrue(pruebita.exists());
	}
	
	
	@Test
	public void desencriptarsomthing() throws Exception {
		File pruebita=new File("C:/encrypt/RC2/llama.encript");
		String pruebita2="The message was: lallamaquellama";
		assertEquals(pruebita2,rc.decryptMessage("llama", "lallama"));
		
		
	}

}
