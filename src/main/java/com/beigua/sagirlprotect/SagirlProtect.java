package com.beigua.sagirlprotect;

import com.beigua.sagirlprotect.Events.PlayerJoinCheck;
import com.beigua.sagirlprotect.Events.checkPlayerCode;
import com.beigua.sagirlprotect.Events.getOnlinePlayers;
import org.bukkit.plugin.java.JavaPlugin;

public final class SagirlProtect extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveConfig();

        this.saveResource("player.yml" , false);
        this.saveResource("tempPlayerCheck.yml" , false);

        out("[SagirlProtect] 已加载！作者:Bei_Gua_");
        getServer().getPluginManager().registerEvents(new getOnlinePlayers() , this);
        getServer().getPluginManager().registerEvents(new PlayerJoinCheck() , this);
        getServer().getPluginManager().registerEvents(new checkPlayerCode() , this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
        out("[SagirlProtect] 已卸载！作者:Bei_Gua_");
    }

    private static void out(Object x){
        System.out.println(x);
    }
}
