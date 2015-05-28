package net.stegr.testplugin.handlers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeHandler
{
    private static JavaPlugin plugin;

    public RecipeHandler(JavaPlugin plugin)
    {
        this.plugin = plugin;
    }

    public static void loadRecipes()
    {
        // -----------------------------------------------------------------------------------------------
        ItemStack InfiniBucketResult = new ItemStack(Material.WATER_BUCKET);
        InfiniBucketResult.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

        ItemMeta InfiniBucketMeta = InfiniBucketResult.getItemMeta();
        InfiniBucketMeta.setDisplayName("Unendlicher Wassereimer");
        InfiniBucketResult.setItemMeta(InfiniBucketMeta);


        ShapedRecipe InfiniBucketRecipe = new ShapedRecipe(InfiniBucketResult);

        InfiniBucketRecipe.shape("GIG", "WEW", "GIG");

        InfiniBucketRecipe.setIngredient('G', Material.GOLD_INGOT);
        InfiniBucketRecipe.setIngredient('I', Material.IRON_INGOT);
        InfiniBucketRecipe.setIngredient('W', Material.WATER_BUCKET);
        InfiniBucketRecipe.setIngredient('E', Material.ENDER_PEARL);
        // -----------------------------------------------------------------------------------------------

        // -----------------------------------------------------------------------------------------------
        ItemStack InfiniEmtptyBucketResult = new ItemStack(Material.BUCKET);
        InfiniEmtptyBucketResult.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

        ItemMeta InfiniEmtptyBucketMeta = InfiniEmtptyBucketResult.getItemMeta();
        InfiniEmtptyBucketMeta.setDisplayName("Unendlich leerer Eimer");
        InfiniEmtptyBucketResult.setItemMeta(InfiniEmtptyBucketMeta);


        ShapedRecipe InfiniEmptyBucketRecipe = new ShapedRecipe(InfiniEmtptyBucketResult);

        InfiniEmptyBucketRecipe.shape("GIG", "BEB", "GIG");

        InfiniEmptyBucketRecipe.setIngredient('G', Material.GOLD_INGOT);
        InfiniEmptyBucketRecipe.setIngredient('I', Material.IRON_INGOT);
        InfiniEmptyBucketRecipe.setIngredient('B', Material.BUCKET);
        InfiniEmptyBucketRecipe.setIngredient('E', Material.ENDER_PEARL);
        // -----------------------------------------------------------------------------------------------


        plugin.getServer().addRecipe(InfiniBucketRecipe);
        plugin.getServer().addRecipe(InfiniEmptyBucketRecipe);
    }

}
