package me.saleh.wordlecraft;

import me.saleh.wordlecraft.commands.WordleGetWordCommand;
import me.saleh.wordlecraft.commands.WordleGuessCommand;
import me.saleh.wordlecraft.commands.WordleStopCommand;
import me.saleh.wordlecraft.commands.WorldeStartCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class WordleCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("wstart").setExecutor(new WorldeStartCommand());
        this.getCommand("wguess").setExecutor(new WordleGuessCommand());
        this.getCommand("wgetword").setExecutor(new WordleGetWordCommand());
        this.getCommand("wstop").setExecutor(new WordleStopCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
