package com.ayman.prime;


import java.util.Stream.IntStream;

public class PrimeConvertor {

  public boolean isPrimeImperative(int number) {
  
    boolean divisible = false;
    
    for (int i=0; i< number; ++i) {
      if(number%i == 0) {
        divisible = true;
        break;
      }
    }
    
    return (number>1) && divisible;
    
  }
  
  
  public boolean isPrimeImperativeInJava8(int number) {
    
    return (number > 1) &&
            IntStream.range(1,number).noneMatch(i -> number%i == 0); // Returns true if none of the Stream elements match the given predicate i.e `number%i==0`
  }
  
  
}
