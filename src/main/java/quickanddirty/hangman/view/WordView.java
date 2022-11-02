package quickanddirty.hangman.view;

import quickanddirty.hangman.controller.WordController;
import quickanddirty.hangman.model.WordModel;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class WordView {
    private final WordController wordCont;
    private final WordModel word;
    private final Scanner scanner;

    public WordView(){
        wordCont = new WordController();
        word = wordCont.getRandomWord();
        scanner = new Scanner(System.in);
    }

    public void drawUi() {
        while (Arrays.toString(word.getGuessedChar()).contains("*")) {
            out.println("Word: ");
            out.println(word.getGuessedChar());
            wordCont.checkLetter(readChar(), word);
        }
        out.println("You guessed the word: " + word.getWord());
    }
    public char readChar(){
        out.println("Guess: ");
        String line = scanner.nextLine();
        return line.charAt(0);
    }
}
