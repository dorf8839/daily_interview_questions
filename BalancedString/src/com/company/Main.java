package com.company;

import java.util.ArrayList;

public class Main {

    //Given a string of round, curly, and square brackets, determine if the brackets are balanced
    //Loop through string and store variables of last opened bracket in arraylist
    //If next closing bracket matches, remove last element and continue through loop
    //Otherwise, stop and return false
    public static void main(String[] args) {
//	    String input = "([])[]({})";
//	    String input = "([)]";
	    String input = "((()";
        ArrayList<Character> bracketTracker = new ArrayList<>();
        char[] elements = input.toCharArray();
        boolean result = false;
        for(char element : elements){
            if(element == '(' || element == '[' || element == '{'){
                bracketTracker.add(element);
            }else {
                switch(element){
                    case ')':
                        if(bracketTracker.get(bracketTracker.size()-1) == '('){
                            bracketTracker.remove(bracketTracker.size()-1);
                            result = true;
                        }else{
                            result = false;
                        }
                        break;
                    case ']':
                        if(bracketTracker.get(bracketTracker.size()-1) == '['){
                            bracketTracker.remove(bracketTracker.size()-1);
                            result = true;
                        }else{
                            result = false;
                        }
                        break;
                    case '}':
                        if(bracketTracker.get(bracketTracker.size()-1) == '{'){
                            bracketTracker.remove(bracketTracker.size()-1);
                            result = true;
                        }else{
                            result = false;
                        }
                        break;
                }
                if(!result) break;
            }
        }

        if(result && bracketTracker.isEmpty()){
            System.out.println("The bracket is balanced");
        }else{
            System.out.println("The bracket is not balanced");
        }
    }
}
