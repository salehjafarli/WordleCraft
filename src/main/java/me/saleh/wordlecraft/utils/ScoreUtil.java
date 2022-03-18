package me.saleh.wordlecraft.utils;
public class ScoreUtil {

    public static void SetScore(){
        //Write to yaml file
    }
    public static String GetLeaderboard(){

        //Make filter and get top 10 player!
        Map<String,int> data = ImportYAML();
        String result = "";
        for (Map.Entry<String, Integer> pair : data.entrySet()) {
            result += String.format("%s - %s", pair.getKey(), pair.getValue()) + "%n";
        }
        return result;
    }
    public static String GetScore(String userName){
        Map<String,int> data = ImportYAML();
        //Make search in map
    }

    private static Map<String,int> ImportYAML(){
        InputStream inputStream = WordleGame.class.getClassLoader().getResourceAsStream("scores.yml");
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }
}