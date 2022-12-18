package com.beigua.sagirlprotect.Events;

import com.beigua.sagirlprotect.Exception.ConfigDataNotFoundException;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;


public class checkPlayerCode extends PlayerJoinCheck implements Listener {
    @EventHandler
    public void onCheck(MiraiGroupMessageEvent e){
        try{
            String message = e.getMessage();
            if (message.length() == 6){
                boolean f = getPlayerData(message);
                if (f){
                    String playerName = config1.getString(message);
                    String code = config1.getString(playerName);

                    if (code == null){
                        throw new ConfigDataNotFoundException();
                    }
                    if (message.equals(code)){
                        MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessage("绑定成功！");
                        config.set(playerName , "enable");
                        config1.set(playerName , null);
                        config1.set(code , null);
                        config.save(file);
                        config1.save(file1);
                    }
                }
            }

        }catch (ConfigDataNotFoundException e1){
            System.out.println(e1.getMessage());
        }catch (IOException e2){
            e2.printStackTrace();
        }
    }

    private static boolean getPlayerData(String x) {
        if (config1.getString(x) == null){
            return false; //nope
        }
        else {
            return true; //yep
        }
    }
}
