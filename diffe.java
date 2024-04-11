import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private static final BigInteger P = new BigInteger("23"); // Prime modulus
    private static final BigInteger G = new BigInteger("5");  // Generator

    public static void main(String[] args) {
        // Alice's private key
        BigInteger aPrivate = generatePrivateKey();
        // Bob's private key
        BigInteger bPrivate = generatePrivateKey();

        // Alice's public key
        BigInteger aPublic = generatePublicKey(aPrivate);
        // Bob's public key
        BigInteger bPublic = generatePublicKey(bPrivate);

        // Shared secret computation by Alice
        BigInteger sharedA = generateSharedSecret(aPrivate, bPublic);
        // Shared secret computation by Bob
        BigInteger sharedB = generateSharedSecret(bPrivate, aPublic);

        // Print shared secrets (should be the same for both Alice and Bob)
        System.out.println("Shared secret computed by Alice: " + sharedA);
        System.out.println("Shared secret computed by Bob: " + sharedB);
    }

    // Method to generate a random private key
    private static BigInteger generatePrivateKey() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(8, random);
    }

    // Method to generate a public key from a private key
    private static BigInteger generatePublicKey(BigInteger privateKey) {
        return G.modPow(privateKey, P);
    }

    // Method to generate a shared secret from a private key and another party's public key
    private static BigInteger generateSharedSecret(BigInteger privateKey, BigInteger publicKey) {
        return publicKey.modPow(privateKey, P);
    }
}
