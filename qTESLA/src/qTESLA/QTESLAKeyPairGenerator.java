package qTESLA;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

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
				
			try {
				
				QTESLA.generateKeyPairI (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SIZE) {
			
			try {
				
				QTESLA.generateKeyPairIIISize (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SPEED) {
			
			try {
				
				QTESLA.generateKeyPairIIISpeed (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_I) {
			
			try {
				
				QTESLA.generateKeyPairIP (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_III) {
			
			try {
				
				QTESLA.generateKeyPairIIIP (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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