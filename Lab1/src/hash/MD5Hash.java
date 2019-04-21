package hash;

        import java.io.UnsupportedEncodingException;
        import java.math.BigInteger;
        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;

public class MD5Hash {
    public static String getHash(String str) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        //String s="f78spx";
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.reset();
        //передаем в MessageDigest байты строки. Русские символы учитываются.
        m.update(str.getBytes("utf-8"));
        //получаем MD5-хеш строки без лидирующих нулей
        String s2 = new BigInteger(1,m.digest()).toString(16);
        //дополняем нулями до 32 символов, в случае необходимости
        while(s2.length() < 32 ){
            s2 = "0"+s2;
        }
        //возвращаем MD5-хеш
        return s2;
    }
}