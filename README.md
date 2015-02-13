# JSON Web Token (JWT) / JSON Web Signature (JWS) 

JWT/JWS for Android. Creates and Validates signatures for JSON Objects.

[JSON Web Token]: http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html

# Installation

Add the `dbwebsignature` folder to your project.

# Usage

### Generating Tokens
```java

JSONObject objectToSign = ... // Can also be JSONArray or String

DBWebSignature signer = new DBWebSignature("mutually-derived-or-agreed-secret", new JWTAlgorithmHS512());
String token = signer.getToken(objectToSign);

```

### Verifying Tokens
```java

String tokenToVerify = "jbd6567asbsdahjbskg32y78";
JSONObject objectToVerify = ... // Can also be JSONArray or String

DBWebSignature signer = new DBWebSignature("mutually-derived-or-agreed-secret", new JWTAlgorithmHS512());
boolean validToken = signer.validateToken(tokenToVerify, objectToVerify);
```

# Algorithms

### Supported Algorithms
- HS512 (HMAC, SHA-512)
- HS256 (HMAC, SHA-256)

Additional algorithms can be added by implementing the `DBWebSignatureAlgorithm` interface.
