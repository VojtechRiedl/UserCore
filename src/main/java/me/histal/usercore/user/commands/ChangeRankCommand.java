package me.histal.usercore.user.commands;

import me.histal.usercore.UserCore;
import me.histal.usercore.Utils;
import me.histal.usercore.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ChangeRankCommand implements TabExecutor {

    private UserCore plugin;

    public ChangeRankCommand() {
        this.plugin = UserCore.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if(args.length != 2){
            player.sendMessage("Použij /rank <hráč> <rank>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target == null){
            player.sendMessage("Hráč nenalezen");
            return true;
        }
        Short rank = Utils.convertStringToShort(args[1]);
        if(rank == null){
            player.sendMessage("Takový rank neexistuje!");
            return true;
        }
        User user = plugin.getUserManager().getUser(target.getName());
        boolean success = plugin.getUserManager().getRankController().setRank(user,rank);

        if(!success){
            player.sendMessage("Rank se nepodařilo změnit");
            return true;
        }
        player.sendMessage("Rank hráče " + target.getName() + " byl změněn na " + rank);
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
