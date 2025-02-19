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

public class LVLAddItem extends PokemonUseItem{
    private final String tier;


    public LVLAddItem(String tier) {
        super(new Properties().stacksTo(1));
        this.tier = tier;
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        int maxLevel = 100; // Maximum level
        int currentLevel = pokemon.getLevel(); // Current level
        // Get the increaseAmount from the config based on the provided tier
        int increaseAmount = getIncreaseAmountForTier(Config.lvlTiers, tier);
        // Modify the Pokémon's friendship by the obtained increaseAmount
        int newLevel = Math.min(currentLevel + increaseAmount, maxLevel);

        int actualIncrease = newLevel - currentLevel;

        if (actualIncrease <= 0) { // If Level is already at max, return fail
            player.sendSystemMessage(Component.translatable("Level is already at maximum"));
            return InteractionResult.FAIL;
        }

        // if Level not max, increase by tier amount
        pokemon.setLevel(currentLevel+actualIncrease);
        player.sendSystemMessage(Component.translatable("Increased Pokémon's Level by " + actualIncrease));
        if (newLevel == maxLevel) { // if new Level amount is maxed, indicate to player
            player.sendSystemMessage(Component.translatable("Pokémon's Level is now at maximum"));
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
