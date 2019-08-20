package firstlab;

import java.util.Scanner;

public class VigenereCipher
{
    public static String encrypt(String text, String key)
    {
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z'){
                continue;
            }
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static String decrypt(String text, String key)
    {
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static void main(String[] args)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("String is: " );
        //String message = input.next();
        
        System.out.println("key is: " );
        //String key = input.next();
        
        String message = "what a nice day to day";
        String key = "crypto";
        
        String encryptedMsg = encrypt(message, key);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
        System.out.println((int)('A'));
        System.out.println((int)('Z'));
        System.out.println((int)('a'));
        System.out.println((int)('z'));
    }
}