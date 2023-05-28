package map;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {

/*
 Given the car models and their respective consumption on the road, do:
 model = gol - consumption = 14.4km/l
 model = uno - consumption = 15.6km/l
 model = mobi - consumption = 16.1 km/l
 model = hb20 - consumption = 14.5 km/l
 model = kwid - fuel consumption = 15.6 km/l
 */

// Map carsPopular2020 = new HashMap(); // before java 5
// Map<String, Double> popularCars = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
// HashMap<String, Double> popularCars = new HashMap<>();
// Map<String, Double> popularcars2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

        System.out.println("Create a dictionary that lists the models and their respective consumption: ");
        Map<String, Double> popularCars = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(popularCars.toString());

        System.out.println("\nReplace the consumption of the goal with 15.2 km/l: ");
        popularCars.put("gol", 15.2);
        System.out.println(popularCars);

        System.out.println("\nCheck if the tucson model is in the dictionary: " + popularCars.containsKey("tucson"));

        System.out.println("\nDisplay uno's fuel consumption: " + popularCars.get("uno"));

// System.out.println("Display the third model added: ");

        System.out.println("\nDisplay the models: ");
        Set<String> models = popularCars.keySet();
        System.out.println(models);

        System.out.println("\nDisplay the consumptions of the cars: ");
        Collection<Double> consumptions = popularCars.values();
        System.out.println(consumptions);

        System.out.println("\nDisplay the most economical model and its consumption: ");
        Double consumptionMostEfficient = Collections.max(popularCars.values());
        Set<Map.Entry<String, Double>> entries = popularCars.entrySet();
        String ModelMostEfficient = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumptionMostEfficient)) {
                ModelMostEfficient = entry.getKey();
                System.out.println("Most efficient model: " + ModelMostEfficient + " - " + consumptionMostEfficient);
            }
        }

        System.out.println("\nDisplay the least efficient model and its consumption: " );

        Double consumptionLessEfficient = Collections.min(popularCars.values());
        String ModelLessEfficient = "";
        for (Map.Entry<String, Double> entry: popularCars.entrySet()) {
            if(entry.getValue().equals(consumptionLessEfficient)) {
                ModelLessEfficient = entry.getKey();
                System.out.println("Least efficient model: " + ModelLessEfficient + " - " + consumptionLessEfficient);
            }
        }

        Iterator<Double> iterator = popularCars.values().iterator();
        Double sum = 0d;
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        System.out.println("\nDisplay the sum of the consumptions: " + sum);

        System.out.println("\nDisplay the average consumption of this car dictionary: " + (sum/popularCars.size()));
        
        System.out.println(popularCars);
        System.out.println("\nRemove the models with consumption equal to 15.6 km/l: ");
        Iterator<Double> iterator1 = popularCars.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(popularCars);

        System.out.println("\nDisplay all cars in the order they were entered: ");
        Map<String, Double> popularCars1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(popularCars1.toString());

        System.out.println("\nDisplay the dictionary sorted by model: ");
        Map<String, Double> popularCars2 = new TreeMap<>(popularCars1);
        System.out.println(popularCars2.toString());

        System.out.println("\nDelete the car dictionary: ");
        popularCars.clear();

        System.out.println("\nCheck that the dictionary is empty: " + popularCars.isEmpty());
    }
}