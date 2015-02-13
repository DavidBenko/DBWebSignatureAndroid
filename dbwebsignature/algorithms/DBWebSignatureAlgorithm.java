package dbwebsignature.algorithms;

/**
 * Created by davidbenko on 2/13/15.
 */
public interface DBWebSignatureAlgorithm {
    public String getName();
    public byte[] encodePayload(String payload, String secret);
}
