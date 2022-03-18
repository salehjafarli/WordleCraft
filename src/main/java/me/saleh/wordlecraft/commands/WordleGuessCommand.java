package me.saleh.wordlecraft.commands;

import me.saleh.wordlecraft.GuessLevel;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.GuessStatusMapper;
import me.saleh.wordlecraft.utils.ScoreUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Arrays;

public class WordleGuessCommand extends BaseCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(args.length > 1){
                p.sendMessage("Too many arguments for command");
            }
            else if(args.length == 0){
                p.sendMessage("No argument was provided");
            }
            else{
                String word = args[0];
                var wordLength = word.length();
                if( wordLength == 5){
                    var game = WordleGame.Game;
                    var guess = game.Guess(word);
                    Boolean _isFound = IsFound(guess);
                    String GuessResult = GuessStatusMapper.Map(guess,word);
                    p.sendMessage(String.format("Your guess is: %s",GuessResult));
                    if(_isFound){
                        //Send message to public console
                        Broadcast("%s found the correct answer!",p.getName());
                        Broadcast("Game is over.Correct word was %s",game.SelectedWord);
                        try {
                            ScoreUtil.SetScore(p.getName());
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        WordleGame.Stop();
                    }
                }
                else if(wordLength < 5){
                    p.sendMessage("The word does not contain enough letters");
                }
                else{
                    p.sendMessage("The word contain too many letters");
                }
            }
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
    private Boolean IsFound(GuessLevel[] guessData){
        return Arrays.stream(guessData).allMatch(lvl -> lvl == GuessLevel.Correct);
    }
}
