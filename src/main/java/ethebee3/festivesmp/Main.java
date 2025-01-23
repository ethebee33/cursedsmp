package ethebee3.festivesmp;


import org.bukkit.plugin.java.JavaPlugin;

import ethebee3.basicUtils.Main2;

import static ethebee3.basicUtils.data.dataCentral.dataCentralLoad;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Main2.init(this);
        dataCentralLoad(this);



    }
}
