package com.hemostaza.milkInBottle;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.potion.PotionEffect;

public class EventListeners implements Listener {

    NamespacedKey bottledMilk;

    public EventListeners(NamespacedKey key) {
        bottledMilk = key;
    }



    @EventHandler
    void onPlayerDrink(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack consumedItem = event.getItem();
        if(consumedItem.getItemMeta()==null) return;
        if(!consumedItem.getItemMeta().equals(Items.milkInBottle.getItemMeta())) return;
        for (PotionEffect effect : player.getActivePotionEffects())
            player.removePotionEffect(effect.getType());
    }

    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent event)
    {
        if (event.getItemStack().getType() == Material.MILK_BUCKET)
        {
            event.getPlayer().discoverRecipe(bottledMilk);
        }
    }

    @EventHandler
    public void onPlayerCraftBottle(CraftItemEvent event){
        if(event.getRecipe().getResult().getType()==Material.GLASS_BOTTLE){
            Player player = (Player) event.getWhoClicked();
            player.discoverRecipe(bottledMilk);
        }
    }
}
