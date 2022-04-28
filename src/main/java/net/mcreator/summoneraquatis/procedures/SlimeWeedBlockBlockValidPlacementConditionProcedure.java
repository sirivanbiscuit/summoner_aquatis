package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SlimeWeedBlockBlockValidPlacementConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SlimeWeedBlockBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SlimeWeedBlockBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SlimeWeedBlockBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SlimeWeedBlockBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency blockstate for procedure SlimeWeedBlockBlockValidPlacementCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		if (!((world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == Blocks.WATER
				&& BlockTags.getCollection().getTagByID(new ResourceLocation("forge:plant_bases"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
			world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(blockstate));
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			return false;
		}
		return true;
	}
}
