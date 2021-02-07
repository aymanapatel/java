import java.util.*;

public class Main {

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
        }
    }

    /**
     * 1. First Attempt
     * 
     */
    public static List < Apple > firstAttempt(List < Apple > inventory) {

        List < Apple > result = new ArrayList < > ();

        for (Apple apple: inventory) {

            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 2. Second Attempt: Add parameter
     * 
     */
    public static List < Apple > secondAttempt(List < Apple > inventory,
        String color) {

        List < Apple > result = new ArrayList < > ();

        for (Apple apple: inventory) {

            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 3. Third Attempt: Filter every attribute in Apple class using Predicate
     * 
     */

    interface ApplePredicate {
        public boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }


    static class AppleColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleRedHeavyPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return ("red".equals(apple.getColor()) && apple.getWeight() > 150);
        }
    }

    public static List < Apple > thirdAttempt(List < Apple > inventory,
        ApplePredicate predicate) {

        List < Apple > result = new ArrayList < > ();

        for (Apple apple: inventory) {

            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }


    /**
     * 5. Final Attempt: Use everything and Genrify
     * 
     */

    interface Predicate < T > {
        public boolean test(T t);
    }

    public static < T > List < T > finalAttempt(List < T > inventory,
        Predicate < T > predicate) {

        List < T > result = new ArrayList < > ();

        for (T e: inventory) {

            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List < Apple > inventory =
            Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
                new Apple(120, "red"), new Apple(170, "red"));

        // 1.
        List < Apple > firstAttemptGreenApples = firstAttempt(inventory);
        System.out.println("First attempt");
        System.out.println(firstAttemptGreenApples);

        // 2.
        List < Apple > secondAttemptGreenApples =
            secondAttempt(inventory, "green");
        System.out.println("Second attempt: Green");
        System.out.println(secondAttemptGreenApples);

        // 3. 
        List < Apple > thirdAttemptGreenApples =
            thirdAttempt(inventory, new AppleColorPredicate());
        System.out.println("Third attempt: Green");
        System.out.println(thirdAttemptGreenApples);

        List < Apple > thirdAttemptHeavyApples = thirdAttempt(inventory, new AppleWeightPredicate());
        System.out.println("Third attempt: Heavy Weight");
        System.out.println(thirdAttemptHeavyApples);


        List < Apple > thirdAttemptRedAndHeavyApples = thirdAttempt(inventory, new AppleRedHeavyPredicate());
        System.out.println("Third attempt: Red and Heavy Weight");
        System.out.println(thirdAttemptRedAndHeavyApples);

        // 4. Use lambda for third attempt
        List < Apple > fourthAttempt = thirdAttempt(inventory, (Apple apple) - > "red".equals(apple.getColor()));
        System.out.println("Fourth attempt: Lambda");
        System.out.println(fourthAttempt);

        // 5. Use everything and Genrify
        List < Apple > finalAttempt = finalAttempt(inventory, (Apple apple) - > "red".equals(apple.getColor()));
        System.out.println("Fourth attempt: Lambda");
        System.out.println(fourthAttempt);


    }
}
