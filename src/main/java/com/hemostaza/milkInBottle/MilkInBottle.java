package com.hemostaza.milkInBottle;

import com.hemostaza.updateChecker.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class MilkInBottle extends JavaPlugin {

    private NamespacedKey bottledMilk;

    @Override
    public void onEnable() {

        new UpdateChecker(this,122232);

        // Plugin startup logic
        new Items();
        AddRecipes();
        getServer().getPluginManager().registerEvents(new EventListeners(bottledMilk), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void AddRecipes(){

        bottledMilk = new NamespacedKey(this,"bottledmilk");
        ShapelessRecipe bottledMilkRecipe = new ShapelessRecipe(bottledMilk,Items.milkInBottle);
        bottledMilkRecipe.addIngredient(Material.GLASS_BOTTLE);
        bottledMilkRecipe.addIngredient(Material.GLASS_BOTTLE);
        bottledMilkRecipe.addIngredient(Material.GLASS_BOTTLE);
        bottledMilkRecipe.addIngredient(Material.MILK_BUCKET);

        Bukkit.addRecipe(bottledMilkRecipe);
    }
}
