package qTESLA;

public class Gauss {
	
	/**
	 * Chunk Size for Sampling
	 */
	public static final int CHUNK = 512;
	
	private static void differ (long[] difference, long[] array, int u, int v, int position) {
		
		difference[0] = (difference[0] + (array[v + position] & Long.MAX_VALUE) - (array[u + position] & Long.MAX_VALUE)) >> 63;
		
	}
	
	private static void swap (long[] exchange, long[] difference, long[] array, int u, int v, int position) {
		
		exchange[0]			= (array[u + position] ^ array[v + position]) & difference[0];
		array[u + position]	^= exchange[0];
		array[v + position]	^= exchange[0];
		
	}
	
	private static void swapOrder (int[] exchange, long[] difference, int[] order, int u, int v) {
		
		exchange[0]	= (order[u] ^ order[v]) & (int) difference[0];
		order[u]	^= exchange[0];
		order[v]	^= exchange[0];
		
	}
	
	private static void minimumMaximum1 (long[] exchange, long[] difference, long[] array, int u, int v) {
		
		differ (difference, array, u, v, 0);
		swap (exchange, difference, array, u, v, 0);
		
	}
	
	private static void minimumMaximum2 (long[] exchange, long[] difference, long[] array, int u, int v, int column) {
		
		if (column > 1) {
			
			differ (difference, array, u, v, 1);
			minimumMaximum1 (exchange, difference, array, u, v);
			swap (exchange, difference, array, u, v, 1);
			
		} else {
			
			minimumMaximum1 (exchange, difference, array, u, v);
			
		}
		
	}
	
	private static void minimumMaximum3 (long[] exchange, long[] difference, long[] array, int u, int v, int column) {
		
		if (column > 2) {
			
			differ (difference, array, u, v, 2);
			minimumMaximum2 (exchange, difference, array, u, v, column);
			swap (exchange, difference, array, u, v, 2);
			
		} else {
			
			minimumMaximum2 (exchange, difference, array, u, v, column);
			
		}
		
	}
	
	private static void minimumMaximum4 (long[] exchange, long[] difference, long[] array, int u, int v, int column) {
		
		if (column > 3) {
		
			differ (difference, array, u, v, 3);
			minimumMaximum3 (exchange, difference, array, u, v, column);
			swap (exchange, difference, array, u, v, 3);
		
		} else {
			
			minimumMaximum3 (exchange, difference, array, u, v, column);
			
		}
		
	}
	
	private static void minimumMaximum5 (long[] exchange, long[] difference, long[] array, int u, int v, int column) {
		
		if (column > 4) {
		
			differ (difference, array, u, v, 4);
			minimumMaximum4 (exchange, difference, array, u, v, column);
			swap (exchange, difference, array, u, v, 4);
			
		} else {
			
			minimumMaximum4 (exchange, difference, array, u, v, column);
			
		}
		
	}
	
	private static void minimumMaximum (long[] array, int uArray, int vArray, int[] order, int uOrder, int vOrder, int column) {
		
		if (column <= 5) {
			
			long[] difference		= {0};
			long[] exchangeArray	= {0};
			int[] exchangeOrder		= {0};
			
			minimumMaximum5 (exchangeArray, difference, array, uArray, vArray, column);
			swapOrder (exchangeOrder, difference, order, uOrder, vOrder);
			
		}
		
	}
	
	private static void minimumMaximumOrder (int[] order, int u, int v) {
		
		int difference	= ((order[v] & 0x7FFFFFFF) - (order[u] & 0x7FFFFFFF)) >> 31;
		int exchange	= (order[u] ^ order[v]) & difference;
		order[u]		^= exchange;
		order[v]		^= exchange;
		
	}
	
	/******************************************************************************************************************
	 * Description: Sort the Key Order Array Using Donald Ervin Knuth's Iterative Merge-Exchange Sorting.
	 * 
	 * @param	key			The Sampling Key Array to Sort in Place
	 * @param	order		The Accompanying Sampling Order Array to Sort Together
	 * @param	size		The Size of the Array
	 * @param	row			The Row Number of the Array
	 * @param	column		The Column Number of the Array
	 * 
	 * @return
	 *******************************************************************************************************************/
	private static void donaldErvinKnuthMergeExchangeKeyOrder (long[] key, int[] order, int size, int row, int column) {
		
		if (size <= 1) {
			
			return;
			
		}
		
		int counter = 1;
		
		while (counter < size - counter) {
			
			counter += counter;
			
		}
		
		for (int p = counter; p > 0; p >>>= 1) {
			
			int position	= 0;
			int positionP	= p * column;
			
			for (int i = 0; i < size - p; i++, position += column, positionP += column) {
				
				if ((i & p) == 0) {
					
					minimumMaximum (key, position, positionP, order, i, p + i, column);
					
				}
				
			}
			
			for (int q = counter; q > p; q >>>= 1) {
				
				positionP		= p * column;
				int positionQ	= q * column;
				
				for (int i = 0; i < size - q; i++, positionP += column, positionQ += column) {
					
					if ((i & p) == 0) {
						
						minimumMaximum (key, positionP, positionQ, order, p + i, q + i, column);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	/********************************************************************************************
	 * Description: Sort the Sampling Order Array Using Donald Ervin Knuth's Iterative Merge-Exchange Sorting.
	 * 
	 * @param	order		The Accompanying Sampling Order Array to Sort Together
	 * @param	size		The Size of the Array
	 * 
	 * @return
	 ********************************************************************************************/
	private static void donaldErvinKnuthMergeExchangeOrder (int[] order, int size) {
		
		if (size <= 1) {
			
			return;
			
		}
		
		int counter = 1;
		
		while (counter < size - counter) {
			
			counter += counter;
			
		}
		
		for (int p = counter; p > 0; p >>>= 1) {
			
			for (int i = 0; i < size - p; i++) {
				
				if ((i & p) == 0) {
					
					minimumMaximumOrder (order, i, p + i);
					
				}
				
			}
			
			for (int q = counter; q > p; q >>>= 1) {
				
				for (int i = 0; i < size - q; i++) {
					
					if ((i & p) == 0) {
						
						minimumMaximumOrder (order, p + i, q + i);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	/************************************************************************************************************************************************************************************
	 * Description: Generate CHUNK Samples from the Normal Distribution in Constant Time for Heuristic qTESLA Security Category 1 and Security Category 3 (Option for Size and Speed)
	 * 
	 * @param		data							Data to be Sampled
	 * @param		dataOffset						Starting Point of the Data to be Sampled
	 * @param		seed							Kappa-Bit Seed
	 * @param		seedOffset						Starting Point of the Kappa-Bit Seed
	 * @param		nonce							Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		row								The Row Number of the Array
	 * @param		column							The Column Number of the Array
	 * @param		cumulativeDistributedTable		The Cumulative Distributed Table		
	 * 
	 * @return
	 ************************************************************************************************************************************************************************************/
	private static void donaldErvinKnuthMergeExchangeGauss (int[] data, int dataOffset, byte[] seed, int seedOffset, int nonce, int row, int column, long[] cumulativeDistributedTable) {
		
		long[] samplingKeyArray		= new long[(CHUNK + row) * column];
		byte[] samplingKeyByteArray	= new byte[(CHUNK + row) * column * Byte.SIZE];
		int[] samplingOrderArray	= new int[CHUNK + row];
		
		if (column == CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I) {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (		
					samplingKeyByteArray, 0, CHUNK * column * Long.SIZE / Byte.SIZE, (short) nonce, seed, seedOffset, Parameter.RANDOM					
			);
			
		} else {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (		
					samplingKeyByteArray, 0, CHUNK * column * Long.SIZE / Byte.SIZE, (short) nonce, seed, seedOffset, Parameter.RANDOM					
			);
			
		}
		
		Common.load64 (samplingKeyByteArray, samplingKeyArray);
				
		System.arraycopy (cumulativeDistributedTable, 0, samplingKeyArray, CHUNK * column, row * column);
		
		/* Keep Track of Each Entry's Sampling Order */
		for (int i = 0; i < CHUNK; i++) {
			
			samplingOrderArray[i] = i << 16;
			
		}
		
		/* Append the Cumulative Distributed Table Gaussian Indices (Prefixed with A Sentinel) */
		for (int i = 0; i < row; i++) {
			
			samplingOrderArray[CHUNK + i] = 0xFFFF0000 ^ i;
			
		}
		
		/* Constant-Time Sorting According to the Uniformly Random Sorting Key */
		donaldErvinKnuthMergeExchangeKeyOrder (samplingKeyArray, samplingOrderArray, CHUNK + row, row, column);
		
		/* Set Each Entry's Gaussian Index */
		int previousIndex = 0;
		
		for (int i = 0; i < CHUNK + row; i++) {
			
			int currentIndex = samplingOrderArray[i] & 0x0000FFFF;
			
			previousIndex ^= (currentIndex ^ previousIndex) & ((previousIndex - currentIndex) >> 31);
			
			/* Only the Unused Most Significant Bit of the Leading Word */
			int negative = (int) (samplingKeyArray[column * i] >> 63);
			
			samplingOrderArray[i] |= ((negative & -previousIndex) ^ (~ negative & previousIndex)) & 0x0000FFFF;
			
		}
		
		/* Sort All Index Entries According to Their Sampling Order as Sorting Key */
		donaldErvinKnuthMergeExchangeOrder (samplingOrderArray, CHUNK + row);
				
		/* Discard the Trailing Entries (Corresponding to the Cumulative Distributed Table) and Sample the Signs */
		for (int i = 0; i < CHUNK; i++) {
			
			data[dataOffset + i] = (samplingOrderArray[i] << 16) >> 16;
			
		}
		
	}
	
	/*************************************************************************************************************************************************************************************
	 * Description: Generate CHUNK Samples from the Normal Distribution in Constant Time for Provably-Secure qTESLA Security Category 1 and Security Category 3
	 * 
	 * @param		data							Data to be Sampled
	 * @param		dataOffset						Starting Point of the Data to be Sampled
	 * @param		seed							Kappa-Bit Seed
	 * @param		seedOffset						Starting Point of the Kappa-Bit Seed
	 * @param		nonce							Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		row								The Row Number of the Array
	 * @param		column							The Column Number of the Array
	 * @param		cumulativeDistributedTable		The Cumulative Distributed Table		
	 * 
	 * @return
	 *************************************************************************************************************************************************************************************/
	private static void donaldErvinKnuthMergeExchangeGauss (long[] data, int dataOffset, byte[] seed, int seedOffset, int nonce, int row, int column, long[] cumulativeDistributedTable) {
		
		long[] samplingKeyArray		= new long[(CHUNK + row) * column];
		byte[] samplingKeyByteArray	= new byte[(CHUNK + row) * column * Byte.SIZE];
		int[] samplingOrderArray	= new int[CHUNK + row];
		
		if (column == CumulativeDistributedTable.CUMULATIVE_DISTRIBUTED_TABLE_COLUMN_I_P) {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK128Simple (		
					samplingKeyByteArray, 0, CHUNK * column * Long.SIZE / Byte.SIZE, (short) nonce, seed, seedOffset, Parameter.RANDOM					
			);
			
		} else {
			
			FederalInformationProcessingStandard202.customizableSecureHashAlgorithmKECCAK256Simple (		
					samplingKeyByteArray, 0, CHUNK * column * Long.SIZE / Byte.SIZE, (short) nonce, seed, seedOffset, Parameter.RANDOM					
			);
			
		}
		
		Common.load64 (samplingKeyByteArray, samplingKeyArray);
		
		System.arraycopy (cumulativeDistributedTable, 0, samplingKeyArray, CHUNK * column, row * column);
		
		/* Keep Track of Each Entry's Sampling Order */
		for (int i = 0; i < CHUNK; i++) {
			
			samplingOrderArray[i] = i << 16;
			
		}
		
		/* Append the Cumulative Distributed Table Gaussian Indices (Prefixed with A Sentinel) */
		for (int i = 0; i < row; i++) {
			
			samplingOrderArray[CHUNK + i] = 0xFFFF0000 ^ i;
			
		}
		
		/* Constant-Time Sorting According to the Uniformly Random Sorting Key */
		donaldErvinKnuthMergeExchangeKeyOrder (samplingKeyArray, samplingOrderArray, CHUNK + row, row, column);
		
		/* Set Each Entry's Gaussian Index */
		int previousIndex = 0;
		
		for (int i = 0; i < CHUNK + row; i++) {
			
			int currentIndex = samplingOrderArray[i] & 0x0000FFFF;
			
			previousIndex ^= (currentIndex ^ previousIndex) & ((previousIndex - currentIndex) >> 31);
			
			/* Only the Unused Most Significant Bit of the Leading Word */
			int negative = (int) (samplingKeyArray[column * i] >> 63);
			
			samplingOrderArray[i] |= ((negative & -previousIndex) ^ (~ negative & previousIndex)) & 0x0000FFFF;
			
		}
		
		/* Sort All Index Entries According to Their Sampling Order as Sorting Key */
		donaldErvinKnuthMergeExchangeOrder (samplingOrderArray, CHUNK + row);
		
		/* Discard the Trailing Entries (Corresponding to the Cumulative Distributed Table) and Sample the Signs */
		for (int i = 0; i < CHUNK; i++) {
			
			data[dataOffset + i] = (long) ((samplingOrderArray[i] << 16) >> 16);
			
		}
		
	}
	
	/************************************************************************************************************************************************************************************
	 * Description:	Gaussian Sampler for Heuristic qTESLA Security Category 1 and Security Category 3 (Option for Size and Speed)
	 * 
	 * @param		data						Data to be Sampled
	 * @param		dataOffset					Starting Point of the Data to be Sampled
	 * @param		seed						Kappa-Bit Seed
	 * @param		seedOffset					Starting Point of the Kappa-Bit Seed
	 * @param		nonce						Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		n							Polynomial Dimension
	 * 
	 * @return		none
	 ************************************************************************************************************************************************************************************/
	public static void polynomialGaussSampler (int[] data, int dataOffset, final byte[] seed, int seedOffset, int nonce, int n, int row, int column, long[] cumulativeDistributedTable) {
		
		int domainSeparator = nonce << 8;
		
		for (int chunk = 0; chunk < n; chunk += CHUNK) {
			
			donaldErvinKnuthMergeExchangeGauss (data, dataOffset + chunk, seed, seedOffset, domainSeparator++, row, column, cumulativeDistributedTable);
			
		}
		
	}
	
	/************************************************************************************************************************************************************************************
	 * Description:	Gaussian Sampler for for Provably-Secure qTESLA Security Category 1 and Security Category 3
	 * 
	 * @param		data						Data to be Sampled
	 * @param		dataOffset					Starting Point of the Data to be Sampled
	 * @param		seed						Kappa-Bit Seed
	 * @param		seedOffset					Starting Point of the Kappa-Bit Seed
	 * @param		nonce						Domain Separator for Error Polynomial and Secret Polynomial
	 * @param		n							Polynomial Dimension
	 * 
	 * @return		none
	 ************************************************************************************************************************************************************************************/
	public static void polynomialGaussSampler (long[] data, int dataOffset, final byte[] seed, int seedOffset, int nonce, int n, int row, int column, long[] cumulativeDistributedTable) {
		
		int domainSeparator = nonce << 8;
		
		for (int chunk = 0; chunk < n; chunk += CHUNK) {
			
			donaldErvinKnuthMergeExchangeGauss (data, dataOffset + chunk, seed, seedOffset, domainSeparator++, row, column, cumulativeDistributedTable);
			
		}
		
	}

}