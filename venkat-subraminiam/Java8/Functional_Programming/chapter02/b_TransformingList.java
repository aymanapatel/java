package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class b_TransformingList {

    public static void main(String[] args) {

        final List<String> friends = Arrays.asList("Ayman", "Patel");

        // 1. Using Enhanced for loop
        final List<String> uppercaseFriends = new ArrayList<>();
        for(String name: friends) {
            uppercaseFriends.add(name.toUpperCase());
        }


        // 2. Using forEachIterator and Lambda loop
        final List<String> uppercaseFriendsForEachIterator = new ArrayList<>();
        friends.forEach(name -> uppercaseFriendsForEachIterator.add(name.toUpperCase()));
        for(String name: friends) {
            uppercaseFriends.add(name.toUpperCase());
        }

        // 3. Using Lambda Expression
        // Advantage:
        //      1. No temporary variable upperCaseFriends...
        //      2. No mutation (Evil of programming)
        Stream<String> uppercaseFriendsStreamAPIWithLambda =
                friends.stream()
                       .map( name -> name.toUpperCase());

        uppercaseFriendsStreamAPIWithLambda.forEach(name -> System.out.print(name));


        System.out.println("\n--------------------------\n");
        // 4. Using Method Reference
        // Advantage:
        //      1. No temporary variable upperCaseFriends...
        //      2. No mutation (Evil of programming)
        Stream<String> uppercaseFriendsStreamAPIWithMethodReference =
                friends.stream()
                       .map(String::toUpperCase);

        uppercaseFriendsStreamAPIWithMethodReference.forEach(name -> System.out.print(name));




    }
}

/**
 * Notes:
 *
 * 1. `String` is immutable -> Instance cannot be changed
 *
 */
