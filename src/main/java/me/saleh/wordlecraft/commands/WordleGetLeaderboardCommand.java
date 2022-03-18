package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.utils.ScoreUtil;
public class WordleGetLeaderboardCommand extends BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            String leaderBoard = ScoreUtil.GetLeaderboard();
            Broadcast(leaderBoard);
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        } 
        return true;
    }
}