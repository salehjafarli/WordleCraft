package me.saleh.wordlecraft.commands;

import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WordleGetWordCommand extends BaseCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.isOp()){
                if(WordleGame.Game == null){
                    p.sendMessage(Messages.OfferStart);
                }
                else{
                    p.sendMessage(WordleGame.Game.SelectedWord);
                }
            }
            else{
                p.sendMessage(Messages.NoPermission);
            }
        }
        else{
            System.out.println(Messages.NotSentByPlayer);
        } 
        return true;
    }
}
