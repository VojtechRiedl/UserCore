package me.histal.usercore.user.listeners;

import me.histal.usercore.UserCore;
import me.histal.usercore.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginListener implements Listener {

    private UserCore plugin;

    public LoginListener() {
        this.plugin = UserCore.getInstance();
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        User user = plugin.getUserManager().createOrGetUser(e.getPlayer());
        user.setPlayer(e.getPlayer());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        User user = plugin.getUserManager().createOrGetUser(e.getPlayer());
        user.setPlayer(null);
    }


}
