package qTESLA;

import java.security.PrivateKey;
import java.util.Arrays;

public final class QTESLAPrivateKey implements PrivateKey {

	/**
	 * The Class Fingerprint That is Set to Indicate Serialization Compatibility with
	 * A previous Version of the Class
	 */
	private static final long serialVersionUID = 7972867974716612313L;

	/**
	 * qTESLA Security Category (From 4 To 8)
	 */
	private int securityCategory;
	
	/**
	 * Text of the qTESLA Private Key
	 */
	private byte[] privateKey;
	
	public QTESLAPrivateKey (int securityCategory) {
		
		this.securityCategory = securityCategory;
		
		if (securityCategory == QTESLASignature.HEURISTIC_I) {
			
			privateKey = new byte[Polynomial.PRIVATE_KEY_I];
			
		}
		
		if (securityCategory == QTESLASignature.HEURISTIC_III_SIZE) {
			
			privateKey = new byte[Polynomial.PRIVATE_KEY_III_SIZE];
			
		}
		
		if (securityCategory == QTESLASignature.HEURISTIC_III_SPEED) {
			
			privateKey = new byte[Polynomial.PRIVATE_KEY_III_SPEED];
			
		}
		
		if (securityCategory == QTESLASignature.PROVABLY_SECURE_I) {
			
			privateKey = new byte[Polynomial.PRIVATE_KEY_I_P];
			
		}
		
		if (securityCategory == QTESLASignature.PROVABLY_SECURE_III) {
			
			privateKey = new byte[Polynomial.PRIVATE_KEY_III_P];
			
		}
		
		Arrays.fill (privateKey, (byte) 0);
		
	}
	
	public int getSecurityCategory () {
		
		return this.securityCategory;
		
	}
	
	public void setSecurityCategory (int securityCategory) {
		
		this.securityCategory = securityCategory;
		
	}
	
	@Override
	public String getAlgorithm () {

		if (this.securityCategory == QTESLASignature.HEURISTIC_I) {
			
			return "heuristic_qTESLA_security_category_I";
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SIZE) {
			
			return "heuristic_qTESLA_security_category_III_option_for_size";
			
		}
		
		if (this.securityCategory == QTESLASignature.HEURISTIC_III_SPEED) {
			
			return "heuristic_qTESLA_security_category_III_option_for_speed";
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_I) {
			
			return "provably_secure_qTESLA_security_category_I";
			
		}
		
		if (this.securityCategory == QTESLASignature.PROVABLY_SECURE_III) {
			
			return "provably_secure_qTESLA_security_category_III";
			
		}
		
		return null;
		
	}

	@Override
	public byte[] getEncoded () {
		
		return privateKey;
	}
	
	public void setPrivateKey (byte[] privateKey) {
		
		System.arraycopy (privateKey, 0, this.privateKey, 0, privateKey.length);
		
	}

	@Override
	public String getFormat () {
		
		return "PKCS#8";
		
	}
	
}