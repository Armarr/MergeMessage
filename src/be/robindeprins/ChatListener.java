/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.robindeprins;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author robin
 */
public class ChatListener implements Listener {

    private Map<Player, String> storedMsg = new HashMap<>();

    @EventHandler(ignoreCancelled = true)
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        if (e.getMessage().endsWith("&")) {
            storeMessage(e.getMessage().substring(0, e.getMessage().length() - 1) + " ", e.getPlayer());
            e.setCancelled(true);
        } else {
            if (storedMsg.containsKey(e.getPlayer())) {
                e.setMessage(storedMsg.get(e.getPlayer()) + e.getMessage());
                storedMsg.remove(e.getPlayer());
            }
        }
    }

    private void storeMessage(String msg, Player player) {
        if (storedMsg.containsKey(player)) {
            storedMsg.put(player, storedMsg.get(player) + msg);
        } else {
            storedMsg.put(player, msg);
        }
    }
}
