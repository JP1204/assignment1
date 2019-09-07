package assignment1;

import java.util.ArrayList;

public class Problem1{
    public static void main(String args[]){
        /*  Input: A 1000-digit number to search through
         *  Output: prints largest product of the at most n adjacent digits
         */
        long startTime = System.nanoTime();
        int n = 0;
        long largestProd = 0;
        String largestProd_str = "";
        String num_str = "";
    System.out.println("length of input is " + args[1].length());
        // retrieve number
        if(args.length == 2){
            n = Integer.parseInt(args[0]);
            num_str = args[1];

            for(int i = 0; i < n; i++){
                largestProd_str += "0";     // edge case for all zero input
            }
        }
        else{
            System.out.println("Wrong number of arguments");
            return;
        }

        // create separate substrings separated by zeroes
        String[] zero_sep_subStr = num_str.split("0");

        // find the largest product within substrings
        for(String subStr : zero_sep_subStr) {
            System.out.println(subStr);
            if (subStr.length() <= n) {
                long product = subStr_product(subStr);

                if (product > largestProd) {
                    largestProd = product;
                    largestProd_str = subStr;
                }
            } else {
                // find product of first n digits
                long product = subStr_product(subStr.substring(0, n));

                // loop through subStrings of length n and compare products
                for (int i = 1; i <= subStr.length()-n; i++) {
                    int j = i + n;

                    System.out.println("product = " + product);

                    // divide by last digit and multiply by next digit to avoid redundant calculations
                    product /= Character.getNumericValue(subStr.charAt(i-1));
                    product *= Character.getNumericValue(subStr.charAt(j-1));

                    if (product > largestProd) {
                        largestProd = product;
                        largestProd_str = subStr.substring(i, j);
                    }
                }
            }
        }
        System.out.println("The largest product of at most " + n + " adjacent digits is "
            + largestProd + " with string: " + largestProd_str);

        long endtime = System.nanoTime();
        System.out.println("Took " + (endtime - startTime) + " ns to run");
    }

    public static long subStr_product(String s){
        /*  Input: substring of a series of numbers
         *  Output: product of all the digits
         */
        long product = 1;

        for(int i = 0; i < s.length(); i++){
            int digit = Character.getNumericValue(s.charAt(i));
            product *= digit;
        }

        return product;
    }
}