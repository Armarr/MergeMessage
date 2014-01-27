/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.robindeprins;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author robin
 */
public class MergeMessage extends JavaPlugin {

    private ChatListener listener;
            
    @Override
    public void onEnable() {
        ChatListener listener = new ChatListener();
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
    }

}
