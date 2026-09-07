package com.gabriel.Spring_Boot_REST.request.converters;

public class NumberConverter {
    public static Double convertToDouble(String strnumber) throws IllegalArgumentException{
        if (strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value");
        String number =  strnumber.replace(",", ".");

        return Double.parseDouble(strnumber);
    }

    public static boolean isNumeric (String strnumber){
        if (strnumber == null || strnumber.isEmpty()) return false;
        String number =  strnumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
