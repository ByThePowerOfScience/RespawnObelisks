package com.redpxnda.respawnobelisks.registry;

import com.mojang.datafixers.util.Either;
import com.redpxnda.respawnobelisks.registry.blocks.RespawnObeliskBlock;
import com.redpxnda.respawnobelisks.registry.effects.ImmortalityCurseEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.redpxnda.respawnobelisks.RespawnObelisks.MODID;

public class Registry {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);
    public static final RegistryObject<MobEffect> IMMORTALITY_CURSE = MOB_EFFECTS.register("curse_of_immortality", ImmortalityCurseEffect::new);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // OVERWORLD OBELISK
    public static final RegistryObject<Block> RESPAWN_OBELISK_BLOCK = BLOCKS.register("respawn_obelisk", () -> new RespawnObeliskBlock(BlockBehaviour.Properties
            .of(Material.STONE)
            .noOcclusion()
            .strength(-1, 3600000.0F)
            .lightLevel((s) -> s.getValue(RespawnObeliskBlock.CHARGE)*5)
            .noLootTable(),
            Either.left(Level.OVERWORLD)
    ));
    public static final RegistryObject<Item> RESPAWN_OBELISK_ITEM = ITEMS.register("respawn_obelisk", () -> new BlockItem(RESPAWN_OBELISK_BLOCK.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_MISC)
            .stacksTo(1)
            .fireResistant()
            .rarity(Rarity.UNCOMMON)
    ));

    // NETHER OBELISK
    public static final RegistryObject<Block> RESPAWN_OBELISK_NETHER_BLOCK = BLOCKS.register("respawn_obelisk_nether", () -> new RespawnObeliskBlock(BlockBehaviour.Properties
            .of(Material.STONE)
            .noOcclusion()
            .strength(-1, 3600000.0F)
            .lightLevel((s) -> s.getValue(RespawnObeliskBlock.CHARGE)*5)
            .noLootTable(),
            Either.left(Level.NETHER)
    ));
    public static final RegistryObject<Item> RESPAWN_OBELISK_NETHER_ITEM = ITEMS.register("respawn_obelisk_nether", () -> new BlockItem(RESPAWN_OBELISK_NETHER_BLOCK.get(), new Item.Properties()
            .tab(CreativeModeTab.TAB_MISC)
            .stacksTo(1)
            .fireResistant()
            .rarity(Rarity.UNCOMMON)
    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        MOB_EFFECTS.register(eventBus);
    }
}
