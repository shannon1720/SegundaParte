package com.encriptacion.objects;

import com.encriptacion.manager.EncryptManager;

public class FactoryEncrypt {

	public static FactoryManager createEncrypt(TypeEncript ptype) {
		switch (ptype) {
		case RSA:
			return new ManagerAsymmetric();

		case AES:
			return new ManagerSymmetric();

		case RC2:
			return new ManagerEncrypttoRC2();
			
		default:
			return null;
		}

	}

}