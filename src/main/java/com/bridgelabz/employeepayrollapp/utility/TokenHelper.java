package com.bridgelabz.employeepayrollapp.utility;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bridgelabz.employeepayrollapp.excpetions.JWTException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hardi
 * Genration and Validation of JWT Token 
 *
 */
@Slf4j
public class TokenHelper {

	@Autowired
	private Environment environment;

	public String createJWT(String id, String issuer, String subject, long ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(environment.getProperty("token.key"));
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public Claims decodeJWT(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as expected)
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(environment.getProperty("token.key")))
					.parseClaimsJws(jwt).getBody();
			return claims;
		} catch (Exception e) {
			log.debug("Token is invalid");
			throw new JWTException(IMessage.INVALID_TOKEN_CODE, IMessage.INVALID_TOKEN);
		}

	}

}
