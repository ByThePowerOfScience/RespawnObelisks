package com.redpxnda.respawnobelisks.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Category(id = "charge", translation = "text.respawnobelisks.config.charge_config")
public final class ChargeConfig {
    @ConfigEntry(
            id = "obeliskChargeItems",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.charge_items"
    )
    @Comment("""
            The items used for charging the obelisk.
            Syntax: ["<ITEM_ID>|<CHARGE_AMOUNT>", ...]
                    ["<ITEM_ID>|<CHARGE_AMOUNT>|<ALLOW_OVERFILL>", ...]
            Ex:     ["minecraft:stick|-1|false"]
            The 'ALLOW_OVERFILL' option is a boolean that determines whether the player
            is allowed to waste their item in order to get a portion of the actual charge amount.
            For example, if the obelisk is charged 90% and your trying to add 20% charge,
            the charge amount WOULD go to 110%. However, since the max is 100%, it only goes to 100%.
            The same logic is applied to going below 0 with negative charge values."""
    )
    public static String[] obeliskChargeItems = {"minecraft:ender_eye|25", "minecraft:ender_pearl|10"};


    @ConfigEntry(
            id = "netherObeliskChargeItems",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.charge_items_nether"
    )
    public static String[] netherObeliskChargeItems = {"minecraft:ender_eye|25", "minecraft:ender_pearl|10"};


    @ConfigEntry(
            id = "endObeliskChargeItems",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.charge_items_end"
    )
    public static String[] endObeliskChargeItems = {"minecraft:ender_eye|25", "minecraft:ender_pearl|10"};

    @ConfigEntry(
            id = "obeliskChargeSound",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.obelisk_charge_sound"
    )
    @Comment("Sound to play when charging an obelisk.")
    public static String obeliskChargeSound = "minecraft:block.respawn_anchor.charge";

    @ConfigEntry(
            id = "obeliskDepleteSound",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.obelisk_deplete_sound"
    )
    @Comment("Sound to play when de-charging(negative charge value) or respawning at an obelisk.")
    public static String obeliskDepleteSound = "minecraft:block.respawn_anchor.deplete";

    @ConfigEntry(
            id = "obeliskSetSpawnSound",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.obelisk_set_spawn_sound"
    )
    @Comment("Sound to play when setting your spawn at an obelisk.")
    public static String obeliskSetSpawnSound = "minecraft:block.respawn_anchor.set_spawn";

    @ConfigEntry(
            id = "obeliskDepleteAmount",
            type = EntryType.INTEGER,
            translation = "text.respawnobelisks.config.obelisk_deplete_amount"
    )
    @Comment("How much charge (%) should be consumed when respawning at an obelisk.")
    public static int obeliskDepleteAmount = 20;

    @ConfigEntry(
            id = "infiniteChargeBlock",
            type = EntryType.STRING,
            translation = "text.respawnobelisks.config.infinite_charge_block"
    )
    @Comment("Block placed under an obelisk to allow for infinite charge.")
    public static String infiniteChargeBlock = "minecraft:beacon";

    @ConfigEntry(
            id = "enablePerPlayerCharge",
            type = EntryType.BOOLEAN,
            translation = "text.respawnobelisks.config.per_player_charge"
    )
    @Comment("""
            Whether obelisk charge is per-player.
            Keep in mind that charge still isn't global. Each obelisk just saves a charge for each player.
            Obelisks' max charges don't become per player. They stay per-obelisk.
            Note that this will break things like comparator support."""
    )
    public static boolean perPlayerCharge = false;
}
