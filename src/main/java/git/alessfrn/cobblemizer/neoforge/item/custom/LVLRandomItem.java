package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class LVLRandomItem extends PokemonUseItem {

    public LVLRandomItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
       int maxLevel = Cobblemon.config.getMaxPokemonLevel(); // maximum level of Pokémon allowed by config
       int minLevel = 1;
       int randomLevel = new Random().nextInt(maxLevel-minLevel+1)+minLevel;
        pokemon.setLevel(randomLevel);

        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        player.sendSystemMessage(Component.translatable("Pokémon level randomized"));
        return InteractionResult.SUCCESS;
    }
}

