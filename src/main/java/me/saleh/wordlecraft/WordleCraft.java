package me.saleh.wordlecraft;
import me.saleh.wordlecraft.commands.WordleGetWordCommand;
import me.saleh.wordlecraft.commands.WordleGuessCommand;
import me.saleh.wordlecraft.commands.WordleStopCommand;
import me.saleh.wordlecraft.commands.WorldeStartCommand;
import me.saleh.wordlecraft.commands.WordleGetLeaderboardCommand;
import me.saleh.wordlecraft.commands.WordleGetScoreCommand;
import org.bukkit.plugin.java.JavaPlugin;
import static me.saleh.wordlecraft.utils.YAMLUtil.InitYAML;

public final class WordleCraft extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("wstart").setExecutor(new WorldeStartCommand());
        this.getCommand("wguess").setExecutor(new WordleGuessCommand());
        this.getCommand("wgetword").setExecutor(new WordleGetWordCommand());
        this.getCommand("wstop").setExecutor(new WordleStopCommand());
        this.getCommand("wleaderboard").setExecutor(new WordleGetLeaderboardCommand());
        this.getCommand("wscore").setExecutor(new WordleGetScoreCommand());
        InitYAML();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
