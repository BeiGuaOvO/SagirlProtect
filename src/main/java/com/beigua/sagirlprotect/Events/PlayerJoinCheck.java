package com.beigua.sagirlprotect.Events;

import com.beigua.sagirlprotect.SagirlProtect;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class PlayerJoinCheck implements Listener {
    public static File file = new File(SagirlProtect.getPlugin(SagirlProtect.class).getDataFolder() , "player.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static File file1 = new File(SagirlProtect.getPlugin(SagirlProtect.class).getDataFolder() , "tempPlayerCheck.yml");
    public static FileConfiguration config1 = YamlConfiguration.loadConfiguration(file1);

    public static String head = ChatColor.GRAY + "[" + ChatColor.RED + "防御系统" + ChatColor.GRAY + "]" + ChatColor.WHITE;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        boolean f1 = getPlayerConfig(player);
        boolean f2 = getTempData(player);
        if (!f1){
            if (!f2){
                String code = com.beigua.sagirlprotect.Tools.getCode.getRCode();
                player.kickPlayer(head + "您的信息未被录入到白名单中\n"
                        + "请到QQ群中发送如下验证码后，方可进入服务器\n"
                        + ChatColor.AQUA + code);

                config1.set(player.getName() , code);
                config1.set(code , player.getName());

                try{
                    config1.save(file1);
                }catch (IOException ee){
                    ee.printStackTrace();
                }

            }else {
                String code = config1.getString(player.getName());
                player.kickPlayer(head + "您的信息未被录入到白名单中\n"
                        + "请到QQ群中发送如下验证码后，方可进入服务器\n"
                        + ChatColor.AQUA + code);
            }


        }
    }

    public static boolean getPlayerConfig(Player player){
        String name = player.getName();


        if (config.getString(name) == null){
            return false; //没有此玩家的信息
        }
        else {
            return true; //有此玩家的信息
        }
    }

    public static boolean getTempData(Player player){
        String name = player.getName();

        if (config1.getString(name) == null){
            return false;//没有此玩家的数据
        }else {
             return true;//有此玩家的数据
        }
    }

}
