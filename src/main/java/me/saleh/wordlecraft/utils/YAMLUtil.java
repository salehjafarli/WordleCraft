package me.saleh.wordlecraft.utils;
import me.saleh.wordlecraft.WordleGame;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
public class YAMLUtil {
    public static <T> T ImportResourceYAML(String ResourceName){
        //Dont read that file from resource,instead read from jar directory path
        InputStream inputStream = WordleGame.class.getClassLoader().getResourceAsStream(ResourceName);
        Yaml yaml = new Yaml();
        var object =  yaml.load(inputStream);
        return (T)object;
    }
    public  static <T> T ImportYAML(String Name){
        Yaml yaml = new Yaml();
        try{
            InputStream inputStream = new FileInputStream(Name);
            Object res =  yaml.load(inputStream);
            return (T)res;
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void InitYAML(){
        File theDir = new File(".\\plugins\\WordleCraft");
        if (!theDir.exists()){
            Boolean DirRes = theDir.mkdirs();
        }
        File yamlFile = new File(".\\plugins\\WordleCraft\\scores.yml");
        try{
            Boolean CreRes = yamlFile.createNewFile();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
