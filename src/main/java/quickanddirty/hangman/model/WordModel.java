package quickanddirty.hangman.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WordModel {
//do unchecked ***** array to replace with guessed characters
    private long id;
    private String word;
    private char[] guessedWord;

    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        //THIS IS DUMB FIX IT
        guessedWord = new char[word.toCharArray().length];
        Arrays.fill(guessedWord, '*');

        this.word = word;
    }

    public char[] getGuessedChar() {
        return guessedWord;
    }

    public void setGuessedChar(int id, char guessedChar) {
        this.guessedWord[id] = guessedChar;
    }

    public char[] getWordChar() {
        return word.toCharArray();
    }
}
