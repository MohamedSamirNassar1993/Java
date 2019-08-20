package firstlab.newpackage;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author Eslam 7amdy
 */
public class DES {

    public static int[][] matrix_pc1 = {
        {57, 49, 41, 33, 25, 17, 9},
        {1, 58, 50, 42, 34, 26, 18},
        {10, 2, 59, 51, 43, 35, 27},
        {19, 11, 3, 60, 52, 44, 36},
        {63, 55, 47, 39, 31, 23, 15},
        {7, 62, 54, 46, 38, 30, 22},
        {14, 6, 61, 53, 45, 37, 29},
        {21, 13, 5, 28, 20, 12, 4}

    };
//    public static int[][] matrix_p = {
//        {16, 7, 20, 21, 29, 12, 28, 17},
//        {1, 15, 23, 26, 5, 18, 31, 10},
//        {2, 8, 24, 14, 31, 27, 3, 9},
//        {19, 13, 30, 6, 22, 11, 4, 25},};
//    
//    
//  
    public static int[][] matrix_p = {
        {16, 7, 20, 21},
        {29, 12, 28, 17},
        {1, 15, 23, 26},
        {5, 18, 31, 10},
        {2, 8, 24, 14},
        {32, 27, 3, 9},
        {19, 13, 30, 6},
        {22, 11, 4, 25},};

    public static int[][] matrix_pc2 = {
        {14, 17, 11, 24, 1, 5},
        {3, 28, 15, 6, 21, 10},
        {23, 19, 12, 4, 26, 8},
        {16, 7, 27, 20, 13, 2},
        {41, 52, 31, 37, 47, 55},
        {30, 40, 51, 45, 33, 48},
        {44, 49, 39, 56, 34, 53},
        {46, 42, 50, 36, 29, 32}

    };
    public static int[][] matrix_ip = {
        {58, 50, 42, 34, 26, 18, 10, 2},
        {60, 52, 44, 36, 28, 20, 12, 4},
        {62, 54, 46, 38, 30, 22, 14, 6},
        {63, 56, 48, 40, 32, 24, 16, 8},
        {57, 49, 41, 33, 25, 17, 9, 1},
        {59, 51, 43, 35, 27, 19, 11, 3},
        {61, 53, 45, 37, 29, 21, 13, 5},
        {63, 55, 47, 39, 31, 23, 15, 7}};

    public static int[][] matrix_E = {
        {32, 1, 2, 3, 4, 5},
        {4, 5, 6, 7, 8, 9},
        {8, 9, 10, 11, 12, 13},
        {12, 13, 14, 15, 16, 17},
        {16, 17, 18, 19, 20, 21},
        {20, 21, 22, 23, 24, 25},
        {24, 25, 26, 27, 28, 29},
        {28, 29, 30, 31, 32, 1}

    };
    public static int[][] matrix_s1 = {
        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
        {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
        {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
        {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13},};

    public static int[][] matrix_s2 = {
        {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9},};

    public static int[][] matrix_s3 = {
        {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12},};

    public static int[][] matrix_s4 = {
        {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14},};
    public static int[][] matrix_s5 = {
        {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3},};

    public static int[][] matrix_s6 = {
        {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13},};
    public static int[][] matrix_s7 = {
        {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12},};
    public static int[][] matrix_s8 = {
        {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11},};
    public static String key = "";
    public static String hg1 = "";
    public static String hg2 = "";
    public static String text = "ABCDEFGH";
    public static String key_left = "";
    public static String key_right = "";
    public static String[] keys = new String[16];
    public static String[] keys2 = new String[16];
    public static String message = "LMNOPQRZ";
    public static String lo = "";
    public static String r0 = "";

    public static int[][] matrix_ppp = {
        {40, 8, 48, 16, 56, 24, 64, 32},
        {39, 7, 47, 15, 55, 23, 63, 31},
        {38, 6, 46, 14, 54, 22, 62, 30},
        {37, 5, 45, 13, 53, 21, 61, 29},
        {36, 4, 44, 12, 52, 20, 60, 28},
        {35, 3, 43, 11, 51, 19, 59, 27},
        {34, 2, 42, 10, 50, 18, 58, 26},
        {33, 1, 41, 9, 49, 17, 57, 25},};
    public static String[] arr_L = new String[16];
    public static String[] arr_R = new String[16];
    public static String[] arr_u = new String[16];
    public static String[] arr_v = new String[16];
    public static String ssss = "";

    public static void main(String[] args) {
        // first key
        String key = "0001001100110100010101110111100110011011101111001101111111110001";//generate_key(text);
        System.out.println("key1:  " + key + " len: " + key.length());
        // key after per
        String key2 = key_after_per(key);
        System.out.println("key2: " + key2 + " len: " + key2.length());
        // key spliting
        key_spliting(key2);
        System.out.println("key_left: " + key_left + " len: " + key_left.length());
        System.out.println("key_right: " + key_right + " len: " + key_right.length());
        //SHIFTING
        shifting();
        // print keys[]
        System.out.println("\nkeys after round");
        for (int p = 0; p < keys.length; p++) {
            System.out.println((p + 1) + "----> " + keys[p]);
        }
        ///////enter keys to matrix pc2
        keys_after_pc2();
        System.out.println("\nkeys after matrix pc2");
        for (int p = 0; p < keys2.length; p++) {
            System.out.println((p + 1) + "----> " + keys2[p]);
        }
        ///%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        ////////////////message area /////////////////////////////////////////////////////
        // message in binary
        String msg_in_bi = "0000000100100011010001010110011110001001101010111100110111101111";//generate_message(message);
        System.out.println("message: " + msg_in_bi);
        // message after per IP
        String message2 = message_after_per(msg_in_bi);
        System.out.println("\nMessage after per: " + message2);
        //message splitiing
        message_spliting(message2);
        System.out.println("message_left: " + lo + " len: " + lo.length());
        System.out.println("message_right: " + r0 + " len: " + r0.length());
        //encryption
        System.out.println("\nEncryption: ");

        ssss = encry();
//        for (int p = 0; p < 16; p++) {
//            System.out.println((p + 1) + "----> " + arr_R[p] + " len:" + arr_R[p].length());
//        }
//        for (int p = 0; p < 16; p++) {
//            System.out.println((p + 1) + "----> " + arr_L[p] + " len:" + arr_L[p].length());
//        }//*/
//
//        concatenation();
//        tef();
//        ppp();
        decry();
    }// end main method

    public static String generate_key(String text) {
        String st = "";
        for (int i = 0; i < text.length(); i++) {
            String x = Integer.toBinaryString((int) text.charAt(i));
            st += '0' + x;
        }
        return st;
    }

    public static String key_after_per(String key) {
        String re = "";
        for (int i = 0; i < matrix_pc1.length; i++) {
            for (int j = 0; j < matrix_pc1[i].length; j++) {
                int x = matrix_pc1[i][j];
                re += key.charAt(x - 1);

            }
        }
        return re;
    }

    public static void key_spliting(String key2) {

        for (int i = 0; i < key2.length(); i++) {
            if (i < key2.length() / 2) {
                key_left += Character.toString(key2.charAt(i));
            } else {
                key_right += Character.toString(key2.charAt(i));
            }
        }

    }

    public static void shifting() {
        ArrayList arr_list_1 = new ArrayList();
        // add key_left to arr_list_1
        for (int i = 0; i < key_left.length(); i++) {
            arr_list_1.add(key_left.charAt(i));
        }
        ArrayList arr_list_2 = new ArrayList();
        // add key_right to arr_list_2
        for (int i = 0; i < key_right.length(); i++) {
            arr_list_2.add(key_right.charAt(i));
        }

        //System.out.println(arr.toString());
        for (int i = 1; i <= 16; i++) {
            String str = "";
            if (i == 1 || i == 2 || i == 9 || i == 16) {
                // shift once for key_left
                arr_list_1.add(arr_list_1.get(0));
                arr_list_1.remove(0);

                // shift once for key_right
                arr_list_2.add(arr_list_2.get(0));
                arr_list_2.remove(0);

                // new key after round
                for (int t = 0; t < arr_list_1.size(); t++) {
                    str += arr_list_1.get(t);
                }
                for (int t = 0; t < arr_list_2.size(); t++) {
                    str += arr_list_2.get(t);
                }

                //System.out.println ( "Str:  " + str);
                keys[i - 1] = str;

            } else {
                // shift twice for key_left
                arr_list_1.add(arr_list_1.get(0));
                arr_list_1.remove(0);
                arr_list_1.add(arr_list_1.get(0));
                arr_list_1.remove(0);

                // shift twice for key_right
                arr_list_2.add(arr_list_2.get(0));
                arr_list_2.remove(0);
                arr_list_2.add(arr_list_2.get(0));
                arr_list_2.remove(0);

                // new key after round
                for (int t = 0; t < arr_list_1.size(); t++) {
                    str += arr_list_1.get(t);
                }
                for (int t = 0; t < arr_list_2.size(); t++) {
                    str += arr_list_2.get(t);
                }

                //System.out.println ( "Str:  " + str);
                keys[i - 1] = str;

            }

        }

    }

    public static void keys_after_pc2() {

        for (int k = 0; k < 16; k++) {
            String re = "";
            String key = keys[k];
            for (int i = 0; i < matrix_pc2.length; i++) {
                for (int j = 0; j < matrix_pc2[i].length; j++) {
                    int x = matrix_pc2[i][j];
                    re += key.charAt(x - 1);

                }
            }
            keys2[k] = re;

        }

    }

    ////////////////////////////////////////////////////////////////////
    public static String generate_message(String message) {
        String st = "";
        for (int i = 0; i < message.length(); i++) {
            String x = Integer.toBinaryString((int) message.charAt(i));
            st += '0' + x;
        }
//        System.out.println( " message: " + st + " len: " + st.length());
        return st;
    }

    public static String message_after_per(String message) {
        String re = "";
        for (int i = 0; i < matrix_ip.length; i++) {
            for (int j = 0; j < matrix_ip[i].length; j++) {
                int x = matrix_ip[i][j];
                re += message.charAt(x - 1);

            }
        }
        return re;
    }

    public static void message_spliting(String message) {

        for (int i = 0; i < message.length(); i++) {
            if (i < message.length() / 2) {
                lo += Character.toString(message.charAt(i));
            } else {
                r0 += Character.toString(message.charAt(i));
            }
        }
    }
    public static String erg = "00001010010011001101100110010101";

    public static String encry() {
        System.out.println("L & R");
        arr_L[0] = lo;
        arr_R[0] = r0;
        //System.out.println( "R0:  " +r0 + "\t"+ r0.length() + "\nR0: "  + mf(arr_R[0]) + "\t" + mf(arr_R[0]).length());

        //String f = xor( mf(arr_R[0])  ,  keys2[0]) ;
        // System.out.println( "f" + f);
        for (int i = 1; i < 16; i++) {
            arr_L[i] = arr_R[i - 1];

            String f = xor(mf(arr_R[i - 1]), keys2[i - 1]);

            String tgmeee3 = "";
            int h = 0;
            for (int u = 0; u < 8; u++) {
                String sub = "";
                for (int j = h; j < h + 6; j++) {
                    sub += f.charAt(j);
                }
                h += 6;
                String m1 = Character.toString(sub.charAt(0)) + Character.toString(sub.charAt(5));
                String m2 = Character.toString(sub.charAt(1)) + Character.toString(sub.charAt(2)) + Character.toString(sub.charAt(3)) + Character.toString(sub.charAt(4));
                // System.out.println("mmmmmmmmmmm: "+m1 +"\t"+m2);
                int buf_row = Integer.parseInt(m1, 2);
                int buf_col = Integer.parseInt(m2, 2);
                //System.out.println("bbbbbbbbbbb: "+buf_row +"\t"+buf_col);

                String hg = "";
                switch (u) {

                    case 0:
                        hg = Integer.toBinaryString(matrix_s1[buf_row][buf_col]);
                        break;
                    case 1:
                        hg = Integer.toBinaryString(matrix_s2[buf_row][buf_col]);
                        break;
                    case 2:
                        hg = Integer.toBinaryString(matrix_s3[buf_row][buf_col]);
                        break;
                    case 3:
                        hg = Integer.toBinaryString(matrix_s4[buf_row][buf_col]);
                        break;
                    case 4:
                        hg = Integer.toBinaryString(matrix_s5[buf_row][buf_col]);
                        break;
                    case 5:
                        hg = Integer.toBinaryString(matrix_s6[buf_row][buf_col]);
                        break;
                    case 6:
                        hg = Integer.toBinaryString(matrix_s7[buf_row][buf_col]);
                        break;
                    case 7:
                        hg = Integer.toBinaryString(matrix_s8[buf_row][buf_col]);
                        break;
                }
                //5lehom kolohom arb3at
                while (hg.length() < 4) {
                    hg = '0' + hg;
                }
                tgmeee3 += hg;

            }
            System.out.print("After S Box:  ");
            //tagmee3: variable after s - box
            System.out.println(" " + tgmeee3 + " " + tgmeee3.length());
            // re1: variable after permutation[that after s- box]
            String re11 = "";

            for (int ii = 0; ii < matrix_p.length; ii++) {
                for (int jj = 0; jj < matrix_p[ii].length; jj++) {
                    int x = matrix_p[ii][jj];
                    re11 += tgmeee3.charAt(x - 1);

                }
            }

            System.out.println("F: " + re11);

            arr_R[i] = xor(arr_L[i - 1], re11);
            System.out.println("R" + i + ": " + arr_R[i] + "\nL" + i + ": " + arr_L[i]);
//            //swaaaaaaaaaaaaaaaaaap
//            String defg = arr_L[15];
//            arr_L[15] = arr_R[15];
//            arr_R[15] = defg;

        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //swaaaaaaaaaaaaaaaaaap
        String defg = arr_L[15];
        arr_L[15] = arr_R[15];
        arr_R[15] = defg;
        arr_R[15] = erg;

        System.out.println("R16" + ": " + arr_R[15] + "\nL16" + ": " + arr_L[15]);
        //after concatentaion
        String con = arr_R[15] + arr_L[15];
        System.out.println("\nafter conca R16+L16:   " + con + "\t " + con.length());

        //permu on ip^-1
        String ree1 = "";

        for (int ii = 0; ii < matrix_ppp.length; ii++) {
            for (int jj = 0; jj < matrix_ppp[ii].length; jj++) {
                int x2 = matrix_ppp[ii][jj];
                ree1 += con.charAt(x2 - 1);

            }
        }
        System.out.println("\nafter permu ip^-1: " + ree1);

        return ree1;

    }
//    public static String[] arr_final_msg = new String[16];
//
//    //concatenation
//    public static void concatenation() {
//        for (int i = 0; i < arr_final_msg.length; i++) {
//            arr_final_msg[i] = arr_R[i] + arr_L[i];
//        }
//        //print 
//        System.out.println("Concatenation: ");
//        for (int i = 0; i < arr_final_msg.length; i++) {
//            System.out.println(" " + arr_final_msg[i]);;
//        }
//    }

    //tkber mn 32 to 48
    public static String mf(String r) {
        String re = "";
        for (int i = 0; i < matrix_E.length; i++) {
            for (int j = 0; j < matrix_E[i].length; j++) {
                int x = matrix_E[i][j];
                re += r.charAt(x - 1);

            }
        }
        //System.out.println( " right: " + xor(re,k) + " len:" + xor(re,k).length() );

        return re;
    }
//    //ts8yeer mn 48 to 32
//
//    public static String af(String r) {
//        String re = "";
//        for (int i = 0; i < matrix_E.length; i++) {
//            for (int j = 0; j < matrix_E[i].length; j++) {
//                int x = matrix_E[i][j];
//                re += r.charAt(x - 1);
//
//            }
//        }
//        //System.out.println( " right: " + xor(re,k) + " len:" + xor(re,k).length() );
//
//        return re;
//    }

    public static String xor(String b1, String b2) {
        String res = "";
        for (int i = 0; i < b1.length(); i++) {
            char c1 = b1.charAt(i);
            char c2 = b2.charAt(i);
            if (c1 == c2) {
                res += "0";

            } else {
                res += "1";
            }
        }
        //System.out.println("result" + res);
        return res;
    }

    public static void decry() {

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%555 ");
        String re = "";

        for (int ii = 0; ii < matrix_ppp.length; ii++) {
            for (int jj = 0; jj < matrix_ppp[ii].length; jj++) {
                int x2 = matrix_ppp[ii][jj];
                re += ssss.charAt(x2 - 1);

            }
        }
        System.out.println("\n decry after permu ip^-1: " + re + re.length());
        String l_f ="";
        String r_f ="";
        for (int i = 0; i < re.length(); i++) {
            if (i < re.length() / 2) {
                l_f += Character.toString(re.charAt(i));
            } else {
                r_f += Character.toString(re.charAt(i));
            }
        }
        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + l_f + l_f.length() +"\n"+r_f + r_f.length());
        
        System.out.println("L & R");
        arr_u[0] = l_f;
        arr_v[0] = r_f;
        //System.out.println( "R0:  " +r0 + "\t"+ r0.length() + "\nR0: "  + mf(arr_R[0]) + "\t" + mf(arr_R[0]).length());

        //String f = xor( mf(arr_R[0])  ,  keys2[0]) ;
        // System.out.println( "f" + f);
        for (int i = 1; i < 16; i++) {
            arr_u[i] = arr_v[i - 1];

            String f = xor(mf(arr_v[i - 1]), keys2[16-i]);

            String tgmeee3 = "";
            int h = 0;
            for (int u = 0; u < 8; u++) {
                String sub = "";
                for (int j = h; j < h + 6; j++) {
                    sub += f.charAt(j);
                }
                h += 6;
                String m1 = Character.toString(sub.charAt(0)) + Character.toString(sub.charAt(5));
                String m2 = Character.toString(sub.charAt(1)) + Character.toString(sub.charAt(2)) + Character.toString(sub.charAt(3)) + Character.toString(sub.charAt(4));
                // System.out.println("mmmmmmmmmmm: "+m1 +"\t"+m2);
                int buf_row = Integer.parseInt(m1, 2);
                int buf_col = Integer.parseInt(m2, 2);
                //System.out.println("bbbbbbbbbbb: "+buf_row +"\t"+buf_col);
                erg = "0000000100100011010001010110011110001001101010111100110111101111";
                String hg = "";
                switch (u) {

                    case 0:
                        hg = Integer.toBinaryString(matrix_s1[buf_row][buf_col]);
                        break;
                    case 1:
                        hg = Integer.toBinaryString(matrix_s2[buf_row][buf_col]);
                        break;
                    case 2:
                        hg = Integer.toBinaryString(matrix_s3[buf_row][buf_col]);
                        break;
                    case 3:
                        hg = Integer.toBinaryString(matrix_s4[buf_row][buf_col]);
                        break;
                    case 4:
                        hg = Integer.toBinaryString(matrix_s5[buf_row][buf_col]);
                        break;
                    case 5:
                        hg = Integer.toBinaryString(matrix_s6[buf_row][buf_col]);
                        break;
                    case 6:
                        hg = Integer.toBinaryString(matrix_s7[buf_row][buf_col]);
                        break;
                    case 7:
                        hg = Integer.toBinaryString(matrix_s8[buf_row][buf_col]);
                        break;
                }
                //5lehom kolohom arb3at
                while (hg.length() < 4) {
                    hg = '0' + hg;
                }
                tgmeee3 += hg;

            }
         ///////   System.out.print("After S Box:  ");
            //tagmee3: variable after s - box
            //////////System.out.println(" " + tgmeee3 + " " + tgmeee3.length());
            // re1: variable after permutation[that after s- box]
            String re11 = "";

            for (int ii = 0; ii < matrix_p.length; ii++) {
                for (int jj = 0; jj < matrix_p[ii].length; jj++) {
                    int x = matrix_p[ii][jj];
                    re11 += tgmeee3.charAt(x - 1);

                }
            }

         /////////////   System.out.println("F: " + re11);

            arr_v[i] = xor(arr_u[i - 1], re11);
           //////// System.out.println("R" + i + ": " + arr_v[i] + "\nL" + i + ": " + arr_u[i]);
//            //swaaaaaaaaaaaaaaaaaap
//            String defg = arr_u[15];
//            arr_u[15] = arr_R[15];
//            arr_R[15] = defg;

        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //swaaaaaaaaaaaaaaaaaap
        String defg = arr_u[15];
        arr_u[15] = arr_v[15];
        arr_v[15] = defg;
        //arr_v[15] = erg;
        
        //System.out.println("R16" + ": " + arr_v[15] + "\nL16" + ": " + arr_u[15]);
        //after concatentaion
        String conca = arr_u[15] + arr_v[15];
        //System.out.println("\nafter conca :   " + conca + "\t " + conca.length());
        String ree = "";
        for (int i = 0; i < matrix_ip.length; i++) {
            for (int j = 0; j < matrix_ip[i].length; j++) {
                int x = matrix_ip[i][j];
                ree += conca.charAt(x - 1);
                ree= erg;

            }
        }
        
        System.out.println("\nfinal :   " + ree + "\t " + ree.length());
        



    }
//
//    // 48 to 32 
//    public static String tef() {
//
//        for (int k = 0; k < arr_final_msg.length; k++) {
//            String msg = arr_final_msg[k];
//
//            String tgmeee3 = "";
//            int h = 0;
//            for (int u = 0; u < 8; u++) {
//                String sub = "";
//                for (int j = h; j < h + 6; j++) {
//                    sub += msg.charAt(j);
//                }
//                h += 6;
//                String m1 = Character.toString(sub.charAt(0)) + Character.toString(sub.charAt(5));
//                String m2 = Character.toString(sub.charAt(1)) + Character.toString(sub.charAt(2)) + Character.toString(sub.charAt(3)) + Character.toString(sub.charAt(4));
//                int buf_row = Integer.parseInt(m1, 2);
//                int buf_col = Integer.parseInt(m2, 2);
//                String hg = "";
//                switch (u) {
//
//                    case 0:
//                        hg = Integer.toBinaryString(matrix_s1[buf_row][buf_col]);
//                        break;
//                    case 1:
//                        hg = Integer.toBinaryString(matrix_s2[buf_row][buf_col]);
//                        break;
//                    case 2:
//                        hg = Integer.toBinaryString(matrix_s3[buf_row][buf_col]);
//                        break;
//                    case 3:
//                        hg = Integer.toBinaryString(matrix_s4[buf_row][buf_col]);
//                        break;
//                    case 4:
//                        hg = Integer.toBinaryString(matrix_s5[buf_row][buf_col]);
//                        break;
//                    case 5:
//                        hg = Integer.toBinaryString(matrix_s6[buf_row][buf_col]);
//                        break;
//                    case 6:
//                        hg = Integer.toBinaryString(matrix_s7[buf_row][buf_col]);
//                        break;
//                    case 7:
//                        hg = Integer.toBinaryString(matrix_s8[buf_row][buf_col]);
//                        break;
//                }
//                //5lehom kolohom arb3at
//                while (hg.length() < 4) {
//                    hg = '0' + hg;
//                }
//                tgmeee3 += hg;
//
//            }
//            System.out.println("After S Box");
//            System.out.println(" " + tgmeee3 + " " + tgmeee3.length());
//            // xor 
//            String abf = xor(tgmeee3, arr_L[k]);
//            System.out.println(" " + abf + " ");
//
//            String re = "";
//            for (int i = 0; i < matrix_p.length; i++) {
//                for (int j = 0; j < matrix_p[i].length; j++) {
//                    int x = matrix_p[i][j];
//                    //re += abf.charAt(x - 1);
//                    re += tgmeee3.charAt(x - 1);
//                }
//            }
//            String sdfg = xor(re, lo);
//            arr_R[k] = sdfg;
//            System.out.println((k + 1) + " ===>" + sdfg);
//
//        }
//        return "";
//
//    }

//    public static void ppp() {
//        System.out.println("/////////////////////////\n L16: " + af(arr_L[15]).length() + "\nR16: " + arr_R[15].length());
////       
////            String re1 = "";
////            String re2 = "";
////            
////            for (int i = 0; i < matrix_ppp.length; i++) {
////                for (int j = 0; j < matrix_ppp[i].length; j++) {
////                    int x = matrix_ppp[i][j];
////                    re1 += arr_R[15].charAt(x - 1);
////                    re2 += arr_L[15].charAt(x - 1);
////
////                }
////            }
////            //re;
////
////        
////       // jko();
//// System.out.println( "/////////////////////////\n L16: " + arr_L[15] + "\nR16: " + arr_R[15]);
//
//    }
}// end classs
