package qTESLA;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
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
	
	public static void main (String[] args)
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException, ShortBufferException, SignatureException
	
	{
		
		/* Common Function */
		
		// testMemoryCopy ();
		// testMemoryEquivalence ();
		// testLoadShortNumber ();
		// testLoadIntegerNumber ();
		// testLoadLongNumber ();
		// testLoadLongArray ();
		// testStoreShortNumber ();
		// testStoreIntegerNumber ();
		// testStoreLongNumber ();
		// testStoreLongArray ();
		
		// testFederalInformationProcessingStandard202 ();
		
		/* Random Number Generator */
		
		// testRandomByte ();
		
		/* Y Sampler */
		
		// testSampleYI ();
		// testSampleYIIISize ();
		// testSampleYPIII ();
		
		/* Polynomial Gaussian Sampler */
		
		// testPolynomialGaussianSamplerI ();
		// testPolynomialGaussianSamplerPI ();
		// testPolynomialGaussianSamplerIIISize ();
		// testPolynomialGaussianSamplerPIII ();
		
		/* Polynomial */
		
		// testBarrettReductionIIISize ();
		// testBarrettReductionPIII ();
		// testPolynomialMultiplicationI ();
		// testPolynomialMultiplicationIIISize ();
		// testPolynomialMultiplicationPIII ();
		// testPolynomialAdditionI ();
		// testPolynomialAdditionIIISize ();
		// testPolynomialAdditionCorrectionIIISize ();
		// testPolynomialAdditionPIII ();
		// testPolynomialSubtractionCorrectionI ();
		// testPolynomialSubtractionCorrectionIIISize ();
		// testPolynomialSubtractionReductionIIISize ();
		// testPolynomialSubtractionPIII ();
		// testPolynomialUniformI ();
		// testPolynomialUniformIIISize ();
		// testPolynomialUniformPIII ();
		// testSparsePolynomialMultiplication16I ();
		// testSparsePolynomialMultiplication16IIISize ();
		// testSparsePolynomialMultiplication8 ();
		// testSparsePolynomialMultiplication32IIISize ();
		// testSparsePolynomialMultiplication32PIII ();
		
		/* Pack */
		
		// testEncodePrivateKeyI ();
		// testEncodePrivateKeyIIISize ();
		// testEncodePrivateKeyIIISpeed ();
		// testDecodePrivateKeyI ();
		// testDecodePrivateKeyIIISize ();
		// testDecodePrivateKeyIIISpeed ();
		// testPackPrivateKeyPIII ();
		// testEncodePublicKeyIIISize ();
		// testEncodePublicKeyIIISpeed ();
		// testEncodePublicKeyPI ();
		// testEncodePublicKeyPIII ();
		// testDecodePublicKeyIIISize ();
		// testDecodePublicKeyIIISpeed ();
		// testDecodePublicKeyPI ();
		// testDecodePublicKeyPIII ();
		// testEncodeSignatureI ();
		// testEncodeSignatureIIISize ();
		// testEncodeSignatureIIISpeed ();
		// testEncodeSignaturePI ();
		// testEncodeSignaturePIII ();
		// testDecodeSignatureIIISize ();
		// testDecodeSignatureIIISpeed ();
		// testDecodeSignaturePI ();
		// testDecodeSignaturePIII ();
		
		/* qTESLA */
		
		// testEncodeC ();
		// testGenerateKeyPairSigningVerifyingI ();
		// testGenerateKeyPairSigningVerifyingIIISize ();
		// testGenerateKeyPairSigningVerifyingIIISpeed ();
		// testGenerateKeyPairSigningVerifyingPI ();
		// testGenerateKeyPairSigningVerifyingPIII ();
		
		/* qTESLA Provider */
		
		// testQTESLAProviderI ();
		// testQTESLAProviderPI ();
		
	}
	
	/* Test for Memory Equivalence in Common Function */
	
	public static void testMemoryEquivalence () {
		
		System.out.println ("Test for Memory Equivalence in Common Function\n");
		
		byte[] newByteArray = new byte[8];
		
		System.arraycopy (byteArray, 2, newByteArray, 0, 8);
		
		System.out.printf ("%B\n\n", Common.memoryEqual (byteArray, 2, newByteArray, 0, 8));
		
		Arrays.fill (newByteArray, (byte) 0xAA);
		
		System.out.printf ("%B\n\n", Common.memoryEqual (byteArray, 2, newByteArray, 0, 8));
		
	}
	
	/* Test for Loading Short Number in Common Function */
	
	public static void testLoadShortNumber () {
		
		System.out.println ("Test for Loading Short Number in Common Function\n");
		
		System.out.printf ("%X\n\n", Common.load16 (byteArray, 15));
		
	}
	
	/* Test for Loading Integer Number in Common Function */
	
	public static void testLoadIntegerNumber () {
		
		System.out.println ("Test for Loading Integer Number in Common Function\n");
		
		System.out.printf ("%X\n\n", Common.load32 (byteArray, 13));
		
	}
	
	/* Test for Loading Long Number in Common Function */
	
	public static void testLoadLongNumber () {
		
		System.out.println ("Test for Loading Long Number in Common Function\n");
		
		System.out.printf ("%X\n\n", Common.load64 (byteArray, 9));
		
	}
	
	/* Test for Loading Long Number Array in Common Function */
	
	public static void testLoadLongArray () {
		
		long[] longArray = new long[2];
		
		Common.load64 (byteArray, longArray);
		
		System.out.println ("Test Load Long Number Array\n");
		
		for (int i = 0; i < 2; i++) {
			
			System.out.printf ("%016X\t", longArray[i]);
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Storing Short Number in Common Function */
	
	public static void testStoreShortNumber () {
		
		System.out.println ("Test for Storing Short Number in Common Function\n");
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		Common.store16 (newByteArray, 4, shortNumber);
		
		for (int i = 0; i < Short.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Integer Number in Common Function */
	
	public static void testStoreIntegerNumber () {
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		System.out.println ("Test for Storing Integer Number in Common Function\n");
		
		Common.store32 (newByteArray, 4, integerNumber);
		
		for (int i = 0; i < Integer.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i + 4]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Long Number in Common Function */
	
	public static void testStoreLongNumber () {
		
		System.out.println ("Test for Storing Long Number in Common Function\n");
		
		byte[] newByteArray = new byte[Long.SIZE];
		
		Common.store64 (newByteArray, 0, longNumber);
		
		for (int i = 0; i < Long.SIZE / Byte.SIZE; i++) {
			
			System.out.printf ("%02X\t", newByteArray[i]);
			
		}
		
		System.out.printf ("\n\n");
		
	}
	
	/* Test for Storing Long Number Array in Common Function */
	
	public static void testStoreLongArray () {
		
		long[] longArray = {0x1122334455667788L, 0xFFEEDDCCBBAA9988L};
		
		byte[] resultArray = new byte[16];
		
		Common.store64 (resultArray, longArray);
		
		System.out.println ("Test for Storing Long Number Array in Common Function\n");
		
		for (int i = 0; i < 16; i++) {
			
			System.out.printf ("%02X ", resultArray[i]);
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for KECCAK F1600 State Permutation in Federal Information Processing Standard 202 */
	
	public static void testFederalInformationProcessingStandard202 () {
		
		System.out.println ("Test for Federal Information Processing Standard 202\n");
		
		long[] longArray = new long[25];
		
		System.arraycopy (PolynomialProvablySecure.ZETA_P_III, 175, longArray, 0, 25);
		
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
		
		RandomNumberGenerator rng	= new RandomNumberGenerator ();
		byte[] seed					= new byte[48];
		byte[] entropyInput			= new byte[48];
		byte[] message				= new byte[3300];
		
		for (int i = 0; i < 48; i++) {
			
			entropyInput[i] = (byte) i;
			
		}
		
		Arrays.fill (message, (byte) 0);
		
		System.out.println ("Test for Random Byte in Random Number Generator");
		
		rng.initiateRandomByte (entropyInput, null, 256);
		
		for (int round = 0; round < 100; round++) {
			
			System.out.printf ("\nRound %3d\n\n\tSeed %3d\n\n\t", round + 1, round + 1);
			
			rng.randomByte (seed, 0, 48);
			
			for (int i = 0; i < 48; i++) {
			
				System.out.printf ("%02X", seed[i]);
			
			}
			
			System.out.printf ("\n\n\tMessage %3d\n\n", round + 1);
			
			rng.randomByte (message, 0, 33 * (round + 1));
			
			for (int i = 0; i < 33 * (round + 1); i++) {
				
				if (i % 33 == 0) {
					
					System.out.printf ("\tLINE %3d\t", i / 33 + 1);
					
				}
				
				System.out.printf ("%02X", message[i]);
				
				if (i % 33 == 32) {
					
					System.out.println ();
					
				}
				
			}
			
			Arrays.fill (message, 33 * (round + 1), 3300, (byte) 0);
		
		}
		
		System.out.println("\n");
		
	}
	
	/* Test for Sampling Y in Sample for Heuristic qTESLA Security Category 1 */
	
	public static void testSampleYI () {
		
		QTESLAYSampler qTESLAYSampler = new QTESLAYSampler ("qTESLA-I");
		
		int[] Y= new int[qTESLAYSampler.getQTESLAParameter().n];
		
		System.out.println ("Test for Sampling Y in Sample for Heuristic qTESLA Security Category 1\n");
		
		qTESLAYSampler.sampleY (Y, seed, 0, 16);
		
		for (int i = 0; i < qTESLAYSampler.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
			
			}
			
			System.out.printf ("%08X ", Y[i]);
			
			if (i % 8 == 7) {
			
				System.out.println ();
			
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sampling Y in Sample for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testSampleYIIISize () {
		
		QTESLAYSampler qTESLAYSampler = new QTESLAYSampler ("qTESLA-III-Size");
		int[] Y = new int[qTESLAYSampler.getQTESLAParameter().n];
		
		System.out.println ("Test for Sampling Y in Sample for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		qTESLAYSampler.sampleY (Y, seed, 0, 16);
		
		for (int i = 0; i < qTESLAYSampler.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
			
			}
			
			System.out.printf ("%08X ", Y[i]);
			
			if (i % 8 == 7) {
			
				System.out.println ();
			
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sampling Y in Sample for Provably Secure qTESLA Security Category 3 */
	
	public static void testSampleYPIII () {
		
		QTESLAYSampler qTESLAYSampler = new QTESLAYSampler ("qTESLA-P-III");
		long[] Y = new long[qTESLAYSampler.getQTESLAParameter().n];
		
		System.out.println ("Test for Sampling Y in Sample for Provably-Secure qTESLA Security Category-3\n");
		
		qTESLAYSampler.sampleY (Y, seed, 0, 16);
		
		for (int i = 0; i < qTESLAYSampler.getQTESLAParameter().n; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
			
			}
			
			System.out.printf ("%016X ", Y[i]);
			
			if (i % 4 == 3) {
			
				System.out.println ();
			
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Gaussian Sampler in Sample for Heuristic qTESLA Security Category 1 */
	
	public static void testPolynomialGaussianSamplerI () {
		
		QTESLAGaussianSampler qTESLAGaussianSampler = new QTESLAGaussianSampler ("qTESLA-I");
		
		System.out.println ("Test for Polynomial Gaussian Sampler in Sample for Heuristic qTESLA Security Category 1\n");
		
		int[] data = new int[qTESLAGaussianSampler.getN()];
		
		qTESLAGaussianSampler.polynomialGaussianSampler (data, 0, seed, 0, 128);
		
		for (int i = 0; i < qTESLAGaussianSampler.getN(); i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", data[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Gaussian Sampler in Sample for Provably Secure qTESLA Security Category 1 */
	
	public static void testPolynomialGaussianSamplerPI () {
		
		QTESLAGaussianSampler qTESLAGaussianSampler = new QTESLAGaussianSampler ("qTESLA-P-I");
		
		System.out.println ("Test for Polynomial Gaussian Sampler in Sample for Provably Secure qTESLA Security Category 1\n");
		
		long[] data	= new long[qTESLAGaussianSampler.getN()];
		
		qTESLAGaussianSampler.polynomialGaussianSampler (data, 0, seed, 0, 128);
		
		for (int i = 0; i < qTESLAGaussianSampler.getN(); i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X ", data[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Gaussian Sampler in Sample for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialGaussianSamplerIIISize () {
		
		QTESLAGaussianSampler qTESLAGaussianSampler = new QTESLAGaussianSampler ("qTESLA-III-Size");
		
		System.out.println ("Test for Polynomial Gaussian Sampler in Sample for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		int[] data = new int[qTESLAGaussianSampler.getN()];
		
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
		
		qTESLAGaussianSampler.polynomialGaussianSampler (data, 0, seedExtended, 0, 128);
		
		for (int i = 0; i < qTESLAGaussianSampler.getN(); i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", data[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Gaussian Sampler in Sample for Provably Secure qTESLA Security Category 3 */
	
	public static void testPolynomialGaussianSamplerPIII () {
		
		QTESLAGaussianSampler qTESLAGaussianSampler = new QTESLAGaussianSampler ("qTESLA-P-III");
		
		System.out.println ("Test for Polynomial Gaussian Sampler in Sample for Provably Secure qTESLA Security Category 3\n");
		
		long[] data	= new long[qTESLAGaussianSampler.getN()];
		
		qTESLAGaussianSampler.polynomialGaussianSampler (data, 0, seed, 0, 256);
		
		for (int i = 0; i < qTESLAGaussianSampler.getN(); i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X ", data[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding C in Sample for Provably Secure qTESLA Security Category 3 */
	
	public static void testEncodeC () {
		
		System.out.println ("Test for Encoding C in Sample\n");
		
		QTESLA qTESLA			= new QTESLA ("qTESLA-P-III");
		int[]	positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[]	signList		= new short[qTESLA.getQTESLAParameter().h];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 8 + 1));
			
			}
			
			System.out.printf ("%4d\t", positionList[i]);
		
			if (i % 8 == 7) {
			
				System.out.println();
			
			}
		
		}
	
		System.out.println ("\nSignature List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
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
	
	/* Test for Paul Barrett Reduction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testBarrettReductionIIISize () {
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		
		System.out.println ("Test for Paul Barrett Reduction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		System.out.printf ("%X\n\n", polynomial.paulBarrettReduction (integerNumber));
		
	}
	
	/* Test for Paul Barrett Reduction in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testBarrettReductionPIII () {
		
		Polynomial polynomial = new Polynomial ("qTESLA-P-III");
		
		System.out.println ("Test for Barrett Reduction in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		System.out.printf ("%X\n\n", polynomial.paulBarrettReduction (longNumber));
		
	}
	
	/* Test for Polynomial Multiplication in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testPolynomialMultiplicationI () {
		
		System.out.println ("Test for Polynomial Multiplication in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-I");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialMultiplication (integerArray, PolynomialHeuristic.ZETA_I, PolynomialHeuristic.ZETA_INVERSE_I);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Multiplication in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialMultiplicationIIISize () {
		
		System.out.println ("Test for Polynomial Multiplication in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialMultiplication (integerArray, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Multiplication in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testPolynomialMultiplicationIIIP () {
		
		System.out.println ("Test for Polynomial Multiplication in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-P-III");
		long[] longArray = new long[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialMultiplication (longArray, 0, PolynomialProvablySecure.ZETA_P_III, 0, PolynomialProvablySecure.ZETA_INVERSE_P_III, 0);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
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
	
	/* Test for Polynomial Addition in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testPolynomialAdditionI () {
		
		System.out.println ("Test for Polynomial Addition in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-I");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialAddition (integerArray, PolynomialHeuristic.ZETA_I, PolynomialHeuristic.ZETA_INVERSE_I);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Addition in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialAdditionIIISize () {
		
		System.out.println ("Test for Polynomial Addition in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialAddition (integerArray, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Addition with Correction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialAdditionCorrectionIIISize () {
		
		System.out.println ("Test for Polynomial Addition with Correction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialAdditionCorrection (integerArray, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Addition in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testPolynomialAdditionIIIP () {
		
		System.out.println ("Test for Polynomial Addition in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-P-III");
		long[] longArray = new long[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialAddition (longArray, 0, PolynomialProvablySecure.ZETA_P_III, 0, PolynomialProvablySecure.ZETA_INVERSE_P_III, 0);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction with Correction in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testPolynomialSubtractionCorrectionI () {
		
		System.out.println ("Test for Polynomial Subtraction with Correction in Heuristic qTESLA Security Category 1\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-I");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialSubtractionCorrection (integerArray, PolynomialHeuristic.ZETA_I, PolynomialHeuristic.ZETA_INVERSE_I);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction with Correction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialSubtractionCorrectionIIISize () {
		
		System.out.println ("Test for Polynomial Subtraction with Correction in Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialSubtractionCorrection (integerArray, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction with Peter Lawrence Montgomery Reduction in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialSubtractionReductionIIISize () {
		
		System.out.println ("Test for Polynomial Subtraction with Peter Lawrence Montgomery Reduction in Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] integerArray = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialSubtractionReduction (integerArray, PolynomialHeuristic.ZETA_III_SIZE, PolynomialHeuristic.ZETA_INVERSE_III_SIZE);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", integerArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Subtraction in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testPolynomialSubtractionPIII () {
		
		System.out.println ("Test for Polynomial Subtraction in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-P-III");
		long[] longArray = new long[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialSubtraction (longArray, 0, PolynomialProvablySecure.ZETA_P_III, 0, PolynomialProvablySecure.ZETA_INVERSE_P_III, 0);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", longArray[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Polynomial Uniform in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testPolynomialUniformI () {
		
		System.out.println ("Test for Polynomial Uniform in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-I");
		int[] A = new int[polynomial.getQTESLAParameter().n];
		
		byte[] seeds = {
			
			(byte) 0x19, (byte) 0x16, (byte) 0xEC, (byte) 0x44, (byte) 0xB5, (byte) 0x2B, (byte) 0x4B, (byte) 0xA9,
			(byte) 0x93, (byte) 0xC5, (byte) 0xFB, (byte) 0xE7, (byte) 0x05, (byte) 0x80, (byte) 0x0B, (byte) 0x2C,
			(byte) 0x07, (byte) 0x0B, (byte) 0x09, (byte) 0xCF, (byte) 0x36, (byte) 0xE0, (byte) 0x90, (byte) 0x8F,
			(byte) 0xB8, (byte) 0x9F, (byte) 0x71, (byte) 0xE2, (byte) 0xF7, (byte) 0xAD, (byte) 0x94, (byte) 0x48,
			(byte) 0x98, (byte) 0xB3, (byte) 0x05, (byte) 0x45, (byte) 0x2F, (byte) 0x9E, (byte) 0xFE, (byte) 0xA0,
			(byte) 0x23, (byte) 0x7F, (byte) 0x6B, (byte) 0xAC, (byte) 0xBE, (byte) 0x40, (byte) 0x22, (byte) 0xFC,
			(byte) 0x80, (byte) 0xE5, (byte) 0xDE, (byte) 0x2D, (byte) 0x66, (byte) 0xD3, (byte) 0x98, (byte) 0x81,
			(byte) 0x4A, (byte) 0x7C, (byte) 0x83, (byte) 0x54, (byte) 0x19, (byte) 0x43, (byte) 0x57, (byte) 0x44
			
		};
		
		polynomial.polynomialUniform (A, seeds, 0);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
				
			if (i % 8 == 0) {
					
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
					
			}
				
			System.out.printf ("%08X ", A[i]);
				
			if (i % 8 == 7) {
					
				System.out.println ();
					
			}
				
		}
			
		System.out.println ();
		
	}
	
	/* Test for Polynomial Uniform in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testPolynomialUniformIIISize () {
		
		System.out.println ("Test for Polynomial Uniform in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-III-Size");
		int[] A = new int[polynomial.getQTESLAParameter().n];
		
		polynomial.polynomialUniform (A, seed, 0);
		
		for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
				
			if (i % 8 == 0) {
					
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
					
			}
				
			System.out.printf ("%08X ", A[i]);
				
			if (i % 8 == 7) {
					
				System.out.println ();
					
			}
				
		}
			
		System.out.println ();
		
	}
	
	/* Test for Polynomial Uniform in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testPolynomialUniformPIII () {
		
		System.out.println ("Test for Polynomial Uniform in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		Polynomial polynomial = new Polynomial ("qTESLA-P-III");
		long[] A = new long[polynomial.getQTESLAParameter().n * polynomial.getQTESLAParameter().k];
		
		polynomial.polynomialUniform (A, seed, 0);
		
		for (int k = 0; k < polynomial.getQTESLAParameter().k; k++) {
			
			System.out.printf ("SAMPLE %d\n\n", (k + 1));
			
			for (int i = 0; i < polynomial.getQTESLAParameter().n; i++) {
				
				if (i % 8 == 0) {
					
					System.out.printf ("LINE %3d\t", (i / 8 + 1));
					
				}
				
				System.out.printf ("%08X ", A[i]);
				
				if (i % 8 == 7) {
					
					System.out.println ();
					
				}
				
			}
			
			System.out.println ();
			
		}
		
	}
	
	/* Test for Sparse Polynomial Multiplication of 16-Bit in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testSparsePolynomialMultiplication16I () {
		
		System.out.println ("Test for Sparse Polynomial Multiplication of 16-Bit in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-I");
		
		int[] positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[] signList	= new short[qTESLA.getQTESLAParameter().h];
		short[] secretKey	= new short[qTESLA.getQTESLAParameter().privateKeySize];
		int[] product		= new int[qTESLA.getQTESLAParameter().n];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 10 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 10 + 1));
			
			}
			
			System.out.printf ("%03X ", positionList[i]);
		
			if (i % 10 == 9) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ("\nSign List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 10 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 10 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d ", signList[i]);
			
			if (i % 10 == 9) {
			
				System.out.println ();
			
			}
		
		}
		
		System.out.println ("\nDisplay Product\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			secretKey[i] = (short) (PolynomialHeuristic.ZETA_I[i % qTESLA.getQTESLAParameter().n] & 0xFFFFL);
			
		}
		
		qTESLA.getPolynomial().sparsePolynomialMultiplication16 (product, secretKey, positionList, signList);
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", product[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
		
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sparse Polynomial Multiplication of 16-Bit in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testSparsePolynomialMultiplication16IIISize () {
		
		System.out.println ("Test for Sparse Polynomial Multiplication of 16-Bit in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-III-Size");
		int[] positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[] signList	= new short[qTESLA.getQTESLAParameter().h];
		short[] secretKey	= new short[qTESLA.getQTESLAParameter().privateKeySize];
		int[] product		= new int[qTESLA.getQTESLAParameter().n];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 16 + 1));
			
			}
			
			System.out.printf ("%03X ", positionList[i]);
		
			if (i % 16 == 15) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ("\nSign List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 16 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d ", signList[i]);
			
			if (i % 16 == 15) {
			
				System.out.println ();
			
			}
		
		}
		
		System.out.println ("\nDisplay Product\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			secretKey[i] = (short) (PolynomialHeuristic.ZETA_III_SIZE[i % qTESLA.getQTESLAParameter().privateKeySize] & 0xFFFFL);
			
		}
		
		qTESLA.getPolynomial().sparsePolynomialMultiplication16 (product, secretKey, positionList, signList);
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", product[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
		
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sparse Polynomial Multiplication of 8-Bit in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testSparsePolynomialMultiplication8 () {
		
		System.out.println ("Test for Sparse Polynomial Multiplication of 8-Bit in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-P-III");
		
		int[] positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[] signList	= new short[qTESLA.getQTESLAParameter().h];
		byte[] secretKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		long[] product		= new long[qTESLA.getQTESLAParameter().n];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 20 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 20 + 1));
			
			}
			
			System.out.printf ("%03X ", positionList[i]);
		
			if (i % 20 == 19) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ("\nSign List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 20 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 20 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d ", signList[i]);
			
			if (i % 20 == 19) {
			
				System.out.println ();
			
			}
		
		}
		
		System.out.println ("\nDisplay Product\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			secretKey[i] = (byte) (PolynomialProvablySecure.ZETA_P_III[i % qTESLA.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLA.getPolynomial().sparsePolynomialMultiplication8 (product, 0, secretKey, 0, positionList, signList);
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().n; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X ", product[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
		
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sparse Polynomial Multiplication of 32-Bit in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testSparsePolynomialMultiplication32IIISize () {
		
		System.out.println ("Test for Sparse Polynomial Multiplication of 32-Bit in Polynomial for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-III-Size");
		
		int[] positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[] signList	= new short[qTESLA.getQTESLAParameter().h];
		int[] publicKey		= new int[qTESLA.getQTESLAParameter().publicKeySize];
		int[] product		= new int[qTESLA.getQTESLAParameter().n];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 16 + 1));
			
			}
			
			System.out.printf ("%03X ", positionList[i]);
		
			if (i % 16 == 15) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ("\nSign List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 16 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d ", signList[i]);
			
			if (i % 16 == 15) {
			
				System.out.println ();
			
			}
		
		}
		
		System.out.println ("\nDisplay Product\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			publicKey[i] = (int) (PolynomialHeuristic.ZETA_III_SIZE[i % qTESLA.getQTESLAParameter().n] & 0xFFFFFFFFL);
			
		}
		
		qTESLA.getPolynomial().sparsePolynomialMultiplication32 (product, publicKey, positionList, signList);
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", product[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
		
		}
		
		System.out.println ();
		
	}
	
	/* Test for Sparse Polynomial Multiplication of 32-Bit in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testSparsePolynomialMultiplication32PIII () {
		
		System.out.println ("Test for Sparse Polynomial Multiplication of 32-Bit in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-P-III");
		
		int[] positionList	= new int[qTESLA.getQTESLAParameter().h];
		short[] signList	= new short[qTESLA.getQTESLAParameter().h];
		int[] publicKey		= new int[qTESLA.getQTESLAParameter().publicKeySize];
		long[] product		= new long[qTESLA.getQTESLAParameter().n];
		
		qTESLA.encodeC (positionList, signList, seed, 0);
		
		System.out.println ("Position List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 20 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 20 + 1));
			
			}
			
			System.out.printf ("%03X ", positionList[i]);
		
			if (i % 20 == 19) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ("\nSign List\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().h; i++) {
			
			if (i % 20 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 20 + 1));
			
			}
			
			if (signList[i] > 0) {
		
				System.out.printf ("+");
				
			}
			
			System.out.printf ("%d ", signList[i]);
			
			if (i % 20 == 19) {
			
				System.out.println ();
			
			}
		
		}
		
		System.out.println ("\nDisplay Product\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			publicKey[i] = (int) (PolynomialProvablySecure.ZETA_P_III[i % qTESLA.getQTESLAParameter().n] & 0xFFFFFFFFL);
			
		}
		
		qTESLA.getPolynomial().sparsePolynomialMultiplication32 (product, 0, publicKey, 0, positionList, signList);
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().n; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X ", product[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
		
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testEncodePrivateKeyI() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-I");
		
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		int[] secretPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		int[] errorPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		
		System.out.println ("Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		System.arraycopy (PolynomialHeuristic.ZETA_I, 0, secretPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		System.arraycopy (PolynomialHeuristic.ZETA_INVERSE_I, 0, errorPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		qTESLAPack.encodePrivateKey (privateKey, secretPolynomial, errorPolynomial, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testEncodePrivateKeyIIISize() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-III-Size");
		
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		int[] secretPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		int[] errorPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		
		System.out.println ("Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		System.arraycopy (PolynomialHeuristic.ZETA_III_SIZE, 0, secretPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		System.arraycopy (PolynomialHeuristic.ZETA_INVERSE_III_SIZE, 0, errorPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		qTESLAPack.encodePrivateKey (privateKey, secretPolynomial, errorPolynomial, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testEncodePrivateKeyIIISpeed() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-III-Speed");
		
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		int[] secretPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		int[] errorPolynomial			= new int[qTESLAPack.getQTESLAParameter().n];
		
		System.out.println ("Test for Encoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		System.arraycopy (PolynomialHeuristic.ZETA_III_SPEED, 0, secretPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		System.arraycopy (PolynomialHeuristic.ZETA_INVERSE_III_SPEED, 0, errorPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		qTESLAPack.encodePrivateKey (privateKey, secretPolynomial, errorPolynomial, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 1 */
	
	public static void testDecodePrivateKeyI() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-I");
		
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		short[] secretPolynomial		= new short[qTESLAPack.getQTESLAParameter().n];
		short[] errorPolynomial			= new short[qTESLAPack.getQTESLAParameter().n];
		byte[] hashValue				= new byte[QTESLAParameter.SEED * 2];
		
		System.out.println ("Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 1\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			privateKey[i]		= (byte) PolynomialHeuristic.ZETA_I[i % qTESLAPack.getQTESLAParameter().n];
			
		}
		
		qTESLAPack.decodePrivateKey (hashValue, secretPolynomial, errorPolynomial, privateKey);
		
		System.out.println ("Seed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED * 2; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", hashValue[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSecret Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", secretPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nError Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", errorPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
	}
	
	/* Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testDecodePrivateKeyIIISize() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-III-Size");
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		short[] secretPolynomial		= new short[qTESLAPack.getQTESLAParameter().n];
		short[] errorPolynomial			= new short[qTESLAPack.getQTESLAParameter().n];
		byte[] hashValue				= new byte[QTESLAParameter.SEED * 2];
		
		System.out.println ("Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			privateKey[i]		= (byte) PolynomialHeuristic.ZETA_III_SIZE[i % qTESLAPack.getQTESLAParameter().n];
			
		}
		
		qTESLAPack.decodePrivateKey (hashValue, secretPolynomial, errorPolynomial, privateKey);
		
		System.out.println ("Seed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED * 2; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", hashValue[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSecret Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", secretPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nError Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", errorPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
	}
	
	/* Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testDecodePrivateKeyIIISpeed() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-III-Speed");
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		short[] secretPolynomial		= new short[qTESLAPack.getQTESLAParameter().n];
		short[] errorPolynomial			= new short[qTESLAPack.getQTESLAParameter().n];
		byte[] hashValue				= new byte[QTESLAParameter.SEED * 2];
		
		System.out.println ("Test for Decoding Private Key in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			privateKey[i]		= (byte) PolynomialHeuristic.ZETA_III_SPEED[i % qTESLAPack.getQTESLAParameter().n];
			
		}
		
		qTESLAPack.decodePrivateKey (hashValue, secretPolynomial, errorPolynomial, privateKey);
		
		System.out.println ("Seed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED * 2; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", hashValue[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSecret Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", secretPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nError Polynomial\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%04X ", errorPolynomial[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
	}
	
	/* Test for Packing Private Key in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testPackPrivateKeyIIIP() {
		
		QTESLAPack qTESLAPack						= new QTESLAPack ("qTESLA-P-III");
		
		byte[] privateKey				= new byte[qTESLAPack.getQTESLAParameter().privateKeySize];
		long[] secretPolynomial			= new long[qTESLAPack.getQTESLAParameter().n];
		long[] errorPolynomial			= new long[qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k];
		
		System.out.println ("Test for Packing Private Key in Polynomial for Provably-Secure qTESLA Security Category 3\n");
		
		System.arraycopy (PolynomialProvablySecure.ZETA_P_III, 0, secretPolynomial, 0, qTESLAPack.getQTESLAParameter().n);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().k; i++) {
			
			System.arraycopy (PolynomialProvablySecure.ZETA_INVERSE_P_III, 0, errorPolynomial, qTESLAPack.getQTESLAParameter().n * i, qTESLAPack.getQTESLAParameter().n);
			
		}
		
		qTESLAPack.packPrivateKey (privateKey, secretPolynomial, errorPolynomial, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Public Key in Pack for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testEncodePublicKeyIIISize () {
		
		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLAPack qTESLAPack					= new QTESLAPack ("qTESLA-III-Size");
		byte[] publicKey			= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		
		qTESLAPack.encodePublicKey (publicKey, PolynomialHeuristic.ZETA_III_SIZE, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println (); 
		
	}
	
	/* Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testEncodePublicKeyIIISpeed () {
		
		System.out.println ("Test for Encoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		QTESLAPack qTESLAPack					= new QTESLAPack ("qTESLA-III-Speed");
		byte[] publicKey 			= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		
		qTESLAPack.encodePublicKey (publicKey, PolynomialHeuristic.ZETA_III_SPEED, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println (); 
		
	}
	
	/* Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category 1 */
	
	public static void testEncodePublicKeyPI () {
		
		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category 1\n");
		
		QTESLAPack qTESLAPack					= new QTESLAPack ("qTESLA-P-I");
		long[] T					= new long[qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k];
		byte[] publicKey			= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		
		for (int k = 0; k < qTESLAPack.getQTESLAParameter().k; k++) {
		
			System.arraycopy (PolynomialProvablySecure.ZETA_P_I, 0, T, qTESLAPack.getQTESLAParameter().n * k, qTESLAPack.getQTESLAParameter().n);
		
		}
		
		qTESLAPack.encodePublicKey (publicKey, T, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println (); 
		
	}
	
	/* Test for Encoding Public Key in QTESLA for Provably Secure qTESLA Security Category 3 */
	
	public static void testEncodePublicKeyPIII () {
		
		System.out.println ("Test for Encoding Public Key in QTESLA for Provably-Secure qTESLA Security Category 3\n");
		
		QTESLAPack qTESLAPack					= new QTESLAPack ("qTESLA-P-III");
		long[] T					= new long[qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k];
		byte[] publicKey			= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		
		for (int k = 0; k < qTESLAPack.getQTESLAParameter().k; k++) {
		
			System.arraycopy (PolynomialProvablySecure.ZETA_P_III, 0, T, qTESLAPack.getQTESLAParameter().n * k, qTESLAPack.getQTESLAParameter().n);
		
		}
		
		qTESLAPack.encodePublicKey (publicKey, T, seed, 0);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println (); 
		
	}
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testDecodePublicKeyIIISize () {
		
		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLAPack qTESLAPack				= new QTESLAPack ("qTESLA-III-Size");
		
		byte[] publicKeyInput	= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		int[] publicKey			= new int[qTESLAPack.getQTESLAParameter().n];
		byte[] seedA			= new byte[QTESLAParameter.SEED];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			publicKeyInput[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
		
		}
		
		qTESLAPack.decodePublicKey (publicKey, seedA, 0, publicKeyInput);

		System.out.println ("Public Key in Integer\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%06X ", publicKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSeed\n");
	
		for (int i = 0; i < QTESLAParameter.SEED; i++) {
	
			System.out.printf ("%02X ", seedA[i]);
	
		}
		
	}
	
	/* Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testDecodePublicKeyIIISpeed () {
		
		System.out.println ("Test for Decoding Public Key in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		QTESLAPack qTESLAPack				= new QTESLAPack ("qTESLA-III-Speed");
		
		byte[] publicKeyInput	= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		int[] publicKey			= new int[qTESLAPack.getQTESLAParameter().n];
		byte[] seedA			= new byte[QTESLAParameter.SEED];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
		
			publicKeyInput[i] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodePublicKey (publicKey, seedA, 0, publicKeyInput);

		System.out.println ("Public Key in Integer\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 16 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 16 + 1));
				
			}
			
			System.out.printf ("%06X\t", publicKey[i]);
			
			if (i % 16 == 15) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSeed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED; i++) {
		
			System.out.printf ("%02X ", seedA[i]);
		
		}
		
	}
	
	/* Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category 1 */
	
	public static void testDecodePublicKeyPI () {
		
		System.out.println ("Test for Decoding Public Key in QTESLA for Provably-Secure qTESLA Security Category 1\n");
		
		QTESLAPack qTESLAPack				= new QTESLAPack ("qTESLA-P-I");
		
		byte[] publicKeyInput	= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		int[] publicKey			= new int[qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k];
		byte[] seedA			= new byte[QTESLAParameter.SEED];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
			
			publicKeyInput[i] = (byte) (PolynomialProvablySecure.ZETA_P_I[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
		
		}
		
		qTESLAPack.decodePublicKey (publicKey, seedA, 0, publicKeyInput);
		
		System.out.println ("Public Key in Integer\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", publicKey[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSeed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED; i++) {
			
			System.out.printf ("%02X ", seedA[i]);
			
		}
		
	}
	
	/* Test for Decoding Public Key in QTESLA for Provably Secure qTESLA Security Category 3 */
	
	public static void testDecodePublicKeyPIII () {
		
		System.out.println ("Test for Decoding Public Key in QTESLA for Provably Secure qTESLA Security Category 3\n");
		
		QTESLAPack qTESLAPack				= new QTESLAPack ("qTESLA-P-III");
		
		byte[] publicKeyInput	= new byte[qTESLAPack.getQTESLAParameter().publicKeySize];
		int[] publicKey			= new int[qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k];
		byte[] seedA			= new byte[QTESLAParameter.SEED];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().publicKeySize; i++) {
		
			publicKeyInput[i] = (byte) (PolynomialProvablySecure.ZETA_P_III[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodePublicKey (publicKey, seedA, 0, publicKeyInput);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n * qTESLAPack.getQTESLAParameter().k; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", publicKey[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ("\nSeed\n");
		
		for (int i = 0; i < QTESLAParameter.SEED; i++) {
			
			System.out.printf ("%02X ", seedA[i]);
			
		}
		
	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 1 */
	
	public static void testEncodeSignatureI () {
		
		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 1\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-I");
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		qTESLAPack.encodeSignature (signature, 0, seed, 0, PolynomialHeuristic.ZETA_I);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testEncodeSignatureIIISize () {
		
		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-III-Size");
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		qTESLAPack.encodeSignature (signature, 0, seed, 0, PolynomialHeuristic.ZETA_III_SIZE);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testEncodeSignatureIIISpeed () {
		
		System.out.println ("Test for Encoding Signature in QTESLA for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-III-Speed");
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		qTESLAPack.encodeSignature (signature, 0, seed, 0, PolynomialHeuristic.ZETA_III_SPEED);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Signature in Polynomial for Provably Secure qTESLA Security Category 1 */
	
	public static void testEncodeSignaturePI () {
		
		System.out.println ("Test for Encoding Signature in Polynomial for Provably Secure qTESLA Security Category 1\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-P-I");
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		qTESLAPack.encodeSignature (signature, 0, seed, 0, PolynomialProvablySecure.ZETA_P_I);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Encoding Signature in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testEncodeSignaturePIII () {
		
		System.out.println ("Test for Encoding Signature in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-P-III");
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		qTESLAPack.encodeSignature (signature, 0, seed, 0, PolynomialProvablySecure.ZETA_P_III);
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
				
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Decoding Signature in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testDecodeSignatureIIISize () {
		
		System.out.println ("Test for Decoding Signature in Polynomial for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-III-Size");
		int[] Z				= new int[qTESLAPack.getQTESLAParameter().n];
		byte[] C			= new byte[QTESLAParameter.HASH];
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
				
			signature[i] = (byte) (PolynomialHeuristic.ZETA_III_SIZE[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodeSignature (C, Z, signature, 0);
		
		System.out.println ("\nDisplay C\n");
		
		for (int i = 0; i < QTESLAParameter.HASH; i++) {
			
			System.out.printf ("%02X ", C[i]);
			
		}
		
		System.out.println ("\n\nDisplay Z\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 8 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
				
			}
			
			System.out.printf ("%08X ", Z[i]);
			
			if (i % 8 == 7) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Decoding Signature in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testDecodeSignatureIIISpeed () {
		
		System.out.println ("Test for Decoding Signature in Polynomial for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-III-Speed");
		int[] Z				= new int[qTESLAPack.getQTESLAParameter().n];
		byte[] C			= new byte[QTESLAParameter.HASH];
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {

			signature[i] = (byte) (PolynomialHeuristic.ZETA_III_SPEED[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodeSignature (C, Z, signature, 0);
		
		System.out.println ("\nDisplay C\n");
		
		for (int i = 0; i < QTESLAParameter.HASH; i++) {
			
			System.out.printf ("%02X ", C[i]);
			
		}
		
		System.out.println ("\n\nDisplay Z\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
		
			if (i % 8 == 0) {
			
				System.out.printf ("LINE %3d\t", (i / 8 + 1));
			
			}
		
			System.out.printf ("%08X ", Z[i]);
		
			if (i % 8 == 7) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ();
		
	}
	
	/* Test for Decoding Signature in Polynomial for Provably Secure qTESLA Security Category 1 */
	
	public static void testDecodeSignaturePI () {
		
		System.out.println ("Test for Decoding Signature in Polynomial for Provably Secure qTESLA Security Category 1\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-P-I");
		long[] Z			= new long[qTESLAPack.getQTESLAParameter().n];
		byte[] C			= new byte[QTESLAParameter.HASH];
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {

			signature[i] = (byte) (PolynomialProvablySecure.ZETA_P_I[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodeSignature (C, Z, signature, 0);
		
		System.out.println ("\nDisplay C\n");
		
		for (int i = 0; i < QTESLAParameter.HASH; i++) {
			
			System.out.printf ("%02X ", C[i]);
			
		}
		
		System.out.println ("\n\nDisplay Z\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
		
			if (i % 4 == 0) {
			
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
			
			}
		
			System.out.printf ("%016X ", Z[i]);
		
			if (i % 4 == 3) {
			
				System.out.println ();
			
			}
		
		}
	
		System.out.println ();
		
	}
	
	/* Test for Decoding Signature in Polynomial for Provably Secure qTESLA Security Category 3 */
	
	public static void testDecodeSignaturePIII () {
		
		System.out.println ("Test for Decoding Signature in Polynomial for Provably Secure qTESLA Security Category 3\n");
		
		QTESLAPack qTESLAPack			= new QTESLAPack ("qTESLA-P-III");
		long[] Z			= new long[qTESLAPack.getQTESLAParameter().n];
		byte[] C			= new byte[QTESLAParameter.HASH];
		byte[] signature	= new byte[qTESLAPack.getQTESLAParameter().signatureSize];
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().signatureSize; i++) {
		
			signature[i] = (byte) (PolynomialProvablySecure.ZETA_P_III[i % qTESLAPack.getQTESLAParameter().n] & 0xFFL);
			
		}
		
		qTESLAPack.decodeSignature (C, Z, signature, 0);
		
		System.out.println ("\nDisplay C\n");
		
		for (int i = 0; i < QTESLAParameter.HASH; i++) {
			
			System.out.printf ("%02X ", C[i]);
			
		}
		
		System.out.println ("\n\nDisplay Z\n");
		
		for (int i = 0; i < qTESLAPack.getQTESLAParameter().n; i++) {
			
			if (i % 4 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 4 + 1));
				
			}
			
			System.out.printf ("%016X ", Z[i]);
			
			if (i % 4 == 3) {
				
				System.out.println ();
				
			}
			
		}
		
		System.out.println ();
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category-1 */
	
	public static void testGenerateKeyPairSigningVerifyingI ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category-1\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-I");
		
		byte[] publicKey	= new byte[qTESLA.getQTESLAParameter().publicKeySize];
		byte[] privateKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		byte[] seed			= new byte[48];
		String seedString 	= "64335BF29E5DE62842C941766BA129B0643B5E7121CA26CFC190EC7DC3543830557FDD5C03CF123A456D48EFEA43C868";
		
		int timeOfTest = 5000;
		
		double[] timeOfGeneratingKeyPair = new double[timeOfTest];
		double[] timeOfSigning = new double[timeOfTest];
		double[] timeOfVerifying = new double[timeOfTest];
		
		seed = Common.hexadecimalStringToByteArray (seedString);
		
		for (int round = 0; round < timeOfTest; round++) {
		
		qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime ();
		qTESLA.generateKeyPair (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime ();
		/*
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category 1\n");
		*/
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		/*
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
		*/
		long startSigningTimeNano	= System.nanoTime ();
		qTESLA.sign (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime ();
		/*
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
		*/
		int valid;
		int response;
		byte[] messageOutput = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		
		// System.out.println ("Test for Verifying for Heuristic qTESLA Security Category 1\n");
		
		long startVerifyingTimeNano1	= System.nanoTime ();
		valid = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano1		= System.nanoTime ();
		
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
		
		signature[secureRandom.nextInt(32) % (qTESLA.getQTESLAParameter().signatureSize + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime ();
		response = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime ();
		
		timeOfGeneratingKeyPair[round] = (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		timeOfSigning[round] = (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		timeOfVerifying[round] = (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 3);
		// System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		// System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		/*
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		*/
		}
		
		System.out.printf ("Key Generation Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfGeneratingKeyPair), Common.averageNumber(timeOfGeneratingKeyPair));
		
		System.out.printf ("Signing Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfSigning), Common.averageNumber(timeOfSigning));
		
		System.out.printf ("Verification Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfVerifying), Common.averageNumber(timeOfVerifying));
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category 3 (Option for Size) */
	
	public static void testGenerateKeyPairSigningVerifyingIIISize ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-III-Size");
		byte[] publicKey	= new byte[qTESLA.getQTESLAParameter().publicKeySize];
		byte[] privateKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		byte[] seed			= new byte[48];
		String seedString 	= "64335BF29E5DE62842C941766BA129B0643B5E7121CA26CFC190EC7DC3543830557FDD5C03CF123A456D48EFEA43C868";
		
		int timeOfTest = 5000;
		
		double[] timeOfGeneratingKeyPair = new double[timeOfTest];
		double[] timeOfSigning = new double[timeOfTest];
		double[] timeOfVerifying = new double[timeOfTest];
		
		seed = Common.hexadecimalStringToByteArray (seedString);
		
		for (int round = 0; round < timeOfTest; round++) {
		
		qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		qTESLA.generateKeyPair (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		/*
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category 3 (Option for Size)\n");
		*/
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		/*
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
		*/
		long startSigningTimeNano	= System.nanoTime();
		qTESLA.sign (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		/*
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
		*/
		int valid;
		int response;
		byte[] messageOutput = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		
		// System.out.println ("Test for Verifying for Heuristic qTESLA Security Category-3 (Option for Size)\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
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
		
		signature[secureRandom.nextInt(32) % (qTESLA.getQTESLAParameter().signatureSize + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		timeOfGeneratingKeyPair[round] = (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		timeOfSigning[round] = (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		timeOfVerifying[round] = (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 3);
		// System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		// System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		/*
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		*/
		}
		
		System.out.printf ("Key Generation Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfGeneratingKeyPair), Common.averageNumber(timeOfGeneratingKeyPair));
		
		System.out.printf ("Signing Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfSigning), Common.averageNumber(timeOfSigning));
		
		System.out.printf ("Verification Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfVerifying), Common.averageNumber(timeOfVerifying));
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Heuristic qTESLA Security Category 3 (Option for Speed) */
	
	public static void testGenerateKeyPairSigningVerifyingIIISpeed ()
			
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-III-Speed");
		byte[] publicKey	= new byte[qTESLA.getQTESLAParameter().publicKeySize];
		byte[] privateKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		byte[] seed			= new byte[48];
		String seedString 	= "64335BF29E5DE62842C941766BA129B0643B5E7121CA26CFC190EC7DC3543830557FDD5C03CF123A456D48EFEA43C868";
		
		int timeOfTest = 5000;
		
		double[] timeOfGeneratingKeyPair = new double[timeOfTest];
		double[] timeOfSigning = new double[timeOfTest];
		double[] timeOfVerifying = new double[timeOfTest];
		
		seed = Common.hexadecimalStringToByteArray (seedString);
		
		for (int round = 0; round < timeOfTest; round++) {
		
		qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		qTESLA.generateKeyPair (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		/*
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		*/
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		/*
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
		*/
		long startSigningTimeNano	= System.nanoTime();
		qTESLA.sign (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		/*
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
		*/
		int valid;
		int response;
		byte[] messageOutput = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		
		// System.out.println ("Test for Verifying for Heuristic qTESLA Security Category 3 (Option for Speed)\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
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
		
		signature[secureRandom.nextInt(32) % (qTESLA.getQTESLAParameter().signatureSize + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		timeOfGeneratingKeyPair[round] = (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		timeOfSigning[round] = (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		timeOfVerifying[round] = (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 3);
		// System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		// System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		/*
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
			
			System.out.println ("Signature Tests Passed\n");
		
		}
		*/
		}
		
		System.out.printf ("Key Generation Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfGeneratingKeyPair), Common.averageNumber(timeOfGeneratingKeyPair));
		
		System.out.printf ("Signing Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfSigning), Common.averageNumber(timeOfSigning));
		
		System.out.printf ("Verification Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfVerifying), Common.averageNumber(timeOfVerifying));
		
	}
	
	/* Test for Generation of the Key Pair, Signing and Verifying for Provably Secure qTESLA Security Category 1 */
	
	public static void testGenerateKeyPairSigningVerifyingPI ()
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Provably Secure qTESLA Security Category 1\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-P-I");
		byte[] publicKey	= new byte[qTESLA.getQTESLAParameter().publicKeySize];
		byte[] privateKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		byte[] seed			= new byte[48];
		String seedString 	= "64335BF29E5DE62842C941766BA129B0643B5E7121CA26CFC190EC7DC3543830557FDD5C03CF123A456D48EFEA43C868";
		
		int timeOfTest = 5000;
		
		double[] timeOfGeneratingKeyPair = new double[timeOfTest];
		double[] timeOfSigning = new double[timeOfTest];
		double[] timeOfVerifying = new double[timeOfTest];
		
		seed = Common.hexadecimalStringToByteArray (seedString);
		
		for (int round = 0; round < timeOfTest; round++) {
		
		qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		qTESLA.generateKeyPairP (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		/*
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Provably Secure qTESLA Security Category 1\n");
		*/
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		/*
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
		*/
		long startSigningTimeNano	= System.nanoTime();
		qTESLA.signP (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		/*
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
		*/
		int valid;
		int response;
		byte[] messageOutput = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		
		// System.out.println ("Test for Verifying for Provably-Secure qTESLA Security Category 1\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = qTESLA.verifyP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
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
		
		signature[secureRandom.nextInt(32) % (qTESLA.getQTESLAParameter().signatureSize + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = qTESLA.verifyP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		timeOfGeneratingKeyPair[round] = (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		timeOfSigning[round] = (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		timeOfVerifying[round] = (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 3);
		// System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		// System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		/*
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
		
			System.out.println ("Signature Test Passed\n");
		
		}
		*/
		}
		
		System.out.printf ("Key Generation Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfGeneratingKeyPair), Common.averageNumber(timeOfGeneratingKeyPair));
		
		System.out.printf ("Signing Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfSigning), Common.averageNumber(timeOfSigning));
		
		System.out.printf ("Verification Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfVerifying), Common.averageNumber(timeOfVerifying));
		
	}

	
	/* Test for Generation of the Key Pair, Signing and Verifying for Provably Secure qTESLA Security Category 3 */
	
	public static void testGenerateKeyPairSigningVerifyingPIII ()
	
			throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException {
		
		System.out.println ("Test for Generation of the Key Pair for Provably-Secure qTESLA Security Category 3\n");
		
		QTESLA qTESLA		= new QTESLA ("qTESLA-P-III");
		byte[] publicKey	= new byte[qTESLA.getQTESLAParameter().publicKeySize];
		byte[] privateKey	= new byte[qTESLA.getQTESLAParameter().privateKeySize];
		byte[] seed			= new byte[48];
		String seedString 	= "64335BF29E5DE62842C941766BA129B0643B5E7121CA26CFC190EC7DC3543830557FDD5C03CF123A456D48EFEA43C868";
		
		int timeOfTest = 5000;
		
		double[] timeOfGeneratingKeyPair = new double[timeOfTest];
		double[] timeOfSigning = new double[timeOfTest];
		double[] timeOfVerifying = new double[timeOfTest];
		
		seed = Common.hexadecimalStringToByteArray (seedString);
		
		for (int round = 0; round < timeOfTest; round++) {
		
		qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
		
		long startGeneratingKeyPairTimeNano	= System.nanoTime();
		qTESLA.generateKeyPairP (publicKey, privateKey, secureRandom);
		long endGeneratingKeyPairTimeNano	= System.nanoTime();
		
		/*
		System.out.println ("Public Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().publicKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %4d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPrivate Key:\n");
		
		for (int i = 0; i < qTESLA.getQTESLAParameter().privateKeySize; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nTest for Signing for Provably-Secure qTESLA Security Category 3\n");
		*/
		int[] signatureLength = new int[1];
		int[] messageLength = new int[1];
		byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		byte[] messageInput = new byte[66];
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		/*
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
		*/
		long startSigningTimeNano	= System.nanoTime();
		qTESLA.signP (signature, 0, signatureLength, messageInput, 0, 66, privateKey, secureRandom);
		long endSigningTimeNano		= System.nanoTime();
		/*
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
		*/
		int valid;
		int response;
		byte[] messageOutput = new byte[qTESLA.getQTESLAParameter().signatureSize + 66];
		
		// System.out.println ("Test for Verifying for Provably Secure qTESLA Security Category 3\n");
		
		long startVerifyingTimeNano1	= System.nanoTime();
		valid = qTESLA.verifyP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
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
		
		signature[secureRandom.nextInt(32) % (qTESLA.getQTESLAParameter().signatureSize + 66)] ^= 1;
		
		long startVerifyingTimeNano2	= System.nanoTime();
		response = qTESLA.verifyP (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
		long endVerifyingTimeNano2		= System.nanoTime();
		
		timeOfGeneratingKeyPair[round] = (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Generating key pair spent %f milliseconds\n\n", (endGeneratingKeyPairTimeNano - startGeneratingKeyPairTimeNano) / Math.pow (10, 6));
		timeOfSigning[round] = (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 3);
		// System.out.printf ("Signing spent %f milliseconds\n\n", (endSigningTimeNano - startSigningTimeNano) / Math.pow (10, 6));
		timeOfVerifying[round] = (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 3);
		// System.out.printf ("Verifying spent %f milliseconds\n\n", (endVerifyingTimeNano1 - startVerifyingTimeNano1) / Math.pow (10, 6));
		// System.out.printf ("After changing signature verifying spent %f milliseconds\n\n", (endVerifyingTimeNano2 - startVerifyingTimeNano2) / Math.pow (10, 6));
		/*
		if (response == 0) {
			
			System.out.println ("Corrupted Signature Verified with " + response + "\n");
			
		} else {
		
			System.out.println ("Signature Test Passed\n");
		
		}
		*/
		}
		
		System.out.printf ("Key Generation Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfGeneratingKeyPair), Common.averageNumber(timeOfGeneratingKeyPair));
		
		System.out.printf ("Signing Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfSigning), Common.averageNumber(timeOfSigning));
		
		System.out.printf ("Verification Time: Median number: %f microseconds, average number: %f microseconds\n\n", 
				Common.medianNumber(timeOfVerifying), Common.averageNumber(timeOfVerifying));
	
	}
	
	/* Test for qTESLA Provider for Heuristic qTESLA Security Category 1 */
	
	public static void testQTESLAProviderI () 
			
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException {
		
		Security.addProvider (new QTESLAProvider ());
		
		for (Provider provider: Security.getProviders()) {
			
			if (provider.getName().equals ("qTESLAProvider")) {
				
				System.out.println ("A Provider is Found: " + provider.getInfo() + "\n");
				
				for (Service service: provider.getServices()) {
					
					System.out.println ("Service: " + service);
					
				}
				
			}
			
		}
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance ("QTESLAKeyPairGenerator", "qTESLAProvider");
		QTESLAParameterSpec specification = new QTESLAParameterSpec ("qTESLA-I");
		keyPairGenerator.initialize (specification, secureRandom);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		QTESLAPrivateKey qTESLAPrivateKey = (QTESLAPrivateKey) keyPair.getPrivate();
		QTESLAPublicKey qTESLAPublicKey = (QTESLAPublicKey) keyPair.getPublic();
		byte[] privateKey = qTESLAPrivateKey.getEncoded();
		byte[] publicKey = qTESLAPublicKey.getEncoded();
		
		System.out.println ("Private Key for Heuristic qTESLA Security Category 1\n");
		
		for (int i = 0; i < privateKey.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31 || i == privateKey.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPublic Key for Heuristic qTESLA Security Category 1\n");
		
		for (int i = 0; i < publicKey.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31 || i == publicKey.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nSign for Heuristic qTESLA Security Category 1\n");
		
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		byte[] messageInput = new byte[66];
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		
		Signature qTESLASignature = Signature.getInstance ("QTESLASignature", "qTESLAProvider");
		qTESLASignature.initSign (qTESLAPrivateKey, secureRandom);
		qTESLASignature.update (messageInput, 0, 66);

		QTESLAParameter parameter = new QTESLAParameter ("qTESLA-I");
		
		byte[] signature = new byte[parameter.signatureSize + 66];
		
		qTESLASignature.sign (signature, 0, signature.length);
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %2d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nVerify for Heuristic qTESLA Security Category 1\n");
		
		qTESLASignature.initVerify (qTESLAPublicKey);
		
		if (qTESLASignature.verify(signature) == true) {
			
			System.out.println ("The Signature Is Valid\n");
			
		} else {
			
			System.out.println ("The Signature Is Invalid\n");
			
		}
		
	}
	
	/* Test for qTESLA Provider for Provably Secure qTESLA Security Category 1 */
	
	public static void testQTESLAProviderPI () 
			
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException {
		
		Security.addProvider (new QTESLAProvider ());
		
		for (Provider provider: Security.getProviders()) {
			
			if (provider.getName().equals ("qTESLAProvider")) {
				
				System.out.println ("A Provider is Found: " + provider.getInfo() + "\n");
				
				for (Service service: provider.getServices()) {
					
					System.out.println ("Service: " + service);
					
				}
				
			}
			
		}
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance ("QTESLAKeyPairGenerator", "qTESLAProvider");
		QTESLAParameterSpec specification = new QTESLAParameterSpec ("qTESLA-P-I");
		keyPairGenerator.initialize (specification, secureRandom);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		QTESLAPrivateKey qTESLAPrivateKey = (QTESLAPrivateKey) keyPair.getPrivate();
		QTESLAPublicKey qTESLAPublicKey = (QTESLAPublicKey) keyPair.getPublic();
		byte[] privateKey = qTESLAPrivateKey.getEncoded();
		byte[] publicKey = qTESLAPublicKey.getEncoded();
		
		System.out.println ("Private Key for Provably Secure qTESLA Security Category 1\n");
		
		for (int i = 0; i < privateKey.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", privateKey[i]);
			
			if (i % 32 == 31 || i == privateKey.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nPublic Key for Provably-Secure qTESLA Security Category 1\n");
		
		for (int i = 0; i < publicKey.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", publicKey[i]);
			
			if (i % 32 == 31 || i == publicKey.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nSign for Provably Secure qTESLA Security Category 1\n");
		
		String messageString =
				"225D5CE2CEAC61930A07503FB59F7C2F936A3E075481DA3CA299A80F8C5DF9223A073E7B90E02EBF98CA2227EBA38C1AB2568209E46DBA961869C6F83983B17DCD49";
		byte[] messageInput = new byte[66];
		messageInput = Common.hexadecimalStringToByteArray (messageString);
		
		Signature qTESLASignature = Signature.getInstance ("QTESLASignature", "qTESLAProvider");
		qTESLASignature.initSign (qTESLAPrivateKey, secureRandom);
		qTESLASignature.update (messageInput, 0, 66);
		
		QTESLAParameter parameter = new QTESLAParameter ("qTESLA-P-I");
		
		byte[] signature = new byte[parameter.signatureSize + 66];
		
		qTESLASignature.sign (signature, 0, signature.length);
		
		for (int i = 0; i < signature.length; i++) {
			
			if (i % 32 == 0) {
				
				System.out.printf ("LINE %3d\t", (i / 32 + 1));
			
			}
			
			System.out.printf ("%02X ", signature[i]);
			
			if (i % 32 == 31 || i == signature.length - 1) {
				
				System.out.println ();
			
			}
			
		}
		
		System.out.println ("\nVerify for Provably-Secure qTESLA Security Category 1\n");
		
		qTESLASignature.initVerify (qTESLAPublicKey);
		
		if (qTESLASignature.verify(signature) == true) {
			
			System.out.println ("The Signature Is Valid\n");
			
		} else {
			
			System.out.println ("The Signature Is Invalid\n");
			
		}
		
	}

}