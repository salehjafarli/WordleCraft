package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class WorldeStartCommand  extends BaseCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p)
        {
            if(WordleGame.IsStarted){
                MessageUtil.Broadcast("There is already an ongoing game!");
            }
            else{
                WordleGame.Start();
                MessageUtil.Broadcast(Messages.GameIsStarted);
            }
        }
        else{
           System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
}
