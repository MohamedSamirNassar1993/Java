package firstlab;

import java.awt.Point;
import java.util.Scanner;

public class PlayFairCipher {
    private int length = 0;    
    private String[][] table;
    public static void main(String[] args) {
        PlayFairCipher pf = new PlayFairCipher();
    }

    private PlayFairCipher() {
        System.out.println("Please input the keyword for the Playfair cipher.");
        Scanner sc = new Scanner(System.in);
        String keyword = parseString(sc);
        while (keyword.equals("")) {
            keyword = parseString(sc);
        }
        System.out.println();
        table = this.cipherTable(keyword);

        // prompts user for message to be encoded
        System.out.println("Please input the message to be encoded");
        System.out.println("using the previously given keyword");
        String input = parseString(sc);
        while(input.equals("")) {
            input = parseString(sc);
        }
        System.out.println();

        // encodes and then decodes the encoded message
        String output = cipher(input);

        // output the results to user
        this.printTable(table);
        
        // prints results (encoded and decoded)
        System.out.println("This is the encoded message:");
        System.out.println(output);
    }

    // parses any input string to remove numbers, punctuation,
    // replaces any J's with I's, and makes string all caps
    private String parseString(Scanner s) {
        String parse = s.nextLine();
        parse = parse.toUpperCase();
        parse = parse.replaceAll("[^A-Z]", "");
        parse = parse.replace("J", "I");
        return parse;
    }

    // creates the cipher table based on some input string (already parsed)
    private String[][] cipherTable(String key) {
        String[][] playfairTable = new String[5][5];
        String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        // fill string array with empty string
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                playfairTable[i][j] = "";
            }
        }

        for (int k = 0; k < keyString.length(); k++) {
            boolean repeat = false;
            boolean used = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (playfairTable[i][j].equals("" + keyString.charAt(k))) {
                        repeat = true;
                    } else if (playfairTable[i][j].equals("") && !repeat && !used) {
                        playfairTable[i][j] = "" + keyString.charAt(k);
                        used = true;
                    }
                }
            }
        }
        return playfairTable;
    }

    // cipher: takes input (all upper-case), encodes it, and returns output
    private String cipher(String in) {
        length = (int) in.length() / 2 + in.length() % 2;

        // insert x between double-letter digraphs & redefines "length"
        for (int i = 0; i < (length - 1); i++) {
            if (in.charAt(2 * i) == in.charAt(2 * i + 1)) {
                in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                length = (int) in.length() / 2 + in.length() % 2;
            }
        }

        // adds an x to the last digraph, if necessary
        String[] digraph = new String[length];
        for (int j = 0; j < length; j++) {
            if (j == (length - 1) && in.length() / 2 == (length - 1)) {
                in = in + "X";
            }
            digraph[j] = in.charAt(2 * j) + "" + in.charAt(2 * j + 1);
        }

        // encodes the digraphs and returns the output
        String out = "";
        String[] encDigraphs = new String[length];
        encDigraphs = encodeDigraph(digraph);
        for (int k = 0; k < length; k++) {
            out = out + encDigraphs[k];
        }
        return out;
    }

    // encodes the digraph input with the cipher's specifications
    private String[] encodeDigraph(String di[]) {
        String[] enc = new String[length];
        for (int i = 0; i < length; i++) {
            char a = di[i].charAt(0);
            char b = di[i].charAt(1);
            int x1 = (int) getPoint(a).getX();
            int x2 = (int) getPoint(b).getX();
            int y1 = (int) getPoint(a).getY();
            int y2 = (int) getPoint(b).getY();

            // case 1: letters in digraph are of same row, shift columns to right
            if (x1 == x2) {
                y1 = (y1 + 1) % 5;
                y2 = (y2 + 1) % 5;

            // case 2: letters in digraph are of same column, shift rows down
            } else if (y1 == y2) {
                x1 = (x1 + 1) % 5;
                x2 = (x2 + 1) % 5;

            // case 3: letters in digraph form rectangle, swap first column # with second column #
            } else {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            //performs the table look-up and puts those values into the encoded array
            enc[i] = table[x1][y1] + "" + table[x2][y2];
        }
        return enc;
    }
    
    // returns a point containing the row and column of the letter
    private Point getPoint(char c) {
        Point pt = new Point(0, 0);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (c == table[i][j].charAt(0)) {
                    pt = new Point(i, j);
                }
            }
        }
        return pt;
    }

    // prints the cipher table out for the user
    private void printTable(String[][] printedTable) {
        System.out.println("This is the cipher table from the given keyword.");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(printedTable[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
