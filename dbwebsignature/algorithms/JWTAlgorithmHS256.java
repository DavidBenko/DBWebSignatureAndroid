package dbwebsignature.algorithms;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by davidbenko on 2/13/15.
 */
public class JWTAlgorithmHS256 implements DBWebSignatureAlgorithm {

    public JWTAlgorithmHS256(){}

    public String getName(){
        return "HS256";
    }
    public byte[] encodePayload(String payload, String secret){
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            return sha256_HMAC.doFinal(payload.getBytes());
        }
        catch(GeneralSecurityException e){
            Log.e("Error",e.getMessage(),e);
        }
        catch (UnsupportedEncodingException e){
            Log.e("Error",e.getMessage(),e);
        }

        return null;
    }
}
