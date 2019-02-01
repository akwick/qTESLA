/******************************************************************************
* qTESLA: An Efficient Post-Quantum Signature Scheme Based on the R-LWE Problem
*
* Heuristic and Provably Secure qTESLA Parameters
* 
* @author Yinhua Xu
*******************************************************************************/

package qTESLA;

public final class QTESLAParameter {
	
	/**
	 * Size of A Random Number (in Byte)
	 */
	public static final int RANDOM	= 32;
	
	/**
	 * Size of A Seed (in Byte)
	 */
	public static final int SEED	= 32;
	
	/**
	 * Size of Hash Value C (in Byte) in the Signature Package
	 */
	public static final int HASH	= 32;
	
	/**
	 * Size of Hashed Message
	 */
	public static final int MESSAGE = 64;
	
	/**
	 * One of Five Heuristic and Provably Secure Security Categories
	 */
	public String securityCategory;
	
	/** 
	 * Dimension, (Dimension - 1) is the Polynomial Degree
	 */
	public int n;
	
	/**
	 * nLogarithm = Logarithm (n) / Logarithm (2)
	 */
	public int nLogarithm;
	
	/**
	 * Modulus
	 */
	public int q;
	
	/**
	 * qLogarihm = Ceil (Logarithm (q) / Logarithm (2))
	 */
	public int qLogarithm;
	
	public long qInverse;
	
	/**
	 * b Determines the Interval the Randomness is Chosen in During Signature Generation
	 */
	public int b;
	
	/**
	 * b = 2 ^ bBit - 1
	 */
	public int bBit;
	
	public int sBit;
	
	/**
	 * Number of Ring-Learning-With-Errors Samples
	 */
	public int k;
	
	/** 
	 * Number of Non-Zero Entries of Output Elements of Encoding
	 */
	public int h;
	
	/** 
	 * Number of Rounded Bits
	 */
	public int d;
	
	/** 
	 * Bound in Checking Error Polynomial (Rejection)
	 */
	public int boundE;
	
	/** 
	 * Bound in Checking Secret Polynomial (U)
	 */
	public int boundS;
	
	public int paulBarrettMultiplier;
	
	public int paulBarrettDivisor;
	
	/**
	 * The Number of Blocks Requested in the First Extendable-Output Function Call
	 */
	public int generateA;
	
	public int inverseNumberTheoreticTransform;
	
	public int r;
	
	/** 
	 * Size of the Signature Package (Z, C) (in Byte)
	 * Z is A Polynomial Bounded by B and C is the Output of A Hashed String
	 */
	public int signatureSize;
	
	/** 
	 * Size of the Public Key (in Byte) Containing seedA and Polynomial T
	 */
	public int publicKeySize;
	
	/** 
	 * Size of the Private Key (in Byte) Containing Polynomials (Secret Polynomial and Error Polynomial) and Seeds (seedA and seedY)
	 */
	public int privateKeySize;
	
	/*******************************************************
	 * qTESLA Parameter Constructor
	 * 
	 * @param securityCategory		qTESLA Security Category
	 *******************************************************/
	public QTESLAParameter (String securityCategory) {
		
		this.securityCategory = securityCategory;
		
		if (securityCategory == "qTESLA-I") {
			
			this.n = 512;
			this.nLogarithm = 9;
			this.q = 4205569;
			this.qLogarithm = 23;
			this.qInverse = 3098553343L;
			this.b = 1048575;
			this.bBit = 20;
			this.sBit = 10;
			this.k = 1;
			this.h = 30;
			this.d = 21;
			this.boundE = 1586;
			this.boundS = 1586;
			this.paulBarrettMultiplier = 1021;
			this.paulBarrettDivisor = 32;
			this.generateA = 19;
			this.inverseNumberTheoreticTransform = 113307;
			this.r = 1081347;
			this.privateKeySize = this.n * this.sBit / Byte.SIZE * 2 + SEED * 2;
			
		} else if (securityCategory == "qTESLA-III-Speed") {
			
			this.n = 1024;
			this.nLogarithm = 10;
			this.q = 8404993;
			this.qLogarithm = 24;
			this.qInverse = 4034936831L;
			this.b = 2097151;
			this.bBit = 21;
			this.sBit = 9;
			this.k = 1;
			this.h = 48;
			this.d = 22;
			this.boundE = 1147;
			this.boundS = 1233;
			this.paulBarrettMultiplier = 511;
			this.paulBarrettDivisor = 32;
			this.generateA = 38;
			this.inverseNumberTheoreticTransform = 237839;
			this.r = 15873;
			this.privateKeySize = this.n * this.sBit / Byte.SIZE * 2 + SEED * 2;
			
		} else if (securityCategory == "qTESLA-III-Size") {
			
			this.n = 1024;
			this.nLogarithm = 10;
			this.q = 4206593;
			this.qLogarithm = 23;
			this.qInverse = 4148178943L;
			this.b = 1048575;
			this.bBit = 20;
			this.sBit = 8;
			this.k = 1;
			this.h = 48;
			this.d = 21;
			this.boundE = 910;
			this.boundS = 910;
			this.paulBarrettMultiplier = 1021;
			this.paulBarrettDivisor = 32;
			this.generateA = 38;
			this.inverseNumberTheoreticTransform = 1217638;
			this.r = 35843;
			this.privateKeySize = this.n * this.sBit / Byte.SIZE * 2 + SEED * 2;
			
		} else if (securityCategory == "qTESLA-P-I") {
			
			this.n = 1024;
			this.nLogarithm = 10;
			this.q = 485978113;
			this.qLogarithm = 29;
			this.qInverse = 3421990911L;
			this.b = 2097151;
			this.bBit = 21;
			this.sBit = 8;
			this.k = 4;
			this.h = 25;
			this.d = 22;
			this.boundE = 554;
			this.boundS = 554;
			this.paulBarrettMultiplier = 1;
			this.paulBarrettDivisor = 29;
			this.generateA = 108;
			this.inverseNumberTheoreticTransform = 472064468;
			this.r = 0;
			privateKeySize = this.n + this.n * this.k + SEED * 2;
			
		} else if (securityCategory == "qTESLA-P-III") {
			
			this.n = 2048;
			this.nLogarithm = 11;
			this.q = 1129725953;
			this.qLogarithm = 31;
			this.qInverse = 861290495L;
			this.b = 8388607;
			this.bBit = 23;
			this.sBit = 8;
			this.k = 5;
			this.h = 40;
			this.d = 24;
			this.boundE = 901;
			this.boundS = 901;
			this.paulBarrettMultiplier = 15;
			this.paulBarrettDivisor = 34;
			this.generateA = 180;
			this.inverseNumberTheoreticTransform = 851423148;
			this.r = 0;
			privateKeySize = this.n + this.n * this.k + SEED * 2;
			
		} else {
			
			this.securityCategory = null;
			this.n = 1;
			this.q = 2;
			this.qLogarithm = 0;
			this.qInverse = 1;
			this.b = 0;
			this.bBit = 0;
			this.sBit = 0;
			this.k = 1;
			this.h = 0;
			this.d = 1;
			this.boundE = 0;
			this.boundS = 0;
			this.paulBarrettMultiplier = 1;
			this.paulBarrettDivisor = 1;
			this.generateA = 1;
			this.inverseNumberTheoreticTransform = 1;
			this.r = 0;
			this.privateKeySize = 1;
			
		}

		signatureSize = (n * d + 7) / 8 + HASH;
		publicKeySize = (n * k * qLogarithm + 7) / 8 + SEED;
		
	}
	
}