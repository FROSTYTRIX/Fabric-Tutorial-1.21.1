package net.frostytrix.tutorialmod.block.custom;

import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class MagicBlock extends Block {
    private static final Map<Item, Item> MAGIC_TRANSMUTATION_MAP =
            Map.of(
                    Items.PAPER, Items.SUGAR,
                    Items.NETHER_STAR, ModItems.STARLIGHT_ASHES
            );


    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f,1f);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            Item item = itemEntity.getStack().getItem();

            if (MAGIC_TRANSMUTATION_MAP.containsKey(item)) {
                itemEntity.setStack(new ItemStack(MAGIC_TRANSMUTATION_MAP.get(item), itemEntity.getStack().getCount())) ;
            }

            if (isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.DIAMONDABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip2"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
