package com.superbrain.assist;

import com.superbrain.configuration.exception.WrongEntityApproachException;
import com.superbrain.data.environment.AESValues;
import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component public class AES {

    private final AESValues values;

    public AES(AESValues values) {
        this.values = values;
    }

    public String encrypt(String plain){

        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(Base64.getDecoder().decode(values.getSecret()),"AES"), new IvParameterSpec(Base64.getDecoder().decode(values.getIv())));

            return new String(Base64.getEncoder().encode(cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8))));
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    public String decrypt(String cypher){

        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    new SecretKeySpec(Base64.getDecoder().decode(values.getSecret()),"AES"), new IvParameterSpec(Base64.getDecoder().decode(values.getIv())));

            return new String(cipher.doFinal(Base64.getDecoder().decode(cypher)));
        }catch (IllegalArgumentException e){
            throw new WrongEntityApproachException();
        } catch (Exception e){
            throw new RuntimeException();
        }

    }

}
