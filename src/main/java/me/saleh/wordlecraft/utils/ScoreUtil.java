package me.saleh.wordlecraft.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import static me.saleh.wordlecraft.utils.YAMLUtil.ImportYAML;

public class ScoreUtil {

    //Create new YAML file on plugin enable,and r/w data
    //scores.yml init!!!
    private static final String ScoreYml = ".\\plugins\\WordleCraft\\scores.yml";
    public static void SetScore(String username) throws IOException {
        Map<String,Integer> data = ImportYAML(ScoreYml);
        if(data == null){
            System.out.println("SetScore - data is null");
            return;
        }
        data.put(username,data.get(username) == null ? 1 : data.get(username)  + 1);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.writeValue(new File(ScoreYml), data);
    }
    public static String GetLeaderboard(){
        Map<String,Integer> data = ImportYAML(ScoreYml);
        if(data == null){
            System.out.println("GetLeaderboard - data is null");
            return "";
        }
        String result = "";
        var list = GetTopTen(data);
        for (Map.Entry<String, Integer> pair : list) {
            result = result + String.format("%s - %s", pair.getKey(), pair.getValue()) + "\n";
        }
        return result;
    }
    public static Integer GetScore(String userName){
        Map<String,Integer> data = ImportYAML(ScoreYml);
        if(data == null){
            System.out.println("GetScore - data is null");
            return 0;
        }
        for(Map.Entry<String,Integer> pair : data.entrySet()){
            System.out.println(pair.getKey());
            if(Objects.equals(pair.getKey(), userName)){
                return pair.getValue();
            }
        }
        return 0;
    }
    private static List<Map.Entry<String, Integer>> GetTopTen (Map<String,Integer> data){
        List<Map.Entry<String, Integer>> result = new ArrayList<>(10);
        for(Map.Entry<String,Integer> pair : data.entrySet()){
            if(result.size() == 0  || result.size() < 10 ){
                add(result,pair);
            }
            else if(pair.getValue() > result.get(0).getValue()){
                add(result,pair);
                result.remove(0);
            }
        }
        return  result;
    }
    private static void add(List<Map.Entry<String, Integer>> result,Map.Entry<String,Integer> num){
        if( result.size() == 0){
            result.add(num);
            return;
        }
        else{
            var i =0;
            for(i = 0; i < result.size();i++){
                var n = result.get(i).getValue();
                if(num.getValue() < n){
                    result.add(i,num);
                    return;
                }
            }
            result.add(num);
        }
    }
}