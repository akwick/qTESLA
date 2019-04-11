# A Lattice-Based Digital Signature Scheme, __qTESLA__

## Tutorials of Using __qTESLA__ in Your Project

### Direct Use of the Methods in the Class __QTESLA__

1. Instantiate a __QTESLA__ object by calling the __QTESLA__ constructor with the parameter __parameterSet__ in String:
   ```
   QTESLA qTESLA = new QTESLA ("qTESLA-I");
   ```

2. Use the signature scheme:

- Key Generation

  1. Create two byte arrays for the key pairs:
  
      ```
      byte[] publicKey = new byte[qTESLA.getQTESLAParameter().publicKeySize];
      byte[] privateKey = new byte[qTESLA.getQTESLAParameter().privateKeySize];
      ```
  2. If you would like to follow the _Known-Already-Tests_ (__KAT__) in [__qTESLA__ in __Portable C__](https://github.com/qtesla/qTesla/tree/master/KAT/), you have to initialize a _random number generator_ defined in the class __RandomNumberGenerator__ on the basis of a given __seed__ in a byte array:
      
      ```
      qTESLA.getRandomNumberGenerator().initiateRandomByte (seed, null, 256);
      ```
  3. Generate the key pair (__secureRandom__ is an object instantiating the class __SecureRandom__, a class providing cryptographically strong random number generator in Java, is not used for __KAT__):
  
      ```
      qTESLA.generateKeyPair (publicKey, privateKey, secureRandom);
      ```
     Then a pair of private and public keys is generated.
     
- Signature Generation, assuming that the key pair has been available

  1. Create byte arrays for the signature and the message, and integer arrays for the length of the signature and the message respectively:
  
     ```
     byte[] signature = new byte[qTESLA.getQTESLAParameter().signatureSize + MESSAGE_SIZE];
     byte[] message = new byte[MESSAGE_SIZE];
     int[] signatureLength = new int[1];
     int[] messageLength = new int[1];
     ```
     where __MESSAGE\_SIZE__ is the size of the message to sign.
     
  2. Sign the message:
  
     ```
     qTESLA.sign (signature, 0, signatureLength, message, 0, MESSAGE_SIZE, privateKey, secureRandom);
     ```
 - Signature Verification
   ```
   valid = qTESLA.verify (messageOutput, 0, messageLength, signature, 0, signatureLength[0], publicKey);
   ```

### Indirect Use of the Methods in the Class __QTESLA__ via a __qTESLA__ provider

1. Add a __qTESLA__ provider dynamically to the current provider list:

   ```
   QTESLAProvider qTESLAProvider = new QTESLAProvider ();
   Security.addProvider (qTESLAProvider);
   ```
   
2. Use the cryptographic service of __qTESLA__ by specifying the service and the corresponding algorithm:

- Key Generation
   
  1. Instantiate a __KeyPairGenenerator__ class, extended by the class __QTESLAKeyPairGenerator__:
     
     ```
     KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance ("QTESLAKeyPairGenerator", "qTESLAProvider");
     ```
     
  2. Choose the parameter set:
  
     ```
     QTESLAParameterSpec specification = new QTESLAParameterSpec ("qTESLA-I");
     ```
     
  3. Initialize the key pair generator:
  
     ```
     keyPairGenerator.initialize (specification, secureRandom);
     ```
     
  4. Store the generated key pair in a __KeyPair__ object:
  
     ```
     KeyPair keyPair = keyPairGenerator.generateKeyPair();
     ```
     
  5. Separate the key pair to the private and public keys:
  
     ```
     QTESLAPrivateKey qTESLAPrivateKey = (QTESLAPrivateKey) keyPair.getPrivate();
     QTESLAPublicKey qTESLAPublicKey = (QTESLAPublicKey) keyPair.getPublic();
     ```
- Signature Generation

  1. Instantiate a __Signature__ class, extended by the class __QTESLASignature__:
  
     ```
     Signature qTESLASignature = Signature.getInstance ("QTESLASignature", "qTESLAProvider");
     ```
     
  2. Initialize the __Signature__ object for signing with the private key, which is a __QTESLAPrivateKey__ object:
  
     ```
     qTESLASignature.initSign (qTESLAPrivateKey, secureRandom);
     ```
     
  3. Pass the message, which will be signed, to the __Signature__ object:
  
     ```
     qTESLASignature.update (message, 0, MESSAGE_SIZE);
     ```
     
     where __message__ is a byte array to store the message to sign, __0__ is the start position of storing such a message (and can be replaced by other numbers).
     
  4. Sign the passed message:
  
     ```
     qTESLASignature.sign (signature, 0, signature.length);
     ```
     
     where __signature__ is a byte array to store the signature-relevant bytes, including the signature, __0__ is the start position of storing such signature-relevant bytes (and can be replaced by other numbers) and __signature.length__ is the size of such signature-relevant bytes.
     
- Signature Verification

  1. Instantiate a __Signature__ class, extended by the class __QTESLASignature__:
  
     ```
     Signature qTESLASignature = Signature.getInstance ("QTESLASignature", "qTESLAProvider");
     ```
     
  2. Initialize the __Signature__ object for verification with the public key, which is a __QTESLAPublicKey__ object:
  
     ```
     qTESLASignature.initVerify (qTESLAPublicKey);
     ```
     
  3. Verify the signature in the signature-relevant bytes __signature__:
  
     ```
     boolean validity = qTESLASignature.verify(signature);
     ```
     if __validity__ is __true, then valid; otherwise, invalid.
