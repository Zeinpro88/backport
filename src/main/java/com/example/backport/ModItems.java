package com.example.backport;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;

/** Предметы из Minecraft 1.8 */
public class ModItems {

    public static Item rabbitRaw;
    public static Item rabbitCooked;
    public static Item muttonRaw;
    public static Item muttonCooked;
    public static Item rabbitStew;
    public static Item rabbitHide;
    public static Item rabbitFoot;
    public static Item prismarineShard;
    public static Item prismarineCrystals;

    public static void register() {
        // еда: (голод, множитель насыщения) как в 1.8
        rabbitRaw    = reg(food("rabbit_raw", 3, 0.3F), "rabbit_raw");
        rabbitCooked = reg(food("rabbit_cooked", 5, 0.6F), "rabbit_cooked");
        muttonRaw    = reg(food("mutton_raw", 2, 0.3F), "mutton_raw");
        muttonCooked = reg(food("mutton_cooked", 6, 0.8F), "mutton_cooked");

        // тушёный кролик: 10 голода, возвращает миску (ItemSoup)
        rabbitStew = reg(new ItemSoup(10)
            .setUnlocalizedName("rabbit_stew")
            .setTextureName(Backport.MODID + ":rabbit_stew")
            .setCreativeTab(CreativeTabs.tabFood), "rabbit_stew");

        rabbitHide         = reg(material("rabbit_hide"), "rabbit_hide");
        rabbitFoot         = reg(material("rabbit_foot"), "rabbit_foot");
        prismarineShard    = reg(material("prismarine_shard"), "prismarine_shard");
        prismarineCrystals = reg(material("prismarine_crystals"), "prismarine_crystals");
    }

    private static Item food(String name, int heal, float saturation) {
        return new ItemFood(heal, saturation, true) // true = любимое мясо волков
            .setUnlocalizedName(name)
            .setTextureName(Backport.MODID + ":" + name)
            .setCreativeTab(CreativeTabs.tabFood);
    }

    private static Item material(String name) {
        return new Item()
            .setUnlocalizedName(name)
            .setTextureName(Backport.MODID + ":" + name)
            .setCreativeTab(CreativeTabs.tabMaterials);
    }

    private static Item reg(Item item, String name) {
        GameRegistry.registerItem(item, name);
        return item;
    }
}
