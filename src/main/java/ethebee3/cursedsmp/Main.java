package ethebee3.cursedsmp;


import ethebee3.cursedsmp.modules.items.*;
import ethebee3.cursedsmp.modules.setKeyCommand;
import org.bukkit.plugin.java.JavaPlugin;

import ethebee3.basicUtils.Main2;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Main2.init(this);
        getLogger().info("fire");
        new bowOfShadows();
        new swordOfUndying();
        new helmOfFortune();
        new gauntletOfStrength();
        this.getCommand("setkey").setExecutor(new setKeyCommand());
    }

    @Override
    public void onDisable() {
        Main2.deinit(this);
    }


}
