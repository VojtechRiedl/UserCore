package me.histal.usercore.user.listeners;

import me.histal.usercore.UserCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener implements Listener {

    private UserCore plugin;

    public LoginListener() {
        this.plugin = UserCore.getInstance();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        plugin.getUserManager().createOrGetUser(e.getPlayer());

    }


}
