package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ShinySwapItem extends PokemonUseItem{
    public ShinySwapItem() {
        super(new Properties());
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        boolean isShiny = pokemon.getShiny(); // Determines if Pokémon is shiny

        // Toggle shiny status
        pokemon.setShiny(!isShiny);

        String shinyMessage = isShiny ? "no longer shiny" : "now shiny";
        player.sendSystemMessage(Component.translatable("The Pokémon is " + shinyMessage));
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
}
