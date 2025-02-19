package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.EVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class EVRandomItem extends PokemonUseItem {

    public EVRandomItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        EVs evs = pokemon.getEvs(); // Access the EVs of the Pokémon
        Random random = new Random(); // random number generator

        // Randomize all EV stats
        for (Stat stat : Stats.values()) {
            if (stat.getType() == Stat.Type.BATTLE_ONLY) continue;
            int randomValue = random.nextInt(EVs.MAX_STAT_VALUE + 1); // Generate a random value between 0 and MAX_STAT_VALUE (inclusive)
            evs.set(stat, randomValue); // Set each EV stat to the generated random value
        }

        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        player.sendSystemMessage(Component.translatable("All EVs randomized"));
        return InteractionResult.SUCCESS;
    }
}
