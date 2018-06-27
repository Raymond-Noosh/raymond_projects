package com.raymond;;

import com.raymond.beans.Person;
import com.raymond.config.AppConfig;
import com.raymond.examples.Singleton;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!222" );
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = ctx.getBean(Person.class);
        person.setEmail("raym123@hotmail.com");
        person.setName("Raymond");

        long userId = 1;
        long workgroupId = 2;
        long projectId = 3;
        long time = 4;
        String message = "" + userId + "_" + workgroupId + "_" + projectId + "_" + time;
        String url = encryptDESede(message, "SE0ZF6j3lP6xkcmaBPclN8Qq");
        System.out.println(url);
        Singleton.getInstance();
    }

    public static String encryptDESede(String word, String key) {
        byte[] data = word.getBytes();
        String encryptedPlaintext = null;
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            SecretKey secretKey = factory.generateSecret(new DESedeKeySpec(key.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data);
            encryptedPlaintext = new String(Base64.encode(encryptedData));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedPlaintext;
    }



    public static boolean isInternalDomain(String serverName) {

        String sjcPatternString = "\\." + "sjc.noosh.com" + "$";//".sjc.noosh.com$";
        String euPatternString = "\\." + "eu\\.noosh\\.com" + "$";//".eu.noosh.com$";
        return patternMatches(sjcPatternString, serverName) || patternMatches(euPatternString, serverName);
    }

    private static boolean patternMatches(String patternString, String targetString){
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(targetString);
        return matcher.find();
    }
}
