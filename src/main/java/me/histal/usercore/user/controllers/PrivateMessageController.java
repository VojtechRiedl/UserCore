package me.histal.usercore.user.controllers;

import me.histal.usercore.UserCore;
import me.histal.usercore.user.User;

public class PrivateMessageController {

    private UserCore plugin;

    public PrivateMessageController() {
        this.plugin = UserCore.getInstance();
    }

    public boolean switchTogglePrivateMessage(User user) {
        if(user == null) {
            return false;
        }
        user.setTogglePrivateMessage(!user.getTogglePrivateMessage());
        return true;
    }
}
