package map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Given the estimated population of some states in northeastern Brazil, do:
 State = PE - population = 9.616.621
 State = AL - population = 3.351.543
 State = CE - population = 9.187.103
 State = RN - population = 3.534.265
 */

public class MapProposedExercise {
    public static void main(String[] args) {
        
        System.out.println("Create a dictionary that lists the states and their respective populations: ");
        Map<String, Integer> statesNE = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(statesNE);

        System.out.println("\nReplace the population of the RN state with 3.534.165: ");
        statesNE.put("RN", 3534165);
        System.out.println(statesNE);

        System.out.println("\nCheck if the state of Paraíba (PB) is in the dictionary, if not, add " + "PB - 4.039.277: ");
        statesNE.put("PB", 4039277);
        System.out.println(statesNE);

        System.out.println("\nDisplay the population of the state PE: " + statesNE.get("PE"));

        System.out.println("\nDisplay all states and their populations in the order they were entered: ");
        Map<String, Integer> statesNE1 = new LinkedHashMap<>(statesNE);
        for (Map.Entry<String, Integer> state : statesNE1.entrySet()) {
            System.out.println("State = " + state.getKey() + " - " + "population = " + state.getValue());
        }

        System.out.println("\nDisplay all states and their populations in alphabetical order: ");
        Map<String, Integer> statesNE2 = new TreeMap<>(statesNE1);
        for (Map.Entry<String, Integer> state1 : statesNE2.entrySet()) {
            System.out.println("State = " + state1.getKey() + " - " + "population = " + state1.getValue());
        }

        System.out.println("\nDisplay the state with the smaller population and its respective amount: ");
        Collection<Integer> statesPopulation = statesNE.values();
        String smallerPopulationState = "";
        for (Map.Entry<String, Integer> state : statesNE.entrySet()) {
            if (state.getValue().equals(Collections.min(statesPopulation))) smallerPopulationState = state.getKey();
        }
        System.out.println("State = " + smallerPopulationState + " - " + "population = " + Collections.min(statesPopulation));

        System.out.println("\nDisplay the state with the bigger population and its respective amount: ");
        String biggerPopulationState = "";
        for (Map.Entry<String, Integer> state1 : statesNE.entrySet()) {
            if (state1.getValue().equals(Collections.max(statesPopulation))) biggerPopulationState = state1.getKey();
        }
        System.out.println("State = " + biggerPopulationState + " - " + "population = " + Collections.max(statesPopulation));

        System.out.println("\nDisplay the sum of the population of these states: ");
        int sum = 0;
        for (Map.Entry<String, Integer> state : statesNE.entrySet()) {
            sum += state.getValue();
        }
        System.out.println(sum);

        System.out.println("\nDisplay the average population of this dictionary of states: " + (sum/statesNE.size()));

        System.out.println("\nRemove the states with population smaller than 4.000.000: ");
        Iterator<Integer> iterator = statesNE.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4000000) iterator.remove();
        }
        System.out.println(statesNE);

        System.out.println("\nDelete the dictionary of states with their respective estimated populations: ");
        statesNE.clear();
        System.out.println(statesNE);

        System.out.println("\nCheck that the dictionary is empty: ");
        System.out.println(statesNE.isEmpty());
    }
}
