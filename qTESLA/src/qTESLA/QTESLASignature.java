package qTESLA;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public abstract class QTESLASignature extends SignatureSpi {
	
	/**
	 * qTESLA Security Category
	 */
	private String securityCategory;
	
	/**
	 * The Public Key of the Identity Whose Signature Will be Generated
	 */
	private QTESLAPublicKey publicKey;
	
	/**
	 * The Private Key of the Identity Whose Signature Will be Generated
	 */
	private QTESLAPrivateKey privateKey;
	
	/**
	 * The Source of Randomness
	 */
	private SecureRandom secureRandom;
	
	private byte[] message;
	
	private int messageOffset;
	
	private int[] messageLength;
		
	public QTESLASignature (String securityCategory) {
		
		this.securityCategory	= securityCategory;
		this.setPublicKey (null);
		this.setPrivateKey (null);
		this.setSecureRandom (null);
		this.setMessage (null);
		this.setMessageOffset (0);
		this.messageLength		= new int[1];
		
	}
	
	public String getSecurityCategory () {
		
		return this.securityCategory;
		
	}
	
	public void setSecurityCategory (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
	}
	
	public QTESLAPublicKey getPublicKey () {
		
		return publicKey;
	
	}

	public void setPublicKey (QTESLAPublicKey publicKey) {
		
		this.publicKey = publicKey;
	
	}
	
	public QTESLAPrivateKey getPrivateKey () {
		
		return privateKey;
	
	}

	public void setPrivateKey (QTESLAPrivateKey privateKey) {
		
		this.privateKey = privateKey;
	
	}
	
	public SecureRandom getSecureRandom () {
		
		return secureRandom;
	
	}

	public void setSecureRandom (SecureRandom secureRandom) {
		
		this.secureRandom = secureRandom;
	
	}
	
	public byte[] getMessage () {
		
		return message;
	
	}

	public void setMessage (byte[] message) {
		
		System.arraycopy (message, 0, this.message, 0, message.length);
	
	}
	
	public int getMessageOffset() {
		
		return messageOffset;
	
	}

	public void setMessageOffset(int messageOffset) {
		
		this.messageOffset = messageOffset;
	
	}
	
	public int[] getMessageLength () {
		
		return messageLength;
	
	}

	public void setMessageLength (int[] messageLength) {
		
		System.arraycopy (messageLength, 0, this.messageLength, 0, messageLength.length);
	
	}
	
	protected void engineInitSign (PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
		
		if (!(privateKey instanceof QTESLAPrivateKey)) {
			
			throw new InvalidKeyException ("The Input Key Is Not A qTESLA Private Key");
			
		}
		
		this.setPrivateKey ((QTESLAPrivateKey) privateKey);
		this.setSecureRandom (random);
		
	}
	
	protected void engineInitSign (PrivateKey privateKey) throws InvalidKeyException {
		
		engineInitSign (privateKey, new SecureRandom ());
		
	}
	
	protected void engineInitVerify (PublicKey publicKey) throws InvalidKeyException {
		
		if (!(publicKey instanceof QTESLAPublicKey)) {
			
			throw new InvalidKeyException ("The Input Key Is Not A qTESLA Public Key");
			
		}
		
		this.setPublicKey ((QTESLAPublicKey) publicKey);
		
	}
	
	protected int engineSign(byte[] signature, int signatureOffset, int signatureLength) throws SignatureException {
		
		int[] lengthOfSignature	= new int[1];
		lengthOfSignature[0]	= signatureLength;
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryI") {
			
			try {
				
				QTESLA.signingI (signature, signatureOffset, lengthOfSignature, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			try {
				
				QTESLA.signingIIISize (signature, signatureOffset, lengthOfSignature, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			try {
				
				QTESLA.signingIIISpeed (signature, signatureOffset, lengthOfSignature, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			try {
				
				QTESLA.signingIP (signature, signatureOffset, lengthOfSignature, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
				
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			try {
				
				QTESLA.signingIIIP (signature, signatureOffset, lengthOfSignature, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		return 0;
		
	}
	
	protected boolean engineVerify (byte[] signature, int signatureOffset, int signatureLength) throws SignatureException {
		
		int success = 0;
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryI") {
			
			success = QTESLA.verifyingI (this.message, this.messageOffset, this.messageLength, signature, signatureOffset, signatureLength, this.publicKey.getEncoded());
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			success = QTESLA.verifyingIIISize (this.message, this.messageOffset, this.messageLength, signature, signatureOffset, signatureLength, this.publicKey.getEncoded());
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			success = QTESLA.verifyingIIISpeed (this.message, this.messageOffset, this.messageLength, signature, signatureOffset, signatureLength, this.publicKey.getEncoded());
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			success = QTESLA.verifyingIP (this.message, this.messageOffset, this.messageLength, signature, signatureOffset, signatureLength, this.publicKey.getEncoded());
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			success = QTESLA.verifyingIIIP (this.message, this.messageOffset, this.messageLength, signature, signatureOffset, signatureLength, this.publicKey.getEncoded());
			
		}
		
		if (success == 0) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	protected boolean engineVerify (byte[] signature) throws SignatureException {
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryI") {
			
			return engineVerify (signature, 0, Polynomial.SIGNATURE_I);
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			return engineVerify (signature, 0, Polynomial.SIGNATURE_III_SIZE);
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			return engineVerify (signature, 0, Polynomial.SIGNATURE_III_SPEED);
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			return engineVerify (signature, 0, Polynomial.SIGNATURE_I_P);
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			return engineVerify (signature, 0, Polynomial.SIGNATURE_III_P);
			
		}
		
		return false;
		
	}
	
	protected void engineUpdate (byte[] data, int offset, int length) throws SignatureException {
		
		(new ByteArrayOutputStream()).write (data, offset, length);
		
	}
	
	protected void engineUpdate (ByteBuffer data) {
		
		super.engineUpdate (data);
		
	}
	
	protected AlgorithmParameters engineGetParameter () throws UnsupportedOperationException {
		
		return super.engineGetParameters();
		
	}
	
	protected void engineSetParameter (AlgorithmParameterSpec specification) throws InvalidAlgorithmParameterException {
		
		super.engineSetParameter (specification);
		
	}
	
}