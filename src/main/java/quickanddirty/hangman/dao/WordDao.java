package quickanddirty.hangman.dao;

import quickanddirty.hangman.dao.connection.Connect;
import quickanddirty.hangman.model.WordModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WordDao {
    private static final String SELECT_WORDS = "SELECT * FROM hangman_words";

    public ArrayList<WordModel> getWordsFormDataBase(){
        Connect newConnection = new Connect();
        Connection conn = newConnection.getConnected();

        ArrayList<WordModel> wordModelArrayList = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(SELECT_WORDS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                long id = rs.getLong(1);
                String word = rs.getString(2);

                WordModel wordModelFromDB = new WordModel();
                wordModelFromDB.setId(id);
                wordModelFromDB.setWord(word);

                wordModelArrayList.add(wordModelFromDB);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        newConnection.closeConnected(conn);
        return wordModelArrayList;
    }
}
