package pixale.ores.util;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import pixale.ores.PixalesOres;
import pixale.ores.ores.Chromium;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class PixaleArmorMaterials {


    public static final RegistryEntry<ArmorMaterial> CHROMIUM = registerArmorMaterial(
            "chromium",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map ->{
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 6);

            }),11,
                    SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Chromium.CHROMIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(PixalesOres.MOD_ID, "chromium"))),
                    2.5F,0
                    )
    );

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(
            String name,
            Supplier<ArmorMaterial> material
    ){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(PixalesOres.MOD_ID, name), material.get());
    }

}
