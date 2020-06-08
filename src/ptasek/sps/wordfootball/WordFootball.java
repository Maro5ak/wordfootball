package ptasek.sps.wordfootball;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordFootball {
    private List<String> words;
    private List<String> languageStrings;
    private Random rnd = new Random();
    private int rounds = 0;

    public void gameStart(String language){
        Scanner scanner = new Scanner(System.in);
        language.toLowerCase();
        if(language.equals("english") || language.equals("anglictina") || language.equals("eng")){
            loadLanguage("eng");
        }
        else if(language.equals("cestina") || language.equals("čeština") || language.equals("cz")){
            loadLanguage("cz");
        }

        for(int i = 0; i < 3; i++){
            System.out.println(languageStrings.get(i));
        }


        //Main game loop
        String nextWord = "";
        String lastTwo;
        while(true) {
            System.out.print(languageStrings.get(4));
            String userWord = scanner.nextLine();
            if(userWord.isEmpty()) continue;
            if(userWord.length() < 2) continue;
            if(userWord.equals("!q")){
                break;
            }
            else {
                if(rounds > 0 && !nextWord.substring(nextWord.length()-2).equals(userWord.substring(0, 2))) {
                    System.out.println(languageStrings.get(5));
                    break;
                }
                lastTwo = userWord.substring(userWord.length()-2);
                while(true) {
                    nextWord = words.get(rnd.nextInt(words.size()));
                    if(nextWord.length() > 1) {
                        if (nextWord.substring(0, 2).equals(lastTwo)) {
                            System.out.println(nextWord);
                            break;
                        }
                    }
                }
                rounds++;
            }
        }
    }
    //Loads in language pack and word "database"
    private void loadLanguage(String lang){
        Path filePath = new File("GLOBAL_STRINGS_" + lang + ".txt").toPath();
        Path wordsPath = new File("WORDS_" + lang + ".txt").toPath();
        try {
            languageStrings = Files.readAllLines(filePath);
            words = Files.readAllLines(wordsPath);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
