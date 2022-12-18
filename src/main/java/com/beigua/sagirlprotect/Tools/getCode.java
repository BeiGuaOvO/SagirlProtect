package com.beigua.sagirlprotect.Tools;

import java.util.Random;

public class getCode {
    public static String getRCode(){
        String number = "";
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        for (int i = 1 ; i <= 6 ; i++){
            number = number + chars.charAt(r.nextInt(chars.length()));
        }
        return number;
    }
}
