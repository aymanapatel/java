package chapter02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class a_IteratingList {


    public static void main(String[] args) {

        final List<String> friends = Arrays.asList("Ayman", "Patel");

        // Iteration 1: Simple for loop
        System.out.println("Simple for loop");
        for (int i = 0; i < friends.size(); ++i) {
            System.out.println(friends.get(i));
        }

        // Iteration 2: Enhanced For Loop
        System.out.println("----------------------------------------------");
        System.out.println("Enhanced for loop");
        for (String name: friends) {
            System.out.println(name);
        }


        // Iteration 3: Lambdas and forEach Iterator
        System.out.println("----------------------------------------------");
        System.out.println("Lambda & forEach Iterator for loop");
        friends.forEach((name) -> System.out.println(name));


        /**
         *  Iteration 4: Method Reference
         *  Lambda vs Method Reference: It's all about readability and reusability of code
         *  https://stackoverflow.com/a/24488060/9642851
         */
        System.out.println("----------------------------------------------");
        System.out.println("Method Reference for loop");
        friends.forEach(System.out::println);




    }

}
