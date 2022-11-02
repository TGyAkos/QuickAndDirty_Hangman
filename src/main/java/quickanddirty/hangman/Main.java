package quickanddirty.hangman;

import quickanddirty.hangman.view.WordView;

public class Main {
    public static void main(String[] args) {
        WordView wordView = new WordView();
        wordView.drawUi();
    }
}