package me.saleh.wordlecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;

public abstract class BaseCommand implements CommandExecutor {
    protected void Broadcast(String message){
        Bukkit.broadcastMessage(message);
    }
    protected  void Broadcast(String message,Object... args){
        Bukkit.broadcastMessage(String.format(message,args));
    }
}
