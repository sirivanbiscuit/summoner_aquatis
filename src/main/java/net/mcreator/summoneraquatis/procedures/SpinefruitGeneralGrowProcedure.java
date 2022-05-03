package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.block.TinySpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.SpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.SmallSpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.MediumSpinefruitBushBlock;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SpinefruitGeneralGrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SpinefruitGeneralGrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SpinefruitGeneralGrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SpinefruitGeneralGrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SpinefruitGeneralGrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof IWaterLoggable
				&& (world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == Blocks.WATER) {
			if (Math.random() < 0.07) {
				if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == TinySpinefruitBushBlock.block) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = SmallSpinefruitBushBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					{
						BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
						if (_property instanceof BooleanProperty)
							world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (true)), 3);
					}
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmallSpinefruitBushBlock.block) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MediumSpinefruitBushBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					{
						BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
						if (_property instanceof BooleanProperty)
							world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (true)), 3);
					}
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MediumSpinefruitBushBlock.block) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpinefruitBushBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
