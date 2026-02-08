package top.ribs.scguns.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.client.screen.*;

@EventBusSubscriber(modid = NeoScorchedGunsMain.MODID)
public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, NeoScorchedGunsMain.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, MechanicalPressRecipe.Serializer> MECHANICAL_PRESS_SERIALIZER =
            SERIALIZERS.register("mechanical_pressing", () -> MechanicalPressRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, PoweredMechanicalPressRecipe.Serializer> POWERED_MECHANICAL_PRESS_SERIALIZER =
            SERIALIZERS.register("powered_mechanical_pressing", () -> PoweredMechanicalPressRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, MaceratorRecipe.Serializer> MACERATOR_SERIALIZER =
            SERIALIZERS.register("macerating", () -> MaceratorRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, PoweredMaceratorRecipe.Serializer> POWERED_MACERATOR_SERIALIZER =
            SERIALIZERS.register("powered_macerating", () -> PoweredMaceratorRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, GunBenchRecipe.Serializer> GUN_BENCH_SERIALIZER =
            SERIALIZERS.register("gun_bench", () -> GunBenchRecipe.Serializer.INSTANCE);

    public static final DeferredHolder<RecipeSerializer<?>, LightningBatteryRecipe.Serializer> LIGHTNING_BATTERY_SERIALIZER =
            SERIALIZERS.register("lightning_battery", () -> LightningBatteryRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}



