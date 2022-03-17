package me.saleh.wordlecraft.commands;

import me.saleh.wordlecraft.GuessLevel;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.GuessStatusMapper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class WordleGuessCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(args.length > 1){
                System.out.println("Too many arguments for command");
            }
            else if(args.length == 0){
                System.out.println("No argument was provided");
            }
            else{
                String word = args[0];
                var wordLength = word.length();
                if( wordLength == 5){
                    var game = WordleGame.Game;
                    var guess = game.Guess(word);
                    Boolean _isFound = IsFound(guess);
                    String GuessResult = GuessStatusMapper.Map(guess);
                    p.sendMessage(String.format("Your guess is: %s",GuessResult));
                    if(_isFound){
                        //Send message to public console
                        System.out.printf("%s found the correct answer!%n",p.getName());
                        System.out.printf("Game is over.Correct word was %s%n",game.SelectedWord);
                        WordleGame.Stop();
                    }
                    //
                }
                else if(wordLength < 5){
                    System.out.println("The word does not contain enough letters");
                }
                else{
                    System.out.println("The word contain too many letters");
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
