package me.saleh.wordlecraft.commands;

import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WordleStopCommand extends  BaseCommand{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.isOp()){
                String CorrectWord = WordleGame.Game.SelectedWord;
                WordleGame.Stop();
                Bukkit.broadcastMessage(String.format("The game is stopped.The correct word was : %s",CorrectWord));
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
