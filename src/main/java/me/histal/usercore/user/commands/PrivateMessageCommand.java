package me.histal.usercore.user.commands;

import me.histal.usercore.UserCore;
import me.histal.usercore.Utils;
import me.histal.usercore.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrivateMessageCommand implements TabExecutor {

    private UserCore plugin;

    public PrivateMessageCommand() {
        this.plugin = UserCore.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if(args.length < 2){
            player.sendMessage("Použij /pm <hráč> <zpráva>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null) {
            player.sendMessage("Hráč nenalezen");
            return true;
        }
        if(target.equals(player)){
            player.sendMessage("Nemůžeš poslat zprávu sobě");
            return true;
        }
        String[] message = Arrays.copyOfRange(args,1,args.length);
        User user = plugin.getUserManager().getUser(player.getName());
        User targetUser = plugin.getUserManager().getUser(target.getName());

        plugin.getUserManager().getPrivateMessageController().sendPrivateMessage(user,targetUser, Utils.stringArrayToString(message));
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
