package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.block.SlimeWeedBlockExtraGrownBlock;
import net.mcreator.summoneraquatis.block.SlimeWeedBlockBlock;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SlimeWeedBlockGrownUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SlimeWeedBlockGrownUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SlimeWeedBlockGrownUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SlimeWeedBlockGrownUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SlimeWeedBlockGrownUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == Blocks.WATER) {
			if (Math.random() < 0.1) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SlimeWeedBlockExtraGrownBlock.block.getDefaultState(), 3);
				{
					BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
					if (_property instanceof BooleanProperty)
						world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (true)), 3);
				}
			}
			if (Math.random() < 0.1 && (world.getFluidState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlockState()).getBlock() == Blocks.WATER
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() instanceof IWaterLoggable)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SlimeWeedBlockBlock.block.getDefaultState(), 3);
				{
					BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
					if (_property instanceof BooleanProperty)
						world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (true)), 3);
				}
			}
		}
	}
}
