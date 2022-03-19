package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.utils.MessageUtil;
import me.saleh.wordlecraft.utils.ScoreUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class WordleGetScoreCommand extends BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            String username = "";
            if(args.length > 1){
                MessageUtil.SendToPlayer(p,"Too many arguments for command");
                return false;
            }
            if(args.length == 1){
                username= args[0];
                Integer score = ScoreUtil.GetScore(username);
                MessageUtil.SendToPlayer(p,"%s's score is %s",username,score);
            }
            else {
                username = p.getName();
                Integer score = ScoreUtil.GetScore(username);
                MessageUtil.SendToPlayer(p,"Your score is %s",score);
            }
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
}