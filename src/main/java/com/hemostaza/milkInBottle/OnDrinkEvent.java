package com.hemostaza.milkInBottle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class OnDrinkEvent implements Listener {
    @EventHandler
    void onPlayerDrink(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack consumedItem = event.getItem();
        if(consumedItem.getItemMeta()==null) return;
        if(!consumedItem.getItemMeta().equals(Items.milkInBottle.getItemMeta())) return;
        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());

    }
}
