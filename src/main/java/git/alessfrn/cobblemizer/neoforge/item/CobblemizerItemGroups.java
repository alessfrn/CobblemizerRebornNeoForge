package git.alessfrn.cobblemizer.neoforge.item;

import git.alessfrn.cobblemizer.neoforge.Cobblemizer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class CobblemizerItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cobblemizer.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COBBLEMAXER_TAB = CREATIVE_MODE_TABS.register("cobblemaxer_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(CobblemizerItems.ALL_IV_MAXER.get()))
                    .title(Component.translatable("itemgroup.cobblemizer"))
                    .displayItems((pParameters, pOutput) -> {
                        // CaughtBallChangerItem
                        pOutput.accept((CobblemizerItems.AZURE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.BEAST_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.CHERISH_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.CITRINE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.DIVE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.DREAM_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.DUSK_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.FAST_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.FRIEND_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.GREAT_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.HEAL_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.HEAVY_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.LEVEL_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.LOVE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.LURE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.LUXURY_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.MASTER_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.MOON_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.NEST_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.NET_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.PARK_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.POKE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.PREMIER_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.REPEAT_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.ROSEATE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.SAFARI_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.SLATE_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.SPORT_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.TIMER_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.ULTRA_BALL_CB_CHANGER.get()));
                        pOutput.accept((CobblemizerItems.VERDANT_BALL_CB_CHANGER.get()));
                        // FriendshipAddItem
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_COMMON.get());
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_UNCOMMON.get());
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_RARE.get());
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_EPIC.get());
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_LEGENDARY.get());
                        pOutput.accept(CobblemizerItems.FRIENDSHIP_ADD_MAX.get());
                        // EVRandom
                        pOutput.accept((CobblemizerItems.EV_RANDOM.get()));
                        //EVAddItem
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_DEF_MAX.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SP_ATK_MAX.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_SPEED_MAX.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_ATK_MAX.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_DEF_MAX.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_COMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_RARE.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_EPIC.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.EV_ADD_HP_MAX.get()));
                        // IVMaxer
                        pOutput.accept((CobblemizerItems.ALL_IV_MAXER.get()));
                        // IVRandom
                        pOutput.accept((CobblemizerItems.IV_RANDOM.get()));
                        // IVAddItem
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_DEF_MAX.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SP_ATK_MAX.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_SPEED_MAX.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_ATK_MAX.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_DEF_MAX.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_COMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_RARE.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_EPIC.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.IV_ADD_HP_MAX.get()));
                        // LVLAddItem
                        pOutput.accept((CobblemizerItems.LVL_ADD_COMMON.get()));
                        pOutput.accept((CobblemizerItems.LVL_ADD_UNCOMMON.get()));
                        pOutput.accept((CobblemizerItems.LVL_ADD_RARE.get()));
                        pOutput.accept((CobblemizerItems.LVL_ADD_EPIC.get()));
                        pOutput.accept((CobblemizerItems.LVL_ADD_LEGENDARY.get()));
                        pOutput.accept((CobblemizerItems.LVL_ADD_MAX.get()));
                        // LVLRandom
                        pOutput.accept((CobblemizerItems.LVL_RANDOM.get()));
                         // NatureChangerItems
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_ADAMANT.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_BASHFUL.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_BOLD.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_BRAVE.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_CALM.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_CAREFUL.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_DOCILE.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_GENTLE.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_HARDY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_HASTY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_IMPISH.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_JOLLY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_LAX.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_LONELY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_MILD.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_MODEST.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_NAIVE.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_NAUGHTY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_QUIET.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_QUIRKY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_RASH.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_RELAXED.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_SASSY.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_SERIOUS.get()));
                        pOutput.accept((CobblemizerItems.NATURE_CHANGER_TIMID.get()));
                        // GenderSwapItems
                        pOutput.accept((CobblemizerItems.GENDER_SWAPPER.get()));
                        // ShinySwapItems
                        pOutput.accept((CobblemizerItems.SHINY_SWAPPER.get()));


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
