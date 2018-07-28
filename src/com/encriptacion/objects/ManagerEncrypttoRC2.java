package com.encriptacion.objects;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ManagerEncrypttoRC2 implements FactoryManager {
	private final int KEYSIZE = 8;
	private final String KEY_EXTENSION = ".key";
	private final String MESSAGE_ENCRYPT_EXTENSION = ".encript";
	private final String PATH = "C:/encrypt/RC2/";

	@Override
	public void createKey(String name) throws Exception {
		byte[] key = generatedSequenceOfBytes();
		writeBytesFile(name, key, KEY_EXTENSION);

	}

	@Override
	public void encryptMessage(String messageName, String message, String keyName) throws Exception {
		byte[] key = readKeyFile(keyName);
		SecureRandom sr = new SecureRandom("password".getBytes());
		KeyGenerator keygenerator = KeyGenerator.getInstance("RC2");
		keygenerator.init(sr);
		SecretKey myDesKey = keygenerator.generateKey();
		Cipher cipher = Cipher.getInstance("RC2");
		cipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		byte[] encryptedData = cipher.doFinal(message.getBytes());
		Encoder oneEncoder = Base64.getEncoder();
		encryptedData = oneEncoder.encode(encryptedData);
		writeBytesFile(messageName, encryptedData, MESSAGE_ENCRYPT_EXTENSION);

	}

	@Override
	public void decryptMessage(String messageName, String keyName) throws Exception {
		byte[] key = readKeyFile(keyName);
		SecureRandom sr = new SecureRandom("password".getBytes());
		KeyGenerator kg = KeyGenerator.getInstance("RC2");
		kg.init(sr);
		SecretKey sk = kg.generateKey();
		byte[] encryptedMessage = readMessageFile(messageName);
		System.out.println(encryptedMessage.length);
		Cipher cipher = Cipher.getInstance("RC2");
		cipher.init(Cipher.DECRYPT_MODE, sk);
		byte[] DecryptedData = cipher.doFinal(encryptedMessage);
		String message = new String(DecryptedData);
		System.out.println("The message was: ");
		System.out.println(message);

	}

	@Override
	public void writeBytesFile(String name, byte[] content, String type) throws IOException {
		FileOutputStream fos = new FileOutputStream(PATH + name + type);
		fos.write(content);
		fos.close();

	}

	@Override
	public byte[] readMessageFile(String messageName) throws Exception {
		File file = new File(PATH + messageName + MESSAGE_ENCRYPT_EXTENSION);
		int length = (int) file.length();
		BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
		byte[] bytes = new byte[length];
		reader.read(bytes, 0, length);
		Decoder oneDecoder = Base64.getDecoder();
		reader.close();
		return oneDecoder.decode(bytes);
	}

	private byte[] readKeyFile(String keyName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(PATH + keyName + KEY_EXTENSION));
		String everything = "";
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			everything = sb.toString();
		} finally {
			br.close();
		}
		return everything.getBytes(StandardCharsets.UTF_8);
	}

	private byte[] generatedSequenceOfBytes() throws Exception {
		StringBuilder randomkey = new StringBuilder();
		for (int i = 0; i < KEYSIZE; i++) {
			randomkey.append(Integer.parseInt(Double.toString((Math.random() + 0.1) * 1000).substring(0, 2)));
		}
		return randomkey.toString().getBytes("UTF-8");
	}
}