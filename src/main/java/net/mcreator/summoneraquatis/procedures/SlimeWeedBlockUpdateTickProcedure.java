package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.summoneraquatis.block.SlimeWeedBlockGrownBlock;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SlimeWeedBlockUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SlimeWeedBlockUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SlimeWeedBlockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SlimeWeedBlockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SlimeWeedBlockUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() < 0.1) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SlimeWeedBlockGrownBlock.block.getDefaultState(), 3);
		}
	}
}
