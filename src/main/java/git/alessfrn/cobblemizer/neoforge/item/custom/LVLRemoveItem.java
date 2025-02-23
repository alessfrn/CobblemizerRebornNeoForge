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

public class LVLRemoveItem extends PokemonUseItem{
    private final String tier;

    public LVLRemoveItem(String tier) {
        super(new Properties().stacksTo(1));
        this.tier = tier;
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        int minLevel = 1; // Minimum level
        int currentLevel = pokemon.getLevel(); // Current level
        // Get the increaseAmount from the config based on the provided tier
        int decreaseAmount = getDecreaseAmountForTier(Config.lvlTiers, tier);
        // Modify the Pokémon's friendship by the obtained increaseAmount
        int newLevel = Math.max(currentLevel - decreaseAmount, minLevel);

        int actualIncrease = currentLevel - newLevel;

        if (actualIncrease == 0) { // If Level is already 1, return fail
            player.sendSystemMessage(Component.translatable("Level is already at minimum"));
            return InteractionResult.FAIL;
        }

        // if Level not max, increase by tier amount
        pokemon.setLevel(newLevel);
        player.sendSystemMessage(Component.translatable("Decreased Pokémon's Level by " + actualIncrease));
        if (newLevel == 1) { // if new Level amount is maxed, indicate to player
            player.sendSystemMessage(Component.translatable("Pokémon's Level is now at minimum"));
        }
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
    // Method to get the increaseAmount from the config based on the provided tier
    private int getDecreaseAmountForTier(List<TierRarityClass> tierList, String tierName) {
        for (TierRarityClass tier : tierList) {
            if (tier.name.equalsIgnoreCase(tierName)) {
                return tier.increaseAmount;
            }
        }
        return 0; // Default value if tierName not found in config
    }
}
