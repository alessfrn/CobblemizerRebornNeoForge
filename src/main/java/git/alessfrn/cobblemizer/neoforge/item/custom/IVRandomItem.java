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

import java.util.Random;

public class IVRandomItem extends PokemonUseItem {
    public IVRandomItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        IVs ivs = pokemon.getIvs(); // Access the IVs of the Pokémon
        Random random = new Random(); // random number generator

        // randomizes all IV stats
        for (Stat stat : Stats.values()) {
            if (stat.getType() == Stat.Type.PERMANENT) {
                int randomValue = random.nextInt(IVs.MAX_VALUE + 1); // Generate a random value between 0 and MAX_STAT_VALUE (inclusive)
                ivs.set(stat, randomValue); // Set each IV stat to the generated random value
            }
        }

        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        player.sendSystemMessage(Component.translatable("All IVs randomized"));
        return InteractionResult.SUCCESS;
    }
}
