package com.beigua.sagirlprotect.Events;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class getOnlinePlayers implements Listener {
    @EventHandler
    public void onPlayerListToFriend(MiraiGroupMessageEvent e){
        if (e.getMessage().equals("！在线人数")){
            MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessage("当前在线人数：" + Bukkit.getOnlinePlayers().size() + "人");
        }
    }
}
