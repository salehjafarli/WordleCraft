package me.saleh.wordlecraft.commands;
import me.saleh.wordlecraft.utils.ScoreUtil;
public class WordleGetScoreCommand extends BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            String score = ScoreUtil.GetScore(p.getName());
            p.sendMessage(String.format("Your score is %s",score));
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        } 
        return true;
    }
}