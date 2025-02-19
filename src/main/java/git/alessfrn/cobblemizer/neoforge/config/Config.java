package git.alessfrn.cobblemizer.neoforge.config;

import com.mojang.logging.LogUtils;
import git.alessfrn.cobblemizer.neoforge.Cobblemizer;
import git.alessfrn.cobblemizer.neoforge.config.tierconfigs.EVTierConfig;
import git.alessfrn.cobblemizer.neoforge.config.tierconfigs.FriendshipTierConfig;
import git.alessfrn.cobblemizer.neoforge.config.tierconfigs.IVTierConfig;
import git.alessfrn.cobblemizer.neoforge.config.tierconfigs.LVLTierConfig;
import git.alessfrn.cobblemizer.neoforge.misc.TierRarityClass;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Cobblemizer.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ModConfigSpec CONFIG_SPEC;

    // Store ConfigValue objects
    private static final ModConfigSpec.ConfigValue<List<List<Object>>> FRIENDSHIP_TIERS;
    private static final ModConfigSpec.ConfigValue<List<List<Object>>> EV_TIERS;
    private static final ModConfigSpec.ConfigValue<List<List<Object>>> IV_TIERS;
    private static final ModConfigSpec.ConfigValue<List<List<Object>>> LVL_TIERS;

    // Public lists to be accessed elsewhere
    public static List<TierRarityClass> friendshipTiers = new ArrayList<>();
    public static List<TierRarityClass> evTiers = new ArrayList<>();
    public static List<TierRarityClass> ivTiers = new ArrayList<>();
    public static List<TierRarityClass> lvlTiers = new ArrayList<>();

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        FRIENDSHIP_TIERS = builder
                .comment("Friendship tier configuration")
                .define("friendshipTiers",
                        serializeTierList(FriendshipTierConfig.getDefaultConfig().getFriendshipTiers()));

        EV_TIERS = builder
                .comment("EV tier configuration")
                .define("evTiers",
                        serializeTierList(EVTierConfig.getDefaultConfig().getEVTiers()));

        IV_TIERS = builder
                .comment("IV tier configuration")
                .define("ivTiers",
                        serializeTierList(IVTierConfig.getDefaultConfig().getIVTiers()));

        LVL_TIERS = builder
                .comment("LVL tier configuration")
                .define("lvlTiers",
                        serializeTierList(LVLTierConfig.getDefaultConfig().getLVLTiers()));

        CONFIG_SPEC = builder.build();
    }
    private static final Logger LOGGER = LogUtils.getLogger();

    private static List<List<Object>> serializeTierList(List<TierRarityClass> tiers) {
        List<List<Object>> serialized = new ArrayList<>();
        for (TierRarityClass tier : tiers) {
            List<Object> data = new ArrayList<>();
            data.add(tier.name);
            data.add(tier.increaseAmount);
            serialized.add(data);
        }
        return serialized;
    }


    private static List<TierRarityClass> deserializeTierList(List<List<Object>> tierData) {
        List<TierRarityClass> tiers = new ArrayList<>();
        for (List<Object> data : tierData) {
            String name = (String) data.get(0);
            double increaseAmount = ((Number) data.get(1)).doubleValue();
            tiers.add(new TierRarityClass(name, (int) increaseAmount));
        }
        return tiers;
    }



    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
        // Extract values from ConfigValue objects
        LOGGER.info("Loading config...");
        friendshipTiers = deserializeTierList(FRIENDSHIP_TIERS.get());
        evTiers = deserializeTierList(EV_TIERS.get());
        ivTiers = deserializeTierList(IV_TIERS.get());
        lvlTiers = deserializeTierList(LVL_TIERS.get());
        LOGGER.info("Config loaded successfully!");
    }
}
