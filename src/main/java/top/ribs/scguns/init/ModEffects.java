package top.ribs.scguns.init;

import top.ribs.scguns.NeoScorchedGunsMain;
import top.ribs.scguns.effect.IncurableEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.ribs.scguns.effect.SulfurPoisoningEffect;

/**
 * Author: MrCrayfish
 */
public class    ModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NeoScorchedGunsMain.MODID);

    public static final RegistryObject<IncurableEffect> BLINDED = EFFECTS.register("blinded", () -> new IncurableEffect(MobEffectCategory.HARMFUL, 0));
    public static final RegistryObject<IncurableEffect> DEAFENED = EFFECTS.register("deafened", () -> new IncurableEffect(MobEffectCategory.HARMFUL, 0));
    public static final RegistryObject<SulfurPoisoningEffect> SULFUR_POISONING = EFFECTS.register("sulfur_poisoning",
            () -> new SulfurPoisoningEffect(MobEffectCategory.HARMFUL, 0xFFE135));
}
