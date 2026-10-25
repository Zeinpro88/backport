package com.example.backport;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

/** Овцы дропают баранину (как в 1.8): 1-2 шт., +looting, жареная если горела */
public class DropHandler {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent e) {
        if (!(e.entityLiving instanceof EntitySheep)) return;
        if (e.entityLiving.worldObj.isRemote || e.entityLiving.isChild()) return;

        int count = 1 + e.entityLiving.getRNG().nextInt(2);
        if (e.lootingLevel > 0) {
            count += e.entityLiving.getRNG().nextInt(e.lootingLevel + 1);
        }
        Item meat = e.entityLiving.isBurning() ? ModItems.muttonCooked : ModItems.muttonRaw;

        EntityItem drop = new EntityItem(e.entityLiving.worldObj,
            e.entityLiving.posX, e.entityLiving.posY, e.entityLiving.posZ,
            new ItemStack(meat, count));
        drop.delayBeforeCanPickup = 10;
        e.drops.add(drop);
    }
}
