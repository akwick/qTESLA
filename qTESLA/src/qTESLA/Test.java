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
			
			(byte) 0x12, (byte) 0x23, (byte) 0x34, (byte) 0x45, (byte) 0x56, (byte) 0x67, (byte) 0x78, (byte) 0x89, // 1
			(byte) 0x9A, (byte) 0xAB, (byte) 0xBC, (byte) 0xCD, (byte) 0xDE, (byte) 0xEF, (byte) 0xF1, (byte) 0x13, // 2
			(byte) 0x24, (byte) 0x35, (byte) 0x46, (byte) 0x57, (byte) 0x68, (byte) 0x79, (byte) 0x8A, (byte) 0x9B, // 3
			(byte) 0xAC, (byte) 0xBD, (byte) 0xCE, (byte) 0xDF, (byte) 0xE1, (byte) 0xF2, (byte) 0x14, (byte) 0x25, // 4
			(byte) 0x36, (byte) 0x47, (byte) 0x58, (byte) 0x69, (byte) 0x7A, (byte) 0x8B, (byte) 0x9C, (byte) 0xAD, // 5
			(byte) 0xBE, (byte) 0xCF, (byte) 0xD1, (byte) 0xE2, (byte) 0xF3, (byte) 0x15, (byte) 0x26, (byte) 0x37, // 6
			(byte) 0x48, (byte) 0x59, (byte) 0x6A, (byte) 0x7B, (byte) 0x8C, (byte) 0x9D, (byte) 0xAE, (byte) 0xBF, // 7
			(byte) 0xC1, (byte) 0xD2, (byte) 0xE3, (byte) 0xF4, (byte) 0x16, (byte) 0x27, (byte) 0x38, (byte) 0x49, // 8
			(byte) 0x5A, (byte) 0x6B, (byte) 0x7C, (byte) 0x8D, (byte) 0x9E, (byte) 0xAF, (byte) 0xB1, (byte) 0xC2, // 9
			(byte) 0xD3, (byte) 0xE4, (byte) 0xF5, (byte) 0x17, (byte) 0x28, (byte) 0x39, (byte) 0x4A, (byte) 0x5B, // 10
			(byte) 0x6C, (byte) 0x7D, (byte) 0x8E, (byte) 0x9F, (byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4, // 11
			(byte) 0xE5, (byte) 0xF6, (byte) 0x18, (byte) 0x29, (byte) 0x3A, (byte) 0x4B, (byte) 0x5C, (byte) 0x6D, // 12
			(byte) 0x7E, (byte) 0x8F, (byte) 0x91, (byte) 0xA2, (byte) 0xB3, (byte) 0xC4, (byte) 0xD5, (byte) 0xE6, // 13
			(byte) 0xF7, (byte) 0x19, (byte) 0x2A, (byte) 0x3B, (byte) 0x4C, (byte) 0x5D, (byte) 0x6E, (byte) 0x7F, // 14
			(byte) 0x81, (byte) 0x92, (byte) 0xA3, (byte) 0xB4, (byte) 0xC5, (byte) 0xD6, (byte) 0xE7, (byte) 0xF8, // 15
			(byte) 0x1A, (byte) 0x2B, (byte) 0x3C, (byte) 0x4D, (byte) 0x5E, (byte) 0x6F, (byte) 0x71, (byte) 0x82, // 16
			
	};
	
	public static byte[] hexadecimalStringToByteArray (String string) {
		
		byte[] byteArray = new byte[string.length() / 2];
		
		for (int i = 0; i < byteArray.length; i++) {
			
			int index		= i * 2;
			int value		= Integer.parseInt(string.substring (index, index + 2), 16);
			byteArray[i]	= (byte) value;
			
		}
		
		return byteArray;
		
	}
	
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
		
		// testRandomByte ();
		
		// testModulus7 ();
		// testBernoulli ();
		// testSampleYIIIP ();
		// testPolynomialGaussSamplerI();
		// testPolynomialGaussSamplerIIISize();
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
		// testPolynomialMultiplicationIIISize ();
		// testPolynomialMultiplicationIIIP ();
		// testPolynomialAdditionIIIP ();
		// testPolynomialSubtractionIIISize ();
		// testPolynomialSubtractionIIIP ();
		// testPolynomialUniformIIIP ();
		
		// testAbsoluteValue ();
		// testTestRejectionIIIP ();
		// testTestZIIIP ();
		// testTestVIIIP ();
		// testCheckErrorPolynomialIIIP ();
		// testCheckSecretPolynomialIIIP ();
		// testPackPrivateKeyIIISize ();
		// testPackPrivateKeyIIIP();
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
		// testGenerateKeyPairSigningVerifyingI ();
		// testGenerateKeyPairSigningVerifyingIIISpeed ();
		// testGenerateKeyPairSigningVerifyingIIISize ();
		testGenerateKeyPairSigningVerifyingIP ();
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
		
		for (int i = 0; i < Short.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Integer Number in Common Function */
	
	public static void testStoreIntegerNumber () {
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		System.out.println ("Test for Storing Integer Number in Common Function\n");
		
		CommonFunction.store32 (newByteArray, 4, integerNumber);
		
		for (int i = 0; i < Integer.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Long Number in Common Function */
	
	public static void testStoreLongNumber () {
		
		System.out.println ("Test for Storing Long Number in Common Function\n");
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		CommonFunction.store64 (newByteArray, 0, longNumber);
		
		for (int i = 0; i < Long.SIZE / Byte.SIZE; i++) {
			
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
	
	/* Test for Random Byte in Random Number Generator */
	
	public static void testRandomByte () throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		RandomNumberGenerator rng = new RandomNumberGenerator ();
		byte[] randomness = new byte[48];
		
		System.out.println ("Test for Random Byte in Random Number Generator\n");
		
		for (int n = 0; n < 100; n++) {
			
			System.out.printf ("Round %3d\t", n + 1);
			
			rng.randomByte (randomness, 0, 48);
			
			for (int i = 0; i < 48; i++) {
			
				System.out.printf ("%02X ", randomness[i]);
			
			}
			
			System.out.println();
		
		}
		
		System.out.println();
		
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
		
		long[] data	= new long[Parameter.N_I];
		
		Sample.polynomialGaussSamplerI (data, 0, seed, 0, 128, Parameter.N_I, Parameter.XI_I, Sample.EXPONENTIAL_DISTRIBUTION_I);
		
		for (int i = 0; i < Parameter.N_I; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X\t", data[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.printf ("\n");
		
	}
	
/* Test for Polynomial Gauss Sampler in Sample for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testPolynomialGaussSamplerIIISize () {
		
		System.out.println ("Test for Polynomial Gauss Sampler in Sample for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		long[] data			= new long[Parameter.N_III_SIZE];
		
		byte[] seedExtended	= {
				
				(byte) 0xFC, (byte) 0xAA, (byte) 0x2D, (byte) 0x9F, (byte) 0xE9, (byte) 0xDB, (byte) 0xC2, (byte) 0x36, 
				(byte) 0x68, (byte) 0x5E, (byte) 0x88, (byte) 0x19, (byte) 0x84, (byte) 0x0C, (byte) 0x46, (byte) 0x5F, 
				(byte) 0xD4, (byte) 0x5C, (byte) 0x49, (byte) 0xDD, (byte) 0xC1, (byte) 0xF9, (byte) 0xAF, (byte) 0x50, 
				(byte) 0x06, (byte) 0xB6, (byte) 0x29, (byte) 0x2C, (byte) 0xCC, (byte) 0x55, (byte) 0xC3, (byte) 0xD3, 
				(byte) 0x42, (byte) 0xC5, (byte) 0x1A, (byte) 0x06, (byte) 0xBC, (byte) 0x4D, (byte) 0x39, (byte) 0x93, 
				(byte) 0x5B, (byte) 0x09, (byte) 0x94, (byte) 0x4C, (byte) 0xBF, (byte) 0xE1, (byte) 0x8C, (byte) 0xB8, 
				(byte) 0x4F, (byte) 0x5F, (byte) 0x20, (byte) 0x4F, (byte) 0x17, (byte) 0xC0, (byte) 0x67, (byte) 0xDB, 
				(byte) 0xFB, (byte) 0xE0, (byte) 0x04, (byte) 0xB0, (byte) 0x2C, (byte) 0xC0, (byte) 0xA9, (byte) 0xBD, 
				(byte) 0xF7, (byte) 0x1D, (byte) 0x0D, (byte) 0x50, (byte) 0xD0, (byte) 0xB5, (byte) 0x5A, (byte) 0xA4, 
				(byte) 0x48, (byte) 0xDE, (byte) 0xE9, (byte) 0xA2, (byte) 0xE8, (byte) 0x31, (byte) 0x9D, (byte) 0x71, 
				(byte) 0x21, (byte) 0x42, (byte) 0xFE, (byte) 0x26, (byte) 0x9F, (byte) 0x11, (byte) 0xEF, (byte) 0x69, 
				(byte) 0xF3, (byte) 0x97, (byte) 0x3D, (byte) 0xB7, (byte) 0x4E, (byte) 0xF9, (byte) 0xF0, (byte) 0xEC, 
				(byte) 0x8D, (byte) 0xBC, (byte) 0x30, (byte) 0xB9, (byte) 0x18, (byte) 0xDD, (byte) 0x28, (byte) 0xA7, 
				(byte) 0x27, (byte) 0x08, (byte) 0x80, (byte) 0x9C, (byte) 0x89, (byte) 0x72, (byte) 0xB6, (byte) 0xD0, 
				(byte) 0x42, (byte) 0x47, (byte) 0xD2, (byte) 0xFC, (byte) 0xFA, (byte) 0x94, (byte) 0xB2, (byte) 0xAC, 
				(byte) 0xA0, (byte) 0x24, (byte) 0x29, (byte) 0x95, (byte) 0x8A, (byte) 0x16, (byte) 0x2B, (byte) 0x09
				
		};
		
		Sample.polynomialGaussSamplerIII (data, 0, seedExtended, 0, 128, Parameter.N_III_SIZE, Parameter.XI_III_SIZE, Sample.EXPONENTIAL_DISTRIBUTION_III_SIZE);
		
		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
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
		
		long[] data	= new long[Parameter.N_III_P];
		
		Sample.polynomialGaussSamplerIII (data, 0, seed, 0, 256, Parameter.N_III_P, Parameter.XI_III_P, Sample.EXPONENTIAL_DISTRIBUTION_P);
		
		for (int i = 0; i < Parameter.N_III_P; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
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
				A, seed, 0,
				Parameter.N_III_P, Parameter.K_III_P, Parameter.Q_III_P, Parameter.Q_INVERSE_III_P, Parameter.Q_LOGARITHM_III_P,
				Parameter.GENERATOR_A_III_P, Parameter.INVERSE_NUMBER_THEORETIC_TRANSFORM_III_P
		);
		
		for (int k = 0; k < Parameter.K_III_P; k++) {
			
			System.out.printf ("SAMPLE %d\n\n", (k + 1));
			
			for (int i = 0; i < Parameter.N_III_P; i++) {
				
				if (i % 8 == 0) {
					
					System.out.printf ("LINE %3d\t", (i / 8 + 1));
					
				}
				
				System.out.printf ("%08X\t", A[i]);
				
				if (i % 8 == 7) {
					
					System.out.println ();
					
				}
				
			}
			
			System.out.println ();
			
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
//		System.out.printf ("%B\n\n", QTESLA.testV (PolynomialProvablySecure.ZETA_III_P, 0, Parameter.N_III_P, Parameter.D_III_P, Parameter.Q_III_P, Parameter.REJECTION_III_P));
//		
//	}
	
	/* Test for Checking Error Polynomial in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testCheckErrorPolynomialIIIP () {
//		
//		System.out.println ("Test for Checking Error Polynomial in QTESLA\n");
//		
//		System.out.printf ("%B\n\n", QTESLA.checkPolynomial (PolynomialProvablySecure.ZETA_III_P, 0, Parameter.KEY_GENERATOR_BOUND_E_III_P, Parameter.N_III_P, Parameter.W_III_P));
//		
//	}
	
//	/* Test for Checking Secret Polynomial in QTESLA for Provably-Secure qTESLA Security Category-3 */
//	
//	public static void testCheckSecretPolynomialIIIP () {
//		
//		System.out.println ("Test for Checking Secret Polynomial in QTESLA\n");
//				
//		System.out.printf ("%B\n\n", QTESLA.checkPolynomial (PolynomialProvablySecure.ZETA_III_P, 0, Parameter.KEY_GENERATOR_BOUND_S_III_P, Parameter.N_III_P, Parameter.W_III_P));
//		
//	}
	
	/* Test for Packing Private Key for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testPackPrivateKeyIIISize() {
//		
//		byte[] privateKey = new byte[Polynomial.PRIVATE_KEY_III_SIZE];
//		
//		System.out.println ("Test for Packing Private Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");	
//	
//		QTESLA.packPrivateKey (privateKey, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE, seed, 0, Parameter.N_III_SIZE);
//		
//		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_SIZE; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", privateKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Packing Private Key for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testPackPrivateKeyIIIP() {
//		
//		byte[] privateKey		= new byte[Polynomial.PRIVATE_KEY_III_P];
//		long[] secretPolynomial	= new long[Parameter.N_III_P];
//		long[] errorPolynomial	= new long[Parameter.N_III_P * Parameter.K_III_P];
//		
//		System.out.println ("Test for Packing Private Key in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		System.arraycopy (PolynomialProvablySecure.ZETA_III_P, 0, secretPolynomial, 0, Parameter.N_III_P);
//		
//		for (int i = 0; i < Parameter.K_III_P; i++) {
//			
//			System.arraycopy (PolynomialProvablySecure.ZETA_INVERSE_III_P, 0, errorPolynomial, Parameter.N_III_P * i, Parameter.N_III_P);
//			
//		}
//		
//		QTESLA.packPrivateKey (
//				
//				privateKey, secretPolynomial, errorPolynomial, seed, 0, Parameter.N_III_P, Parameter.K_III_P
//		
//		);
//		
//		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_P; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", privateKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testEncodePublicKeyIIISize () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] publicKey = new byte[Polynomial.PUBLIC_KEY_III_SIZE];
//		
//		QTESLA.encodePublicKey (publicKey, PolynomialHeuristic.ZETA_III_SIZE, seed, 0, Parameter.N_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE);
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SIZE; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", publicKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testEncodePublicKeyIIISpeed () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		byte[] publicKey = new byte[Polynomial.PUBLIC_KEY_III_SPEED];
//		
//		QTESLA.encodePublicKeyIIISpeed (publicKey, PolynomialHeuristic.ZETA_III_SPEED, seed, 0);
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SPEED; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", publicKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1 */
	
//	public static void testEncodePublicKeyIP () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1\n");
//		
//		long[] T					= new long[Parameter.N_I_P * Parameter.K_I_P];
//		byte[] publicKey			= new byte[Polynomial.PUBLIC_KEY_I_P];
//		
//		for (int k = 0; k < Parameter.K_I_P; k++) {
//		
//			System.arraycopy (PolynomialProvablySecure.ZETA_I_P, 0, T, Parameter.N_I_P * k, Parameter.N_I_P);
//		
//		}
//		
//		QTESLA.encodePublicKeyIP (publicKey, T, seed, 0);
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_I_P; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", publicKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testEncodePublicKeyIIIP () {
//		
//		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] T					= new long[Parameter.N_III_P * Parameter.K_III_P];
//		byte[] publicKey			= new byte[Polynomial.PUBLIC_KEY_III_P];
//		
//		for (int k = 0; k < Parameter.K_III_P; k++) {
//		
//			System.arraycopy (PolynomialProvablySecure.ZETA_III_P, 0, T, Parameter.N_III_P * k, Parameter.N_III_P);
//		
//		}
//		
//		QTESLA.encodePublicKeyIIIP (publicKey, T, seed, 0);
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_P; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %4d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", publicKey[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testDecodePublicKeyIIISize () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] publicKeyInput	= new byte[Polynomial.PUBLIC_KEY_III_SIZE];
//		int[] publicKey			= new int[Parameter.N_III_SIZE];
//		byte[] seedA			= new byte[Polynomial.SEED];
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SIZE; i++) {
//			
//			publicKeyInput[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % Parameter.N_III_SIZE] & 0xFFL);
//		
//		}
//		
//		QTESLA.decodePublicKey (publicKey, seedA, 0, publicKeyInput, Parameter.N_III_SIZE, Parameter.Q_LOGARITHM_III_SIZE);
//
//		System.out.println ("Public Key in Integer\n");
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			if (i % 16 == 0) {
//				
//				System.out.printf ("LINE %2d\t", (i / 16 + 1));
//				
//			}
//			
//			System.out.printf ("%06X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ("\nSeed\n");
//	
//		for (int i = 0; i < Polynomial.SEED; i++) {
//	
//			System.out.printf ("%02X ", seedA[i]);
//	
//		}
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testDecodePublicKeyIIISpeed () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		byte[] publicKeyInput	= new byte[Polynomial.PUBLIC_KEY_III_SPEED];
//		int[] publicKey			= new int[Parameter.N_III_SPEED];
//		byte[] seedA			= new byte[Polynomial.SEED];
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SPEED; i++) {
//		
//			publicKeyInput[i] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i % Parameter.N_III_SPEED] & 0xFFL);
//			
//		}
//		
//		QTESLA.decodePublicKeyIIISpeed (publicKey, seedA, 0, publicKeyInput);
//
//		System.out.println ("Public Key in Integer\n");
//		
//		for (int i = 0; i < Parameter.N_III_SPEED; i++) {
//			
//			if (i % 16 == 0) {
//				
//				System.out.printf ("LINE %2d\t", (i / 16 + 1));
//				
//			}
//			
//			System.out.printf ("%06X\t", publicKey[i]);
//			
//			if (i % 16 == 15) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ("\nSeed\n");
//		
//		for (int i = 0; i < Polynomial.SEED; i++) {
//		
//			System.out.printf ("%02X ", seedA[i]);
//		
//		}
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1 */
	
//	public static void testDecodePublicKeyIP () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-1\n");
//		
//		byte[] publicKeyInput	= new byte[Polynomial.PUBLIC_KEY_I_P];
//		int[] publicKey			= new int[Parameter.N_I_P * Parameter.K_I_P];
//		byte[] seedA			= new byte[Polynomial.SEED];
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_I_P; i++) {
//			
//			publicKeyInput[i] = (byte) (PolynomialProvablySecure.ZETA_I_P[i % Parameter.N_I_P] & 0xFFL);
//		
//		}
//		
//		QTESLA.decodePublicKeyIP (publicKey, seedA, 0, publicKeyInput);
//		
//		System.out.println ("Public Key in Integer\n");
//		
//		for (int i = 0; i < Parameter.N_I_P * Parameter.K_I_P; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 8 + 1));
//				
//			}
//			
//			System.out.printf ("%08X\t", publicKey[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ("\nSeed\n");
//		
//		for (int i = 0; i < Polynomial.SEED; i++) {
//			
//			System.out.printf ("%02X ", seedA[i]);
//			
//		}
//		
//	}
	
	/* Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testDecodePublicKeyIIIP () {
//		
//		System.out.println ("Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		byte[] publicKeyInput	= new byte[Polynomial.PUBLIC_KEY_III_P];
//		int[] publicKey			= new int[Parameter.N_III_P * Parameter.K_III_P];
//		byte[] seedA			= new byte[Polynomial.SEED];
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_P; i++) {
//		
//			publicKeyInput[i] = (byte) (PolynomialProvablySecure.ZETA_III_P[i % Parameter.N_III_P] & 0xFFL);
//			
//		}
//		
//		QTESLA.decodePublicKeyIIIP (publicKey, seedA, 0, publicKeyInput);
//		
//		for (short i = 0; i < Parameter.N_III_P * Parameter.K_III_P; i++) {
//			
//			if (i % 8 == 0) {
//				
//				System.out.printf ("LINE %4d\t", (i / 8 + 1));
//				
//			}
//			
//			System.out.printf ("%08X\t", publicKey[i]);
//			
//			if (i % 8 == 7) {
//				
//				System.out.println ();
//				
//			}
//			
//		}
//		
//		System.out.println ("\nSeed\n");
//		
//		for (int i = 0; i < Polynomial.SEED; i++) {
//			
//			System.out.printf ("%02X ", seedA[i]);
//			
//		}
//		
//	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testEncodeSignatureIIISize () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_SIZE];
//		
//		QTESLA.encodeSignature (signature, 0, seed, 0, PolynomialHeuristic.ZETA_III_SIZE, Parameter.N_III_SIZE, Parameter.D_III_SIZE);
//		
//		for (int i = 0; i < Polynomial.SIGNATURE_III_SIZE; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %2d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", signature[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testEncodeSignatureIIISpeed () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_SPEED];
//		
//		QTESLA.encodeSignatureIIISpeedIP (signature, 0, seed, 0, PolynomialHeuristic.ZETA_III_SPEED, Parameter.N_III_SPEED, Parameter.D_III_SPEED);
//		
//		for (int i = 0; i < Polynomial.SIGNATURE_III_SPEED; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %2d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", signature[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Encoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testEncodeSignatureIIIP () {
//		
//		System.out.println ("Test for Encoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_P];
//		
//		QTESLA.encodeSignature (signature, 0, seed, 0, PolynomialProvablySecure.ZETA_III_P);
//		
//		for (short i = 0; i < Polynomial.SIGNATURE_III_P; i++) {
//			
//			if (i % 32 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 32 + 1));
//				
//			}
//			
//			System.out.printf ("%02X ", signature[i]);
//			
//			if (i % 32 == 31) {
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
	
	/* Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testDecodeSignatureIIISize () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SIZE];
//		byte[] C			= new byte[Polynomial.HASH];
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_SIZE];
//		
//		for (int i = 0; i < Polynomial.SIGNATURE_III_SIZE; i++) {
//				
//			signature[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % Parameter.N_III_SIZE] & 0xFFL);
//			
//		}
//		
//		QTESLA.decodeSignature (C, Z, signature, 0, Parameter.N_III_SIZE, Parameter.D_III_SIZE);
//		
//		System.out.println ("\nDisplay C\n");
//		
//		for (int i = 0; i < Polynomial.HASH; i++) {
//			
//			System.out.printf ("%02X ", C[i]);
//			
//		}
//		
//		System.out.println ("\n\nDisplay Z\n");
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", Z[i]);
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
	
	/* Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
//	public static void testDecodeSignatureIIISpeed () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
//		
//		long[] Z			= new long[Parameter.N_III_SPEED];
//		byte[] C			= new byte[Polynomial.HASH];
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_SPEED];
//		
//		for (int i = 0; i < Polynomial.SIGNATURE_III_SPEED; i++) {
//
//			signature[i] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i % Parameter.N_III_SPEED] & 0xFFL);
//			
//		}
//		
//		QTESLA.decodeSignatureIIISpeedIP (C, Z, signature, 0, Parameter.N_III_SPEED, Parameter.D_III_SPEED);
//		
//		System.out.println ("\nDisplay C\n");
//		
//		for (int i = 0; i < Polynomial.HASH; i++) {
//			
//			System.out.printf ("%02X ", C[i]);
//			
//		}
//		
//		System.out.println ("\n\nDisplay Z\n");
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//		
//			if (i % 4 == 0) {
//			
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//			
//			}
//		
//			System.out.printf ("%016X\t", Z[i]);
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
	
	/* Test for Decoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testDecodeSignatureIIIP () {
//		
//		System.out.println ("Test for Decoding Signature in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] Z			= new long[Parameter.N_III_P];
//		byte[] C			= new byte[Polynomial.HASH];
//		byte[] signature	= new byte[Polynomial.SIGNATURE_III_P];
//		
//		for (int i = 0; i < Polynomial.SIGNATURE_III_P; i++) {
//		
//			signature[i] = (byte) (PolynomialProvablySecure.ZETA_III_P[i % Parameter.N_III_P] & 0xFFL);
//			
//		}
//		
//		QTESLA.decodeSignature (C, Z, signature, 0);
//		
//		System.out.println ("\nDisplay C\n");
//		
//		for (int i = 0; i < Polynomial.HASH; i++) {
//			
//			System.out.printf ("%02X ", C[i]);
//			
//		}
//		
//		System.out.println ("\n\nDisplay Z\n");
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", Z[i]);
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
	
	/* Test for Sparse Polynomial Multiplication of 16-Bit in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testSparsePolynomialMultiplication16 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 16-Bit in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		int[] positionList	= new int[Parameter.W_III_SIZE];
//		short[] signList	= new short[Parameter.W_III_SIZE];
//		byte[] secretKey	= new byte[Polynomial.PRIVATE_KEY_III_SIZE];
//		long[] product		= new long[Parameter.N_III_SIZE];
//		
//		Sample.encodeC (positionList, signList, seed, 0, Parameter.N_III_SIZE, Parameter.W_III_SIZE);
//		
//		System.out.println ("Position List\n");
//		
//		for (int i = 0; i < Parameter.W_III_SIZE; i++) {
//			
//			if (i % 16 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 16 + 1));
//			
//			}
//			
//			System.out.printf ("%03X ", positionList[i]);
//		
//			if (i % 16 == 15) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSign List\n");
//		
//		for (int i = 0; i < Parameter.W_III_SIZE; i++) {
//			
//			if (i % 16 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 16 + 1));
//			
//			}
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d ", signList[i]);
//			
//			if (i % 16 == 15) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_SIZE; i++) {
//			
//			secretKey[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % Parameter.N_III_SIZE] & 0xFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication16 (product, 0, secretKey, 0, positionList, signList, Parameter.N_III_SIZE, Parameter.W_III_SIZE);
//		
//		for (int i = 0; i < Parameter.N_III_SIZE; i++) {
//			
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", product[i]);
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
	
	/* Test for Sparse Polynomial Multiplication of 8-Bit in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testSparsePolynomialMultiplication8 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 8-Bit in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		int[] positionList	= new int[Parameter.W_III_P];
//		short[] signList	= new short[Parameter.W_III_P];
//		byte[] secretKey	= new byte[Polynomial.PRIVATE_KEY_III_P];
//		long[] product		= new long[Parameter.N_III_P];
//		
//		Sample.encodeC (positionList, signList, seed, 0, Parameter.N_III_P, Parameter.W_III_P);
//		
//		System.out.println ("Position List\n");
//		
//		for (int i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (i % 20 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 20 + 1));
//			
//			}
//			
//			System.out.printf ("%03X ", positionList[i]);
//		
//			if (i % 20 == 19) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSign List\n");
//		
//		for (int i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (i % 20 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 20 + 1));
//			
//			}
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d ", signList[i]);
//			
//			if (i % 20 == 19) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_P; i++) {
//			
//			secretKey[i] = (byte) (PolynomialProvablySecure.ZETA_III_P[i % Parameter.N_III_P] & 0xFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication8 (product, 0, secretKey, 0, positionList, signList, Parameter.N_III_P, Parameter.W_III_P);
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", product[i]);
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
	
	/* Test for Sparse Polynomial Multiplication of 32-Bit in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testSparsePolynomialMultiplication32 () {
//		
//		System.out.println ("Test for Sparse Polynomial Multiplication of 32-Bit in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		int[] positionList	= new int[Parameter.W_III_P];
//		short[] signList	= new short[Parameter.W_III_P];
//		int[] publicKey		= new int[Polynomial.PUBLIC_KEY_III_P];
//		long[] product		= new long[Parameter.N_III_P];
//		
//		Sample.encodeC (positionList, signList, seed, 0, Parameter.N_III_P, Parameter.W_III_P);
//		
//		System.out.println ("Position List\n");
//		
//		for (int i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (i % 20 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 20 + 1));
//			
//			}
//			
//			System.out.printf ("%03X ", positionList[i]);
//		
//			if (i % 20 == 19) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//	
//		System.out.println ("\nSign List\n");
//		
//		for (int i = 0; i < Parameter.W_III_P; i++) {
//			
//			if (i % 20 == 0) {
//				
//				System.out.printf ("LINE %d\t", (i / 20 + 1));
//			
//			}
//			
//			if (signList[i] > 0) {
//		
//				System.out.printf ("+");
//				
//			}
//			
//			System.out.printf ("%d ", signList[i]);
//			
//			if (i % 20 == 19) {
//			
//				System.out.println ();
//			
//			}
//		
//		}
//		
//		System.out.println ("\nDisplay Product\n");
//		
//		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_P; i++) {
//			
//			publicKey[i] = (int) (PolynomialProvablySecure.ZETA_III_P[i % Parameter.N_III_P] & 0xFFFFFFFFL);
//			
//		}
//		
//		QTESLA.sparsePolynomialMultiplication32 (
//				
//				product, 0, publicKey, 0, positionList, signList,
//				Parameter.N_III_P, Parameter.W_III_P, Parameter.Q_III_P,
//				Parameter.BARRETT_MULTIPLICATION_III_P, Parameter.BARRETT_DIVISION_III_P
//		
//		);
//		
//		for (int i = 0; i < Parameter.N_III_P; i++) {
//			
//			if (i % 4 == 0) {
//				
//				System.out.printf ("LINE %3d\t", (i / 4 + 1));
//				
//			}
//			
//			System.out.printf ("%016X\t", product[i]);
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
	
	/* Test for Hash Function in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size) */
	
//	public static void testHashFunctionIIISize () {
//		
//		System.out.println ("Test for Hash Function in QTESLA for Heuristic qTESLA Security Category-3 (Option for Size)\n");
//		
//		byte[] message	= new byte[2097152];
//		byte[] output	= new byte[Polynomial.HASH];
//		long[] V		= new long[Parameter.N_III_SIZE];
//		
//		for (int i = 0; i < 2097152; i++) {
//			
//			message[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % Parameter.N_III_SIZE] & 0xFFL);
//			
//		}
//		
//		System.arraycopy (PolynomialHeuristic.ZETA_III_SIZE, 0, V, 0, Parameter.N_III_SIZE);
//		
//		System.out.printf ("Hash Value\n\n");
//		
//		QTESLA.hashFunction (
//				
//				output, 0, V, message, 0, 2097152,
//				Parameter.N_III_SIZE, Parameter.D_III_SIZE, Parameter.Q_III_SIZE
//				
//		);
//		
//		for (int i = 0; i < Polynomial.HASH; i++) {
//			
//			System.out.printf ("%02X ", output[i]);
//			
//		}
//		
//		System.out.println ();
//		
//	}
	
	/* Test for Hash Function in QTESLA for Provably-Secure qTESLA Security Category-3 */
	
//	public static void testHashFunctionIIIP () {
//		
//		System.out.println ("Test for Hash Function in QTESLA for Provably-Secure qTESLA Security Category-3\n");
//		
//		long[] V		= new long[Parameter.N_III_P * Parameter.K_III_P];
//		byte[] message	= new byte[2097152];
//		byte[] output	= new byte[Polynomial.HASH];
//		
//		for (int i = 0; i < 2097152; i++) {
//			
//			message[i] = (byte) (PolynomialProvablySecure.ZETA_III_P[i % Parameter.N_III_P] & 0xFFL);
//			
//		}
//		
//		for (int k = 0; k < Parameter.K_III_P; k++) {
//			
//			System.arraycopy (PolynomialProvablySecure.ZETA_III_P, 0, V, Parameter.N_III_P * k, Parameter.N_III_P);
//			
//		}
//		
//		System.out.println ("\nHash Value\n\n");
//		
//		QTESLA.hashFunction (
//				
//				output, 0, V, message, 0, 2097152,
//				Parameter.N_III_P, Parameter.K_III_P, Parameter.D_III_P, Parameter.Q_III_P
//		
//		);
//		
//		for (int i = 0; i < Polynomial.HASH; i++) {
//			
//			System.out.printf ("%02X ", output[i]);
//			
//		}
//		
//		System.out.println ();
//		
//	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category-1 */
	
	public static void testGenerateKeyPairSigningVerifyingI ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category-1\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_I];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_I];
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		QTESLA.generateKeyPairI (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_I; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_I; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category-1\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_I + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = hexadecimalStringToByteArray (messageString);
		
		System.out.println ("Message:\n");
		
		for (int i = 0; i < 66; i++) {
			
			if (i % 32 == 0) {
					
				System.out.printf ("LINE %d\t", (i / 32 + 1));
			
			}
				
			System.out.printf ("%02X ", messageInput[i]);
			
			if (i % 32 == 31 || i == 65) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nSignature:\n");
		
		long startSigningTimeNano	= System.nanoTime();
		QTESLA.signingI (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
		
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
		
			}
			
		}
		
		System.out.printf ("\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);
		
		int valid;
		int response;
		byte[] messageOutput = new byte[Polynomial.SIGNATURE_I + 66];
		
		System.out.println ("Test for Verifying for Heuristic qTESLA Security Category-1\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = QTESLA.verifyingI (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime();
		
		if (valid != 0) {
			
			System.out.println ("Signature Verification Failed with " + valid + "\n");
			
		} else if (messageLength[0] != 66) {
			
			System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
		}
		
		for (int i = 0; i < messageLength[0]; i++) {
			
			if (messageInput[i] != messageOutput[i]) {
				
				System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
				break;
				
			}
			
		}
		
		signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_I + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = QTESLA.verifyingIIISpeed (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category-3 (Option for Speed) */
	
	public static void testGenerateKeyPairSigningVerifyingIIISpeed ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_III_SPEED];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_III_SPEED];
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		QTESLA.generateKeyPairIIISpeed (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SPEED; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_SPEED; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_III_SPEED + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = hexadecimalStringToByteArray (messageString);
		
		System.out.println ("Message:\n");
		
		for (int i = 0; i < 66; i++) {
			
			if (i % 32 == 0) {
					
				System.out.printf ("LINE %d\t", (i / 32 + 1));
			
			}
				
			System.out.printf ("%02X ", messageInput[i]);
			
			if (i % 32 == 31 || i == 65) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nSignature:\n");
		
		long startSigningTimeNano	= System.nanoTime();
		QTESLA.signingIIISpeed (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
		
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
		
			}
			
		}
		
		System.out.printf ("\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);
		
		int valid;
		int response;
		byte[] messageOutput = new byte[Polynomial.SIGNATURE_III_SPEED + 66];
		
		System.out.println ("Test for Verifying for Heuristic qTESLA Security Category-3 (Option for Speed)\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = QTESLA.verifyingIIISpeed (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime();
		
		if (valid != 0) {
			
			System.out.println ("Signature Verification Failed with " + valid + "\n");
			
		} else if (messageLength[0] != 66) {
			
			System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
		}
		
		for (int i = 0; i < messageLength[0]; i++) {
			
			if (messageInput[i] != messageOutput[i]) {
				
				System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
				break;
				
			}
			
		}
		
		signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_III_SPEED + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = QTESLA.verifyingIIISpeed (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category-3 (Option for Size) */
	
	public static void testGenerateKeyPairSigningVerifyingIIISize ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_III_SIZE];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_III_SIZE];
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		QTESLA.generateKeyPairIIISize (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_SIZE; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_SIZE; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_III_SIZE + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = hexadecimalStringToByteArray (messageString);
		
		System.out.println ("Message:\n");
		
		for (int i = 0; i < 66; i++) {
			
			if (i % 32 == 0) {
					
				System.out.printf ("LINE %d\t", (i / 32 + 1));
			
			}
				
			System.out.printf ("%02X ", messageInput[i]);
			
			if (i % 32 == 31 || i == 65) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nSignature:\n");
		
		long startSigningTimeNano	= System.nanoTime();
		QTESLA.signingIIISize (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
		
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
		
			}
			
		}
		
		System.out.printf ("\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);
		
		int valid;
		int response;
		byte[] messageOutput = new byte[Polynomial.SIGNATURE_III_SIZE + 66];
		
		System.out.println ("Test for Verifying for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = QTESLA.verifyingIIISize (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime();
		
		if (valid != 0) {
			
			System.out.println ("Signature Verification Failed with " + valid + "\n");
			
		} else if (messageLength[0] != 66) {
			
			System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
		}
		
		for (int i = 0; i < messageLength[0]; i++) {
			
			if (messageInput[i] != messageOutput[i]) {
				
				System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
				break;
				
			}
			
		}
		
		signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_III_SIZE + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = QTESLA.verifyingIIISize (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Provably-Secure qTESLA Security Category-1 */
	
	public static void testGenerateKeyPairSigningVerifyingIP ()
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Provably-Secure qTESLA Security Category-1\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_I_P];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_I_P];
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		QTESLA.generateKeyPairIP (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_I_P; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_I_P; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Provably-Secure qTESLA Security Category-1\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_I_P + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = hexadecimalStringToByteArray (messageString);
		
		System.out.println ("Message:\n");
		
		for (int i = 0; i < 66; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %d\t", i / 32 + 1);
					
			}
			
			System.out.printf ("%02X ", messageInput[i]);
			
			if (i % 32 == 31 || i == 66) {
					
				System.out.println ();
					
			}
				
		}
		
		System.out.println ("\n\nSignature:\n");
		
		long startSigningTimeNano	= System.nanoTime();
		QTESLA.signingIP (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.printf ("\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);

		int valid;
		int response;
		byte[] messageOutput = new byte[Polynomial.SIGNATURE_I_P + 66];
		
		System.out.println ("Test for Verifying for Provably-Secure qTESLA Security Category-1\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = QTESLA.verifyingIP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime();
		
		if (valid != 0) {
			
			System.out.println ("Signature Verification Failed with " + valid + "\n");
			
		} else if (messageLength[0] != 66) {
			
			System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
		}
		
		for (int i = 0; i < messageLength[0]; i++) {
			
			if (messageInput[i] != messageOutput[i]) {
				
				System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
				break;
				
			}
			
		}
		
		signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_I_P + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = QTESLA.verifyingIP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
		
			System.out.println ("Signature Test Passed\n");
		
		}
	}

	
	/* Test for Generation of the Key Pair, Signing and Verifying for Provably-Secure qTESLA Security Category-3 */
	
	public static void testGenerateKeyPairSigningVerifyingIIIP ()
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Provably-Secure qTESLA Security Category-3\n");
		
		byte[] publicKey	= new byte[Polynomial.PUBLIC_KEY_III_P];
		byte[] privateKey	= new byte[Polynomial.PRIVATE_KEY_III_P];
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		QTESLA.generateKeyPairIIIP (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < Polynomial.PUBLIC_KEY_III_P; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < Polynomial.PRIVATE_KEY_III_P; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Provably-Secure qTESLA Security Category-3\n");
		
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[Polynomial.SIGNATURE_III_P + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = hexadecimalStringToByteArray (messageString);
		
		System.out.println ("Message:\n");
		
		for (int i = 0; i < 66; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %d\t", i / 32 + 1);
					
			}
			
			System.out.printf ("%02X ", messageInput[i]);
			
			if (i % 32 == 31 || i == 66) {
					
				System.out.println ();
					
			}
				
		}
		
		System.out.println ("\n\nSignature:\n");
		
		long startSigningTimeNano	= System.nanoTime();
		QTESLA.signingIIIP (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.printf ("\nThe Length of Signature is %d and the Length of Signature Package is %d\n\n", signature.length, signatureLength[0]);

		int valid;
		int response;
		byte[] messageOutput = new byte[Polynomial.SIGNATURE_III_P + 66];
		
		System.out.println ("Test for Verifying for Provably-Secure qTESLA Security Category-3\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = QTESLA.verifyingIIIP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime();
		
		if (valid != 0) {
			
			System.out.println ("Signature Verification Failed with " + valid + "\n");
			
		} else if (messageLength[0] != 66) {
			
			System.out.println ("Verifying Returned BAD Message Length with " + messageLength[0] + " Bytes\n");
			
		}
		
		for (int i = 0; i < messageLength[0]; i++) {
			
			if (messageInput[i] != messageOutput[i]) {
				
				System.out.println ("Verifying Returned BAD Message Value with Message Input " + messageInput[i] + "and Message Output " + messageOutput[i] + "\n");
				break;
				
			}
			
		}
		
		signature[secureRandom.nextInt(32) % (Polynomial.SIGNATURE_III_P + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = QTESLA.verifyingIIIP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
		
			System.out.println ("Signature Test Passed\n");
		
		}
	}

}