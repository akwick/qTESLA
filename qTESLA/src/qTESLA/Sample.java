package qTESLA;

public class Sample {
	
	/******************************************************************************************************************
	 * Description:	Samples Polynomial Y, Such That Each Coefficient is in the Range [-B, B], for Heuristic qTESLA
	 * 				Security Category-1 and Security Category-3 (Option for Size or Speed)
	 * 
	 * @param		Y				Polynomial Y
	 * @param		seed			Kappa-Bit Seed
	 * @param		seedOffset		Starting Point of the Kappa-Bit Seed
	 * @param		nonce			Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		n				Polynomial Degree
	 * @param		q				Modulus
	 * @param		b				Determines the Interval the Randomness is Chosen in During Signing
	 * @param		bBit			b = 2 ^ bBit - 1
	 * 
	 * @return		none		
	 ******************************************************************************************************************/
	public static void sampleY (int[] Y, final byte[] seed, int seedOffset, int nonce, int n, int q, int b, int bBit) {
		
		int i = 0;
		int position = 0;
		int numberOfByte = (bBit + 1 + 7) / 8;
		int numberOfBlock = n;
		byte[] buffer = new byte[n * numberOfByte];
		int[] y = new int[4];
		
		short dualModeSampler = (short) (nonce << 8);
		
		if (q == Parameter.Q_I) {
		
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
				buffer, 0, n * numberOfByte, dualModeSampler++, seed, seedOffset, Parameter.RANDOM
			);
		
		}
		
		if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
				buffer, 0, n * numberOfByte, dualModeSampler++, seed, seedOffset, Parameter.RANDOM
			);
			
		}
		
		while (i < n) {
			
			if (position > numberOfBlock * numberOfByte * 4) {
				
				if (q == Parameter.Q_I) {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE /
							((bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
						dualModeSampler++,
						seed, seedOffset, Parameter.RANDOM
					);
					
				}
				
				if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE /
							((bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE,
						dualModeSampler++,
						seed, seedOffset, Parameter.RANDOM
					);
					
				}
				
				position = 0;
				
			}
			
			y[0]  = (Common.load32 (buffer, position)						& ((1 << (bBit + 1)) - 1)) - b;
			y[1]  = (Common.load32 (buffer, position + numberOfByte)		& ((1 << (bBit + 1)) - 1)) - b;
			y[2]  = (Common.load32 (buffer, position + numberOfByte * 2)	& ((1 << (bBit + 1)) - 1)) - b;
			y[3]  = (Common.load32 (buffer, position + numberOfByte * 3)	& ((1 << (bBit + 1)) - 1)) - b;
			
			if (i < n && y[0] != (1 << bBit)) {
				
				Y[i++] = y[0];
				
			}
			
			if (i < n && y[1] != (1 << bBit)) {
				
				Y[i++] = y[1];
				
			}
			
			if (i < n && y[2] != (1 << bBit)) {
				
				Y[i++] = y[2];
				
			}
			
			if (i < n && y[3] != (1 << bBit)) {
				
				Y[i++] = y[3];
				
			}
			
			position += numberOfByte * 4;
			
		}
		
	}
	
	/*******************************************************************************************************************
	 * Description:	Samples Polynomial Y, Such That Each Coefficient is in the Range [-B, B], for Provably-Secure qTESLA
	 *				Security Category-1 and Security Category-3
	 * 
	 * @param		Y				Polynomial Y
	 * @param		seed			Kappa-Bit Seed
	 * @param		seedOffset		Starting Point of the Kappa-Bit Seed
	 * @param		nonce			Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		n				Polynomial Degree
	 * @param		q				Modulus
	 * @param		b				Determines the Interval the Randomness is Chosen in During Signing
	 * @param		bBit			b = 2 ^ bBit - 1
	 * 
	 * @return		none		
	 *******************************************************************************************************************/
	public static void sampleY (long[] Y, final byte[] seed, int seedOffset, int nonce, int n, int q, int b, int bBit) {
		
		int i = 0;
		int position = 0;
		int numberOfByte = (bBit + 1 + 7) / 8;
		int numberOfBlock = n;
		byte[] buffer = new byte[n * numberOfByte];
		
		short dualModeSampler = (short) (nonce << 8);
		
		if (q == Parameter.Q_I_P) {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
				buffer, 0, n * numberOfByte, dualModeSampler++, seed, seedOffset, Parameter.RANDOM
			);
		
		}
		
		if (q == Parameter.Q_III_P) {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
				buffer, 0, n * numberOfByte, dualModeSampler++, seed, seedOffset, Parameter.RANDOM
			);
			
		}
		
		while (i < n) {
			
			if (position > numberOfBlock * numberOfByte) {
				
				if (q == Parameter.Q_I_P) {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE /
							((bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
						dualModeSampler++,
						seed, seedOffset, Parameter.RANDOM
					);
					
				}
				
				if (q == Parameter.Q_III_P) {
					
					numberOfBlock =
						FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE /
							((bBit + 1 + 7) / 8);
					
					FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (
						buffer, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_256_RATE,
						dualModeSampler++,
						seed, seedOffset, Parameter.RANDOM
					);
					
				}
				
				position = 0;
				
			}
			
			Y[i]  = (Common.load32 (buffer, position) & ((1 << (bBit + 1)) - 1)) - b;
			
			if (Y[i] != (1 << bBit)) {
				
				i++;
				
			}
			
			position += numberOfByte;
			
		}
		
	}
	
}