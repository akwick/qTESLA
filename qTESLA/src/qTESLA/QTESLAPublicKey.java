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
	 * qTESLA Security Category
	 */
	private String securityCategory;
	
	/**
	 * Text of the qTESLA Public Key
	 */
	private byte[] publicKey;
	
	public QTESLAPublicKey (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
		if (securityCategory == "heuristicQTESLASecurityCategoryI") {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_I];
			
		}
		
		if (securityCategory == "heuristicQTESLASecurityCategoryIIISize") {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_SIZE];
			
		}
		
		if (securityCategory == "heuristicQTESLASecurityCategoryIIISpeed") {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_SPEED];
			
		}
		
		if (securityCategory == "provablySecureQTESLASecurityCategoryI") {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_I_P];
			
		}
		
		if (securityCategory == "provablySecureQTESLASecurityCategoryIII") {
			
			publicKey = new byte[Polynomial.PUBLIC_KEY_III_P];
			
		}
		
		Arrays.fill (publicKey, (byte) 0);
		
	}
	
	public void setSecurityCategory (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
	}
	
	@Override
	public String getAlgorithm () {

		return this.securityCategory;
		
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