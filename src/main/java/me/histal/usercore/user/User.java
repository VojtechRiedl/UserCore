package me.histal.usercore.user;

public class User {

    private boolean togglePrivateMessage;
    private short rank;

    public User() {
        this.togglePrivateMessage = true;
        this.rank = 1;
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
}
