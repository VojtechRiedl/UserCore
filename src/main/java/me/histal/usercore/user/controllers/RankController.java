package me.histal.usercore.user.controllers;

import me.histal.usercore.UserCore;
import me.histal.usercore.user.User;

public class RankController {

    private UserCore plugin;

    public RankController() {
        this.plugin = UserCore.getInstance();
    }

    public boolean isValid(short rank) {
        return rank > 0;
    }

    public boolean setRank(User user, short rank) {
        if(!isValid(rank)) {
            return false;
        }
        if(user == null) {
            return false;
        }
        user.setRank(rank);
        return true;
    }
}
