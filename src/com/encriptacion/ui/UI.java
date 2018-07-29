package com.encriptacion.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.encriptacion.manager.EncryptManager;
import com.encriptacion.objects.TypeEncript;

public class UI {
	private static EncryptManager eM = new EncryptManager();
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		start();
	}

	public static void start() throws Exception {

		int opc = 0;

		do {

			showMenu();
			opc = Integer.parseInt(br.readLine());
			chooseOption(opc);

		} while (opc != 4);

	}

	private static void chooseOption(int opc) throws Exception {

		switch (opc) {
		case 1:
			asymmetricOption(TypeEncript.RSA);
			break;

		case 2:
			symmetricOption(TypeEncript.AES);
			break;

		case 3:
			 otherOption(TypeEncript.RC2);
			break;

		case 4:
			System.out.print("Bye,bye!");
			break;

		default:
			System.out.println("We sorry, this option is incorrect.");
			break;

		}

	}

	private static void otherOption(TypeEncript ptype) throws Exception {
		int opc = 0;
		do {
			subMenu();
			opc = Integer.parseInt(br.readLine());
			chooseOptionA(opc, ptype);
		} while (opc != 4);
	}

	private static void symmetricOption(TypeEncript ptype) throws Exception {

		int opc = 0;
		do {
			subMenu();
			opc = Integer.parseInt(br.readLine());
			chooseOptionA(opc, ptype);
		} while (opc != 4);
	}

	private static void asymmetricOption(TypeEncript string) throws Exception {
		int opc = 0;
		do {
			subMenu();
			opc = Integer.parseInt(br.readLine());
			chooseOptionA(opc, string);
		} while (opc != 4);
	}

	private static void chooseOptionA(int opc, TypeEncript ptype) throws Exception {
		eM.initEncrypt(ptype);
		switch (opc) {
		case 1:
			createkey();
			break;
		case 2:
			encriptMessage();
			break;
		case 3:
			DencryptMessage();
			break;
		case 4:
			break;
		}

	}

	private static void DencryptMessage() throws Exception {
		String keyName, messageName;
		System.out.println("Key name: ");
		keyName = br.readLine();
		System.out.println("Message name: ");
		messageName = br.readLine();
		System.out.println(eM.decryptMessage(messageName, keyName));

	}

	private static void encriptMessage() throws Exception {
		String name, messageName, message;
		System.out.println("Key name: ");
		name = br.readLine();
		System.out.println("Message name: ");
		messageName = br.readLine();
		System.out.println("Message: ");
		message = br.readLine();
		eM.encryptMessage(messageName, message, name);

	}

	private static void createkey() throws Exception {
		System.out.println("Key name: ");
		String name = br.readLine();
		eM.createKey(name);

	}

	private static void subMenu() {
		System.out.println("1.Create key");
		System.out.println("2.Encript Message");
		System.out.println("3.Decrypt Message");
		System.out.println("4.Exit ");
		System.out.println("Choose a option:");

	}

	private static void showMenu() {
		System.out.println("Menu");
		System.out.println();
		System.out.println("1-RSA");
		System.out.println("2-AES");
		System.out.println("3-RC2");
		System.out.println("4-Exit");
		System.out.println("Choose a option:");
	}

}
