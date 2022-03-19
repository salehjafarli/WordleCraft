package me.saleh.wordlecraft;
import me.saleh.wordlecraft.TimerTasks.GuiNotifierTask;
import me.saleh.wordlecraft.TimerTasks.MainTask;
import java.util.*;
import static me.saleh.wordlecraft.utils.YAMLUtil.ImportResourceYAML;

public class WordleGame {
    //Instance Field
    public String SelectedWord;

    //Game status
    public static Boolean IsStarted = false;
    public static WordleGame Game;

    //Timers
    private static Timer gameTimer;
    private static Timer childTimer;
    private static TimerTask MainTask;
    private static TimerTask GuiNotifierTask;

    private WordleGame(String selectedWord){
        this.SelectedWord = selectedWord;
    }
    public static void Start(){
        Random rand = new Random();
        int wordIndex = rand.nextInt(2308);
        String selected = GetWord(wordIndex);
        IsStarted = true;
        Game = new WordleGame(selected);
        InitTimers();
    }
    public static void Stop(){
        IsStarted = false;
        Game = null;
        gameTimer.cancel();
        childTimer.cancel();
        gameTimer = null;
        childTimer = null;
    }
    public static void InitTimers(){
        gameTimer = new Timer();
        childTimer = new Timer();
        MainTask = new MainTask();
        GuiNotifierTask = new GuiNotifierTask();
        Calendar Currentdate = Calendar.getInstance();
        long timeInSecs = Currentdate.getTimeInMillis();
        Date date = new Date(timeInSecs + (60 * 1000));
        gameTimer.schedule(MainTask, date);
        childTimer.schedule(GuiNotifierTask,0,1000);
    }
    public GuessLevel[] Guess(String guess) {
        if(!CheckWord(guess)){
            return null;
        }
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
        Map<String,Object> data = ImportResourceYAML("words.yml");;
        Object wordObj = data.get("Ma");
        List<String> words =(List<String>) wordObj;
        return words.get(index);
    }
    private static Boolean CheckWord(String word){
        Map<String,Object> data = ImportResourceYAML("words.yml");;
        Object wordObj = data.get("Ma");
        List<String> Mwords =(List<String>) wordObj;
        var res1 = Mwords.contains(word);
        Object wordObj2 = data.get("Oa");
        List<String> Owords =(List<String>) wordObj2;
        var res2 = Owords.contains(word);
        return res1 || res2;
    }
}
