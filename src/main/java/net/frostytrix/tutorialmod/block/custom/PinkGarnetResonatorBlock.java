package net.frostytrix.tutorialmod.block.custom;

import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PinkGarnetResonatorBlock extends Block {
    static int minCharge = 0;
    static int maxCharge = 4;
    public static final IntProperty CHARGE = IntProperty.of("charge", minCharge, maxCharge);

    public PinkGarnetResonatorBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CHARGE, 0));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        int currentCharge = state.get(CHARGE);

        if (!world.isClient) {
            if (entity instanceof PlayerEntity player) {
                if (currentCharge > 0 && player.getStatusEffect(StatusEffects.SPEED) == null) {
                    world.setBlockState(pos, state.with(CHARGE, currentCharge - 1), Block.NOTIFY_LISTENERS);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 1));
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int currentCharge = state.get(CHARGE);

        if (!world.isClient) {
            if (currentCharge < maxCharge && player.getMainHandStack().getItem() == ModItems.PINK_GARNET) {
                world.setBlockState(pos, state.with(CHARGE, currentCharge + 1), Block.NOTIFY_LISTENERS);
                player.getMainHandStack().decrement(1);
            }

        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGE);
    }
}
