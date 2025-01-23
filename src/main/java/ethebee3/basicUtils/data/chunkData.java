package ethebee3.basicUtils.data;

import ethebee3.basicUtils.utils.logUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import static ethebee3.basicUtils.data.dataCentral.makeYml;

public class chunkData {
    static File chunkDataFile;
    public static YamlConfiguration chunkDataConfig = new YamlConfiguration();

    public static void chunkData(JavaPlugin plugin){
        chunkDataFile = new File(plugin.getDataFolder(), "chunks.yml");
        if (!chunkDataFile.exists()) {
            if (makeYml(chunkDataFile)) chunkDataConfig = YamlConfiguration.loadConfiguration(chunkDataFile);
        } else {
            chunkDataConfig = YamlConfiguration.loadConfiguration(chunkDataFile);
        }
    }

    public static void saveChunkData() {
        try {
            chunkDataConfig.save(chunkDataFile);
        } catch (IOException e) {
            logUtils.logError(e.getMessage());
        }
    }
}
