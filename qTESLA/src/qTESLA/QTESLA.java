package qTESLA;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class QTESLA {
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte) for Heuristic qTESLA Security Category-1.
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public static final int SIGNATURE_I			= (Parameter.N_I			* Parameter.D_I			+ 7) / 8 + Parameter.HASH;
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte) for Heuristic qTESLA Security Category-3 (Option for Size).
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public static final int SIGNATURE_III_SIZE	= (Parameter.N_III_SIZE		* Parameter.D_III_SIZE	+ 7) / 8 + Parameter.HASH;
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte) for Heuristic qTESLA Security Category-3 (Option for Speed).
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public static final int SIGNATURE_III_SPEED	= (Parameter.N_III_SPEED	* Parameter.D_III_SPEED	+ 7) / 8 + Parameter.HASH;
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte) for Provably-Secure qTESLA Security Category-1.
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public static final int SIGNATURE_I_P		= (Parameter.N_I_P			* Parameter.D_I_P		+ 7) / 8 + Parameter.HASH;
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte) for Provably-Secure qTESLA Security Category-3.
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public static final int SIGNATURE_III_P		= (Parameter.N_III_P		* Parameter.D_III_P		+ 7) / 8 + Parameter.HASH;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T for Heuristic qTESLA Security Category-1
	 */
	public static final int PUBLIC_KEY_I			= (Parameter.N_I			* Parameter.K_I			* Parameter.Q_LOGARITHM_I			+ 7) / 8 + Parameter.SEED;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T for Heuristic qTESLA Security Category-3 (Option for Size)
	 */
	public static final int PUBLIC_KEY_III_SIZE		= (Parameter.N_III_SIZE		* Parameter.K_III_SIZE	* Parameter.Q_LOGARITHM_III_SIZE	+ 7) / 8 + Parameter.SEED;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T for Heuristic qTESLA Security Category-3 (Option for Speed)
	 */
	public static final int PUBLIC_KEY_III_SPEED	= (Parameter.N_III_SPEED	* Parameter.K_III_SPEED	* Parameter.Q_LOGARITHM_III_SPEED	+ 7) / 8 + Parameter.SEED;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T for Provably-Secure qTESLA Security Category-1
	 */
	public static final int PUBLIC_KEY_I_P			= (Parameter.N_I_P			* Parameter.K_I_P		* Parameter.Q_LOGARITHM_I_P			+ 7) / 8 + Parameter.SEED;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T for Provably-Secure qTESLA Security Category-3
	 */
	public static final int PUBLIC_KEY_III_P		= (Parameter.N_III_P		* Parameter.K_III_P		* Parameter.Q_LOGARITHM_III_P		+ 7) / 8 + Parameter.SEED;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 * for Heuristic qTESLA Security Category-1
	 */
	public static final int PRIVATE_KEY_I			= Parameter.N_I			* Parameter.S_BIT_I			/ Byte.SIZE * 2 + Parameter.SEED * 2;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 * for Heuristic qTESLA Security Category-3 (Option for Size)
	 */
	public static final int PRIVATE_KEY_III_SIZE	= Parameter.N_III_SIZE	* Parameter.S_BIT_III_SIZE	/ Byte.SIZE * 2 + Parameter.SEED * 2;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 * for Heuristic qTESLA Security Category-3 (Option for Speed)
	 */
	public static final int PRIVATE_KEY_III_SPEED	= Parameter.N_III_SPEED	* Parameter.S_BIT_III_SPEED	/ Byte.SIZE * 2 + Parameter.SEED * 2;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 * for Provably-Secure qTESLA Security Category-1
	 */
	public static final int PRIVATE_KEY_I_P			= Parameter.N_I_P	+ Parameter.N_I_P	* Parameter.K_I_P	+ Parameter.SEED * 2;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 * for Provably-Secure qTESLA Security Category-3
	 */
	public static final int PRIVATE_KEY_III_P		= Parameter.N_III_P	+ Parameter.N_III_P	* Parameter.K_III_P	+ Parameter.SEED * 2;
	
	private static RandomNumberGenerator rng = new RandomNumberGenerator ();
	
	public static RandomNumberGenerator getRandomNumberGenerator () {
		
		return rng;
		
	}
	
	/******************************************************************************************************************************************
	 * Description:	Hash-Based Function to Generate C' for Heuristic qTESLA Security Category 1 and Category 3 (Option for Size or Speed)
	 ******************************************************************************************************************************************/
	private static void hashFunction (byte[] output, int outputOffset, int[] V, final byte[] message, int messageOffset, int n, int d, int q) {
		
		int mask;
		int cL;
		
		byte[] T = new byte[n + Parameter.MESSAGE];
		
		for (int i = 0; i < n; i++) {
			/* If V[i] > Q / 2 Then V[i] = V[i] - Q */
			mask	= (q / 2 - V[i]) >> 31;
			V[i]	= ((V[i] - q) & mask) | (V[i] & (~ mask));
			cL		= V[i] & ((1 << d) - 1);
			/* If cL > 2 ^ (d - 1) Then cL = cL - 2 ^ d */
			mask	= ((1 << (d - 1)) - cL) >> 31;
			cL		= ((cL - (1 << d)) & mask) | (cL & (~ mask));
			T[i]	= (byte) ((V[i] - cL) >> d);
			
		}
		
		System.arraycopy (message, messageOffset, T, n, Parameter.MESSAGE);
		
		if (q == Parameter.Q_I) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (output, outputOffset, Parameter.HASH, T, 0, n + Parameter.MESSAGE);
		
		}
		
		if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (output, outputOffset, Parameter.HASH, T, 0, n + Parameter.MESSAGE);
			
		}
		
	}
	
	/**************************************************************************************************************************************************
	 * Description:	Hash Function to Generate C' for Provably-Secure qTESLA Security Category 1 and Security Category 3
	 **************************************************************************************************************************************************/
	private static void hashFunction (byte[] output, int outputOffset, long[] V, final byte[] message, int messageOffset, int n, int k, int d, int q) {
		
		int index;
		int mask;
		int cL;
		int temporary;
		
		byte[] T = new byte[n * k + Parameter.MESSAGE];
		
		for (int j = 0; j < k; j++) {
			
			index = n * j;
			
			for (int i = 0; i < n; i++) {
				
				temporary	= (int) V[index];
				/* If V[i] > Q / 2 Then V[i] = V[i] - Q */
				mask		= (q / 2 - temporary) >> 63;
				temporary	= ((temporary - q) & mask) | (temporary & (~ mask));
				cL			= temporary & ((1 << d) - 1);
				/* If cL > 2 ^ (d - 1) Then cL = cL - 2 ^ d */
				mask		= ((1 << (d - 1)) - cL) >> 31;
				cL			= ((cL - (1 << d)) & mask) | (cL & (~ mask));
				T[index++]	= (byte) ((temporary - cL) >> d);
				
			}
			
		}
		
		System.arraycopy (message, messageOffset, T, n * k, Parameter.MESSAGE);
		
		if (q == Parameter.Q_I_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (output, outputOffset, Parameter.HASH, T, 0, n * k + Parameter.MESSAGE);
		
		}
		
		if (q == Parameter.Q_III_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (output, outputOffset, Parameter.HASH, T, 0, n * k + Parameter.MESSAGE);
			
		}
	
	}
	
	/*************************************************************************************************************************
	 * Description:	Encoding of C' by Mapping the Output of the Hash Function H to An N-Element Vector with Entries {-1, 0, 1}
	 * 
	 * @param		postionList			{0, ..., n - 1} ^ h
	 * @param		signList			{-1, +1} ^ h
	 * @param		output				Result of the Hash Function H
	 * @param		outputOffset		Starting Point of the Result of the Hash Function H
	 * @param		n					Polynomial Degree
	 * @param		h					Number of Non-Zero Entries of Output Elements of Encryption
	 * 
	 * @return		none
	 *************************************************************************************************************************/
	public static void encodeC (int[] positionList, short[] signList, byte[] output, int outputOffset, int n, int h) {
		
		int count = 0;
		int position;
		short domainSeparator = 0;
		short[] C = new short[n];
		byte[] randomness = new byte[FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE];
		
		/* Use the Hash Value as Key to Generate Some Randomness */
		FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
			randomness, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
			domainSeparator++,
			output, outputOffset, Parameter.RANDOM
		);
		
		/* Use Rejection Sampling to Determine Positions to be Set in the New Vector */
		Arrays.fill (C, 0, n, (short) 0);
		
		/* Sample A Unique Position k times.
		 * Use Two Bytes
		 */
		for (int i = 0; i < h;) {
			
			if (count > FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE - 3) {
				
				FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (
					randomness, 0, FederalInformationProcessingStandard202.SECURE_HASH_ALGORITHM_KECCAK_128_RATE,
					domainSeparator++,
					output, outputOffset, Parameter.RANDOM
				);
				
				count = 0;
				
			}
			
			position = (randomness[count] << 8) | (randomness[count + 1] & 0xFF);
			position &= (n - 1);
				
			/* Position is between [0, n - 1] and Has not Been Set Yet
			 * Determine Signature
			 */
			if (C[position] == 0) {
				
				if ((randomness[count + 2] & 1) == 1) {
						
					C[position] = -1;
						
				} else {
						
					C[position] = 1;
						
				}
					
				positionList[i] = position;
				signList[i] = C[position];
				i++;
					
			}
			
			count += 3;
			
		}
		
	}

	
	/*********************************************************************************
	 * Description:	Checks Bounds for Signature Vector Z During Signification.
	 * 				Leaks the Position of the Coefficient that Fails the Test.
	 * 				The Position of the Coefficient is Independent of the Secret Data.
	 * 				Does not Leak the Signature of the Coefficients.
	 * 				For Heuristic qTESLA Security Category-1 and Security Category-3
	 * 				(Option for Size or Speed)
	 * 
	 * @param		Z		Signature Vector
	 * @param		n		Polynomial Degree
	 * @param		b		Interval the Randomness is Chosen in During Signification
	 * @param		u		Bound in Checking Secret Polynomial
	 * 
	 * @return		false	Valid / Accepted
	 * 				true	Invalid / Rejected
	 ********************************************************************************/
	private static boolean testRejection (int[] Z, int n, int b, int u) {
		
		for (int i = 0; i < n; i++) {
			
			if (Common.absolute (Z[i]) > (b - u)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/*************************************************************************************
	 * Description:	Checks Bounds for Signature Vector Z During Signification.
	 * 				Leaks the Position of the Coefficient that Fails the Test.
	 * 				The Position of the Coefficient is Independent of the Secret Data.
	 * 				Does not Leak the Signature of the Coefficients.
	 * 				For Provably-Secure qTESLA Security Category-1 and Security Category-3
	 * 
	 * @param		Z		Signature Vector
	 * @param		n		Polynomial Degree
	 * @param		b		Interval the Randomness is Chosen in During Signification
	 * @param		u		Bound in Checking Secret Polynomial
	 * 
	 * @return		false	Valid / Accepted
	 * 				true	Invalid / Rejected
	 *************************************************************************************/
	private static boolean testRejection (long[] Z, int n, int b, int u) {
		
		for (int i = 0; i < n; i++) {
			
			if (Common.absolute ((int) Z[i]) > (b - u)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**********************************************************************************
	 * Description:	Checks Bounds for Signature Vector Z During Signature Verification
	 * 				for Heuristic qTESLA Security Category 1 and Security Category 3
	 * 				(Option of Size of Speed)
	 * 
	 * @param		Z		Signature Vector
	 * @param		n		Polynomial Degree
	 * @param		b		Interval the Randomness is Chosen in During Signification
	 * @param		u		Bound in Checking Secret Polynomial
	 * 
	 * @return		false	Valid / Accepted
	 * 				true	Invalid / Rejected
	 *********************************************************************************/
	private static boolean testZ (int[] Z, int n, int b, int u) {
		
		for (int i = 0; i < n; i++) {
			
			if ((Z[i] < - (b - u)) || (Z[i] > b - u)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/*************************************************************************************
	 * Description:	Checks Bounds for Signature Vector Z During Signature Verification
	 * 				for Provably-Secure qTESLA Security Category-1 and Security Category-3
	 * 
	 * @param		Z		Signature Vector
	 * @param		n		Polynomial Degree
	 * @param		b		Interval the Randomness is Chosen in During Signification
	 * @param		u		Bound in Checking Secret Polynomial
	 * 
	 * @return		false	Valid / Accepted
	 * 				true	Invalid / Rejected
	 *************************************************************************************/
	private static boolean testZ (long[] Z, int n, int b, int u) {
		
		for (int i = 0; i < n; i++) {
			
			if ((Z[i] < - (b - u)) || (Z[i] > b - u)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/*************************************************************************************
	 * Description:	Checks Bounds for W = V - EC During Signature Verification.
	 * 				Leaks the Position of the Coefficient that Fails the Test.
	 * 				The Position of the Coefficient is Independent of the Secret Data.
	 * 				Does not Leak the Signature of the Coefficients.
	 * 				For Heuristic qTESLA Security Category 1 and Security Category 3
	 * 				(Option for Size or Speed)
	 * 
	 * @param		V			Parameter to be Checked
	 * @param		n			Polynomial Degree
	 * @param		d			Number of Rounded Bits
	 * @param		q			Modulus
	 * @param		rejection	Bound in Checking Error Polynomial
	 * 
	 * @return		false		Valid / Accepted
	 * 				true		Invalid / Rejected
	 *************************************************************************************/
	private static boolean testCorrectness (int[] V, int n, int d, int q, int rejection) {
	
		int mask;
		int left;
		int right;
		int test1;
		int test2;
		
		for (int i = 0; i < n; i++) {
			
			mask  = (q / 2 - V[i]) >> 31;
			right = ((V[i] - q) & mask) | (V[i] & (~ mask));
			test1 = (~ (Common.absolute (right) - (q / 2 - rejection))) >>> 31;
			left  = right;
			right = (right + (1 << (d - 1)) - 1) >> d;
			right = left - (right << d);
			test2 = (~ (Common.absolute (right) - ((1 << (d - 1)) - rejection))) >>> 31;
			
			/* Two Tests Fail */
			if ((test1 | test2) == 1) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**************************************************************************************************
	 * Description:	Checks Bounds for W = V - EC During Signature Verification.
	 * 				Leaks the Position of the Coefficient that Fails the Test.
	 * 				The Position of the Coefficient is Independent of the Secret Data.
	 * 				Does not Leak the Signature of the Coefficients.
	 * 				For Provably-Secure qTESLA Security Category 1 and Security Category 3
	 * 
	 * @param		V			Parameter to be Checked
	 * @param		vOffset		Starting Point of V
	 * @param		n			Polynomial Degree
	 * @param		d			Number of Rounded Bits
	 * @param		q			Modulus
	 * @param		rejection	Bound in Checking Error Polynomial
	 * 
	 * @return		false		Valid / Accepted
	 * 				true		Invalid / Rejected
	 ***************************************************************************************************/
	private static boolean testCorrectness (long[] V, int vOffset, int n, int d, int q, int rejection) {
	
		int mask;
		int left;
		int right;
		int test1;
		int test2;
		
		for (int i = 0; i < n; i++) {
			
			mask  = (int) (q / 2 - V[vOffset + i]) >> 31;
			right = (int) (((V[vOffset + i] - q) & mask) | (V[vOffset + i] & (~ mask)));
			test1 = (~ (Common.absolute (right) - (q / 2 - rejection))) >>> 31;
			
			left  = right;
			right = (right + (1 << (d - 1)) - 1) >> d;
			right = left - (right << d);
			test2 = (~ (Common.absolute (right) - ((1 << (d - 1)) - rejection))) >>> 31;
			
			/* Two Tests Fail */
			if ((test1 | test2) == 1L) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**********************************************************************************************************
	 * Description:	Checks Whether the Generated Error Polynomial or the Generated Secret Polynomial
	 *				Fulfills Certain Properties Needed in Key Generation Algorithm
	 *				For Heuristic qTESLA Security Category-1 and Security Category-3 (Option for Size or Speed)
	 * 
	 * @param		polynomial		Parameter to be Checked
	 * @param		bound			Threshold of Summation
	 * @param		n				Polynomial Degree
	 * @param		h				Number of Non-Zero Entries of Output Elements of Encryption
	 * 
	 * @return		false			Fulfillment
	 * 				true			No Fulfillment
	 **********************************************************************************************************/
	private static boolean checkPolynomial (int[] polynomial, int bound, int n, int h) {
		
		long summation = 0;
		int limit = n;
		int temporary;
		int mask;
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			list[i] = Common.absolute (polynomial[i]);
			
		}
		
		for (int i = 0; i < h; i++) {
			
			for (int j = 0; j < limit - 1; j++) {
				/* If list[j + 1] > list[j] Then Exchanges Contents */
				mask		= (list[j + 1] - list[j]) >> 31;
				temporary	= (list[j + 1] & mask) | (list[j]     & (~ mask));
				list[j + 1]	= (list[j]     & mask) | (list[j + 1] & (~ mask));
				list[j]		= temporary;
				
			}
			
			summation += list[limit - 1];
			
			limit--;
			
		}
		
		if (summation > bound) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/***********************************************************************************************
	 * Description:	Checks Whether the Generated Error Polynomial or the Generated Secret Polynomial
	 *				Fulfills Certain Properties Needed in Key Generation Algorithm
	 *				For Provably-Secure qTESLA Security Category 1 and Security Category 3
	 * 
	 * @param		polynomial		Parameter to be Checked
	 * @param		offset			Starting Point of the Polynomial to be Checked
	 * @param		bound			Threshold of Summation
	 * @param		n				Polynomial Degree
	 * @param		h				Number of Non-Zero Entries of Output Elements of Encryption
	 * 
	 * @return		false			Fulfillment
	 * 				true			No Fulfillment
	 ***********************************************************************************************/
	private static boolean checkPolynomial (long[] polynomial, int offset, int bound, int n, int h) {
		
		int summation = 0;
		int limit = n;
		int temporary;
		int mask;
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			list[i] = Common.absolute ((int) polynomial[offset + i]);
			
		}
		
		for (int i = 0; i < h; i++) {
			
			for (int j = 0; j < limit - 1; j++) {
				/* If list[j + 1] > list[j] Then Exchanges Contents */
				mask		= (list[j + 1] - list[j]) >> 31;
				temporary	= (list[j + 1] & mask) | (list[j]	  & (~ mask));
				list[j + 1]	= (list[j]     & mask) | (list[j + 1] & (~ mask));
				list[j]		= temporary;
				
			}
			
			summation += list[limit - 1];
			limit--;
			
		}
		
		if (summation > bound) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Heuristic qTESLA Security Category-1 and Security Category-3
	 *				(Option for Size or Speed)
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness
	 * @param		n									Polynomial Degree
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		xi
	 * @param		zeta
	 * @param		errorBound							Bound in Checking Error Polynomial
	 * @param		secretBound							Bound in Checking Secret Polynomial		
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws 		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ************************************************************************************************************************************************************/
	private static int generateKeyPair (
			
			byte[] publicKey, byte[] privateKey, SecureRandom secureRandom,
			int n, int h, int q, long qInverse, int qLogarithm, int generatorA, int inverseNumberTheoreticTransform, double xi,
			int[] zeta,
			int errorBound, int secretBound)
					
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		/* Initialize Domain Separator for Error Polynomial and Secret Polynomial */
		int nonce = 0;
		
		byte[] randomness			= new byte[Parameter.RANDOM];
		
		/* Extend Random Bytes to Seed Generation of Error Polynomial and Secret Polynomial */
		byte[] randomnessExtended	= new byte[Parameter.SEED * 4];
		
		int[] secretPolynomial	= new int[n];
		int[] errorPolynomial	= new int[n];
		int[] A					= new int[n];
		int[] T					= new int[n];
		
		/* Get randomnessExtended <- seedErrorPolynomial, seedSecretPolynomial, seedA, seedY */
		rng.randomByte (randomness, 0, Parameter.RANDOM);
		// secureRandom.nextBytes (randomness);
		
		if (q == Parameter.Q_I) { 
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (randomnessExtended, 0, Parameter.SEED * 4, randomness, 0, Parameter.RANDOM);
			
		}
		
		if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (randomnessExtended, 0, Parameter.SEED * 4, randomness, 0, Parameter.RANDOM);
			
		}
		
		/* 
		 * Sample the Error Polynomial Fulfilling the Criteria 
		 * Choose All Error Polynomial in R with Entries from D_SIGMA
		 * Repeat Step at Iteration if the h Largest Entries of Error Polynomial Summation to L_E
		 */
		do {
			
			if (q == Parameter.Q_I) {
				
				Gauss.polynomialGaussSampler (
						errorPolynomial, 0, randomnessExtended, 0, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_I,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_I
				);
				
			}
			
			if (q == Parameter.Q_III_SIZE) {
				
				Gauss.polynomialGaussSampler (
						errorPolynomial, 0, randomnessExtended, 0, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_SIZE,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_SIZE,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_SIZE
				);
				
			}
			
			if (q == Parameter.Q_III_SPEED) {
				
				Gauss.polynomialGaussSampler (
						errorPolynomial, 0, randomnessExtended, 0, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_SPEED,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_SPEED,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_SPEED
				);
				
			}
			
		} while (checkPolynomial (errorPolynomial, errorBound, n, h) == true);
		
		/* 
		 * Sample the Secret Polynomial Fulfilling the Criteria 
		 * Choose Secret Polynomial in R with Entries from D_SIGMA
		 * Repeat Step if the h Largest Entries of Secret Polynomial Summation to L_S
		 */
		do {
			
			if (q == Parameter.Q_I) {
				
				Gauss.polynomialGaussSampler (
						secretPolynomial, 0, randomnessExtended, Parameter.SEED, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_I,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_I
				);
				
			}
			
			if (q == Parameter.Q_III_SIZE) {
				
				Gauss.polynomialGaussSampler (
						secretPolynomial, 0, randomnessExtended, Parameter.SEED, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_SIZE,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_SIZE,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_SIZE
				);
				
			}
			
			if (q == Parameter.Q_III_SPEED) {
				
				Gauss.polynomialGaussSampler (
						secretPolynomial, 0, randomnessExtended, Parameter.SEED, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_SPEED,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_SPEED,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_SPEED
				);
				
			}
			
		} while (checkPolynomial (secretPolynomial, secretBound, n, h) == true);
		
		/* Generate Uniform Polynomial A */
		Polynomial.polynomialUniform (A, randomnessExtended, Parameter.SEED * 2, n, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform);
		
		/* Compute the Public Key T = A * secretPolynomial + errorPolynomial */
		Polynomial.polynomialMultiplication (T, A, secretPolynomial, n, q, qInverse, zeta);
		Polynomial.polynomialAdditionCorrection (T, T, errorPolynomial, n, q);
		
		/* Pack Public and Private Keys */
		if (q == Parameter.Q_I) {
			
			Pack.encodePrivateKeyI (privateKey, secretPolynomial, errorPolynomial, randomnessExtended, Parameter.SEED * 2);
			Pack.encodePublicKey (publicKey, T, randomnessExtended, Parameter.SEED * 2, Parameter.N_I,	Parameter.Q_LOGARITHM_I);
		
		}
		
		if (q == Parameter.Q_III_SIZE) {
			
			Pack.encodePrivateKeyIIISize (privateKey, secretPolynomial, errorPolynomial, randomnessExtended, Parameter.SEED * 2);
			Pack.encodePublicKey (publicKey, T, randomnessExtended, Parameter.SEED * 2, Parameter.N_III_SIZE,	Parameter.Q_LOGARITHM_III_SIZE);
			
		}
		
		if (q == Parameter.Q_III_SPEED) {
			
			Pack.encodePrivateKeyIIISpeed (privateKey, secretPolynomial, errorPolynomial, randomnessExtended, Parameter.SEED * 2);
			Pack.encodePublicKeyIIISpeed (publicKey, T, randomnessExtended, Parameter.SEED * 2);
			
		}
		
		return 0;
		
	}
	
	/****************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for
	 * 				Heuristic qTESLA Security Category-1
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************************/
	public static int generateKeyPairI (byte[] publicKey, byte[] privateKey, SecureRandom secureRandom)
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return generateKeyPair (
				
				publicKey, privateKey, secureRandom,
				Parameter.N_I, Parameter.H_I, Parameter.Q_I, Parameter.Q_INVERSE_I, Parameter.Q_LOGARITHM_I,
				Parameter.GENERATOR_A_I, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I,
				Parameter.XI_I,
				PolynomialHeuristic.ZETA_I,
				Parameter.KEY_GENERATOR_BOUND_E_I, Parameter.KEY_GENERATOR_BOUND_S_I
		
		);
		
	}
	
	/****************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Heuristic qTESLA Security Category-3 (Option for Size)
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************************/
	public static int generateKeyPairIIISize (byte[] publicKey, byte[] privateKey, SecureRandom secureRandom)

			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return generateKeyPair (
				
				publicKey, privateKey, secureRandom,
				Parameter.N_III_SIZE, Parameter.H_III_SIZE, Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE,
				Parameter.GENERATOR_A_III_SIZE, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SIZE,
				Parameter.XI_III_SIZE,
				PolynomialHeuristic.ZETA_III_SIZE,
				Parameter.KEY_GENERATOR_BOUND_E_III_SIZE, Parameter.KEY_GENERATOR_BOUND_S_III_SIZE
		
		);
		
	}
	
	/****************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Heuristic qTESLA Security Category-3
	 * 				(Option for Speed)
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************************/
	public static int generateKeyPairIIISpeed (byte[] publicKey, byte[] privateKey, SecureRandom secureRandom)
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return generateKeyPair (
				
				publicKey, privateKey, secureRandom,
				Parameter.N_III_SPEED, Parameter.H_III_SPEED, Parameter.Q_III_SPEED, Parameter.Q_INVERSE_III_SPEED, Parameter.Q_LOGARITHM_III_SPEED,
				Parameter.GENERATOR_A_III_SPEED, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SPEED,
				Parameter.XI_III_SPEED,
				PolynomialHeuristic.ZETA_III_SPEED,
				Parameter.KEY_GENERATOR_BOUND_E_III_SPEED, Parameter.KEY_GENERATOR_BOUND_S_III_SPEED
		
		);
		
	}
	
	/*******************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Provably-Secure qTESLA Security Category-1
	 * 				and Category-3
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness
	 * @param		n									Polynomial Degree
	 * @param		k									Number of Ring-Learning-With-Errors Samples
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		xi
	 * @param		zeta
	 * @param		errorBound							Bound in Checking Error Polynomial
	 * @param		secretBound							Bound in Checking Secret Polynomial	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException 
	 * @throws		IllegalBlockSizeException 
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException 
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 *******************************************************************************************************************************************************/
	private static int generateKeyPair (
			
			byte[] publicKey, byte[] privateKey, SecureRandom secureRandom, 
			int n, int k, int h, int q, long qInverse, int qLogarithm, int generatorA, int inverseNumberTheoreticTransform, double xi,
			long[] zeta,
			int errorBound, int secretBound
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		/* Initialize Domain Separator for Error Polynomial and Secret Polynomial */
		int nonce = 0;
		
		byte[] randomness			= new byte[Parameter.RANDOM];
		
		/* Extend Random Bytes to Seed Generation of Error Polynomial and Secret Polynomial */
		byte[] randomnessExtended	= new byte[Parameter.SEED * (k + 3)];
		
		long[] secretPolynomial							= new long[n];
		long[] secretPolynomialNumberTheoreticTransform	= new long[n];
		long[] errorPolynomial							= new long[n * k];
		long[] A										= new long[n * k];
		long[] T										= new long[n * k];
		
		/* Get randomnessExtended <- seedErrorPolynomial, seedSecretPolynomial, seedA, seedY */
		rng.randomByte (randomness, 0, Parameter.RANDOM);
		// secureRandom.nextBytes (randomness);
		
		if (q == Parameter.Q_I_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				randomnessExtended, 0, Parameter.SEED * (k + 3), randomness, 0, Parameter.RANDOM
			);
			
		}
		
		if (q == Parameter.Q_III_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				randomnessExtended, 0, Parameter.SEED * (k + 3), randomness, 0, Parameter.RANDOM
			);
			
		}
		
		/* 
		 * Sample the Error Polynomial Fulfilling the Criteria 
		 * Choose All Error Polynomial_i in R with Entries from D_SIGMA
		 * Repeat Step at Iteration if the h Largest Entries of Error Polynomial_k Summation to L_E
		 */
		for (int i = 0; i < k; i++) {
			
			do {
				
				if (q == Parameter.Q_I_P) {
					
					Gauss.polynomialGaussSampler (
							errorPolynomial, n * i, randomnessExtended, Parameter.SEED * i, ++nonce, n,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_I_P,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I_P,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_I_P
					);
					
				}
				
				if (q == Parameter.Q_III_P) {
					
					Gauss.polynomialGaussSampler (
							errorPolynomial, n * i, randomnessExtended, Parameter.SEED * i, ++nonce, n,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_P,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_P,
							CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_P
					);
					
				}
				
			} while (checkPolynomial (errorPolynomial, n * i, errorBound, n, h) == true);
		
		}
		
		/* 
		 * Sample the Secret Polynomial Fulfilling the Criteria 
		 * Choose Secret Polynomial in R with Entries from D_SIGMA
		 * Repeat Step if the h Largest Entries of Secret Polynomial Summation to L_S
		 */
		do {
			
			if (q == Parameter.Q_I_P) {
				
				Gauss.polynomialGaussSampler (
						secretPolynomial, 0, randomnessExtended, Parameter.SEED * k, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_I_P,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I_P,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_I_P
				);
				
			}
			
			if (q == Parameter.Q_III_P) {
				
				Gauss.polynomialGaussSampler (
						secretPolynomial, 0, randomnessExtended, Parameter.SEED * k, ++nonce, n,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_ROW_III_P,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_III_P,
						CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_III_P
				);

			}
			
		} while (checkPolynomial (secretPolynomial, 0, secretBound, n, h) == true);
		
		/* Generate Uniform Polynomial A */
		Polynomial.polynomialUniform (
			A, randomnessExtended, Parameter.SEED * (k + 1), n, k, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform
		);
			
		Polynomial.polynomialNumberTheoreticTransform (secretPolynomialNumberTheoreticTransform, secretPolynomial, n);
		
		/* Compute the Public Key T = A * secretPolynomial + errorPolynomial */
		for (int i = 0; i < k; i++) {
			
			Polynomial.polynomialMultiplication (T, n * i, A, n * i, secretPolynomialNumberTheoreticTransform, 0, n, q, qInverse);	
			Polynomial.polynomialAdditionCorrection (T, n * i, T, n * i, errorPolynomial, n * i, n, q);
		
		}
		
		/* Pack Public and Private Keys */
		Pack.packPrivateKey (privateKey, secretPolynomial, errorPolynomial, randomnessExtended, Parameter.SEED * (k + 1), n, k);
		
		if (q == Parameter.Q_I_P) {
			
			Pack.encodePublicKeyIP (publicKey, T, randomnessExtended, Parameter.SEED * (k + 1));
			
		}
		
		if (q == Parameter.Q_III_P) {
			
			Pack.encodePublicKeyIIIP (publicKey, T, randomnessExtended, Parameter.SEED * (k + 1));
			
		}
		
		return 0;
		
	}
	
	/****************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Provably-Secure qTESLA Security Category-1
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException 
	 * @throws		IllegalBlockSizeException 
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException 
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************************/
	public static int generateKeyPairIP (byte[] publicKey, byte[] privateKey, SecureRandom secureRandom)
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return generateKeyPair (
				
				publicKey, privateKey, secureRandom,
				Parameter.N_I_P, Parameter.K_I_P, Parameter.H_I_P, Parameter.Q_I_P, Parameter.Q_INVERSE_I_P, Parameter.Q_LOGARITHM_I_P,
				Parameter.GENERATOR_A_I_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I_P,
				Parameter.XI_I_P,
				PolynomialProvablySecure.ZETA_I_P,
				Parameter.KEY_GENERATOR_BOUND_E_I_P, Parameter.KEY_GENERATOR_BOUND_S_I_P
				
		);
		
	}
	
	/****************************************************************************************************************************************************************
	 * Description:	Generates A Pair of Public Key and Private Key for qTESLA Signature Scheme for Provably-Secure qTESLA Security Category-3
	 * 
	 * @param		publicKey							Contains Public Key
	 * @param		privateKey							Contains Private Key
	 * @param		secureRandom						Source of Randomness	
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException 
	 * @throws		IllegalBlockSizeException 
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException 
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************************/
	public static int generateKeyPairIIIP (byte[] publicKey, byte[] privateKey, SecureRandom secureRandom)
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return generateKeyPair (
				
				publicKey, privateKey, secureRandom,
				Parameter.N_III_P, Parameter.K_III_P, Parameter.H_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P, Parameter.Q_LOGARITHM_III_P,
				Parameter.GENERATOR_A_III_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_P,
				Parameter.XI_III_P,
				PolynomialProvablySecure.ZETA_III_P,
				Parameter.KEY_GENERATOR_BOUND_E_III_P, Parameter.KEY_GENERATOR_BOUND_S_III_P
		
		);
		
	}
	
	/******************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Heuristic qTESLA Security Category-1 and
	 * 				Security Category-3 (Option for Size or Speed)
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * @param		n									Polynomial Degree
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		b									Determines the Interval the Randomness is Chosen in During Signing
	 * @param		bBit								b = (2 ^ bBit) - 1
	 * @param		d									Number of Rounded Bits
	 * @param		u									Bound in Checking Secret Polynomial
	 * @param		rejection							Bound in Checking Error Polynomial
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		barrettMultiplication
	 * @param		barrettDivision
	 * @param		zeta
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException 
	 * @throws		ShortBufferException
	 ******************************************************************************************************************************************************/
	private static int signing (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom,
			int n, int h, int q, long qInverse, int qLogarithm, int b, int bBit, int d, int u, int rejection,
			int generatorA, int inverseNumberTheoreticTransform,
			int barrettMultiplication, int barrettDivision,
			int[] zeta
	
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		byte[] C						= new byte[Parameter.HASH];
		byte[] randomness				= new byte[Parameter.SEED];
		byte[] randomnessInput			= new byte[Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE];
		byte[] seed						= new byte[Parameter.SEED * 2];
		// byte[] temporaryRandomnessInput	= new byte[Polynomial.RANDOM];
		int[] positionList				= new int[h];
		short[] signList				= new short[h];
		short[] secretPolynomial		= new short[n];
		short[] errorPolynomial			= new short[n];
		
		int[] A		= new int[n];
		int[] V		= new int[n];
		int[] Y		= new int[n];
		int[] Z		= new int[n];
		int[] SC	= new int[n];
		int[] EC	= new int[n];
		
		/* Domain Separator for Sampling Y */
		int nonce = 0;
		
		if (q == Parameter.Q_I) {
			
			Pack.decodePrivateKeyI (seed, secretPolynomial, errorPolynomial, privateKey);
			
		}
		
		if (q == Parameter.Q_III_SIZE) {
			
			Pack.decodePrivateKeyIIISize (seed, secretPolynomial, errorPolynomial, privateKey);
			
		}
		
		if (q == Parameter.Q_III_SPEED) {
			
			Pack.decodePrivateKeyIIISpeed (seed, secretPolynomial, errorPolynomial, privateKey);
			
		}
		
		rng.randomByte (randomnessInput, Parameter.RANDOM, Parameter.RANDOM);
		// secureRandom.nextBytes (temporaryRandomnessInput);
		// System.arraycopy (temporaryRandomnessInput, 0, randomnessInput, Polynomial.RANDOM, Polynomial.RANDOM);
		
		System.arraycopy (seed, Parameter.SEED, randomnessInput, 0, Parameter.SEED);
		
		if (q == Parameter.Q_I) {
		
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				randomnessInput, Parameter.RANDOM + Parameter.SEED, Parameter.MESSAGE, message, 0, messageLength
			);
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				randomness, 0, Parameter.SEED, randomnessInput, 0, Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE
			);
		
		}
		
		if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				randomnessInput, Parameter.RANDOM + Parameter.SEED, Parameter.MESSAGE, message, 0, messageLength
			);
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				randomness, 0, Parameter.SEED, randomnessInput, 0, Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE
			);
			
		}
		
		Polynomial.polynomialUniform (A, seed, 0, n, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform);
		
		/* Loop Due to Possible Rejection */
		while (true) {
			
			/* Sample Y Uniformly Random from -B to B */
			Sample.sampleY (Y, randomness, 0, ++nonce, n, q, b, bBit);
			
			/* V = A * Y Modulo Q */
			Polynomial.polynomialMultiplication (V, A, Y, n, q, qInverse, zeta);
			
			hashFunction (C, 0, V, randomnessInput, Parameter.RANDOM + Parameter.SEED, n, d, q);
			
			/* Generate C = EncodeC (C') Where C' is the Hashing of V Together with Message */
			encodeC (positionList, signList, C, 0, n, h);
			
			Polynomial.sparsePolynomialMultiplication16 (SC, secretPolynomial, positionList, signList, n, h);
			
			/* Z = Y + EC Modulo Q */
			Polynomial.polynomialAddition(Z, Y, SC, n);
			
			/* Rejection Sampling */
			if (testRejection (Z, n, b, u) == true) {
				
				continue;
				
			}
			
			Polynomial.sparsePolynomialMultiplication16 (EC, errorPolynomial, positionList, signList, n, h);
			
			/* V = V - EC modulo Q */
			Polynomial.polynomialSubtractionCorrection (V, V, EC, n, q);
			
			if (testCorrectness (V, n, d, q, rejection) == true) {
				
				continue;
				
			}
			
			if (q == Parameter.Q_I) {

				/* Copy the Message into the Signature Package */
				System.arraycopy (message, messageOffset, signature, signatureOffset + SIGNATURE_I, messageLength);
				
				/* Length of the Output */
				signatureLength[0] = SIGNATURE_I + messageLength;
				
				/* Pack Signature */
				Pack.encodeSignature (signature, 0, C, 0, Z, n, d);
				
			}
			
			if (q == Parameter.Q_III_SIZE) {
				
				/* Copy the Message into the Signature Package */
				System.arraycopy (message, messageOffset, signature, signatureOffset + SIGNATURE_III_SIZE, messageLength);
				
				/* Length of the Output */
				signatureLength[0] = SIGNATURE_III_SIZE + messageLength;
				
				/* Pack Signature */
				Pack.encodeSignature (signature, 0, C, 0, Z, n, d);
				
			}
			
			if (q == Parameter.Q_III_SPEED) {
				
				/* Copy the Message into the Signature Package */
				System.arraycopy (message, messageOffset, signature, signatureOffset + SIGNATURE_III_SPEED, messageLength);
				
				/* Length of the Output */
				signatureLength[0] = SIGNATURE_III_SPEED + messageLength;
				
				/* Pack Signature */
				Pack.encodeSignatureIIISpeed (signature, 0, C, 0, Z);
				
			}
			
			return 0;
			
		}
		
	}
	
	/*****************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Heuristic qTESLA Security Category-1
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException 
	 * @throws		ShortBufferException
	 *****************************************************************************************************************************************************/
	public static int signingI (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return signing (
				
				signature, signatureOffset, signatureLength,
				message, messageOffset, messageLength,
				privateKey, secureRandom,
				Parameter.N_I, Parameter.H_I, Parameter.Q_I, Parameter.Q_INVERSE_I, Parameter.Q_LOGARITHM_I,
				Parameter.B_I, Parameter.B_BIT_I, Parameter.D_I, Parameter.U_I, Parameter.REJECTION_I,
				Parameter.GENERATOR_A_I, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I,
				Parameter.BARRETT_MULTIPLICATION_I, Parameter.BARRETT_DIVISION_I,
				PolynomialHeuristic.ZETA_I
		
		);
		
	}
	
	/*****************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Heuristic qTESLA Security Category-3
	 * 				(Option for Size)
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException 
	 * @throws		ShortBufferException
	 *****************************************************************************************************************************************************/
	public static int signingIIISize (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return signing (
				
				signature, signatureOffset, signatureLength,
				message, messageOffset, messageLength,
				privateKey, secureRandom,
				Parameter.N_III_SIZE, Parameter.H_III_SIZE, Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE,
				Parameter.B_III_SIZE, Parameter.B_BIT_III_SIZE, Parameter.D_III_SIZE, Parameter.U_III_SIZE, Parameter.REJECTION_III_SIZE,
				Parameter.GENERATOR_A_III_SIZE, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SIZE,
				Parameter.BARRETT_MULTIPLICATION_III_SIZE, Parameter.BARRETT_DIVISION_III_SIZE,
				PolynomialHeuristic.ZETA_III_SIZE
		
		);
		
	}
	
	/****************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Heuristic qTESLA Security Category-3
	 *				(Option for Speed)
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException 
	 * @throws		ShortBufferException
	 ****************************************************************************************************************************************************/
	public static int signingIIISpeed (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return signing (
				
				signature, signatureOffset, signatureLength,
				message, messageOffset, messageLength,
				privateKey, secureRandom,
				Parameter.N_III_SPEED, Parameter.H_III_SPEED, Parameter.Q_III_SPEED, Parameter.Q_INVERSE_III_SPEED, Parameter.Q_LOGARITHM_III_SPEED,
				Parameter.B_III_SPEED, Parameter.B_BIT_III_SPEED, Parameter.D_III_SPEED, Parameter.U_III_SPEED, Parameter.REJECTION_III_SPEED,
				Parameter.GENERATOR_A_III_SPEED, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SPEED,
				Parameter.BARRETT_MULTIPLICATION_III_SPEED, Parameter.BARRETT_DIVISION_III_SPEED,
				PolynomialHeuristic.ZETA_III_SPEED
		
		);
		
	}
	
	/*****************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Provably-Secure qTESLA Security Category-1
	 *				and Category-3
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * @param		n									Polynomial Degree
	 * @param		k									Number of Ring-Learning-With-Errors Samples
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		b									Determines the Interval the Randomness is Chosen in During Signing
	 * @param		bBit								b = (2 ^ bBit) - 1
	 * @param		d									Number of Rounded Bits
	 * @param		u									Bound in Checking Secret Polynomial
	 * @param		rejection							Bound in Checking Error Polynomial
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		privateKeySize						Size of the Private Key
	 * @param		barrettMultiplication
	 * @param		barrettDivision
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 *****************************************************************************************************************************************************/
	private static int signing (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom,
			int n, int k, int h, int q, long qInverse, int qLogarithm, int b, int bBit, int d, int u, int rejection,
			int generatorA, int inverseNumberTheoreticTransform, int privateKeySize,
			int barrettMultiplication, int barrettDivision
	
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		byte[] C						= new byte[Parameter.HASH];
		byte[] randomness				= new byte[Parameter.SEED];
		byte[] randomnessInput			= new byte[Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE];
		// byte[] temporaryRandomnessInput	= new byte[Polynomial.RANDOM];
		int[] positionList				= new int[h];
		short[] signList				= new short[h];
		
		long[] A							= new long[n * k];
		long[] V							= new long[n * k];
		long[] Y							= new long[n];
		long[] numberTheoreticTransformY	= new long[n];
		long[] Z							= new long[n];
		long[] SC							= new long[n];
		long[] EC							= new long[n * k];
		
		boolean response = false;
		
		/* Domain Separator for Sampling Y */
		int nonce = 0;
		
		rng.randomByte (randomnessInput, Parameter.RANDOM, Parameter.RANDOM);
		// secureRandom.nextBytes (temporaryRandomnessInput);
		// System.arraycopy (temporaryRandomnessInput, 0, randomnessInput, Polynomial.RANDOM, Polynomial.RANDOM);
		System.arraycopy (privateKey, privateKeySize - Parameter.SEED, randomnessInput, 0, Parameter.SEED);
		
		if (q == Parameter.Q_I_P) {
		
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				randomnessInput, Parameter.RANDOM + Parameter.SEED, Parameter.MESSAGE, message, 0, messageLength
			);
			
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				randomness, 0, Parameter.SEED, randomnessInput, 0, Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE
			);
		
		}
		
		if (q == Parameter.Q_III_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				randomnessInput, Parameter.RANDOM + Parameter.SEED, Parameter.MESSAGE, message, 0, messageLength
			);
			
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				randomness, 0, Parameter.SEED, randomnessInput, 0, Parameter.RANDOM + Parameter.SEED + Parameter.MESSAGE
			);
			
		}
		
		Polynomial.polynomialUniform (
			A, privateKey, privateKeySize - 2 * Parameter.SEED, n, k, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform
		);
		
		/* Loop Due to Possible Rejection */
		while (true) {
			
			/* Sample Y Uniformly Random from -B to B */
			Sample.sampleY (Y, randomness, 0, ++nonce, n, q, b, bBit);
			
			Polynomial.polynomialNumberTheoreticTransform (numberTheoreticTransformY, Y, n);
			
			/* V_i = A_i * Y Modulo Q for All i */
			for (int i = 0; i < k; i++) {
				
				Polynomial.polynomialMultiplication (V, n * i, A, n * i, numberTheoreticTransformY, 0, n, q, qInverse);
				
			}
			
			hashFunction (C, 0, V, randomnessInput, Parameter.RANDOM + Parameter.SEED, n, k, d, q);
			
			/* Generate C = EncodeC (C') Where C' is the Hashing of V Together with Message */
			encodeC (positionList, signList, C, 0, n, h);
			
			Polynomial.sparsePolynomialMultiplication8 (SC, 0, privateKey, 0, positionList, signList, n, h);
			
			/* Z = Y + EC modulo Q */
			Polynomial.polynomialAddition (Z, 0, Y, 0, SC, 0, n);
			
			/* Rejection Sampling */
			if (testRejection (Z, n, b, u) == true) {
				
				continue;
				
			}
			
			for (int i = 0; i < k; i++) {
				
				Polynomial.sparsePolynomialMultiplication8 (EC, n * i, privateKey, n * (i + 1), positionList, signList, n, h);
				
				/* V_i = V_i - EC_i Modulo Q for All k */
				Polynomial.polynomialSubtraction (V, n * i, V, n * i, EC, n * i, n, q, barrettMultiplication, barrettDivision);
				
				response = testCorrectness (V, n * i, n, d, q, rejection);
				
				if (response == true) {
				
					break;
					
				}
			
			}
			
			if (response == true) {
				
				continue;
				
			}
			
			if (q == Parameter.Q_I_P) {
				
				/* Copy the Message into the Signature Package */
				System.arraycopy (message, messageOffset, signature, signatureOffset + SIGNATURE_I_P, messageLength);
				
				/* Length of the Output */
				signatureLength[0] = messageLength + SIGNATURE_I_P;
				
				/* Pack Signature */
				Pack.encodeSignatureIP (signature, 0, C, 0, Z);
				
			}
			
			if (q == Parameter.Q_III_P) {
				
				/* Copy the Message into the Signature Package */
				System.arraycopy (message, messageOffset, signature, signatureOffset + SIGNATURE_III_P, messageLength);
				
				/* Length of the Output */
				signatureLength[0] = messageLength + SIGNATURE_III_P;
				
				/* Pack Signature */
				Pack.encodeSignatureIIIP (signature, 0, C, 0, Z);
				
			}
			
			return 0;
			
		}
		
	}
	
	/*****************************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Provably-Secure qTESLA Security Category-1
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 *****************************************************************************************************************************************************/
	public static int signingIP (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return signing (
				
				signature, signatureOffset, signatureLength,
				message, messageOffset, messageLength,
				privateKey, secureRandom,
				Parameter.N_I_P, Parameter.K_I_P, Parameter.H_I_P, Parameter.Q_I_P, Parameter.Q_INVERSE_I_P, Parameter.Q_LOGARITHM_I_P,
				Parameter.B_I_P, Parameter.B_BIT_I_P, Parameter.D_I_P, Parameter.U_I_P, Parameter.REJECTION_I_P,
				Parameter.GENERATOR_A_I_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I_P, PRIVATE_KEY_I_P,
				Parameter.BARRETT_MULTIPLICATION_I_P, Parameter.BARRETT_DIVISION_I_P
		
		);
		
	}
	
	/**********************************************************************************************************************************************
	 * Description:	Generates A Signature for A Given Message According to the Ring-TESLA Signature Scheme for Provably-Secure
	 * 				qTESLA Security Category-3
	 * 
	 * @param		message								Message to be Signed
	 * @param		messageOffset						Starting Point of the Message to be Signed
	 * @param		messageLength						Length of the Message to be Signed
	 * @param		signature							Output Package Containing Signature
	 * @param		signatureOffset						Starting Point of the Output Package Containing Signature
	 * @param		signatureLength						Length of the Output Package Containing Signature
	 * @param		privateKey							Private Key
	 * @param		secureRandom						Source of Randomness
	 * 
	 * @return		0									Successful Execution
	 * 
	 * @throws		BadPaddingException
	 * @throws		IllegalBlockSizeException
	 * @throws		InvalidKeyException
	 * @throws		NoSuchAlgorithmException
	 * @throws		NoSuchPaddingException
	 * @throws		ShortBufferException
	 **********************************************************************************************************************************************/
	public static int signingIIIP (
			
			byte[] signature, int signatureOffset, int[] signatureLength,
			final byte[] message, int messageOffset, int messageLength,
			final byte[] privateKey, SecureRandom secureRandom
			
	) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		return signing (
				
				signature, signatureOffset, signatureLength,
				message, messageOffset, messageLength,
				privateKey, secureRandom,
				Parameter.N_III_P, Parameter.K_III_P, Parameter.H_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P, Parameter.Q_LOGARITHM_III_P,
				Parameter.B_III_P, Parameter.B_BIT_III_P, Parameter.D_III_P, Parameter.U_III_P, Parameter.REJECTION_III_P,
				Parameter.GENERATOR_A_III_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_P, PRIVATE_KEY_III_P,
				Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P
		
		);
		
	}
	
	/*********************************************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for A Given Signature Package
	 * 				for Heuristic qTESLA Security Category-1 and Security Category-3 (Option for Size of Speed)
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * @param		n									Polynomial Degree
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		b									Determines the Interval the Randomness is Chosen in During Signing
	 * @param		d									Number of Rounded Bits
	 * @param		u									Bound in Checking Secret Polynomial
	 * @param		r
	 * @param		signatureSize						Size of the Given Signature Package
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		barrettMultiplication
	 * @param		barrettDivision
	 * @param		zeta
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 *********************************************************************************************************************************/
	private static int verifying (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey,
			int n, int h, int q, long qInverse, int qLogarithm, int b, int d, int u, int r, int signatureSize,
			int generatorA, int inverseNumberTheoreticTransform,
			int barrettMultiplication, int barrettDivision,
			int[] zeta
		
	) {
		
		byte[]	C				= new byte[Parameter.HASH];
		byte[]	cSignature		= new byte[Parameter.HASH];
		byte[]	seed			= new byte[Parameter.SEED];
		byte[]	hashMessage		= new byte[Parameter.MESSAGE];
		int[]	newPublicKey	= new int[n];
		
		int[] 	positionList	= new int[h];
		short[] signList		= new short[h];
		
		int[] W		= new int[n];
		int[] Z		= new int[n];
		int[] TC	= new int[n];
		int[] A		= new int[n];
		
		if (signatureLength < signatureSize) {
			
			return -1;
			
		}
		
		if (q == Parameter.Q_I || q == Parameter.Q_III_SIZE) {
			
			Pack.decodeSignature (C, Z, signature, signatureOffset, n, d);
		
		}
		
		if (q == Parameter.Q_III_SPEED) {
			
			Pack.decodeSignatureIIISpeed (C, Z, signature, signatureOffset);
			
		}
		
		/* Check Norm of Z */
		if (testZ (Z, n, b, u) == true) {
			
			return -2;
			
		}
		
		if (q == Parameter.Q_I || q == Parameter.Q_III_SIZE) {
			
			Pack.decodePublicKey (newPublicKey, seed, 0, publicKey, n, qLogarithm);
			
		}
		
		if (q == Parameter.Q_III_SPEED) {
			
			Pack.decodePublicKeyIIISpeed (newPublicKey, seed, 0, publicKey);
			
		}
		
		/* Generate A Polynomial */
		Polynomial.polynomialUniform (A, seed, 0, n, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform);
		
		encodeC (positionList, signList, C, 0, n, h);
		
		/* W = A * Z - TC */
		Polynomial.sparsePolynomialMultiplication32 (TC, newPublicKey, positionList, signList, n, h);
		
		Polynomial.polynomialMultiplication (W, A, Z, n, q, qInverse, zeta);
		
		Polynomial.polynomialSubtractionMontgomery (W, W, TC, n, q, qInverse, r);
		
		if (q == Parameter.Q_I) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				hashMessage, 0, Parameter.MESSAGE, signature, signatureSize, signatureLength - signatureSize
			);
			
		}
		
		if (q == Parameter.Q_III_SIZE || q == Parameter.Q_III_SPEED) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				hashMessage, 0, Parameter.MESSAGE, signature, signatureSize, signatureLength - signatureSize
			);
			
		}
		
		/* Obtain the Hash Symbol */
		hashFunction (cSignature, 0, W, hashMessage, 0, n, d, q);
		
		/* Check if Same With One from Signature */
		if (Common.memoryEqual (C, 0, cSignature, 0, Parameter.HASH) == false) {
			
			return -3;
			
		}
		
		messageLength[0] = signatureLength - signatureSize;
		
		System.arraycopy (signature, signatureOffset + signatureSize, message, messageOffset, messageLength[0]);
		
		return 0;

	}
	
	/*******************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for
	 * 				A Given Signature Package for Heuristic qTESLA Security Category-1
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 *******************************************************************************************************/
	public static int verifyingI (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey
			
	) {
		
		return verifying (
				
				message, messageOffset, messageLength,
				signature, signatureOffset, signatureLength,
				publicKey,
				Parameter.N_I, Parameter.H_I, Parameter.Q_I, Parameter.Q_INVERSE_I, Parameter.Q_LOGARITHM_I,
				Parameter.B_I, Parameter.D_I, Parameter.U_I, Parameter.R_I,
				SIGNATURE_I,
				Parameter.GENERATOR_A_I, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I,
				Parameter.BARRETT_MULTIPLICATION_I, Parameter.BARRETT_DIVISION_I,
				PolynomialHeuristic.ZETA_I
				
		);
		
	}
	
	/******************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for
	 *				A Given Signature Package for Heuristic qTESLA Security Category-3 (Option for Size)
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 ******************************************************************************************************/
	public static int verifyingIIISize (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey
			
	) {
		
		return verifying (
				
				message, messageOffset, messageLength,
				signature, signatureOffset, signatureLength,
				publicKey,
				Parameter.N_III_SIZE, Parameter.H_III_SIZE,
				Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE,
				Parameter.B_III_SIZE, Parameter.D_III_SIZE, Parameter.U_III_SIZE, Parameter.R_III_SIZE,
				SIGNATURE_III_SIZE,
				Parameter.GENERATOR_A_III_SIZE, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SIZE,
				Parameter.BARRETT_MULTIPLICATION_III_SIZE, Parameter.BARRETT_DIVISION_III_SIZE,
				PolynomialHeuristic.ZETA_III_SIZE
				
		);
		
	}
	
	/**********************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for
	 * 				A Given Signature Package for Heuristic qTESLA Security Category-3 (Option for Speed)
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 **********************************************************************************************************/
	public static int verifyingIIISpeed (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey
			
	) {
		
		return verifying (
				
				message, messageOffset, messageLength,
				signature, signatureOffset, signatureLength,
				publicKey,
				Parameter.N_III_SPEED, Parameter.H_III_SPEED,
				Parameter.Q_III_SPEED, Parameter.Q_INVERSE_III_SPEED, Parameter.Q_LOGARITHM_III_SPEED,
				Parameter.B_III_SPEED, Parameter.D_III_SPEED, Parameter.U_III_SPEED, Parameter.R_III_SPEED,
				SIGNATURE_III_SPEED,
				Parameter.GENERATOR_A_III_SPEED, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_SPEED,
				Parameter.BARRETT_MULTIPLICATION_III_SPEED, Parameter.BARRETT_DIVISION_III_SPEED,
				PolynomialHeuristic.ZETA_III_SPEED
				
		);
		
	}
	
	/**************************************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for A Given Signature
	 * 				Package for Provably-Secure qTESLA Security Category-1 and Category-3
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * @param		n									Polynomial Degree
	 * @param		k									Number of Ring-Learning-With-Errors Samples
	 * @param		h									Number of Non-Zero Entries of Output Elements of Encryption
	 * @param		q									Modulus
	 * @param		qInverse
	 * @param		qLogarithm							q <= 2 ^ qLogarithm
	 * @param		b									Determines the Interval the Randomness is Chosen in During Signing
	 * @param		d									Number of Rounded Bits
	 * @param		u									Bound in Checking Secret Polynomial
	 * @param		lowerBound							Size of the Given Signature Package
	 * @param		generatorA
	 * @param		inverseNumberTheoreticTransform
	 * @param		barrettMultiplication
	 * @param		barrettDivision
	 * @param		zeta
	 * @param		zetaInverse
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 *************************************************************************************************************************/
	private static int verifying (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey,
			int n, int k, int h, int q, long qInverse, int qLogarithm, int b, int d, int u, int signatureSize,
			int generatorA, int inverseNumberTheoreticTransform,
			int barrettMultiplication, int barrettDivision,
			long[] zeta
			
	) {
		
		byte[]	C					= new byte[Parameter.HASH];
		byte[]	cSignature			= new byte[Parameter.HASH];
		byte[]	seed				= new byte[Parameter.SEED];
		byte[]	hashMessage			= new byte[Parameter.MESSAGE];
		int[]	newPublicKey		= new int[n * k];
		
		int[]	positionList		= new int[h];
		short[]	signList			= new short[h];
		
		long[] W							= new long[n * k];
		long[] Z							= new long[n];
		long[] numberTheoreticTransformZ	= new long[n];
		long[] TC							= new long[n * k];
		long[] A							= new long[n * k];
		
		if (signatureLength < signatureSize) {
			
			return -1;
			
		}
		
		if (q == Parameter.Q_I_P) {
			
			Pack.decodeSignatureIP (C, Z, signature, signatureOffset);
		
		}
		
		if (q == Parameter.Q_III_P) {
			
			Pack.decodeSignatureIIIP (C, Z, signature, signatureOffset);
			
		}
		
		/* Check Norm of Z */
		if (testZ (Z, n, b, u) == true) {
			
			return -2;
			
		}
		
		if (q == Parameter.Q_I_P) {
			
			Pack.decodePublicKeyIP (newPublicKey, seed, 0, publicKey);
			
		}
		
		if (q == Parameter.Q_III_P) {
			
			Pack.decodePublicKeyIIIP (newPublicKey, seed, 0, publicKey);
			
		}
		
		/* Generate A Polynomial */
		Polynomial.polynomialUniform (A, seed, 0, n, k, q, qInverse, qLogarithm, generatorA, inverseNumberTheoreticTransform);
		
		encodeC (positionList, signList, C, 0, n, h);
		
		Polynomial.polynomialNumberTheoreticTransform (numberTheoreticTransformZ, Z, n);
		
		/* W_i = A_i * Z_i - TC_i for All i */
		for (int i = 0; i < k; i++) {
			
			Polynomial.polynomialMultiplication (W, n * i, A, n * i, numberTheoreticTransformZ, 0, n, q, qInverse);	
			
			Polynomial.sparsePolynomialMultiplication32 (
					TC, n * i, newPublicKey, n * i, positionList, signList, n, h, q, barrettMultiplication, barrettDivision
			);
			
			Polynomial.polynomialSubtraction (W, n * i, W, n * i, TC, n * i, n, q, barrettMultiplication, barrettDivision);
		
		}
		
		if (q == Parameter.Q_I_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (
				hashMessage, 0, Parameter.MESSAGE, signature, signatureSize, signatureLength - signatureSize
			);
			
		}
		
		if (q == Parameter.Q_III_P) {
			
			FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (
				hashMessage, 0, Parameter.MESSAGE, signature, signatureSize, signatureLength - signatureSize
			);
			
		}
		
		/* Obtain the Hash Symbol */
		hashFunction (cSignature, 0, W, hashMessage, 0, n, k, d, q);
		
		/* Check if Same with One from Signature */
		if (Common.memoryEqual (C, 0, cSignature, 0, Parameter.HASH) == false) {
			
			return -3;
			
		}
		
		messageLength[0] = signatureLength - signatureSize;
		
		System.arraycopy (signature, signatureOffset + signatureSize, message, messageOffset, messageLength[0]);
		
		return 0;

	}
	
	/*****************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for
	 * 				A Given Signature Package for Provably-Secure qTESLA Security Category-1
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 *****************************************************************************************************/
	public static int verifyingIP (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey
			
	) {
		
		return verifying (
				
				message, messageOffset, messageLength,
				signature, signatureOffset, signatureLength,
				publicKey,
				Parameter.N_I_P, Parameter.K_I_P, Parameter.H_I_P,
				Parameter.Q_I_P, Parameter.Q_INVERSE_I_P, Parameter.Q_LOGARITHM_I_P,
				Parameter.B_I_P, Parameter.D_I_P, Parameter.U_I_P, SIGNATURE_I_P,
				Parameter.GENERATOR_A_I_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_I_P,
				Parameter.BARRETT_MULTIPLICATION_I_P, Parameter.BARRETT_DIVISION_I_P,
				PolynomialProvablySecure.ZETA_I_P
				
		);
		
	}
	
	/*****************************************************************************************************
	 * Description:	Extracts the Original Message and Checks Whether the Generated Signature is Valid for
	 * 				A Given Signature Package for Provably-Secure qTESLA Security Category-3
	 * 
	 * @param 		signature							Given Signature Package
	 * @param		signatureOffset						Starting Point of the Given Signature Package
	 * @param		signatureLength						Length of the Given Signature Package
	 * @param		message								Original (Signed) Message
	 * @param		messageOffset						Starting Point of the Original (Signed) Message
	 * @param		messageLength						Length of the Original (Signed) Message
	 * @param		publicKey							Public Key
	 * 
	 * @return		0									Valid Signature
	 * 				< 0									Invalid Signature
	 *****************************************************************************************************/
	public static int verifyingIIIP (
			
			byte[] message, int messageOffset, int[] messageLength,
			final byte[] signature, int signatureOffset, int signatureLength,
			final byte[] publicKey
			
	) {
		
		return verifying (
				
				message, messageOffset, messageLength,
				signature, signatureOffset, signatureLength,
				publicKey,
				Parameter.N_III_P, Parameter.K_III_P, Parameter.H_III_P,
				Parameter.Q_III_P, Parameter.Q_INVERSE_III_P, Parameter.Q_LOGARITHM_III_P,
				Parameter.B_III_P, Parameter.D_III_P, Parameter.U_III_P, SIGNATURE_III_P,
				Parameter.GENERATOR_A_III_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_P,
				Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P,
				PolynomialProvablySecure.ZETA_III_P
				
		);
		
	}
	
}