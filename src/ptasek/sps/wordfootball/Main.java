package ptasek.sps.wordfootball;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> currentLanguages = new ArrayList<>();
        currentLanguages.add("English");
        currentLanguages.add("Čeština");
        for(String s : currentLanguages){
            System.out.println(s);
        }
        System.out.println("_______________________________________________________________________________");
        System.out.print(">");
        WordFootball game = new WordFootball();
        Scanner scanner = new Scanner(System.in);
        game.gameStart(scanner.nextLine());
    }
}
