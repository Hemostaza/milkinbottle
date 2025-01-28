package com.hemostaza.milkInBottle;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public static ItemStack milkInBottle;

    FileConfiguration config;

    public Items(){
        createMilk();
    }

    private void createMilk() {
        ItemStack item = new ItemStack(Material.POTION,3);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        if(potionMeta!=null){
            potionMeta.setDisplayName("Bottled milk");
            potionMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            potionMeta.setColor(Color.fromRGB(200,200,200));
            List<String> lore = new ArrayList<>();
            lore.add("Just milk");
            potionMeta.setLore(lore);
            item.setItemMeta(potionMeta);
        }
        milkInBottle = item;
    }
}
