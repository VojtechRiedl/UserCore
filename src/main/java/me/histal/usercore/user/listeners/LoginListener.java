package me.histal.usercore.user.listeners;

import me.histal.usercore.UserCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener {

    private UserCore plugin;

    public LoginListener() {
        this.plugin = UserCore.getInstance();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        plugin.getUserManager().CreateOrGetUser(e.getPlayer());

    }


}
