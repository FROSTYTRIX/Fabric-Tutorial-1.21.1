package net.frostytrix.tutorialmod.util;

import net.frostytrix.tutorialmod.TutorialMod;
import net.frostytrix.tutorialmod.component.ModDataComponentTypes;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicate() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(TutorialMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);

        ModelPredicateProviderRegistry.register(ModItems.PINK_GARNET_SWORD, Identifier.of(TutorialMod.MOD_ID, "health"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 1f;
                    }

                    float healthRatio = entity.getHealth() / entity.getMaxHealth();

                    if (healthRatio == 1f) {
                        return 1.0f; // High health
                    } else if (healthRatio >= 0.8f && healthRatio < 1f) {
                        return 0.8f; // Mid-high health
                    } else if (healthRatio >= 0.6f && healthRatio < 0.8f) {
                        return 0.6f; // Wounded
                    } else {
                        return 0.4f;  // Critical
                    }
                });

        registerCustomBow(ModItems.FROST_BOW);
    }

    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }


}
