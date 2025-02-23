package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import git.alessfrn.cobblemizer.neoforge.config.Config;
import git.alessfrn.cobblemizer.neoforge.misc.TierRarityClass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class FriendshipVoidItem extends PokemonUseItem {
    public FriendshipVoidItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        int minFriendship = 0; // Minimum friendship value
        int currentFriendship = pokemon.getFriendship(); // Current friendship value
        // Modify the Pokémon's friendship to 0
        boolean increasedFriendship = pokemon.setFriendship(minFriendship, false);

        if (!increasedFriendship || currentFriendship==0) { // fail if friendship is at min already
            // If friendship is already at min, return fail
            player.sendSystemMessage(Component.translatable("Pokémon's friendship is already at " + minFriendship));
            return InteractionResult.FAIL;
        }

        // Send a message to the player indicating the change in friendship
        player.sendSystemMessage(Component.translatable("Set Pokémon's friendship to " + minFriendship));
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
}
