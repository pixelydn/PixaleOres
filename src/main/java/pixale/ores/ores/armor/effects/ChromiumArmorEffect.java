package pixale.ores.ores.armor.effects;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import pixale.ores.ores.Chromium;

public class ChromiumArmorEffect {


    public static boolean hasFullSet(PlayerEntity player) {
        return player.getInventory().armor.get(3).isOf(Chromium.CHROMIUM_HELMET) &&
                player.getInventory().armor.get(2).isOf(Chromium.CHROMIUM_CHESTPLATE) &&
                player.getInventory().armor.get(1).isOf(Chromium.CHROMIUM_LEGGINGS) &&
                player.getInventory().armor.get(0).isOf(Chromium.CHROMIUM_BOOTS);
    }


    public static void onArmorTick(PlayerEntity player) {
        if (hasFullSet(player)) {
            player.removeStatusEffect(StatusEffects.POISON);
            player.removeStatusEffect(StatusEffects.WITHER);
        }
    }


    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                onArmorTick(player);
            }
        });
    }
}
