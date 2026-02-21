package net.frostytrix.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.component.ModDataComponentTypes;
import net.frostytrix.tutorialmod.item.ModItemGroups;
import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.util.MiningHammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 20000);
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 300);

		ModDataComponentTypes.registerDataComponents();

		PlayerBlockBreakEvents.BEFORE.register(new MiningHammerUsageEvent());

	}
}