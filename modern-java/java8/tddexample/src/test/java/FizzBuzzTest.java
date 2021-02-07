import com.ayman.fizzbuzz.FizzBuzzConvertor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {




    @Test
    public void fizzBuzzFor3() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("Fizz", fizzBuzz.convertor(9));
    }

    @Test
    public void fizzBuzzFor5() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("Buzz", fizzBuzz.convertor(25));
    }

    @Test
    public void fizzBuzzFor3And5() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("FizzBuzz", fizzBuzz.convertor(90));
    }

    @Test
    public void fizzBuzzForNoFizzBuzz() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("89", fizzBuzz.convertor(89));
    }


    // Java 8

    @Test
    public void fizzBuzzFor3InJava8() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("Fizz", fizzBuzz.convertorInJava8(9));
    }

    @Test
    public void fizzBuzzFor5InJava8() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("Buzz", fizzBuzz.convertorInJava8(25));
    }

    @Test
    public void fizzBuzzFor3And5InJava8() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("FizzBuzz", fizzBuzz.convertorInJava8(90));
    }

    @Test
    public void fizzBuzzForNoFizzBuzzInJava8() {

        FizzBuzzConvertor fizzBuzz = new FizzBuzzConvertor();

        assertEquals("89", fizzBuzz.convertorInJava8(89));
    }
}
