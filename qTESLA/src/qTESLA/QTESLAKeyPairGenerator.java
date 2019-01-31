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
	
	/**
	 * The Source of Randomness
	 */
	private SecureRandom random;
	
	private QTESLA qTESLA;
	
	public void setQTESLA (QTESLA qTESLA) {
		
		this.qTESLA = qTESLA;
		
	}
	
	@Override
	public KeyPair generateKeyPair() {
		
		QTESLAPrivateKey qTESLAPrivateKey	= new QTESLAPrivateKey (this.securityCategory);
		QTESLAPublicKey qTESLAPublicKey		= new QTESLAPublicKey (this.securityCategory);
		
		byte[] privateKey	= qTESLAPrivateKey.getEncoded();
		byte[] publicKey 	= qTESLAPublicKey.getEncoded();
		this.random			= new SecureRandom();
		
		if (this.securityCategory == "qTESLA-I" || this.securityCategory == "qTESLA-III-Speed" || this.securityCategory == "qTESLA-III-Size") {
				
			try {
				
				qTESLA.generateKeyPair (publicKey, privateKey, random);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "qTESLA-P-I" || this.securityCategory == "qTESLA-P-III") {
			
			try {
				
				qTESLA.generateKeyPairP (publicKey, privateKey, random);
			
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
		this.random = random;
		this.qTESLA = new QTESLA (this.securityCategory);
		
	}
	
}