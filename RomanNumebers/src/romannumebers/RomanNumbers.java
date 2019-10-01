/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romannumebers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mohamed
 */
public class RomanNumbers {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            System.out.println(i + " -> " + Roman(i));
        }
    }
    
    public static String Roman(int n) {
        LinkedHashMap<String, Integer> roman = new LinkedHashMap<>();

        roman.put("C" ,100);
        roman.put("XC", 90);
        roman.put("L" , 50);
        roman.put("XL", 40);
        roman.put("X" , 10);
        roman.put("IX",  9);
        roman.put("V" ,  5);
        roman.put("IV",  4);
        roman.put("I" ,  1);
        String roman_number = "";
        for (Map.Entry<String, Integer> entry : roman.entrySet()) {
            int matches = n / entry.getValue();
            roman_number += repeat(entry.getKey(), matches);
            n = n % entry.getValue();
        }
        return roman_number;
    }
    
    public static String repeat(String s, int n) {
        if (s == null){
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(s);
        }
        return sb.toString();
    }
}   
