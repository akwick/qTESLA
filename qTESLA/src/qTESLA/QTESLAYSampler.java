/******************************************************************************
* qTESLA: An Efficient Post-Quantum Signature Scheme Based on the R-LWE Problem
*
* Y Sampler
* 
* @author Yinhua Xu
*******************************************************************************/

package qTESLA;

public class QTESLAYSampler {
	
	private static QTESLAParameter parameter;
	
	/*******************************************************
	 * Y Sampler Constructor
	 * 
	 * @param securityCategory		qTESLA Security Category
	 *******************************************************/
	public QTESLAYSampler (String securityCategory) {
		
		parameter = new QTESLAParameter (securityCategory);
		
	}
	
	/*********************************************
	 * Getter of qTESLA Parameter Object
	 * 
	 * @return	none
	 *********************************************/
	public QTESLAParameter getQTESLAParameter () {
		
		return parameter;
		
	}
	
	/**************************************************************************************************************
	 * Description:	Samples Polynomial Y, Such That Each Coefficient is in the Range [-B, B] for Heuristic qTESLA
	 * 
	 * @param		Y				Polynomial Y
	 * @param		seed			Kappa-Bit Seed
	 * @param		seedOffset		Starting Point of the Kappa-Bit Seed
	 * @param		nonce			Domain Separator for Error Polynomial and Secret Polynomial
	 * 
	 * @return		none		
	 **************************************************************************************************************/
	public void sampleY (int[] Y, final byte[] seed, int seedOffset, int nonce) {
		
		int i = 0;
		int position = 0;
		int numberOfByte = (parameter.bBit + 1 + 7) / 8;
		int numberOfBlock = parameter.n;
		byte[] buffer = new byte[parameter.n * numberOfByte];
		int[] y = new int[4];
		
		short dualModeSampler = (short) (nonce << 8);
		
		if (parameter.securityCategory == "qTESLA-I") {
		
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
				
				buffer, 0, parameter.n * numberOfByte, dualModeSampler++, seed, seedOffset, QTESLAParameter.RANDOM
		
			);
		
		}
		
		if (parameter.securityCategory == "qTESLA-III-Speed" || parameter.securityCategory == "qTESLA-III-Size") {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
				
				buffer, 0, parameter.n * numberOfByte, dualModeSampler++, seed, seedOffset, QTESLAParameter.RANDOM
			
			);
			
		}
		
		while (i < parameter.n) {
			
			if (position > numberOfBlock * numberOfByte * 4) {
				
				if (parameter.securityCategory == "qTESLA-I") {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE /
							((parameter.bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
						
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
						dualModeSampler++,
						seed, seedOffset, QTESLAParameter.RANDOM
					
					);
					
				}
				
				if (parameter.securityCategory == "qTESLA-III-Speed" || parameter.securityCategory == "qTESLA-III-Size") {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE /
							((parameter.bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
						
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE,
						dualModeSampler++,
						seed, seedOffset, QTESLAParameter.RANDOM
					
					);
					
				}
				
				position = 0;
				
			}
			
			y[0]  = (Common.load32 (buffer, position)						& ((1 << (parameter.bBit + 1)) - 1))
					- parameter.b;
			
			y[1]  = (Common.load32 (buffer, position + numberOfByte)		& ((1 << (parameter.bBit + 1)) - 1))
					- parameter.b;
			
			y[2]  = (Common.load32 (buffer, position + numberOfByte * 2)	& ((1 << (parameter.bBit + 1)) - 1))
					- parameter.b;
			
			y[3]  = (Common.load32 (buffer, position + numberOfByte * 3)	& ((1 << (parameter.bBit + 1)) - 1))
					- parameter.b;
			
			if (i < parameter.n && y[0] != (1 << parameter.bBit)) {
				
				Y[i++] = y[0];
				
			}
			
			if (i < parameter.n && y[1] != (1 << parameter.bBit)) {
				
				Y[i++] = y[1];
				
			}
			
			if (i < parameter.n && y[2] != (1 << parameter.bBit)) {
				
				Y[i++] = y[2];
				
			}
			
			if (i < parameter.n && y[3] != (1 << parameter.bBit)) {
				
				Y[i++] = y[3];
				
			}
			
			position += numberOfByte * 4;
			
		}
		
	}
	
	/*************************************************************************************************************
	 * Description:	Samples Polynomial Y, Such That Each Coefficient is in the Range [-B, B], for Provably Secure
	 *				qTESLA
	 * 
	 * @param		Y				Polynomial Y
	 * @param		seed			Kappa-Bit Seed
	 * @param		seedOffset		Starting Point of the Kappa-Bit Seed
	 * @param		nonce			Domain Separator for Error Polynomial and Secret Polynomial
	 * 
	 * @return		none		
	 *************************************************************************************************************/
	public void sampleY (long[] Y, final byte[] seed, int seedOffset, int nonce) {
		
		int i = 0;
		int position = 0;
		int numberOfByte = (parameter.bBit + 1 + 7) / 8;
		int numberOfBlock = parameter.n;
		byte[] buffer = new byte[parameter.n * numberOfByte];
		
		short dualModeSampler = (short) (nonce << 8);
		
		if (parameter.securityCategory == "qTESLA-P-I") {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
				
				buffer, 0, parameter.n * numberOfByte, dualModeSampler++, seed, seedOffset, QTESLAParameter.RANDOM
			
			);
		
		}
		
		if (parameter.securityCategory == "qTESLA-P-III") {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
				
				buffer, 0, parameter.n * numberOfByte, dualModeSampler++, seed, seedOffset, QTESLAParameter.RANDOM
			
			);
			
		}
		
		while (i < parameter.n) {
			
			if (position > numberOfBlock * numberOfByte) {
				
				if (parameter.securityCategory == "qTESLA-P-I") {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE /
							((parameter.bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
						
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
						dualModeSampler++,
						seed, seedOffset, QTESLAParameter.RANDOM
					
					);
					
				}
				
				if (parameter.securityCategory == "qTESLA-P-III") {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE /
							((parameter.bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
						
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE,
						dualModeSampler++,
						seed, seedOffset, QTESLAParameter.RANDOM
					
					);
					
				}
				
				position = 0;
				
			}
			
			Y[i]  = (Common.load32 (buffer, position) & ((1 << (parameter.bBit + 1)) - 1)) - parameter.b;
			
			if (Y[i] != (1 << parameter.bBit)) {
				
				i++;
				
			}
			
			position += numberOfByte;
			
		}
		
	}
	
}