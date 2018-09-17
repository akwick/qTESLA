package qTESLA;

import java.security.PublicKey;
import java.util.Arrays;

public final class QTESLAPublicKey implements PublicKey {

	/**
	 * The Class Fingerprint That is Set to Indicate Serialization Compatibility with
	 * A previous Version of the Class
	 */
	private static final long serialVersionUID = -8146247554834846930L;
	
	/**
	 * qTESLA Security Category (From 4 To 8)
	 */
	private int securityCategory;
	
	/**
	 * Text of the qTESLA Public Key
	 */
	private byte[] publicKey;
	
	public QTESLAPublicKey (int securityCategory) {
		
		this.securityCategory = securityCategory;
		
		if (securityCategory == QTESLASignature.HEURISTIC_I) {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_I];
			
		}
		
		if (securityCategory == QTESLASignature.HEURISTIC_III_SIZE) {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_SIZE];
			
		}
		
		if (securityCategory == QTESLASignature.HEURISTIC_III_SPEED) {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_SPEED];
			
		}
		
		if (securityCategory == QTESLASignature.PROVABLY_SECURE_I) {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_I_P];
			
		}
		
		if (securityCategory == QTESLASignature.PROVABLY_SECURE_III) {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_P];
			
		}
		
		Arrays.fill (publicKey, (byte) 0);
		
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
		
		return publicKey;
	}
	
	public void setPublicKey (byte[] publicKey) {
		
		System.arraycopy (publicKey, 0, this.publicKey, 0, publicKey.length);
		
	}

	@Override
	public String getFormat () {
		
		return "X.509";
		
	}
	
}