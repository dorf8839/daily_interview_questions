package com.company;

import java.text.Collator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Collection<String> dictionary = new TreeSet<>(Collator.getInstance());
        dictionary.add("dog");
        dictionary.add("deer");
        dictionary.add("deal");
        String input = "de";

        Collection<String> results = autoComplete(dictionary, input);

        System.out.println(results.toString());
    }

    public static Collection<String> autoComplete(Collection<String> dictionary, String input){
        Collection<String> results = new ArrayList<>();
        Iterator<String> iter = dictionary.iterator();

        while(iter.hasNext()) {
            String s = iter.next();
            if(s.startsWith(input)){
                results.add(s);
            }
        }
        return results;
    }
}
