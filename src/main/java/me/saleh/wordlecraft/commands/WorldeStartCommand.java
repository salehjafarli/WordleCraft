package me.saleh.wordlecraft.commands;

import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class WorldeStartCommand  extends BaseCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p)
        {
            if(WordleGame.IsStarted){
                Broadcast("There is already an ongoing game!");
            }
            else{
                WordleGame.Start();
                Broadcast(Messages.GameIsStarted);
            }
            //
        }
        else{
           System.out.println(Messages.NotSentByPlayer);
        }
        return true;
    }
}
