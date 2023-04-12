package me.histal.usercore.user.controllers;

import me.histal.usercore.UserCore;
import me.histal.usercore.Utils;
import me.histal.usercore.user.User;

public class PrivateMessageController {

    private UserCore plugin;

    public PrivateMessageController() {
        this.plugin = UserCore.getInstance();
    }

    public boolean switchTogglePrivateMessage(User user) {
        if (user == null) {
            return false;
        }
        user.setTogglePrivateMessage(!user.getTogglePrivateMessage());
        return true;
    }

    public void sendPrivateMessage(User who, User to, String message) {
        if (who == null || to == null || message == null) {
            return;
        }
        if(!to.getTogglePrivateMessage() && who.getRank() < to.getRank()){
            who.getPlayer().sendMessage();
            return;
        }
        to.getPlayer().sendMessage("[" + who.getPlayer().getName() + "] -> " + message);
        who.getPlayer().sendMessage("[" + who.getPlayer().getName() + "] -> " + message);
    }

}