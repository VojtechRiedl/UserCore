package me.histal.usercore;

import me.histal.usercore.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UserCore extends JavaPlugin {

    private static UserCore userCore;

    private UserManager userManager;


    @Override
    public void onEnable() {
        userCore = this;
        userManager = new UserManager();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static UserCore getInstance() {
        return userCore;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
