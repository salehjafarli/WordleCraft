package me.saleh.wordlecraft.utils;
import me.saleh.wordlecraft.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class MessageUtil {
    public static final void Broadcast(String message){
        Bukkit.broadcastMessage(Messages.Prefix + message);
    }
    public static final void Broadcast(String message,Object... args){
        Bukkit.broadcastMessage(Messages.Prefix + String.format(message,args));
    }
    public static void SendToPlayer(Player p, String message){
        p.sendMessage(Messages.Prefix + message);
    }
    public static void SendToPlayer(Player p, String message,Object... args){
        p.sendMessage(Messages.Prefix +String.format(message,args));
    }
}
