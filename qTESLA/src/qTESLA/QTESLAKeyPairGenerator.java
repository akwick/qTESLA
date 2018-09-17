package qTESLA;

import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;

public final class QTESLAKeyPairGenerator extends KeyPairGeneratorSpi {

	/**
	 * qTESLA Security Category (From 4 To 8)
	 */
	private int securityCategory;
	
	private SecureRandom secureRandom;
	
	public QTESLAKeyPairGenerator (int securityCategory) {
		
		this.securityCategory = securityCategory;
		this.secureRandom = null;
		
	}
	
	@Override
	public KeyPair generateKeyPair() {
		
		QTESLAPrivateKey qTESLAPrivateKey	= new QTESLAPrivateKey (this.securityCategory);
		QTESLAPublicKey qTESLAPublicKey		= new QTESLAPublicKey (this.securityCategory);
		
		byte[] privateKey	= qTESLAPrivateKey.getEncoded();
		byte[] publicKey 	= qTESLAPublicKey.getEncoded();
		this.secureRandom	= new SecureRandom();
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_I) {
				
			QTESLA.generateKeyPairI (publicKey, privateKey, secureRandom);
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SIZE) {
			
			QTESLA.generateKeyPairIIISize (publicKey, privateKey, secureRandom);
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SPEED) {
			
			QTESLA.generateKeyPairIIISpeed (publicKey, privateKey, secureRandom);
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_I) {
			
			QTESLA.generateKeyPairIP (publicKey, privateKey, secureRandom);
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_III) {
			
			QTESLA.generateKeyPairIIIP (publicKey, privateKey, secureRandom);
			
		}
		
		qTESLAPrivateKey.setPrivateKey (privateKey);
		qTESLAPublicKey.setPublicKey (publicKey);
		
		return new KeyPair (qTESLAPublicKey, qTESLAPrivateKey);
		
	}

	@Override
	public void initialize(int securityCategory, SecureRandom random) {
		
		if (securityCategory != QTESLASignature.HEURISTIC_I &&
			securityCategory != QTESLASignature.HEURISTIC_III_SIZE &&
			securityCategory != QTESLASignature.HEURISTIC_III_SPEED &&
			securityCategory != QTESLASignature.PROVABLY_SECURE_I &&
			securityCategory != QTESLASignature.PROVABLY_SECURE_III) {
			
			throw new InvalidParameterException ("Invalid Security Category");
			
		}
		
		this.securityCategory = securityCategory;
		
	}
	
}