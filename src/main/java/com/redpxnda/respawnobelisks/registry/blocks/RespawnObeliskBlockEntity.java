package com.redpxnda.respawnobelisks.registry.blocks;

import com.redpxnda.respawnobelisks.registry.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RespawnObeliskBlockEntity extends BlockEntity {
    private double charge;

    public RespawnObeliskBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(Registry.RESPAWN_OBELISK_BE.get(), pPos, pBlockState);
    }

    public double getCharge() {
        return charge;
    }

    public BlockEntity decreaseCharge(double amnt, Level level, BlockPos pos, BlockState state) {
        if (charge-amnt >= 0 && charge-amnt<=100) charge-=amnt;
        setChanged(level, pos, state);
        return this;
    }

    public BlockEntity increaseCharge(double amnt, Level level, BlockPos pos, BlockState state) {
        if (charge+amnt >= 0 && charge+amnt<=100) charge+=amnt;
        setChanged(level, pos, state);
        return this;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.charge = tag.getDouble("Charge");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putDouble("Charge", this.charge);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("Charge", charge);
        return tag;
    }

    protected static void setChanged(Level pLevel, BlockPos pPos, BlockState pState) {
        BlockEntity.setChanged(pLevel, pPos, pState);
        pLevel.sendBlockUpdated(pPos, pLevel.getBlockState(pPos), pState, 3);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.load(tag);
    }
}
