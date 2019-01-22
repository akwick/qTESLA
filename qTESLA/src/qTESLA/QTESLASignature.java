package qTESLA;

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
	 * Possible {@link #state} Value, Signifying That This {@code SignatureQTESLA} Object
	 * Has Not Yet Been Initialized
	 */
	public final static int UNINITIALIZED	= 0;
	
	/**
	 * Possible {@link #state} Value, Signifying That This {@code SignatureQTESLA} Object
	 * Has Been Initialized For Signing
	 */
	public final static int SIGN			= 2;
	
	/**
	 * Possible {@link #state} Value, Signifying That This {@code SignatureQTESLA} Object
	 * Has Been Initialized For Verification
	 */
	public final static int VERIFY			= 3;
	
	/**
	 * Current State of This Signature Object (UNITIALIZED / SIGN / VERIFY)
	 */
	private int state;
	
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
	
	private byte[] signature;
	
	private int signatureOffset;
	
	private int[] signatureLength;
	
	public QTESLASignature (String securityCategory) {
		
		this.state				= UNINITIALIZED;
		this.securityCategory	= securityCategory;
		this.setPublicKey (null);
		this.setPrivateKey (null);
		this.setSecureRandom (null);
		this.setMessage (null);
		this.setMessageOffset (0);
		this.messageLength		= new int[1];
		this.setSignatureOffset (0);
		this.signatureLength	= new int[1];
		
	}
	
	public int getState () {
		
		return this.state;
		
	}
	
	public void setState (int state) {
		
		this.state = state;
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
		
		this.message = message;
	
	}
	
	public byte[] getSignature () {
		
		return signature;
	
	}

	public void setSignature (byte[] signature) {
		
		this.signature = signature;
	
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
		
		this.messageLength = messageLength;
	
	}
	
	public int getSignatureOffset() {
		
		return signatureOffset;
	
	}

	public void setSignatureOffset(int signatureOffset) {
		
		this.signatureOffset = signatureOffset;
	
	}
	
	public int[] getSignatureLength() {
		
		return signatureLength;
	
	}

	public void setSignatureLength(int[] signatureLength) {
		
		this.signatureLength = signatureLength;
	
	}
	
	protected void engineInitSign (PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
		
		this.setPrivateKey ((QTESLAPrivateKey) privateKey);
		this.setPublicKey (null);
		this.setSecureRandom (random);
		
	}
	
	protected void engineInitSign (PrivateKey privateKey) throws InvalidKeyException {
		
		engineInitSign (privateKey, new SecureRandom ());
		
	}
	
	protected void engineInitVerify (PublicKey publicKey) throws InvalidKeyException {
		
		this.setPublicKey ((QTESLAPublicKey) publicKey);
		this.setPrivateKey (null);
		this.setSecureRandom (null);
		
	}
	
	protected byte[] engineSign() throws SignatureException {
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryI") {
			
			try {
				
				QTESLA.signingI (this.signature, this.signatureOffset, this.signatureLength, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			try {
				
				QTESLA.signingIIISize (this.signature, this.signatureOffset, this.signatureLength, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			try {
				
				QTESLA.signingIIISpeed (this.signature, this.signatureOffset, this.signatureLength, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
			
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			try {
				
				QTESLA.signingIP (this.signature, this.signatureOffset, this.signatureLength, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException exception) {
				
				exception.printStackTrace();
				
			}
			
		}
		
		if (this.securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			try {
				
				QTESLA.signingIIIP (this.signature, this.signatureOffset, this.signatureLength, this.message, this.messageOffset, this.messageLength[0], this.privateKey.getEncoded(), this.secureRandom);
			
			} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException
					| NoSuchPaddingException | ShortBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return this.signature;
		
	}
	
	protected boolean engineVerify (byte[] signature, int signatureOffset, int signatureLength) throws SignatureException {
		
		int success = 1;
		int[] length = new int[1];
		length[0] = signatureLength;
		
		this.setSignatureOffset (signatureOffset);
		this.setSignatureLength (length);
		
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
		
		System.arraycopy (signature, 0, this.signature, 0, signatureLength);
		
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
	
	protected void engineUpdate (ByteBuffer input) {
		
		super.engineUpdate (input);
		
	}
	
	protected AlgorithmParameters engineGetParameter () throws UnsupportedOperationException {
		
		return super.engineGetParameters();
		
	}
	
	protected void engineSetParameter (AlgorithmParameterSpec specification) throws InvalidAlgorithmParameterException {
		
		super.engineSetParameter (specification);
		
	}
	
}