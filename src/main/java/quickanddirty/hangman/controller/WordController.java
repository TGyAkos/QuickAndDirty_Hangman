package quickanddirty.hangman.controller;

import quickanddirty.hangman.dao.WordDao;
import quickanddirty.hangman.model.WordModel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class WordController {
    private final ArrayList<WordModel> allWords;

    public WordController(){
        WordDao wordDao = new WordDao();
        allWords = wordDao.getWordsFormDataBase();
    }

    public WordModel getRandomWord(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, allWords.size());
        return allWords.get(randomNum);
    }

    public WordModel checkLetter(char letter, WordModel wordModel){
        for (int i = 0; i < wordModel.getWordChar().length; i++) {
            if (letter == wordModel.getWordChar()[i]){
                wordModel.setGuessedChar(i, letter);
            }
        }
        return wordModel;
    }
}
