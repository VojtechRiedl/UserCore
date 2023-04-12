package me.histal.usercore.user.commands;

import me.histal.usercore.UserCore;
import me.histal.usercore.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PrivateMessageToggleCommand implements TabExecutor {
    private UserCore plugin;

    public PrivateMessageToggleCommand() {
        this.plugin =   UserCore.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if(args.length != 0){
            player.sendMessage("Použij /pmtoggle");
            return true;
        }
        User user = plugin.getUserManager().getUser(player.getName());

        boolean success = plugin.getUserManager().getPrivateMessageController().switchTogglePrivateMessage(user);
        if(!success){
            player.sendMessage("Něco se pokazilo");
            return true;
        }
        player.sendMessage( (user.getTogglePrivateMessage() ? "Povolil " : "Zakázal ")  + "jsi soukromé zprávy");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            return Bukkit.getOnlinePlayers().stream().map(player -> player.getName()).collect(Collectors.toList());
        }
        return null;
    }
}
