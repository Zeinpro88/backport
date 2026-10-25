package com.example.backport;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    public static Block granite;

    public static void register() {
        // пример: гранит из 1.8
        granite = new Block(Material.rock)
            .setBlockName("granite")
            .setBlockTextureName(Backport.MODID + ":granite")
            .setHardness(1.5F)
            .setResistance(10.0F)
            .setStepSound(Block.soundTypeStone)
            .setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(granite, "granite");
    }
}
