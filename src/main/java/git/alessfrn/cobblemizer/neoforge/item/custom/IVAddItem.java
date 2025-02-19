package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import git.alessfrn.cobblemizer.neoforge.config.Config;
import git.alessfrn.cobblemizer.neoforge.misc.TierRarityClass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class IVAddItem extends PokemonUseItem {
    private final String tier;
    private final Stat statToBoost;

    public IVAddItem(String tier, Stat statToBoost) {
        super(new Properties().stacksTo(1));
        this.tier = tier;
        this.statToBoost = statToBoost;
    }
    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        int maxIV = IVs.MAX_VALUE; // Maximum IV value
        IVs IVs = pokemon.getIvs(); // Current IV values
        // Get the increaseAmount from the config based on the provided tier
        int increaseAmount = getIncreaseAmountForTier(Config.ivTiers, tier);
        int IVcurrentAmount = IVs.get(this.statToBoost);
        // Modify the Pokémon's IV by the obtained increaseAmount
        int newIVAmount = Math.min(IVcurrentAmount + increaseAmount, maxIV);
        int actualIncrease = newIVAmount - IVcurrentAmount;

        if (actualIncrease <= 0) { // If IV is already at max, return fail
            player.sendSystemMessage(Component.translatable((statToBoost.getDisplayName().getString() + " IV is already at maximum")));
            return InteractionResult.FAIL;
        }

        // if IV not max, increase by tier amount
        IVs.set(statToBoost, IVcurrentAmount+actualIncrease);
        player.sendSystemMessage(Component.translatable("Increased Pokémon's " + statToBoost.getDisplayName().getString() + " IV by " + actualIncrease));
        if (newIVAmount == maxIV) { // if new IV amount is maxed, indicate to player
            player.sendSystemMessage(Component.translatable("Pokémon's " + statToBoost.getDisplayName().getString() + " IV is now at maximum"));
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
