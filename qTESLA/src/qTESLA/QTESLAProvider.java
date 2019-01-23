package qTESLA;

import java.security.Provider;

public class QTESLAProvider extends Provider {

	/**
	 * Serial Version User Identity
	 */
	private static final long serialVersionUID = 8348304362615727658L;
	
	protected QTESLAProvider() {
		
		super ("qTESLAProvider", 2.3, "qTESLA Provider 2.3, An Efficient and Post-Quantum Secure Lattice-Based Signature Scheme");
		
		put ("KeyPairGenerator.QTESLAKeyPairGenerator", QTESLAKeyPairGenerator.class.getName());
		put ("Signature.QTESLASignature", QTESLASignature.class.getName());
	
	}
	
}