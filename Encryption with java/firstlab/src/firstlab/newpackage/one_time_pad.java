package firstlab.newpackage;

import java.util.Random;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class one_time_pad {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("enter massage: ");

        String message = cin.nextLine(), temp = "", encrypt_str = "", decrypt_str = "";

        message = message.replaceAll(" ", "");

        int num_len = message.length(), index = 0, num;

        System.out.println("enter seed: ");

        int seed = cin.nextInt();

        boolean[] plain_text = new boolean[8 * num_len];
        boolean[] cipher_text = new boolean[8 * num_len];

        boolean[] rand_gen = new boolean[8 * num_len];

        boolean[] decrypt_text = new boolean[8 * num_len];
        boolean[] decrypt_msg = new boolean[8 * num_len];

        generate_random(num_len, rand_gen, seed);

        fill_bool(plain_text, message);
        encrypt(plain_text, rand_gen, cipher_text);
        index = 0;
        for (int i = 0; i < num_len; i++) {
            temp = "";
            for (int j = 0; j < 8; j++) {
                if (cipher_text[index++]) {
                    temp = temp + '1';
                } else {
                    temp = temp + '0';
                }
            }
            num = Integer.parseInt(temp, 2);
            encrypt_str = encrypt_str + (char) (num);
        }
        encrypt(cipher_text, rand_gen, decrypt_msg);
        index = 0;
        for (int i = 0; i < num_len; i++) {
            temp = "";
            for (int j = 0; j < 8; j++) {
                if (decrypt_msg[index++]) {
                    temp = temp + '1';
                } else {
                    temp = temp + '0';
                }
            }
            num = Integer.parseInt(temp, 2);
            decrypt_str = decrypt_str + (char) (num);
        }
        System.out.println("key of binarys");
        print(rand_gen, num_len);
        System.out.println("message of binarys");
        print(plain_text, num_len);
        System.out.println("XOR , encryption:");
        print(cipher_text, num_len);
        System.out.println("encrypted message");
        System.out.println(encrypt_str);
        System.out.println("decrypted message:");
        System.out.print(decrypt_str);

    }

    public static void generate_random(int n, boolean[] bool, int seed) {
        Random r = new Random();
        r.setSeed(seed);
        int Low = 1, High = 26, number, index = 0;
        String binaryString = "";
        for (int i = 0; i < n; i++) {
            number = r.nextInt();
            binaryString = String.format("%8s", Integer.toBinaryString(number)).replace(' ', '0');
            for (int j = 0; j < 8; j++) {
                if (binaryString.charAt(j) == '0') {
                    bool[index++] = false;
                } else {
                    bool[index++] = true;
                }
            }
        }
    }

    public static void fill_bool(boolean[] bool, String str) {
        int index = 0;
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp = Integer.toBinaryString(str.charAt(i));
            temp = String.format("%8s", temp).replace(' ', '0');
            for (int j = 0; j < 8; j++) {
                if (temp.charAt(j) == '0') {
                    bool[index++] = false;
                } else {
                    bool[index++] = true;
                }
            }

        }

    }

    public static void encrypt(boolean[] bool1, boolean[] bool2, boolean[] bool3) {
        for (int i = 0; i < bool1.length; i++) {
            if (bool1[i] == bool2[i]) {
                bool3[i] = false;
            } else {
                bool3[i] = true;
            }
        }
    }

    public static void print(boolean[] bool, int len) {
        int index = 0;
        String temp = "";
        for (int i = 0; i < len; i++) {
            temp = "";
            for (int j = 0; j < 8; j++) {
                if (bool[index++]) {
                    temp = temp + '1';
                } else {
                    temp = temp + '0';
                }
            }
            System.out.print(temp + " ");
        }
        System.out.println();
    }

}
