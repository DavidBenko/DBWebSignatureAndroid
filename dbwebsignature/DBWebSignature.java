package anypresence.diffiehellmantestandroid.dbwebsignature;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import anypresence.diffiehellmantestandroid.dbwebsignature.algorithms.DBWebSignatureAlgorithm;

/**
 * Created by davidbenko on 2/13/15.
 */
public class DBWebSignature {

    private String _secret;
    private DBWebSignatureAlgorithm _algorithm;

    private DBWebSignature(){}

    public DBWebSignature(String secret, DBWebSignatureAlgorithm algorithm){
        _secret = secret;
        _algorithm = algorithm;
    }

    public String getToken(JSONObject payload){
        return getToken(payload.toString());
    }

    public String getToken(JSONArray payload){
        return getToken(payload.toString());
    }

    public String getToken(String payload){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("typ","JWT");
        headers.put("alg",_algorithm.getName());

        final String delimiter = ".";

        String headerSegment = encodeSegment(headers.toString());
        String bodySegment = encodeSegment(payload);
        String input = headerSegment + delimiter + bodySegment;
        String output = Base64.encodeToString(_algorithm.encodePayload(input, _secret), Base64.URL_SAFE);

        return headerSegment + delimiter + bodySegment + delimiter + output;
    }

    public boolean validateToken(String token, JSONObject payload){
        String generatedToken = getToken(payload.toString());
        return token.equals(generatedToken);
    }

    public boolean validateToken(String token, JSONArray payload){
        String generatedToken = getToken(payload.toString());
        return token.equals(generatedToken);
    }

    public boolean validateToken(String token, String payload){
        String generatedToken = getToken(payload);
        return token.equals(generatedToken);
    }

    private String encodeSegment(String segment){
        return Base64.encodeToString(segment.getBytes(), Base64.URL_SAFE);
    }
}
