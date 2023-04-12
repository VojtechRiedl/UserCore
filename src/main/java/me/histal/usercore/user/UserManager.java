package me.histal.usercore.user;

import me.histal.usercore.UserCore;
import me.histal.usercore.user.controllers.PrivateMessageController;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class UserManager {

    private UserCore plugin;
    private HashMap<String,User> users = new HashMap<>();

    private PrivateMessageController privateMessageController;


    public UserManager() {
       this.plugin = UserCore.getInstance();
       this.privateMessageController = new PrivateMessageController();
    }



    public User createOrGetUser(Player player) {
        if(player == null || player.getName().isEmpty()){
            return null;
        }
        User user = getUser(player.getName().toLowerCase());
        if(user != null) {
            return user;
        }
        user = new User();
        users.put(player.getName().toLowerCase(),user);
        return user;
    }


    public User getUser(String name) {
        if(!users.containsKey(name.toLowerCase())){
            return null;
        }
        return users.get(name.toLowerCase());
    }

    public PrivateMessageController getPrivateMessageController() {
        return privateMessageController;
    }
}
