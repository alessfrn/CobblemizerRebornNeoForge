package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import git.alessfrn.cobblemizer.neoforge.config.Config;
import git.alessfrn.cobblemizer.neoforge.misc.TierRarityClass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class FriendshipAddItem extends PokemonUseItem{
    private final String tier;

    public FriendshipAddItem(String tier) {
        super(new Properties().stacksTo(1));
        this.tier = tier;
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        int maxFriendship = 255; // Maximum friendship value
        int currentFriendship = pokemon.getFriendship(); // Current friendship value
        // Get the increaseAmount from the config based on the provided tier
        int increaseAmount = getIncreaseAmountForTier(Config.friendshipTiers, tier);
        // Modify the Pokémon's friendship by the obtained increaseAmount
        int newFriendship = Math.min(currentFriendship + increaseAmount, maxFriendship);
        int actualIncrease = newFriendship - currentFriendship;
        boolean increasedFriendship = pokemon.incrementFriendship(actualIncrease, false);

        if (!increasedFriendship || actualIncrease==0) { // fail if friendship is at max already
            // If friendship is already at max, return fail
            player.sendSystemMessage(Component.translatable("Pokémon's friendship is already at max"));
            return InteractionResult.FAIL;
        }

        // Send a message to the player indicating the change in friendship
        player.sendSystemMessage(Component.translatable("Increased Pokémon's friendship by " + actualIncrease));
        if (newFriendship == maxFriendship) {
            player.sendSystemMessage(Component.translatable("Pokémon's friendship is now at max"));
        }

        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }

    // Method to get the increaseAmount from the config based on the provided tier
    private int getIncreaseAmountForTier(List<TierRarityClass> tierList, String tierName) {
        for (TierRarityClass tier : tierList) {
            if (tier.name.equalsIgnoreCase(tierName)) {
                return tier.increaseAmount;
            }
        }
        return 0; // Default value if tierName not found in config
    }
}
