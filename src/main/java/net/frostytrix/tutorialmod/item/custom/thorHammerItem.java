package net.frostytrix.tutorialmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class thorHammerItem extends Item {
    public thorHammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if  (!world.isClient) {
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, context.getBlockPos(), SpawnReason.TRIGGERED);
            return ActionResult.PASS;
        }
        return ActionResult.FAIL;
    }
}
