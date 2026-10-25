package com.example.backport;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {

    public static void register() {
        // плавка в печи (опыт как в 1.8)
        GameRegistry.addSmelting(ModItems.rabbitRaw, new ItemStack(ModItems.rabbitCooked), 0.35F);
        GameRegistry.addSmelting(ModItems.muttonRaw, new ItemStack(ModItems.muttonCooked), 0.35F);

        // тушёный кролик: печёная картошка, морковь, жареный кролик, гриб, миска
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rabbitStew),
            Items.baked_potato, Items.carrot, ModItems.rabbitCooked, Blocks.brown_mushroom, Items.bowl);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rabbitStew),
            Items.baked_potato, Items.carrot, ModItems.rabbitCooked, Blocks.red_mushroom, Items.bowl);

        // 4 кроличьи шкурки -> кожа
        GameRegistry.addShapedRecipe(new ItemStack(Items.leather),
            "HH", "HH", 'H', ModItems.rabbitHide);
    }
}
