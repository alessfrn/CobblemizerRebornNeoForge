package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.api.interaction.PokemonEntityInteraction.Ownership;
import com.cobblemon.mod.common.api.storage.StoreCoordinates;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public abstract class PokemonUseItem extends Item {
    public PokemonUseItem(Properties arg) {
        super(arg);
    }

    // Interact item on Pokémon
    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity target, InteractionHand hand) {
        // ensures code is running on client side only
        if (player.level().isClientSide) {
            return InteractionResult.PASS;
        }

        //checks whether target is Pokémon
        if (!(target instanceof PokemonEntity)) {
            player.sendSystemMessage(Component.translatable("Not a Pokémon"));
            return InteractionResult.FAIL;
        }

        // stores pokemon information
        PokemonEntity pokemonEntity = (PokemonEntity) target;
        Pokemon pokemon = pokemonEntity.getPokemon();
        StoreCoordinates<?> storeCoordinates = pokemon.getStoreCoordinates().get();
        // determines Pokémon ownership
        Ownership ownership;
        if (storeCoordinates == null) {
            ownership = Ownership.WILD;
        } else if (storeCoordinates.getStore().getUuid().equals(player.getUUID())) {
            ownership = Ownership.OWNER;
        } else {
            ownership = Ownership.OWNED_ANOTHER;
        }

        if (ownership != Ownership.OWNER) {
            player.sendSystemMessage(Component.translatable("Not your Pokémon"));
            return InteractionResult.FAIL;
        }

        return processInteraction(itemStack, player, pokemonEntity, pokemon);
    }
    public abstract InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon);
}
