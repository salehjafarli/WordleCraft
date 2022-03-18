package me.saleh.wordlecraft.utils;

import me.saleh.wordlecraft.GuessLevel;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class GuessStatusMapper {
    private static Map<GuessLevel, ChatColor> Colors = Map.of(
            GuessLevel.Correct,ChatColor.GREEN,
            GuessLevel.CorrectButWrongPlace,ChatColor.YELLOW,
            GuessLevel.Wrong,ChatColor.GRAY
    );
    public static String Map(GuessLevel[] GuessData,String word){
        StringBuilder result = new StringBuilder();
        for (var i = 0; i < word.length();i++){
            ChatColor charColor = Colors.get(GuessData[i]);
            result.append(charColor);
            result.append(word.charAt(i));
        }
        return result.toString();
    }
}
