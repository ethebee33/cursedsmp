package ethebee3.basicUtils.data;

import ethebee3.festivesmp.Main;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class dataCentral {

    private Main plugin;

    private YamlConfiguration yaml;



    public static void dataCentralLoad(Main plugin) {
        chunkData.chunkData(plugin);
    }

    public static boolean makeYml(File temp) {
        try {
            temp.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
