package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokeball.PokeBall;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CaughtBallChangerItem extends PokemonUseItem{
    private final PokeBall selectedBall;

    public CaughtBallChangerItem(PokeBall selectedBall) {
        super(new Properties().stacksTo(1));
        this.selectedBall = selectedBall;
    }

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        PokeBall currentball = pokemon.getCaughtBall();

        if (currentball == selectedBall) {
            player.sendSystemMessage(Component.translatable("The Pokémon has the same caught ball"));
            return InteractionResult.FAIL;
        }
        // change caught ball
        pokemon.setCaughtBall(selectedBall);
        player.sendSystemMessage(Component.translatable("The Pokémon's caught ball has been changed to " + selectedBall.item().getName(itemStack).getString()));
        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
}
