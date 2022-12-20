package cn.powernukkitx.exampleplugin;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * author: MagicDroidX
 * NukkitExamplePlugin Project
 */
public class ExamplePlugin extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "I've been loaded!");
    }

    @Override
    public void onEnable() {
        try {
            Item.registerCustomItem(List.of(MyBow.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "I've been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName().toLowerCase()) {
            case "example":
                try {
                    this.getLogger().info(Utils.readFile(new File(this.getDataFolder(), "string.txt")) + " " + sender.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return true;
    }

}
