package team.sensivity.hardcoreplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.sensivity.hardcoreplugin.mysql.PlayerInfos;

import java.time.LocalDate;

public class JoinListener implements Listener {
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        if(PlayerInfos.isExist(p.getUniqueId().toString(), "minecraft_uuid", "users")) {
                if (PlayerInfos.userDead(p.getUniqueId().toString())) {
                    if (LocalDate.now().equals(PlayerInfos.getDate(p.getUniqueId().toString()))) {
                        p.kickPlayer("Du bist Heute schon einmal gestorben du darfst erst Morgen wieder Joinen!!");
                    }
                }
        }else {
            p.kickPlayer("Du brauchst einen TeamSensivityAccount um auf diesem Server zu spielen... Falls du schon einen hast Verbinde deinen Account mit dem Minecraft Account. Benutze dafür /connect in der Lobby.");
        }
    }
}
