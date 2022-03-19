package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.GuessLevel;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.GuessStatusMapper;
import me.saleh.wordlecraft.utils.MessageUtil;
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
                MessageUtil.SendToPlayer(p,"Too many arguments for command");
                return  false;
            }
            else if(args.length == 0){
                MessageUtil.SendToPlayer(p,"No argument was provided");
                return  false;
            }
            else{
                String word = args[0];
                var wordLength = word.length();
                if( wordLength == 5){
                    if(!WordleGame.IsStarted){
                        MessageUtil.SendToPlayer(p,Messages.OfferStart);
                        return true;
                    }
                    var game = WordleGame.Game;
                    var guess = game.Guess(word);
                    if(guess == null){
                        MessageUtil.SendToPlayer(p,"This word does not exist in library");
                        return true;
                    }
                    Boolean _isFound = IsFound(guess);
                    String GuessResult = GuessStatusMapper.Map(guess,word);
                    MessageUtil.SendToPlayer(p,"Your guess is: %s",GuessResult);
                    if(_isFound){
                        //Send message to public console
                        MessageUtil.Broadcast("%s found the correct answer!",p.getName());
                        MessageUtil.Broadcast("Game is over.Correct word was %s",game.SelectedWord);
                        try {
                            ScoreUtil.SetScore(p.getName());
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        WordleGame.Stop();
                    }
                }
                else if(wordLength < 5){
                    MessageUtil.SendToPlayer(p,"The word does not contain enough letters");
                }
                else{
                    MessageUtil.SendToPlayer(p,"The word contain too many letters");
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
