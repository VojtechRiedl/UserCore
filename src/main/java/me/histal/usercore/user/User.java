package me.histal.usercore.user;

public class User {

    private boolean togglePrivateMessage;
    private short rank;

    public User() {
        this.togglePrivateMessage = true;
        this.rank = 0;
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

    public boolean setRank(short rank) {
        if(rank < 0 || rank > 128) {
            return false;
        }
        this.rank = rank;
        return true;
    }
}
