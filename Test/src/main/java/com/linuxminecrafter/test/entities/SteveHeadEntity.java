package com.linuxminecrafter.test.entities;

import com.linuxminecrafter.test.init.ModBlocks;
import com.linuxminecrafter.test.init.ModEntityTypes;
import com.linuxminecrafter.test.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SteveHeadEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModBlocks.TOASTER.get());

    public SteveHeadEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 18.8D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute
                        (Attributes.ATTACK_DAMAGE, 2.0D);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0F, true));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.80D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.10, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }



    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.STEVE_HEAD.get().create(this.world);
    }
}
