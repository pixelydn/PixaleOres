package pixale.ores.util;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import pixale.ores.ores.Chromium;
import pixale.ores.ores.Titanium;
import pixale.ores.ores.Uranium;

import java.util.function.Supplier;

public enum PixaleToolMaterials implements ToolMaterial {


    CHROMIUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1145, 7.5F, 1.0F, 11, () -> Ingredient.ofItems(Chromium.CHROMIUM_INGOT)),
    //ALUMINUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1145, 7.5F, 1.0F, 11, () -> Ingredient.ofItems(Aluminum.ALUMINUM_INGOT)),
    URANIUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1145, 7.5F, 1.0F, 11, () -> Ingredient.ofItems(Uranium.URANIUM_INGOT)),
    TITANIUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2010, 7.5F, 1.0F, 11, () -> Ingredient.ofItems(Titanium.TITANIUM_INGOT));





    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;
    

    private PixaleToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
