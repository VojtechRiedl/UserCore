package me.histal.usercore;

import me.histal.usercore.user.UserManager;
import me.histal.usercore.user.commands.ChangeRankCommand;
import me.histal.usercore.user.commands.PrivateMessageCommand;
import me.histal.usercore.user.commands.PrivateMessageToggleCommand;
import me.histal.usercore.user.listeners.LoginListener;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class UserCore extends JavaPlugin {

    private static UserCore userCore;

    private UserManager userManager;


    @Override
    public void onEnable() {
        userCore = this;
        userManager = new UserManager();
        // Plugin startup logic

        registerCommand("pmtoggle", new PrivateMessageToggleCommand());
        registerCommand("rank", new ChangeRankCommand());
        registerCommand("pm", new PrivateMessageCommand());
        this.getServer().getPluginManager().registerEvents(new LoginListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommand(String cmd, TabExecutor executor) {
        Objects.requireNonNull(this.getCommand(cmd)).setExecutor(executor);
        Objects.requireNonNull(this.getCommand(cmd)).setTabCompleter(executor);
    }


    public UserManager getUserManager() {
        return userManager;
    }
    public static UserCore getInstance() {
        return userCore;
    }




}
