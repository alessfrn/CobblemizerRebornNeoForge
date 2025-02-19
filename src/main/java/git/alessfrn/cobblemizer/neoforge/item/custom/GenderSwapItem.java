package git.alessfrn.cobblemizer.neoforge.item.custom;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Gender;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class GenderSwapItem extends PokemonUseItem {
    public GenderSwapItem() { super(new Properties().stacksTo(1));}

    @Override
    public InteractionResult processInteraction(ItemStack itemStack, Player player, PokemonEntity target, Pokemon pokemon) {
        Gender gender = pokemon.getGender();
        // if gender is genderless, it cannot swap
        if (gender == Gender.GENDERLESS) {
            player.sendSystemMessage(Component.translatable("Cannot change gender of gender unknown Pokémon"));
            return InteractionResult.FAIL;
        }

        // swap male -> female and female -> male
        if (gender == Gender.MALE) {
            Gender newGender = Gender.FEMALE;
            pokemon.setGender(newGender);
            String genderName = newGender.name().toLowerCase(); // Get the lowercase gender name
            String formattedGender = Character.toUpperCase(genderName.charAt(0)) + genderName.substring(1); // Convert to title case
            player.sendSystemMessage(Component.translatable("The Pokémon's gender has been changed to "+formattedGender));
        } else if (gender == Gender.FEMALE) {
            Gender newGender = Gender.MALE;
            pokemon.setGender(newGender);
            String genderName = newGender.name().toLowerCase(); // Get the lowercase gender name
            String formattedGender = Character.toUpperCase(genderName.charAt(0)) + genderName.substring(1); // Convert to title case
            player.sendSystemMessage(Component.translatable("The Pokémon's gender has been changed to "+formattedGender));
        }

        itemStack.setCount(itemStack.getCount() - 1); // remove item after use
        return InteractionResult.SUCCESS;
    }
}
