/*******************************************************************************
* qTESLA: An Efficient Post-Quantum Signature Scheme Based on the R-LWE Problem
*
* Algorithm Parameters of qTESLA Specification for Heuristic or Provably Secure
* Parameter Sets
* 
* @author Yinhua Xu
********************************************************************************/

package qTESLA;

import java.security.spec.AlgorithmParameterSpec;

public final class QTESLASpecificParameters implements AlgorithmParameterSpec {
	
	/**
	 * qTESLA Security Category
	 */
	private String securityCategory;
	
	/**************************************************************
	 * qTESLA Parameter Specification Constructor
	 * 
	 * @param securityCategory		qTESLA Security Category
	 **************************************************************/
	public QTESLASpecificParameters (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
	}
	
	/*************************************
	 * Getter of Security Category
	 * 
	 * @return	none
	 *************************************/
	public String getSecurityCategory () {
		
		return this.securityCategory;
		
	}
	
}