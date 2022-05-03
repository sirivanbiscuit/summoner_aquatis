package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;

import net.mcreator.summoneraquatis.item.SpinefruitCuttingItem;
import net.mcreator.summoneraquatis.item.SlimyPolypItem;
import net.mcreator.summoneraquatis.block.TinySpinefruitBushBlock;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SpinefruitCuttingPlaceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SpinefruitCuttingPlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SpinefruitCuttingPlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SpinefruitCuttingPlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SpinefruitCuttingPlace!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency direction for procedure SpinefruitCuttingPlace!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency entity for procedure SpinefruitCuttingPlace!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		if (BlockTags.getCollection().getTagByID(new ResourceLocation("forge:valid_spinefruit_base"))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()) && Direction.UP == direction
				&& (world.getFluidState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlockState()).getBlock() == Blocks.WATER
				&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() instanceof IWaterLoggable)) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == SpinefruitCuttingItem.block) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(SlimyPolypItem.block);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TinySpinefruitBushBlock.block.getDefaultState(), 3);
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == SpinefruitCuttingItem.block) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(SlimyPolypItem.block);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TinySpinefruitBushBlock.block.getDefaultState(), 3);
			}
		}
	}
}
