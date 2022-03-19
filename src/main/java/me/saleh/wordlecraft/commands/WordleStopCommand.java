package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class WordleStopCommand extends  BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.isOp()){
                if(WordleGame.Game == null){
                   MessageUtil.SendToPlayer(p,Messages.OfferStart);
                }
                else{
                    String CorrectWord = WordleGame.Game.SelectedWord;
                    WordleGame.Stop();
                    MessageUtil.Broadcast("The game is stopped.The correct word was : %s",CorrectWord);
                }
            }
            else{
                MessageUtil.SendToPlayer(p,Messages.NoPermission);
            }
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
}
