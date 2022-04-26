import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        // Streams / Lambda

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Ciudad de México");
        cities.add("Lima");

        /*for (String city : cities) {
            System.out.println(city);
        }*/

        // Lambda
        //cities.forEach(city -> System.out.println(city));

        // Reference to a Method
        //cities.forEach(Main::printCity);

        // More simple
        //cities.forEach(System.out::println);

        // Simple example of Parallel - Pipeline
        //cities.stream().parallel().forEach(System.out::println);


        List<String> filteredCities = cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .collect(toList());
    }

    public static boolean filterCity(String city) {
        return city.startsWith("B");
    }

    public static void printCity(String city) {
        System.out.println(city);
    }
}
