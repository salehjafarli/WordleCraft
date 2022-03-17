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
                Bukkit.broadcastMessage(WordleGame.Game.SelectedWord);
            }
            else{
                Bukkit.broadcastMessage(Messages.NoPermission);
            }
        }
        else{
            Bukkit.broadcastMessage(Messages.NotSentByPlayer);
        }
        return true;
    }
}
