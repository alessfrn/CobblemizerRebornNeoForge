package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class IVAllVoidItem extends PokemonUseItem {
    public IVAllVoidItem() {
        super(new Properties().stacksTo(1));
    }
    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        IVs ivs = pokemon.getIvs(); // Current IV values
        int IVsMin = 0;
        // Get the increaseAmount from the config based on the provided tier
        for (Stat stat : Stats.values()) { // checks how many stats are maxed
            if (stat.getType() == Stat.Type.BATTLE_ONLY) { // skip null since Evasion and Accuracy are not IV's
                continue;
            }
            Integer currentIV = ivs.get(stat);
            if (currentIV == 0) {
                IVsMin++;
            }
        }
        if (IVsMin == 6) { //fail, all stats maxed (only 6 IV stats)
            player.sendSystemMessage(Component.translatable("All IVs at min already"));
            return InteractionResult.FAIL;
        }
        // Pass
        for (Stat stat : Stats.values()) {
            if (stat.getType() == Stat.Type.BATTLE_ONLY) {
                continue;
            }
            ivs.set(stat, 0);
        }
        // maximise all stats
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        player.sendSystemMessage(Component.translatable("All IVs reset successfully"));
        return InteractionResult.SUCCESS;
    }
}


