package me.histal.usercore.user;

import org.bukkit.entity.Player;

public class User {

    private boolean togglePrivateMessage;
    private short rank;
    private Player player;

    public User() {
        this.togglePrivateMessage = true;
        this.rank = 1;
        this.player = null;
    }

    public boolean getTogglePrivateMessage() {
        return this.togglePrivateMessage;
    }

    public void setTogglePrivateMessage(boolean togglePrivateMessage) {
        this.togglePrivateMessage = togglePrivateMessage;
    }

    public short getRank() {
        return this.rank;
    }

    public void setRank(short rank) {
        this.rank = rank;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
