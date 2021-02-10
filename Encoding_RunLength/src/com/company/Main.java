package com.company;

public class Main {

    //Implement run-length encoding
    //i.e. "AAAABBBCCDAA" becomes "4A3B2C1D2A"
    //Loop through the string and keep count of the current character
    //When a new character is encountered, add the current count and character to the result string
    //After all characters have been looped through, print the result

    public static void main(String[] args) {
	    String input = "AAAABBBCCDAA";

        System.out.println(encode(input));

		System.out.println(decode(encode(input)));
    }

    public static String encode(String input){
		int count = 1;
		char curr = input.charAt(0);
		String result = "";
		for(int i = 1; i < input.length(); i++){
			if(input.charAt(i) != curr){
				result += count + String.valueOf(curr);
				count = 1;
				curr = input.charAt(i);
			}else{
				count++;
			}
		}
		result += count + String.valueOf(curr);
		return result;
	}

	public static String decode(String input){
    	int count;
    	String curr;
    	int i=0;
    	String result = "";
    	while(i < input.length()){
    		count = Integer.parseInt(String.valueOf(input.charAt(i)));
    		i++;
    		curr = String.valueOf(input.charAt(i));
    		i++;
    		for(int j = 0; j < count; j++){
    			result += curr;
			}
		}
    	return result;
	}
}
