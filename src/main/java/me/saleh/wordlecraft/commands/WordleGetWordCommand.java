package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class WordleGetWordCommand extends BaseCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.isOp()){
                if(WordleGame.Game == null){
                    MessageUtil.SendToPlayer(p,Messages.OfferStart);
                }
                else{
                    MessageUtil.SendToPlayer(p,WordleGame.Game.SelectedWord);
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
