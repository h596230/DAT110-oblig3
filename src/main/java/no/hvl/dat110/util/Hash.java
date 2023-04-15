package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;
		try {
			// use the MD5 hash algo
			MessageDigest md = MessageDigest.getInstance("MD5");
			// calculate the hash value of the input entity as an array of bytes
			byte[] hash = md.digest(entity.getBytes());
			// convert the byte array into a hexadecimal string representation
			String hex = toHex(hash);
			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// return BigInt hash value
		return hashint;
	}

	public static BigInteger addressSize() {
		// compute the number of bits = bitSize()
		int bits = bitSize();
		// compute the address size = 2 ^ number of bits
		BigInteger addressSize = new BigInteger("2").pow(bits);
		// return the address size
		return addressSize;
	}

	public static int bitSize() {

		int digestlen = 0;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// get len of the md5 hash digest in bytes
			digestlen = md.getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// return the bit size
		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
