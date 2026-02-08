package top.ribs.scguns.init;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.common.EventBusSubscriber;
import top.ribs.scguns.NeoScorchedGunsMain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@EventBusSubscriber(modid = NeoScorchedGunsMain.MODID)
public class ModArmorMaterials {
    // protection ARRAY { BOOTS, LEGGINGS, CHESTPLATE, HELMET(, BODY) }
    public static Holder<ArmorMaterial> ADRIEN = registerArmorMaterial(
            "adrien",
            new int[]{ 3, 6, 6, 4 },
            8,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(ModItems.TREATED_IRON_INGOT.get()),
            0.5f,
            0.1f);
    public static Holder<ArmorMaterial> ANTHRALITE = registerArmorMaterial(
            "anthralite",
            new int[]{ 2, 4, 3, 2 },
            12,
            SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(ModItems.ANTHRALITE_INGOT.get()),
            1.0f,
            0.05f);
    public static Holder<ArmorMaterial> DIAMOND_STEEL = registerArmorMaterial(
            "diamond_steel",
            new int[]{ 3, 6, 5, 3 },
            16,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ModItems.DIAMOND_STEEL_INGOT.get()),
            2.0f,
            0.05f);
    public static Holder<ArmorMaterial> TREATED_BRASS = registerArmorMaterial(
            "treated_brass",
            new int[]{ 4, 6, 5, 4 },
            10,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(ModItems.TREATED_BRASS_INGOT.get()),
            0.0f,
            0.2f);
    public static Holder<ArmorMaterial> ANCIENT_BRASS = registerArmorMaterial(
            "ancient_brass", new int[]{ 3, 5, 4, 3 },
            10,
            SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(ModItems.ANCIENT_BRASS.get()),
            0.0f,
            0.15f);
    public static Holder<ArmorMaterial> EXO_SUIT = registerArmorMaterial(
            "exo_suit",
            new int[]{ 1, 1, 1, 1 },
            6,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModItems.TREATED_IRON_INGOT.get()),
            0.0f,
            0.0f);


    // TODO: These durabilities probably have been ported to the Armor directly
    private static final int[] BASE_DURABILITY = { 8, 12, 12, 9 };
    // ADRIEN, ANTHRALITE, DIAMOND_STEEL, TREATED_BRASS, ANCIENT_BRASS, EXO_SUIT
    private static final int[] DURABILITY_MULT = { 22, 32, 36, 30, 16, 200 };

    private static Holder<ArmorMaterial> registerArmorMaterial(String name,
                                                               int[] protectionAmounts,
                                                               int enchantmentValue,
                                                               Holder<SoundEvent> equipSound,
                                                               Supplier<Ingredient> repairIngredient,
                                                               float toughness,
                                                               float knockbackResistance) {
        Map<ArmorItem.Type, Integer> defenseMap = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), armorMap -> {
            armorMap.put(ArmorItem.Type.BOOTS, protectionAmounts[0]);
            armorMap.put(ArmorItem.Type.LEGGINGS, protectionAmounts[1]);
            armorMap.put(ArmorItem.Type.CHESTPLATE, protectionAmounts[2]);
            armorMap.put(ArmorItem.Type.HELMET, protectionAmounts[3]);
        });
        ResourceLocation materialLocation = ResourceLocation.fromNamespaceAndPath(NeoScorchedGunsMain.MODID, name);
        List<ArmorMaterial.Layer> layerList = List.of(new ArmorMaterial.Layer(materialLocation))

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                materialLocation,
                new ArmorMaterial(defenseMap, enchantmentValue, equipSound, repairIngredient, layerList, toughness, knockbackResistance));
    }
}