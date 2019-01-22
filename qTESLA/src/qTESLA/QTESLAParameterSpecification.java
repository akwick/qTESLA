package qTESLA;

import java.security.spec.AlgorithmParameterSpec;

/** 
 * @author Yinhua Xu
 * 
 * Parameters of qTESLA Algorithm.
 * 
 * They are Divided in Terms of Five Security Categories for Every Parameter Set
 */
public final class QTESLAParameterSpecification implements AlgorithmParameterSpec {
	
	private String securityCategory;
	
	public QTESLAParameterSpecification (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
	}
	
	public String getSecurityCategory () {
		
		return this.securityCategory;
		
	}
	
}