package team.sensivity.hardcoreplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import team.sensivity.hardcoreplugin.mysql.PlayerInfos;

public class PlayerDeath implements Listener {

    public void onDeath(PlayerDeathEvent event){
        Player p = event.getEntity();

        PlayerInfos.updatePlayer(p.getUniqueId().toString(), "dead", "1");
        p.kickPlayer("Du bist gestorben, du kannst erst Morgen wieder joinen.");
    }
}
