package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CriminalInterrogation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        List<String> answers = new ArrayList<>();

        System.out.println("Questions: ");
        System.out.print("\nDid you call the victim? ");
        String answer = reader.next();
        answers.add(answer.toLowerCase());

        System.out.print("\nWere you at the crime scene? ");
        answer = reader.next();
        answers.add(answer.toLowerCase());

        System.out.print("\nDo you live near the victim? ");
        answer = reader.next();
        answers.add(answer.toLowerCase());

        System.out.print("\nOwed to victim? ");
        answer = reader.next();
        answers.add(answer.toLowerCase());

        System.out.print("\nHave you ever worked with the victim? ");
        answer = reader.next();
        answers.add(answer.toLowerCase());
    
        System.out.println("\nAnswers: " + answers);
    
        int counter = 0;
        Iterator<String> count = answers.iterator();
        while(count.hasNext()){
                String answ = count.next();
            if(answ.contains("yes")) {
                    counter ++;
            }
        }

        switch (counter) {
            case 2:
                System.out.println("\nSuspect.");
                break;
            case 3:
            case 4:
                System.out.println("\nAccomplice.");
                break;
            case 5:
                System.out.println("\nKiller.");
                break;
            
            default:
                System.out.println("\nInnocent.");
                break;
        }
    }
}
