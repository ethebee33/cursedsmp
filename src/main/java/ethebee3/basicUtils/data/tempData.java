package ethebee3.basicUtils.data;

import ethebee3.basicUtils.utils.logUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import static ethebee3.basicUtils.data.dataCentral.makeYml;

public class tempData {
    static File tempDataFile;
    public static YamlConfiguration tempDataConfig = new YamlConfiguration();

    public static void tempData(JavaPlugin plugin){
        tempDataFile = new File(plugin.getDataFolder(), "tempData.yml");
        if (!tempDataFile.exists()) {
            if (makeYml(tempDataFile)) tempDataConfig = YamlConfiguration.loadConfiguration(tempDataFile);
        } else {
            tempDataConfig = YamlConfiguration.loadConfiguration(tempDataFile);
        }
    }

    public static void saveTempData() {
        try {
            tempDataConfig.save(tempDataFile);
        } catch (IOException e) {
            logUtils.logError(e.getMessage());
        }
    }
}
