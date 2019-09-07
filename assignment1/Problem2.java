package assignment1;

import java.util.ArrayList;

public class Problem2{
    public static void main(String args[]){
        ArrayList<String> dollar_words = new ArrayList<>();

        // parse paragraph with spaces
        if(args.length == 1){
            // fill out lookup table with cost of each letter
            int cost = 1;
            for(char c = 'a', c2 = 'A'; c <= 'z' && c2 <= 'Z'; c++, c2++){
                int ch = c;     // convert to int to access array
                int ch2 = c2;
                lookup_table[ch] = cost;
                lookup_table[ch2] = cost;
                cost++;
            }

            String[] words = args[0].split(" ");
            dollar_words = find_dollar_words(words);
        }
        else{
            System.out.println("Wrong number of arguments");
            return;
        }
    for(int i = 0; i < ASCII_SIZE; i++){
        System.out.println(lookup_table[i]);
    }
        System.out.println("The dollar words are:");
        for(String word : dollar_words){
            System.out.println(word);
        }
    }

    private static ArrayList<String> find_dollar_words(String[] words){
        ArrayList<String> dollar_words = new ArrayList<>();

        for(String word : words){
            int sum = 0;

            for(char c : word.toCharArray()){
                int ch = c;
                sum += lookup_table[ch];
            }

            if(sum == 100){
                dollar_words.add(word);
            }
        }

        return dollar_words;
    }

    private final static int ASCII_SIZE = 256;
    private static int[] lookup_table = new int[ASCII_SIZE];

}