package qTESLA;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class Test {
	
	static SecureRandom secureRandom = new SecureRandom();
	static short shortNumber = (short) 0xCCDD;
	static int integerNumber = 0xCCDDEEFF;
	static long longNumber = 0xCCDDEEFFAABB0011L;
	
	static byte[] byteArray = {
			
			(byte) 0xAB, (byte) 0xBC, (byte) 0xCD, (byte) 0xDE,
			(byte) 0xEF, (byte) 0xF0, (byte) 0x01, (byte) 0x12,
			(byte) 0x23, (byte) 0x34, (byte) 0x45, (byte) 0x56,
			(byte) 0x67, (byte) 0x78, (byte) 0x89, (byte) 0x9A
	
	};
	
	static byte[] seed = {
			
			(byte) 0x12, (byte) 0x23, (byte) 0x34, (byte) 0x45, (byte) 0x56, (byte) 0x67, (byte) 0x78, (byte) 0x89,
			(byte) 0x9A, (byte) 0xAB, (byte) 0xBC, (byte) 0xCD, (byte) 0xDE, (byte) 0xEF, (byte) 0xF1, (byte) 0x13,
			(byte) 0x24, (byte) 0x35, (byte) 0x46, (byte) 0x57, (byte) 0x68, (byte) 0x79, (byte) 0x8A, (byte) 0x9B,
			(byte) 0xAC, (byte) 0xBD, (byte) 0xCE, (byte) 0xDF, (byte) 0xE1, (byte) 0xF2, (byte) 0x14, (byte) 0x25
			
	};
	
	public static void main (String[] args) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		// testMemoryCopy ();
		// testMemoryEquivalence ();
		// testLoadShortNumber ();
		// testLoadIntegerNumber ();
		// testLoadLongNumber ();
		// testStoreShortNumber ();
		// testStoreIntegerNumber ();
		// testStoreLongNumber ();
		
		// testFederalInformationProcessingStandard202 ();
		
		// testModulus7 ();
		// testBernoulli ();
		// testSampleYIIIP ();
		// testPolynomialGaussSamplerI();
		// testPolynomialGaussSamplerIIIP();
		// testEncodeC ();
		
		// testMontgomery ();
		// testBarrettReductionIIISize ();
		// testBarrettReductionIIIP ();
		// testNumberTheoreticTransformIIISize ();
		// testNumberTheoreticTransformIIIP ();
		// testInverseNumberTheoreticTransformI ();
		// testInverseNumberTheoreticTransformIIISize ();
		// testInverseNumberTheoreticTransformIP ();
		// testInverseNumberTheoreticTransformIIIP ();
		// testComponentWisePolynomialMultiplicationIIIP ();
		testPolynomialMultiplicationIIISize ();
		// testPolynomialMultiplicationIIIP ();
		// testPolynomialAdditionIIIP ();
		// testPolynomialSubtractionIIISize ();
		// testPolynomialSubtractionIIIP ();
		// testPolynomialUniformIIIP ();
		
		// testRandomByte ();
		
		// testAbsoluteValue ();
		// testTestRejectionIIIP ();
		// testTestZIIIP ();
		// testTestVIIIP ();
		// testCheckErrorPolynomialIIIP ();
		// testCheckSecretPolynomialIIIP ();
		// testEncodePublicKeyIIISize ();
		// testEncodePublicKeyIIISpeed ();
		// testEncodePublicKeyIP ();
		// testEncodePublicKeyIIIP ();
		// testDecodePublicKeyIIISize ();
		// testDecodePublicKeyIIISpeed ();
		// testDecodePublicKeyIP ();
		// testDecodePublicKeyIIIP ();
		// testEncodeSignatureIIISize ();
		// testEncodeSignatureIIISpeed ();
		// testEncodeSignatureIIIP ();
		// testDecodeSignatureIIISize ();
		// testDecodeSignatureIIISpeed ();
		// testDecodeSignatureIIIP ();
		// testSparsePolynomialMultiplication16 ();
		// testSparsePolynomialMultiplication8 ();
		// testSparsePolynomialMultiplication32 ();
		// testHashFunctionIIISize ();
		// testHashFunctionIIIP ();
		// testGenerateKeyPairSigningVerifyingIIISize ();
		// testGenerateKeyPairSigningVerifyingIIIP ();
		
	}
	
	/* Test for Memory Equivalence in Common Function */
	
	public static void testMemoryEquivalence () {
		
		System.out.println ("Test for Memory Equivalence in Common Function\n");
		
		byte[] newByteArray = new byte[8];
		
		System.arraycopy (byteArray, 2, newByteArray, 0, 8);
		
		System.out.printf ("%B\n\n", CommonFunction.memoryEqual (byteArray, 2, newByteArray, 0, 8));
		
		Arrays.fill (newByteArray, (byte) 0xAA);
		
		System.out.printf ("%B\n\n", CommonFunction.memoryEqual (byteArray, 2, newByteArray, 0, 8));
		
	}
	
	/* Test for Loading Short Number in Common Function */
	
	public static void testLoadShortNumber () {
		
		System.out.println ("Test for Loading Short Number in Common Function\n");
		
		System.out.printf ("%X\n\n", CommonFunction.load16 (byteArray, 15));
		
	}
	
	/* Test for Loading Integer Number in Common Function */
	
	public static void testLoadIntegerNumber () {
		
		System.out.println ("Test for Loading Integer Number in Common Function\n");
		
		System.out.printf ("%X\n\n", CommonFunction.load32 (byteArray, 13));
		
	}
	
	/* Test for Loading Long Number in Common Function */
	
	public static void testLoadLongNumber () {
		
		System.out.println ("Test for Loading Long Number in Common Function\n");
		
		System.out.printf ("%X\n\n", CommonFunction.load64 (byteArray, 9));
		
	}
	
	/* Test for Storing Short Number in Common Function */
	
	public static void testStoreShortNumber () {
		
		System.out.println ("Test for Storing Short Number in Common Function\n");
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		CommonFunction.store16 (newByteArray, 4, shortNumber);
		
		for (short i = 0; i < Short.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Integer Number in Common Function */
	
	public static void testStoreIntegerNumber () {
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		System.out.println ("Test for Storing Integer Number in Common Function\n");
		
		CommonFunction.store32 (newByteArray, 4, integerNumber);
		
		for (short i = 0; i < Integer.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Long Number in Common Function */
	
	public static void testStoreLongNumber () {
		
		System.out.println ("Test for Storing Long Number in Common Function\n");
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		CommonFunction.store64 (newByteArray, 0, longNumber);
		
		for (short i = 0; i < Long.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for KECCAK F1600 State Permutation in Federal Information Processing Standard 202 */
	
	public static void testFederalInformationProcessingStandard202 () {
		
		System.out.println ("Test for Federal Information Processing Standard 202\n");
		
		long[] longArray = new long[25];
		
		System.arraycopy (PolynomialProvablySecure.ZETA_III_P, 175, longArray, 0, 25);
		
		System.out.println ("Before State Permutation\n");
		
		for (int i = 0; i < 25; i++) {
			
			if (i % 5 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 5 + 1));
				
			}
			
			System.out.printf ("%016X\t", longArray[i]);
			
			if (i % 5 == 4) {
				
				System.out.println();
				
			}
			
		}
		
//		System.out.println ("\nAfter State Permutation\n");
//		
//		FederalInformationProcessingStandard202.keccakF1600StatePermution (longArray);
//		
//		for (int i = 0; i < 25; i++) {
//			
//			if (i % 5 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 5 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", longArray[i]);
//			
//			if (i % 5 == 4) {
//				
//				System.out.println();
//				
//			}
//			
//		}
		
		byte[] input = new byte[128];
		
		for (int i = 0; i < 128; i++) {
			
			input[i] = (byte) i;
			
		}
		
		System.out.println ("\nAfter KECCAK Absorb 128\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128Absorb (longArray, input, 60, 60);
		
		for (int i = 0; i < 25; i++) {
			
			if (i % 5 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 5 + 1));
				
			}
			
			System.out.printf ("%016X\t", longArray[i]);
			
			if (i % 5 == 4) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter KECCAK Absorb 256\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256Absorb (longArray, input, 60, 60);
		
		for (int i = 0; i < 25; i++) {
			
			if (i % 5 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 5 + 1));
				
			}
			
			System.out.printf ("%016X\t", longArray[i]);
			
			if (i % 5 == 4) {
				
				System.out.println();
				
			}
			
		}
		
		byte[] output = new byte[32768];
		
		for (int i = 0; i < 32768; i++) {
			
			output[i] = (byte) (i % 256);
			
		}
		
		System.out.println ("\nAfter KECCAK Squeeze Block 128\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128SqueezeBlock (output, 0, 64, longArray);
		
		for (int i = 0; i < 512; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter KECCAK Squeeze Block 256\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256SqueezeBlock (output, 0, 64, longArray);
		
		for (int i = 0; i < 512; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Secure Hash Algorithm KECCAK 128\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK128 (output, 0, 8192, input, 60, 60);
		
		for (int i = 0; i < 8192; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Secure Hash Algorithm KECCAK 256\n");
		
		FederalInformationProcessingStandard202.secureHashAlgorithmKECCAK256 (output, 0, 8192, input, 60, 60);
		
		for (int i = 0; i < 8192; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Customizable Secure Hash Algorithm KECCAK 128 Simple Absorb\n");
		
		FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128SimpleAbsorb (longArray, (short) 777, input, 60, 60);
		
		for (int i = 0; i < 25; i++) {
			
			if (i % 5 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 5 + 1));
				
			}
			
			System.out.printf ("%016X\t", longArray[i]);
			
			if (i % 5 == 4) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Customizable Secure Hash Algorithm KECCAK 256 Simple Absorb\n");
		
		FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256SimpleAbsorb (longArray, (short) 777, input, 60, 60);
		
		for (int i = 0; i < 25; i++) {
			
			if (i % 5 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 5 + 1));
				
			}
			
			System.out.printf ("%016X\t", longArray[i]);
			
			if (i % 5 == 4) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Customizable Secure Hash Algorithm KECCAK 128 Simple\n");
		
		FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (output, 0, 8192, (short) 999, input, 60, 60);
		
		for (int i = 0; i < 8192; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
		System.out.println ("\nAfter Customizable Secure Hash Algorithm KECCAK 256 Simple\n");
		
		FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (output, 0, 8192, (short) 999, input, 60, 60);
		
		for (int i = 0; i < 8192; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%02X", output[i]);
			
			if (i % 16 == 15) {
				
				System.out.println();
				
			}
			
		}
		
	}
	
	/* Test for Modulus 7 in Sample */
	
//	public static void testModulus7 () {
//		
//		System.out.println ("Test for Modulus 7 in Sample\n");
//		
//		System.out.printf ("%X\n\n", Sample.modulus7 (0xABCDEFEDCBABCDEFL));
//		
//	}
	
	/* Test for Bernoulli in Sample */
	
//	public static void testBernoulli () {
//		
//		System.out.println ("Test for Bernoulli in Sample\n");
//		
//		System.out.printf ("%X\n\n", Sample.bernoulli (0x123456789ABCDEF0L, 0x56789ABCDEF01234L, Sample.EXPONENTIAL_DISTRIBUTION_P));
//		
//	}
	
	/* Test for Sampling Y in Sample for Provably-Secure qTESLA Security Category-3 */
	
	public static void testSampleYIIIP () {
		
		long[]	Y			= new long[Parameter.N_III_P];
		
		System.out.println ("Test for Sampling Y in Sample for Provably-Secure qTESLA Security Category-3\n");
		
		Sample.sampleY (Y, seed, 0, 16, Parameter.N_III_P, Parameter.Q_III_P, Parameter.B_III_P, Parameter.B_BIT_III_P);
		
		for (int i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
			
			}
			
			System.out.printf ("%016X\t", Y[i]);
			
			if (i % 4 == 3) {
			
				System.out.println ();
			
			}
			
		}
		
		System.out.printf ("\n");
		
	}
	
	/* Test for Polynomial Gauss Sampler in Sample for Heuristic qTESLA Security Category-1 */
	
	public static void testPolynomialGaussSamplerI () {
		
		System.out.println ("Test for Polynomial Gauss Sampler in Sample for Heuristic qTESLA Security Category-1\n");
		
		long[]	data		= new long[Parameter.N_I];
		
		Sample.polynomialGaussSamplerI (data, 0, seed, 0, 128, Parameter.N_I, Parameter.XI_I, Sample.EXPONENTIAL_DISTRIBUTION_I);
		
		for (short i = 0; i < Parameter.N_I; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\n", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X\t", data[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.printf ("\n");
		
	}
	
	/* Test for Polynomial Gauss Sampler in Sample for Provably-Secure qTESLA Security Category-3 */
	
	public static void testPolynomialGaussSamplerIIIP () {
		
		System.out.println ("Test for Polynomial Gauss Sampler in Sample for Provably-Secure qTESLA Security Category-3\n");
		
		long[]	data		= new long[Parameter.N_III_P];
		
		Sample.polynomialGaussSamplerIII (data, 0, seed, 0, 256, Parameter.N_III_P, Parameter.XI_III_P, Sample.EXPONENTIAL_DISTRIBUTION_P);
		
		for (int i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\n", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X\t", data[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding C in Sample for Provably-Secure qTESLA Security Category-3 */
	
	public static void testEncodeC () {
		
		System.out.println ("Test for Encoding C in Sample\n");
		
		int[]	positionList	= new int[Parameter.W_III_P];
		short[]	signList		= new short[Parameter.W_III_P];
		
		Sample.encodeC (positionList, signList, seed, 0, Parameter.N_III_P, Parameter.W_III_P);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < Parameter.W_III_P; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 8 + 1));
			
			}
			
			System.out.printf ("%4d\t", positionList[i]);
		
			if (i % 8 == 7) {
			
				System.out.println();
			
			}
		
		}
	
		System.out.println ("\nSignature List\n");
		
		for (int i = 0; i < Parameter.W_III_P; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %d\n", (i / 8 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d\t", signList[i]);
			
			if (i % 8 == 7) {
			
				System.out.println();
			
			}
		
		}
		
	}
	
	/* Test for Montgomery Reduction in Polynomial */
	
//	public static void testMontgomery () {
//		
//		System.out.println ("Test for Montgomery Reduction in Polynomial\n");
//		
//		System.out.printf ("%X\n\n", Polynomial.montgomery (longNumber, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P));
//		
//	}
	
	/* Test for Barrett Reduction in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testBarrettReductionIIISize () {
		
		System.out.println ("Test for Barrett Reduction in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		System.out.printf ("%X\n\n", Polynomial.barrett (longNumber, Parameter.Q_III_SIZE, Parameter.BARRETT_MULTIPLICATION_III_SIZE, Parameter.BARRETT_DIVISION_III_SIZE));
		
	}
	
	/* Test for Barrett Reduction in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
	public static void testBarrettReductionIIIP () {
		
		System.out.println ("Test for Barrett Reduction in Polynomial for Provably-Secure qTESLA Security Category-3\n");
		
		System.out.printf ("%X\n\n", Polynomial.barrettP (longNumber, Parameter.Q_III_P, Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P));
		
	}
	
	/* Test for Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testNumberTheoreticTransformIIISize() {
//		
//		System.out.println ("Test for Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		long[] longArray = new long[Parameter.N_III_SIZE];
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			longArray[i] = PolynomialHeuristic.ZETA_III_SIZE[i];
//			
//		}
//		
//		Polynomial.numberTheoreticTransform (longArray, PolynomialHeuristic.ZETA_INVERSE_III_SIZE, Parameter.N_III_SIZE, Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE);
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//				
//			}
//			
//			System.out.printf ("%08X\t", longArray[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ();
//		
//	}
	
	/* Test for Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testNumberTheoreticTransformIIIP () {
//		
//		System.out.println ("Test for Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] longArray = new long[Parameter.N_III_P];
//	
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//		
//			longArray[i] = PolynomialProvablySecure.ZETA_III_P[i];
//		
//		}
//	
//		Polynomial.numberTheoreticTransform (longArray, PolynomialProvablySecure.ZETA_INVERSE_III_P);
//	
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//		
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//			
//			}
//			
//			System.out.printf ("%016X\t", longArray[i]);
//		
//			if (i % 4 == 3) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ();
//		
//	}
	
	/* Test for Inverse Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-1 */
	
//	public static void testInverseNumberTheoreticTransformI () {
//		
//		System.out.println ("Test for Inverse Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-1\n");
//		
//		long[] longArray = new long[Parameter.N_I];
//		
//		for (int i = 0; i < Parameter.N_I; i++) {
//			
//			longArray[i] = PolynomialHeuristic.ZETA_I[i];
//			
//		}
//		
//		Polynomial.inverseNumberTheoreticTransformI (longArray, 0, PolynomialHeuristic.ZETA_INVERSE_I, 0);
//		
//		for (int i = 0; i < Parameter.N_I; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %2d\t", (i / 8 + 1));
//				
//			}
//			
//			System.out.printf ("%08X\t", longArray[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ();
//		
//	}
	
	/* Test for Inverse Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testInverseNumberTheoreticTransformIIISize () {
//		
//		System.out.println ("Test for Inverse Number Theoretic Transform in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		long[] longArray = new long[Parameter.N_III_SIZE];
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//		
//			longArray[i] = PolynomialHeuristic.ZETA_III_SIZE[i];
//		
//		}
//	
//		Polynomial.inverseNumberTheoreticTransform (
//				
//				longArray, 0, PolynomialHeuristic.ZETA_INVERSE_III_SIZE, 0,
//				Parameter.N_III_SIZE, Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE,
//				Parameter.BARRETT_MULTIPLICATION_III_SIZE, Parameter.BARRETT_DIVISION_III_SIZE
//		
//		);
//	
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//			
//			}
//		
//			System.out.printf ("%08X\t", longArray[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ("");
//		
//	}
	
	/* Test for Inverse Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-1 */
	
//	public static void testInverseNumberTheoreticTransformIP () {
//		
//		System.out.println ("Test for Inverse Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-1\n");
//		
//		long[] longArray = new long[Parameter.N_I_P];
//		
//		for (int i = 0; i < Parameter.N_I_P; i++) {
//		
//			longArray[i] = PolynomialProvablySecure.ZETA_I_P[i];
//		
//		}
//	
//		Polynomial.inverseNumberTheoreticTransform (
//				
//				longArray, 0, PolynomialProvablySecure.ZETA_INVERSE_I_P, 0,
//				Parameter.N_I_P, Parameter.Q_I_P, Parameter.Q_INVERSE_I_P,
//				Parameter.BARRETT_MULTIPLICATION_I_P, Parameter.BARRETT_DIVISION_I_P
//		
//		);
//	
//		for (int i = 0; i < Parameter.N_I_P; i++) {
//		
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//			
//			}
//			
//			System.out.printf ("%08X\t", longArray[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ();
//		
//	}
	
	/* Test for Inverse Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testInverseNumberTheoreticTransformIIIP () {
//		
//		System.out.println ("Test for Inverse Number Theoretic Transform in Polynomial for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] longArray = new long[Parameter.N_III_P];
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			longArray[i] = PolynomialProvablySecure.ZETA_III_P[i];
//		
//		}
//		
//		Polynomial.inverseNumberTheoreticTransformIIIP (longArray, 0, PolynomialProvablySecure.ZETA_INVERSE_III_P, 0);
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//			
//			}
//			
//			System.out.printf ("%08X\t", longArray[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ();
//		
//	}
	
	/* Test for Component Wise Polynomial Multiplication in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testComponentWisePolynomialMultiplicationIIIP () {
//		
//		System.out.println ("Test for Component Wise Polynomial Multiplication in Polynomial for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] longArray = new long[Parameter.N_III_P];
//		
//		Polynomial.componentWisePolynomialMultiplication (
//				
//				longArray, 0, PolynomialProvablySecure.ZETA_III_P, 0, PolynomialProvablySecure.ZETA_INVERSE_III_P, 0,
//				Parameter.N_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P
//				
//		);
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//				
//			}
//			
//			System.out.printf ("%08X\t", longArray[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ();
//		
//	}
	
	/* Test for Polynomial Multiplication in Polynomial for Polynomial Multiplication for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testPolynomialMultiplicationIIISize () {
		
		System.out.println ("Test for Polynomial Multiplication in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		long[] longArray = new long[Parameter.N_III_SIZE];
		
		Polynomial.polynomialMultiplication (
				
				longArray, 0, PolynomialHeuristic.ZETA_III_SIZE, 0, PolynomialHeuristic.ZETA_INVERSE_III_SIZE, 0,
				Parameter.N_III_SIZE, Parameter.Q_III_SIZE, Parameter.Q_INVERSE_III_SIZE, PolynomialHeuristic.ZETA_III_SIZE
		
		);
		
		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X\t", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Multiplication in Polynomial for Polynomial Multiplication for Provably-Secure qTESLA Security Category-3 */
	
	public static void testPolynomialMultiplicationIIIP () {
		
		System.out.println ("Test for Polynomial Multiplication in Polynomial for Polynomial Multiplication for Provably-Secure qTESLA Security Category-3\n");
		
		long[] longArray = new long[Parameter.N_III_P];
		
		Polynomial.polynomialMultiplication (
				
				longArray, 0, PolynomialProvablySecure.ZETA_III_P, 0, PolynomialProvablySecure.ZETA_INVERSE_III_P, 0,
				Parameter.N_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P
				
		);
		
		for (int i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X\t", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Addition in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
	public static void testPolynomialAdditionIIIP () {
		
		System.out.println ("Test for Polynomial Addition in Polynomial for Provably-Secure qTESLA Security Category-3\n");
		
		long[] longArray = new long[Parameter.N_III_P];
		
		Polynomial.polynomialAddition (longArray, 0, PolynomialProvablySecure.ZETA_III_P, 0, PolynomialProvablySecure.ZETA_INVERSE_III_P, 0, Parameter.N_III_P);
		
		for (short i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X\t", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testPolynomialSubtractionIIISize () {
		
		System.out.println ("Test for Polynomial Subtraction in Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		long[] longArray = new long[Parameter.N_III_SIZE];
		
		Polynomial.polynomialSubtraction (
				
				longArray, 0, PolynomialHeuristic.ZETA_III_SIZE, 0, PolynomialHeuristic.ZETA_INVERSE_III_SIZE, 0,
				Parameter.N_III_SIZE, Parameter.Q_III_SIZE,
				Parameter.BARRETT_MULTIPLICATION_III_SIZE, Parameter.BARRETT_DIVISION_III_SIZE
				
		);
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
	public static void testPolynomialSubtractionIIIP () {
		
		System.out.println ("Test for Polynomial Subtraction in Polynomial for Provably-Secure qTESLA Security Category-3\n");
		
		long[] longArray = new long[Parameter.N_III_P];
		
		Polynomial.polynomialSubtractionP (
				
				longArray, 0, PolynomialProvablySecure.ZETA_III_P, 0, PolynomialProvablySecure.ZETA_INVERSE_III_P, 0,
				Parameter.N_III_P, Parameter.Q_III_P,
				Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P
		
		);
		
		for (int i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X\t", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Uniform in Polynomial for Provably-Secure qTESLA Security Category-3 */
	
	public static void testPolynomialUniformIIIP () {
		
		System.out.println ("Test for Polynomial Uniform in Polynomial for Provably-Secure qTESLA Security Category-3\n");
		
		long[]	A			= new long[Parameter.N_III_P * Parameter.K_III_P];
		
		Polynomial.polynomialUniform (
				A,
				seed, 0,
				Parameter.N_III_P, Parameter.K_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P, Parameter.Q_LOGARITHM_III_P,
				Parameter.GENERATOR_A_III_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_P
		);
		
		for (short k = 0; k < Parameter.K_III_P; k++) {
			
			System.out.printf ("SAMPLE %d\n\n", (k + 1));
			
			for (short i = 0; i < Parameter.N_III_P; i++) {
				
				System.out.printf ("%08X\t", A[i]);
				
				if (i % 8 == 7) {
					
					System.out.printf ("LINE %3d\n", (i / 8 + 1));
					
				}
				
			}
			
			System.out.printf ("\n");
			
		}
		
	}
	
	/* Test for Absolute Value in QTESLA */
	
//	public static void testAbsoluteValue () {
//		
//		System.out.println ("Test for Absolute Value in QTESLA\n");
//		
//		System.out.printf ("Absolute Value of %d is %d and %d\n\n", longNumber, QTESLA.absolute(longNumber), Math.abs(longNumber));
//		
//	}
	
	/* Test for Testing Rejection in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testTestRejectionIIIP () {
//		
//		System.out.println ("Test for Testing Rejection in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		System.out.printf ("%B\n\n", QTESLA.testRejection (PolynomialProvablySecure.ZETA_III_P, Parameter.N_III_P, Parameter.B_III_P, Parameter.U_III_P));
//		
//	}
	
	/* Test for Testing Z in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testTestZIIIP () {
//		
//		System.out.println ("Test for Testing Z in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		System.out.printf ("%B\n\n", QTESLA.testZ (PolynomialProvablySecure.ZETA_III_P, Parameter.N_III_P, Parameter.B_III_P, Parameter.U_III_P));
//		
//	}
	
	/* Test for Testing V in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testTestVIIIP () {
//		
//		System.out.println ("Test for Testing V in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		System.out.printf ("%B\n\n", QTESLA.testV (PolynomialProvablySecure.ZETA_III_P, Parameter.N_III_P, Parameter.D_III_P, Parameter.Q_III_P, Parameter.REJECTION_III_P));
//		
//	}
	
	/* Test for Checking Error Polynomial in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testCheckErrorPolynomialIIIP () {
//		
//		System.out.println ("Test for Checking Error Polynomial in QTESLA\n");
//		
//		long[] errorPolynomial		= new long[Parameter.N_III_P];
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		
//		System.out.println ("Test for Secure Hash Algorithm KECCAK 256 in Federal Information Processing Standard 202\n");
//		
//		fips.secureHashAlgorithmKECCAK256 (
//				randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE
//		);
//		
//		for (short i = 0; i < randomnessExtended.length; i++) {
//			
//			System.out.printf ("%02X\t", randomnessExtended[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//		sample.polynomialGaussSamplerIII (
//				errorPolynomial, randomnessExtended, (short) 0, 63, Parameter.N_III_P, Parameter.XI_III_P, Sample.EXPONENTIAL_DISTRIBUTION_P
//		);
//		
//		System.out.printf ("%B\n\n", QTESLA.checkPolynomial (errorPolynomial, (short) 0, Parameter.KEY_GENERATOR_BOUND_E_III_P, Parameter.N_III_P, Parameter.W_III_P));
//		
//	}
	
	/* Test for Checking Secret Polynomial in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testCheckSecretPolynomialIIIP () {
//		
//		System.out.println ("Test for Checking Secret Polynomial in QTESLA\n");
//		
//		long[] secretPolynomial		= new long[Parameter.N_III_P];
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		
//		System.out.println ("Test for Secure Hash Algorithm KECCAK 256 in Federal Information Processing Standard 202\n");
//		
//		fips.secureHashAlgorithmKECCAK256 (
//				randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE
//		);
//		
//		for (short i = 0; i < randomnessExtended.length; i++) {
//			
//			System.out.printf ("%02X\t", randomnessExtended[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//		sample.polynomialGaussSamplerIII (
//				secretPolynomial, randomnessExtended, (short) 0, 63, Parameter.N_III_P, Parameter.XI_III_P, Sample.EXPONENTIAL_DISTRIBUTION_P
//		);
//		
//		System.out.printf ("%B\n\n", QTESLA.checkPolynomial (secretPolynomial, (short) 0, Parameter.KEY_GENERATOR_BOUND_S_III_P, Parameter.N_III_P, Parameter.W_III_P));
//		
//	}
	
	/* Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testEncodePublicKeyIIISize () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		byte[] publicKey			= new byte[Parameter.N_III_SIZE * Parameter.Q_LOGARITHM_III_SIZE / Integer.SIZE];
//		
//		fips.secureHashAlgorithmKECCAK256 (randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE);
//		
//		QTESLA.encodePublicKey (publicKey, PolynomialHeuristic.ZETA_III_SIZE, randomnessExtended, Polynomial.SEED_BYTE * 2, Parameter.N_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE);
//		
//		for (short i = 0; i < Parameter.N_III_SIZE * Parameter.Q_LOGARITHM_III_SIZE / Integer.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n"); 
//		
//	}
	
	/* Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testEncodePublicKeyIIISpeed () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		byte[] publicKey			= new byte[Parameter.N_III_SPEED * Parameter.Q_LOGARITHM_III_SPEED / Integer.SIZE];
//		
//		fips.secureHashAlgorithmKECCAK256 (randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE);
//		
//		QTESLA.encodePublicKeyIIISpeed (publicKey, PolynomialHeuristic.ZETA_III_SPEED, randomnessExtended, Polynomial.SEED_BYTE * 2);
//		
//		for (short i = 0; i < Parameter.N_III_SPEED * Parameter.Q_LOGARITHM_III_SPEED / Integer.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n"); 
//		
//	}
	
	/* Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1 */
	
//	public static void testEncodePublicKeyIP () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1\n");
//		
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		long[] T					= new long[Parameter.N_I_P * Parameter.K_I_P];
//		byte[] publicKey			= new byte[Parameter.N_I_P * Parameter.K_I_P * Parameter.Q_LOGARITHM_I_P / Integer.SIZE];
//		
//		for (short k = 0; k < Parameter.K_I_P; k++) {
//		
//			function.memoryCopy(T, Parameter.N_I_P * k, PolynomialProvablySecure.ZETA_I_P, 0, Parameter.N_I_P);
//		
//		}
//		
//		fips.secureHashAlgorithmKECCAK128 (randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE);
//		
//		QTESLA.encodePublicKeyIP (publicKey, T, randomnessExtended, Polynomial.SEED_BYTE * 2);
//		
//		for (short i = 0; i < Parameter.N_I_P * Parameter.K_I_P * Parameter.Q_LOGARITHM_I_P / Integer.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n"); 
//		
//	}
	
	/* Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testEncodePublicKeyIIIP () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		byte[] randomnessExtended	= new byte[Polynomial.SEED_BYTE * 4];
//		long[] T					= new long[Parameter.N_III_P * Parameter.K_III_P];
//		byte[] publicKey			= new byte[Parameter.N_III_P * Parameter.K_III_P * Parameter.Q_LOGARITHM_III_P / Integer.SIZE];
//		
//		for (short k = 0; k < Parameter.K_III_P; k++) {
//		
//			function.memoryCopy (T, Parameter.N_III_P * k, PolynomialProvablySecure.ZETA_III_P, 0, Parameter.N_III_P);
//		
//		}
//		
//		fips.secureHashAlgorithmKECCAK256 (randomnessExtended, (short) 0, (short) (Polynomial.SEED_BYTE * 4), seed, 0, Polynomial.RANDOM_BYTE);
//		
//		QTESLA.encodePublicKeyIP (publicKey, T, randomnessExtended, Polynomial.SEED_BYTE * 2);
//		
//		for (short i = 0; i < Parameter.N_III_P * Parameter.K_III_P * Parameter.Q_LOGARITHM_III_P / Integer.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n"); 
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testDecodePublicKeyIIISize () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] publicKeyInput	= new byte[Parameter.Q_LOGARITHM_III_SIZE * Integer.SIZE * 4];
//		int[] publicKey			= new int[Parameter.N_III_SIZE];
//		
//		for (short j = 0; j < 4; j++) {
//		
//			for (short i = 0; i < Parameter.Q_LOGARITHM_III_SIZE * Integer.SIZE; i++) {
//			
//				publicKeyInput[i + Parameter.Q_LOGARITHM_III_SIZE * Integer.SIZE * j] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i] & 0xFFL);
//			
//			}
//		
//		}
//		
//		QTESLA.decodePublicKey (publicKey, seed, 0, publicKeyInput, Parameter.N_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE);
//		
//		for (short i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			System.out.printf ("%06X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testDecodePublicKeyIIISpeed () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		byte[] publicKeyInput	= new byte[Parameter.Q_LOGARITHM_III_SPEED * Integer.SIZE * 4];
//		int[] publicKey			= new int[Parameter.N_III_SPEED];
//		
//		for (short j = 0; j < 4; j++) {
//		
//			for (short i = 0; i < Parameter.Q_LOGARITHM_III_SPEED * Integer.SIZE; i++) {
//			
//				publicKeyInput[i + Parameter.Q_LOGARITHM_III_SPEED * Integer.SIZE * j] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i] & 0xFFL);
//			
//			}
//		
//		}
//		
//		QTESLA.decodePublicKeyIIISpeed (publicKey, seed, 0, publicKeyInput);
//		
//		for (short i = 0; i < Parameter.N_III_SPEED; i++) {
//			
//			System.out.printf ("%06X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1 */
	
//	public static void testDecodePublicKeyIP () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1\n");
//		
//		byte[] publicKeyInput	= new byte[Parameter.Q_LOGARITHM_I_P * Integer.SIZE * Parameter.K_I_P * 4];
//		int[] publicKey			= new int[Parameter.N_I_P * Parameter.K_I_P];
//		
//		for (short j = 0; j < 4; j++) {
//		
//			for (short k = 0; k < Parameter.K_I_P; k++) {
//		
//				for (short i = 0; i < Parameter.Q_LOGARITHM_I_P * Integer.SIZE; i++) {
//			
//					publicKeyInput[i + Parameter.Q_LOGARITHM_I_P * Integer.SIZE * k + Parameter.Q_LOGARITHM_I_P * Integer.SIZE * Parameter.K_I_P * j] = (byte) (PolynomialProvablySecure.ZETA_I_P[i] & 0xFFL);
//			
//				}
//		
//			}
//		
//		}
//		
//		QTESLA.decodePublicKeyIP (publicKey, seed, 0, publicKeyInput);
//		
//		for (short i = 0; i < Parameter.N_I_P * Parameter.K_I_P; i++) {
//			
//			System.out.printf ("%08X\t", publicKey[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.printf ("LINE %3d\n", (i / 8 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testDecodePublicKeyIIIP () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		byte[] publicKeyInput	= new byte[Parameter.Q_LOGARITHM_III_P * Integer.SIZE * Parameter.K_III_P * 8];
//		int[] publicKey			= new int[Parameter.N_III_P * Parameter.K_III_P];
//		
//		for (short j = 0; j < 8; j++) {
//		
//			for (short k = 0; k < Parameter.K_III_P; k++) {
//		
//				for (short i = 0; i < Parameter.Q_LOGARITHM_III_P * Integer.SIZE; i++) {
//			
//					publicKeyInput[i + Parameter.Q_LOGARITHM_III_P * Integer.SIZE * k + Parameter.Q_LOGARITHM_III_P * Integer.SIZE * Parameter.K_III_P * j] = (byte) (PolynomialProvablySecure.ZETA_III_P[i] & 0xFFL);
//			
//				}
//		
//			}
//		
//		}
//		
//		QTESLA.decodePublicKeyIIIP (publicKey, seed, 0, publicKeyInput);
//		
//		for (short i = 0; i < Parameter.N_III_P * Parameter.K_III_P; i++) {
//			
//			System.out.printf ("%08X\t", publicKey[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.printf ("LINE %4d\n", (i / 8 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testEncodeSignatureIIISize () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SIZE];
//		byte[] signature	= new byte[Parameter.N_III_SIZE * Parameter.D_III_SIZE / Byte.SIZE + Polynomial.C_BYTE];
//		
//		function.memoryCopy (Z, 0, PolynomialHeuristic.ZETA_III_SIZE, 0, Parameter.N_III_SIZE);
//		
//		QTESLA.encodeSignature (signature, 0, seed, (short) 0, Z, Parameter.N_III_SIZE, Parameter.D_III_SIZE);
//		
//		for (short i = 0; i < Parameter.N_III_SIZE * Parameter.D_III_SIZE / Byte.SIZE + Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", signature[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testEncodeSignatureIIISpeed () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SPEED];
//		byte[] signature	= new byte[Parameter.N_III_SPEED * Parameter.D_III_SPEED / Byte.SIZE + Polynomial.C_BYTE];
//		
//		function.memoryCopy (Z, 0, PolynomialHeuristic.ZETA_III_SPEED, 0, Parameter.N_III_SPEED);
//		
//		QTESLA.encodeSignatureIIISpeedIP (signature, 0, seed, (short) 0, Z, Parameter.N_III_SPEED, Parameter.D_III_SPEED);
//		
//		for (short i = 0; i < Parameter.N_III_SPEED * Parameter.D_III_SPEED / Byte.SIZE + Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", signature[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Encoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testEncodeSignatureIIIP () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] Z			= new long[Parameter.N_III_P];
//		byte[] signature	= new byte[Parameter.N_III_P * Parameter.D_III_P / Byte.SIZE + Polynomial.C_BYTE];
//		
//		function.memoryCopy (Z, 0, PolynomialProvablySecure.ZETA_III_P, 0, Parameter.N_III_P);
//		
//		QTESLA.encodeSignature (signature, 0, seed, (short) 0, Z);
//		
//		for (short i = 0; i < Parameter.N_III_P * Parameter.D_III_P / Byte.SIZE + Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", signature[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testDecodeSignatureIIISize () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SIZE];
//		byte[] C			= new byte[Polynomial.C_BYTE];
//		byte[] signature	= new byte[Parameter.N_III_SIZE * Parameter.D_III_SIZE / Byte.SIZE + Polynomial.C_BYTE];
//		
//		for (short j = 0; j < Integer.SIZE / Byte.SIZE; j++) {
//			
//			for (short i = 0; i < Parameter.N_III_SIZE * Parameter.D_III_SIZE / Integer.SIZE; i++) {
//				
//				signature[i + Parameter.N_III_SIZE * Parameter.D_III_SIZE / Integer.SIZE * j] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i] & 0xFFL);
//				
//			}
//			
//		}
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			signature[i + Parameter.N_III_SIZE * Parameter.D_III_SIZE / Byte.SIZE] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i] & 0xFFL);
//		
//		}
//		
//		QTESLA.decodeSignature (C, Z, signature, 0, Parameter.N_III_SIZE, Parameter.D_III_SIZE);
//		
//		System.out.println ("Display C\n");
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", C[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.println ("\nDisplay Z\n");
//		
//		for (short i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			System.out.printf ("%06X\t", Z[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testDecodeSignatureIIISpeed () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SPEED];
//		byte[] C			= new byte[Polynomial.C_BYTE];
//		byte[] signature	= new byte[Parameter.N_III_SPEED * Parameter.D_III_SPEED / Byte.SIZE + Polynomial.C_BYTE];
//		
//		for (short j = 0; j < Integer.SIZE / Byte.SIZE; j++) {
//			
//			for (short i = 0; i < Parameter.N_III_SPEED * Parameter.D_III_SPEED / Integer.SIZE; i++) {
//				
//				signature[i + Parameter.N_III_SPEED * Parameter.D_III_SPEED / Integer.SIZE * j] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i] & 0xFFL);
//				
//			}
//			
//		}
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			signature[i + Parameter.N_III_SPEED * Parameter.D_III_SPEED / Byte.SIZE] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i] & 0xFFL);
//		
//		}
//		
//		QTESLA.decodeSignatureIIISpeedIP (C, Z, signature, 0, Parameter.N_III_SPEED, Parameter.D_III_SPEED);
//		
//		System.out.println ("Display C\n");
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", C[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.println ("\nDisplay Z\n");
//		
//		for (short i = 0; i < Parameter.N_III_SPEED; i++) {
//			
//			System.out.printf ("%06X\t", Z[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %2d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Decoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testDecodeSignatureIIIP () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] Z			= new long[Parameter.N_III_P];
//		byte[] C			= new byte[Polynomial.C_BYTE];
//		byte[] signature	= new byte[Parameter.N_III_P * Parameter.D_III_P / Byte.SIZE + Polynomial.C_BYTE];
//		
//		for (short j = 0; j < Integer.SIZE / Byte.SIZE; j++) {
//			
//			for (short i = 0; i < Parameter.N_III_P * Parameter.D_III_P / Integer.SIZE; i++) {
//				
//				signature[i + Parameter.N_III_P * Parameter.D_III_P / Integer.SIZE * j] = (byte) (PolynomialProvablySecure.ZETA_III_P[i] & 0xFFL);
//				
//			}
//			
//		}
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			signature[i + Parameter.N_III_P * Parameter.D_III_P / Byte.SIZE] = (byte) (PolynomialProvablySecure.ZETA_III_P[i] & 0xFFL);
//		
//		}
//		
//		QTESLA.decodeSignature (C, Z, signature, 0);
//		
//		System.out.println ("Display C\n");
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X\t", C[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.println ("\nDisplay Z\n");
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			System.out.printf ("%06X\t", Z[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Sparse Polynomial Multiplication of 16-Bit in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testSparsePolynomialMultiplication16 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 16-Bit in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		short[] positionList	= new short[Parameter.W_III_SIZE];
//		short[] signList		= new short[Parameter.W_III_SIZE];
//		byte[] secretKey		= new byte[Parameter.N_III_SIZE];
//		long[] product			= new long[Parameter.N_III_SIZE];
//		
//		sample.encodeC (positionList, signList, seed, (short) 0, Parameter.N_III_SIZE, Parameter.W_III_SIZE);
//		
//		System.out.println ("Position List\n");
//		
//		for (short i = 0; i < Parameter.W_III_SIZE; i++) {
//			
//			System.out.printf ("%4d\t", positionList[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSignature List\n");
//		
//		for (short i = 0; i < Parameter.W_III_SIZE; i++) {
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d\t", signList[i]);
//			
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (short i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			secretKey[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i] & 0xFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication16 (product, secretKey, (short) 0, positionList, signList, Parameter.N_III_SIZE, Parameter.W_III_SIZE);
//		
//		for (short i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			System.out.printf ("%016X\t", product[i]);
//			
//			if (i % 4 == 3) {
//				
//				System.out.printf ("LINE %3d\n", (i / 4 + 1));
//				
//			}
//		
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Sparse Polynomial Multiplication of 8-Bit in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testSparsePolynomialMultiplication8 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 8-Bit in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		short[] positionList	= new short[Parameter.W_III_P];
//		short[] signList		= new short[Parameter.W_III_P];
//		byte[] secretKey		= new byte[Parameter.N_III_P];
//		long[] product			= new long[Parameter.N_III_P];
//		
//		sample.encodeC (positionList, signList, seed, (short) 0, Parameter.N_III_P, Parameter.W_III_P);
//		
//		System.out.println ("Position List\n");
//		
//		for (short i = 0; i < Parameter.W_III_P; i++) {
//			
//			System.out.printf ("%4d\t", positionList[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSignature List\n");
//		
//		for (short i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d\t", signList[i]);
//			
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			secretKey[i] = (byte) (PolynomialProvablySecure.ZETA_III_P[i] & 0xFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication8 (product, secretKey, (short) 0, positionList, signList, Parameter.N_III_P, Parameter.W_III_P);
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			System.out.printf ("%016X\t", product[i]);
//			
//			if (i % 4 == 3) {
//				
//				System.out.printf ("LINE %3d\n", (i / 4 + 1));
//				
//			}
//		
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Sparse Polynomial Multiplication of 32-Bit in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testSparsePolynomialMultiplication32 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 32-Bit in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		short[] positionList	= new short[Parameter.W_III_P];
//		short[] signList		= new short[Parameter.W_III_P];
//		int[] publicKey			= new int[Parameter.N_III_P];
//		long[] product			= new long[Parameter.N_III_P];
//		
//		sample.encodeC (positionList, signList, seed, (short) 0, Parameter.N_III_P, Parameter.W_III_P);
//		
//		System.out.println ("Position List\n");
//		
//		for (short i = 0; i < Parameter.W_III_P; i++) {
//			
//			System.out.printf ("%4d\t", positionList[i]);
//		
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSignature List\n");
//		
//		for (short i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d\t", signList[i]);
//			
//			if (i % 8 == 7) {
//			
//				System.out.printf ("LINE %d\n", (i / 8 + 1));
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			publicKey[i] = (int) (PolynomialProvablySecure.ZETA_III_P[i] & 0xFFFFFFFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication32 (
//				product,
//				publicKey, (short) 0,
//				positionList, signList,
//				Parameter.N_III_P, Parameter.W_III_P, Parameter.Q_III_P,
//				Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P
//		);
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			System.out.printf ("%016X\t", product[i]);
//			
//			if (i % 4 == 3) {
//				
//				System.out.printf ("LINE %3d\n", (i / 4 + 1));
//				
//			}
//		
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Hash Function in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testHashFunctionIIISize () {
//		
//		System.out.println ("Test for Hash Function in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] message	= new byte[Parameter.N_III_SIZE * Long.SIZE / Byte.SIZE];
//		byte[] output	= new byte[Polynomial.C_BYTE];
//		
//		for (short i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			function.store64 (message, i * Long.SIZE / Byte.SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE[i]);
//			
//		}
//		
//		System.out.println ("Message\n");
//		
//		for (short i = 0; i < Parameter.N_III_SIZE * Long.SIZE / Byte.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", message[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %3d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\nSignature\n\n");
//		
//		QTESLA.hashFunction (
//				output, (short) 0,
//				PolynomialHeuristic.ZETA_III_SIZE,
//				message, 0, Parameter.N_III_SIZE * Long.SIZE / Byte.SIZE,
//				Parameter.N_III_SIZE, Parameter.D_III_SIZE, Parameter.Q_III_SIZE
//		);
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X", output[i]);
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Hash Function in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testHashFunctionIIIP () {
//		
//		System.out.println ("Test for Hash Function in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] V		= new long[Parameter.N_III_P * Parameter.K_III_P];
//		byte[] message	= new byte[Parameter.N_III_P * Long.SIZE / Byte.SIZE];
//		byte[] output	= new byte[Polynomial.C_BYTE];
//		
//		for (short i = 0; i < Parameter.N_III_P; i++) {
//			
//			function.store64 (message, i * Long.SIZE / Byte.SIZE, PolynomialProvablySecure.ZETA_INVERSE_III_P[i]);
//			
//		}
//		
//		System.out.println ("Message\n");
//		
//		for (short i = 0; i < Parameter.N_III_P * Long.SIZE / Byte.SIZE; i++) {
//			
//			System.out.printf ("%02X\t", message[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.printf ("LINE %4d\n", (i / 16 + 1));
//				
//			}
//			
//		}
//		
//		System.out.printf ("\nSignature\n\n");
//		
//		for (short k = 0; k < Parameter.K_III_P; k++) {
//			
//			for (short i = 0; i < Parameter.N_III_P; i++) {
//				
//				V[Parameter.N_III_P * k + i] = PolynomialProvablySecure.ZETA_III_P[i];
//				
//			}
//			
//		}
//		
//		QTESLA.hashFunction (
//				output, (short) 0,
//				V,
//				message, 0, Parameter.N_III_P * Long.SIZE / Byte.SIZE,
//				Parameter.N_III_P, Parameter.K_III_P, Parameter.D_III_P, Parameter.Q_III_P
//		);
//		
//		for (short i = 0; i < Polynomial.C_BYTE; i++) {
//			
//			System.out.printf ("%02X", output[i]);
//			
//		}
//		
//		System.out.printf ("\n");
//		
//	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testGenerateKeyPairSigningVerifyingIIISize () {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_III_SIZE];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_III_SIZE];
		
		QTESLA.generateKeyPairIIISize (publicKey, privateKey, secureRandom);
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SIZE; i++) {
			
			System.out.printf ("%02X\t", publicKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.printf ("LINE %3d\n", (i / 16 + 1));
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_SIZE; i++) {
			
			System.out.printf ("%02X\t", privateKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.printf ("LINE %3d\n", (i / 16 + 1));
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_III_SIZE + 59];
		byte[] messageInput = new byte[59];
		
		for (int round = 0; round < 5; round++) {
		
			System.out.println("Round " + (round + 1) + "\n");
			
			secureRandom.nextBytes(messageInput);
		
			System.out.println ("Message:\n");
		
			for (int i = 0; i < 59; i++) {
			
				System.out.printf ("%02X\t", messageInput[i]);
			
				if (i % 16 == 15) {
				
					System.out.printf ("LINE %d\n", (i / 16 + 1));
			
				}
			
			}
		
			System.out.println ("\n\nSignature:\n");
		
			QTESLA.signingIIISize (signature, 0, signatureLength, messageInput, 0, 59, privateKey, secureRandom);
		
			for (int i = 0; i < signature.length; i++) {
			
				System.out.printf ("%02X\t", signature[i]);
			
				if (i % 16 == 15) {
				
					System.out.printf ("LINE %d\n", (i / 16 + 1));
			
				}
			
			}
		
			System.out.printf ("\n\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);
		
			int valid;
			int response;
			byte[] messageOutput = new byte[Polynomial.SIGNATURE_III_SIZE + 59];
		
			System.out.println ("Test for Verifying for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
			valid = QTESLA.verifyingIIISize(messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		
			if (valid != 0) {
			
				System.out.println ("Signature Verification Failed with " + valid + "\n");
			
			} else if (messageLength[0] != 59) {
			
				System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
			}
		
			for (short i = 0; i < messageLength[0]; i++) {
			
				if (messageInput[i] != messageOutput[i]) {
				
					System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
					break;
				
				}
			
			}
		
			signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_III_SIZE + 59)] ^= 1;
		
			response = QTESLA.verifyingIIISize (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		
			if (response == 0) {
			
				System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
			}
		
			System.out.println ("Signature Tests Passed\n");
		
		}
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Provably-Secure qTESLA Security Category-3 */
	
	public static void testGenerateKeyPairSigningVerifyingIIIP () {
		
		System.out.println ("Test for Generation of the Key Pair for Provably-Secure qTESLA Security Category-3\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_III_P];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_III_P];
		
		QTESLA.generateKeyPairIIIP (publicKey, privateKey, secureRandom);
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_P; i++) {
			
			System.out.printf ("%02X\t", publicKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.printf ("LINE %4d\n", (i / 16 + 1));
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_P; i++) {
			
			System.out.printf ("%02X\t", privateKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.printf ("LINE %3d\n", (i / 16 + 1));
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Provably-Secure qTESLA Security Category-3\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_III_P + 59];
		byte[] messageInput = new byte[59];
		
		for (int round = 0; round < 5; round++) {
		
			secureRandom.nextBytes(messageInput);
		
			System.out.println ("Message:\n");
		
			for (int i = 0; i < 59; i++) {
			
				System.out.printf ("%02X\t", messageInput[i]);
			
				if (i % 16 == 15) {
				
					System.out.printf ("LINE %d\n", (i / 16 + 1));
			
				}
			
			}
		
			System.out.println ("\n\nSignature:\n");
		
			QTESLA.signingIIIP (signature, 0, signatureLength, messageInput, 0, 59, privateKey, secureRandom);
		
			for (int i = 0; i < signature.length; i++) {
			
				System.out.printf ("%02X\t", signature[i]);
			
				if (i % 16 == 15) {
				
					System.out.printf ("LINE %d\n", (i / 16 + 1));
			
				}
			
			}
		
			System.out.printf ("\n\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);

			int valid;
			int response;
			byte[] messageOutput = new byte[Polynomial.SIGNATURE_III_P + 59];
		
			System.out.println ("Test for Verifying for Provably-Secure qTESLA Security Category-3\n");
		
			valid = QTESLA.verifyingIIISize(messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		
			if (valid != 0) {
			
				System.out.println ("Signature Verification Failed with " + valid + "\n");
			
			} else if (messageLength[0] != 59) {
			
				System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
			}
		
			for (short i = 0; i < messageLength[0]; i++) {
			
				if (messageInput[i] != messageOutput[i]) {
				
					System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
					break;
				
				}
			
			}
		
			signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_III_P + 59)] ^= 1;
		
			response = QTESLA.verifyingIIIP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		
			if (response == 0) {
			
				System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
			}
		
			System.out.println ("Signature Tests " + (round + 1) + " Passed\n");
		
		}
		
	}

}