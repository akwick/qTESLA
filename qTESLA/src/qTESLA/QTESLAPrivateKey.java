/******************************************************************************
* qTESLA: An Efficient Post-Quantum Signature Scheme Based on the R-LWE Problem
*
* Generated qTESLA Private Key
* 
* @author Yinhua Xu
*******************************************************************************/

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
	 * qTESLA Security Category
	 */
	private String securityCategory;
	
	/**
	 * Text of the qTESLA Private Key
	 */
	private byte[] privateKey;
	
	public QTESLAPrivateKey (String securityCategory) {
		
		this.securityCategory = securityCategory;
		QTESLAParameter parameter = new QTESLAParameter (securityCategory);
		privateKey = new byte[parameter.privateKeySize];
		Arrays.fill (privateKey, (byte) 0);
		
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