package firstlab;

import java.util.Scanner;

public class Playfair {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your key");
        String key = in.nextLine().replaceAll("j", "i").replaceAll(" ", "").toUpperCase();
        int vis[] = new int[128];
        System.out.println("Enter your plain Text : ");
        int chars[] = new int[25];
        char arr[][] = new char[5][5];
        int cnt = 0;
        int pointer = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cnt < key.length()) {
                    char temp = key.charAt(cnt++);
                    if(vis[(int)temp] == 1) {
                        j--;
                        continue;
                    }
                    arr[i][j] = temp;
                    vis[(int)temp] = 1;
                    int c = key.charAt(cnt - 1) - 'a';
                    if (c >= 10) {
                        c--;
                    }
                    chars[c] = 1;
                } else {
                    while (chars[pointer] == 1) {
                        pointer++;
                    }
                    char c = (char) ('a' + pointer);
                    if (c - 'a' >= 9) {
                        c++;
                    }
                    arr[i][j] = c;
                    chars[pointer] = 1;

                }
            }
        }

        String plainText = in.nextLine().replaceAll(" ", "").replaceAll("j", "i").toLowerCase();
        System.out.println("Enter 1 to encrypt , any key to decrypt");
        if (in.next().equals("1")) {
            System.out.println("Your cipher text is : " + encrypt(plainText, arr));
        } else {
            System.out.println("Your plain text is : " + decrypt(plainText, arr));
        }
    }

    public static String encrypt(String plainText, char[][] arr) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int[] fIndex = new int[2]; // index of first character in the pair
            int[] sIndex = new int[2]; // index of second character in the pair
            char fchar = '_'; //first character in the pair
            char schar = '_'; //second character in the pair
             if(i == (plainText.length() - 1) || plainText.charAt(i) == plainText.charAt(i + 1)) {
                fIndex = getIndex(plainText.charAt(i), arr);
                sIndex = getIndex('x', arr);
            }
             else{
                fIndex = getIndex(plainText.charAt(i), arr);
                sIndex = getIndex(plainText.charAt(++i), arr);
                
            }
            // same row
            if (fIndex[0] == sIndex[0]) {
                fchar = arr[fIndex[0]][(fIndex[1] + 1) % 5];
                schar = arr[sIndex[0]][(sIndex[1] + 1) % 5];
                cipherText = cipherText + fchar + schar;
                
            }
            // same col
            else if (fIndex[1] == sIndex[1]) {
                fchar = arr[(fIndex[0] + 1) % 5][fIndex[1]];
                schar = arr[(sIndex[0] + 1) % 5][sIndex[1]];
                cipherText = cipherText + fchar + schar;
            } else {
                fchar = arr[fIndex[0]][sIndex[1]];
                schar = arr[sIndex[0]][fIndex[1]];
                cipherText = cipherText + fchar + schar;
            }
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, char[][] arr) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int[] fIndex = getIndex(cipherText.charAt(i), arr);
            int[] sIndex = getIndex(cipherText.charAt(++i), arr);
            char fchar = '_';
            char schar = '_';

            if (fIndex[0] == sIndex[0]) {
                fchar = arr[fIndex[0]][(fIndex[1] + 4) % 5];
                schar = arr[sIndex[0]][(sIndex[1] + 4) % 5];
                plainText = plainText + fchar + schar;
            } else if (fIndex[1] == sIndex[1]) {
                fchar = arr[(fIndex[0] + 4) % 5][fIndex[1]];
                schar = arr[(sIndex[0] + 4) % 5][sIndex[1]];
                plainText = plainText + fchar + schar;
            } else {
                fchar = arr[fIndex[0]][sIndex[1]];
                schar = arr[sIndex[0]][fIndex[1]];
                plainText = plainText + fchar + schar;
            }
        }
        plainText = plainText.replaceAll("x", "");
        return plainText;
    }

    public static int[] getIndex(char c, char arr[][]) {
        int[] x = new int[2];
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (c == arr[i][j]) {
                    x[0] = i;
                    x[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                return x;
            }
        }
        x[0] = x[1] = -1;
        return x;
    }
}