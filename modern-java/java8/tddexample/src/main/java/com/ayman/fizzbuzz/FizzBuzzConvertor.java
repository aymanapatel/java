package com.ayman.fizzbuzz;

import java.util.Optional;

public class FizzBuzzConvertor {

    public String convertor(int toBeConvertToFizzBuzz) {

        String result = "";
        if((toBeConvertToFizzBuzz%3) == 0) {
            result += "Fizz";
        }
        if((toBeConvertToFizzBuzz%5) == 0) {
            result += "Buzz";
        }
        if(result.isEmpty()) {
            result = String.valueOf(toBeConvertToFizzBuzz);
        }

        return result;
    }


    public String convertorInJava8(int toBeConvertToFizzBuzz) {

        String result = Optional.of(toBeConvertToFizzBuzz)
                .map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : ""))
                .get();


        return result.isEmpty() ? Integer.toString(toBeConvertToFizzBuzz) : result;
    }
}
