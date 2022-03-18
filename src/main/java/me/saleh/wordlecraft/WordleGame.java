package me.saleh.wordlecraft;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordleGame {

    public String SelectedWord;

    public static Boolean IsStarted = false;
    public static WordleGame Game;

    private WordleGame(String selectedWord){
        this.SelectedWord = selectedWord;
    }
    public static void Start(){
        Random rand = new Random();
        int wordIndex = rand.nextInt(10663);
        String selected = GetWord(wordIndex);
        IsStarted = true;
        Game = new WordleGame(selected);
    }
    public static void Stop(){
        IsStarted = false;
        Game = null;
    }
    public GuessLevel[] Guess(String guess) {
        var res = new GuessLevel[5];
        for (var i = 0;i < 5;i++) {
            char c = guess.charAt(i);
            var glevel = CheckChar(c,i);
            res[i] = glevel;
        }
        return res;
    }
    private GuessLevel CheckChar(char c,int index){
        if(SelectedWord.charAt(index) == c){
            return GuessLevel.Correct;
        }
        else if(SelectedWord.indexOf(c) != -1){
            return GuessLevel.CorrectButWrongPlace;
        }
        return GuessLevel.Wrong;
    }

    private static String GetWord(int index){
        InputStream inputStream = WordleGame.class.getClassLoader().getResourceAsStream("words.yml");
        Yaml yaml = new Yaml();
        Map<String,Object> data = yaml.load(inputStream);
        Object wordObj = data.get("words");
        List<String> words =(List<String>) wordObj;
        return words.get(index);
    }
}
