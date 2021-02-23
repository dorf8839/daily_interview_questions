package com.company;

import java.util.ArrayList;

public class Main {

    //Given list of flight itineraries, and a starting destination, compute a person's itinerary
    //If none exist, return null
    //Use 2-D string array to capture origin, destination pairs
    //Use a list to capture the visited airports
    //Use dynamic programming until the string array is empty
    //Track origin and destination in separate variables with a curr variable to designate where we are
    //Loop through string array until an origin is found matching curr
    //If multiple exist, take the lexicographically smaller origin
    //Change the curr to the destination of the origin
    //Remove origin/destination pair from string array and put into visited array
    //Continue through loop while string array is not empty or no matches are found
    //Verify visited array is equal to length of string array + 1
    //If no matches are found in the process, or the lengths do not match, return null
    //Otherwise, return visited array
    public static void main(String[] args) {
//	    String[][] flights = new String[][] {{"SFO", "HKO"}, {"YYZ", "SFO"}, {"YUL", "YYZ"}, {"HKO", "ORD"}};
//	    String[][] flights = new String[][] {{"SFO", "COM"}, {"COM", "YYZ"}};
	    String[][] flights = new String[][] {{"A", "B"}, {"A", "C"}, {"B", "C"}, {"C", "A"}};
        ArrayList<String> itinerary = new ArrayList<>();
        String origin = "A";
        String dest = "";
        int loc = -1;
        itinerary.add(origin);
        while(itinerary.size() < flights.length + 1){
            for(int i = 0; i < flights.length; i++){
                if(flights[i][0].equals(origin)){
                    if(dest.isEmpty()){
                        loc = i;
                        dest = flights[i][1];
                    }else {
                        if(dest.compareTo(flights[i][1]) > 0){
                            loc = i;
                            dest = flights[i][1];
                        }
                    }

                }
            }
            if(dest.isEmpty()){
                while(!itinerary.isEmpty()){
                    itinerary.remove(0);
                }
                itinerary.add("NULL");
                break;
            }
            origin = dest;
            itinerary.add(origin);
            flights[loc][0] = "";
            flights[loc][1] = "";
            dest = "";
        }
        System.out.println(itinerary.toString());
    }
}
