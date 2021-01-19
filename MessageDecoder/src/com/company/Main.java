package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[] codeMap = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                                    'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.println("Please enter your message to encode:");
        String input = sc.nextLine().toLowerCase();
        String encodedMessage = encoder(input, codeMap);
        System.out.println("Your encoded message is:");
        System.out.println(encodedMessage);
        int num_decodes = num_encodings(encodedMessage);
        System.out.println("The possible number of decoded messages is " + num_decodes);
    }

    private static String encoder(String input, char[] codeMap){
        char[] charArray = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < codeMap.length; j++){
                if(charArray[i] == codeMap[j]){
                    stringBuilder.append(j + 1);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static int num_encodings(String input){
        if (input.startsWith("0")){
            return 0;
        }else if(input.length() <= 1){
            return 1;
        }
        int total = 0;

        if(Integer.parseInt(input.substring(0,2)) <= 26){
            total += num_encodings(input.substring(2));
        }
        total += num_encodings(input.substring(1));
        return total;
    }
}
