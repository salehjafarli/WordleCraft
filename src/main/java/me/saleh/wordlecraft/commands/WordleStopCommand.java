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
                if(WordleGame.Game == null){
                    p.sendMessage(Messages.OfferStart);
                }
                else{
                    String CorrectWord = WordleGame.Game.SelectedWord;
                    WordleGame.Stop();
                    Broadcast(String.format("The game is stopped.The correct word was : %s",CorrectWord));
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
