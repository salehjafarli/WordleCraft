package me.saleh.wordlecraft.TimerTasks;
import me.saleh.wordlecraft.Messages;
import me.saleh.wordlecraft.WordleGame;
import me.saleh.wordlecraft.utils.MessageUtil;
import org.bukkit.ChatColor;
import java.util.TimerTask;
public class MainTask extends TimerTask {
    @Override
    public void run() {
        MessageUtil.Broadcast(Messages.GameIsOver);
        MessageUtil.Broadcast("The correct word was : %s", ChatColor.GREEN + WordleGame.Game.SelectedWord);
        WordleGame.Stop();
    }
}
