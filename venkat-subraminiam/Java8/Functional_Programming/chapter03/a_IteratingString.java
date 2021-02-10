ackage chapter03;

public class a_IteratingString {

    public static void main(String[] args) {

        final String str = "ayman";

        // 1. Iterating using Lambda
        str.chars() // Returns IntStream
           .forEach(ch -> System.out.print(ch));

        System.out.println("\n--------------------------");

        // 2. Iterating using Method Reference
        str.chars() // Returns IntStream
           .forEach(System.out::print);


        System.out.println("\n--------------------------");

        // i. Print character instead of ASCII using Int
        // Iterating using Method Reference
        str.chars() // Returns IntStream
           .forEach(IterateString::printChar);// convert int to char

        System.out.println("\n--------------------------");

        // ii. Print character instead of ASCII by processing characters directly with `mapToObj`
        // Iterating using forEach
        str.chars() // Returns IntStream
           .mapToObj(ch -> Character.valueOf((char) ch))
           .forEach(System.out::print);

        System.out.println("\n--------------------------");


        // a. Using filter for only digits
        // Iterating using forEach
        final String newStr = "ay2man";
        newStr.chars() // Returns IntStream
            .filter(ch -> Character.isDigit(ch))
            .forEach(IterateString::printChar); // or .forEach(ch -> printChar(ch)); for Lambda instead of method reference



    }

    private static class IterateString {

        private static void printChar(int aChar) {
            System.out.print((char) (aChar));
        }
    }
}
