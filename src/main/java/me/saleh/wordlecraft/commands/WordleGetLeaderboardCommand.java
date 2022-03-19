package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.utils.MessageUtil;
import me.saleh.wordlecraft.utils.ScoreUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class WordleGetLeaderboardCommand extends BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            String leaderBoard = ScoreUtil.GetLeaderboard();
            MessageUtil.Broadcast("\n" + leaderBoard);
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
}