package qTESLA;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public final class QTESLAKeyPairGenerator extends KeyPairGeneratorSpi {

	/**
	 * qTESLA Security Category
	 */
	private String securityCategory;
	
	private SecureRandom secureRandom;
	
	@Override
	public KeyPair generateKeyPair() {
		
		QTESLAPrivateKey qTESLAPrivateKey	= new QTESLAPrivateKey (this.securityCategory);
		QTESLAPublicKey qTESLAPublicKey		= new QTESLAPublicKey (this.securityCategory);
		
		byte[] privateKey	= qTESLAPrivateKey.getEncoded();
		byte[] publicKey 	= qTESLAPublicKey.getEncoded();
		this.secureRandom	= new SecureRandom();
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryI") {
				
			try {
				
				QTESLA.generateKeyPairI (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			try {
				
				QTESLA.generateKeyPairIIISize (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			try {
				
				QTESLA.generateKeyPairIIISpeed (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			try {
				
				QTESLA.generateKeyPairIP (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			try {
				
				QTESLA.generateKeyPairIIIP (publicKey, privateKey, secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			}
			
		}
		
		qTESLAPrivateKey.setPrivateKey (privateKey);
		qTESLAPublicKey.setPublicKey (publicKey);
		
		return new KeyPair (qTESLAPublicKey, qTESLAPrivateKey);
		
	}

	
	@Override
	public void initialize(int keysize, SecureRandom random) {
		
		try {
				
			throw new InvalidKeyException("A Single Key Size is not Supported by qTESLA Algorithm");
			
		} catch (InvalidKeyException exception) {
				
			exception.printStackTrace();
			
		}
			
	}
	
	@Override
	public void initialize (AlgorithmParameterSpec specification, SecureRandom random) throws InvalidAlgorithmParameterException {
		
		if (! (specification instanceof QTESLAParameterSpecification)) {
			
			throw new InvalidAlgorithmParameterException ("Parameters Do Not Belong To qTESLA");
			
		}
		
		QTESLAParameterSpecification qTESLAParameterSpecification = (QTESLAParameterSpecification) specification;
		
		this.securityCategory = qTESLAParameterSpecification.getSecurityCategory();
		this.secureRandom = random;
		
	}
	
}