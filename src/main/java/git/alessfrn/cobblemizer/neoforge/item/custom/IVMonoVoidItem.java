package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class IVMonoVoidItem extends PokemonUseItem {
    private final Stat statToReset;

    public IVMonoVoidItem(Stat statToBoost) {
        super(new Properties().stacksTo(1));
        this.statToReset = statToBoost;
    }
    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        IVs IVs = pokemon.getIvs(); // Current IV values
        // Get the increaseAmount from the config based on the provided tier
        int IVcurrentAmount = IVs.get(this.statToReset);
        // Modify the Pokémon's IV by the obtained increaseAmount
        int newIVAmount = 0;
        if (IVcurrentAmount == 0) { // If IV is already at min, return fail
            player.sendSystemMessage(Component.translatable((statToReset.getDisplayName().getString() + " IV is already at 0")));
            return InteractionResult.FAIL;
        }

        // if IV not min, reset
        IVs.set(statToReset, newIVAmount);
        player.sendSystemMessage(Component.translatable("Reset Pokémon's " + statToReset.getDisplayName().getString() + " IV to " + newIVAmount));
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
}

