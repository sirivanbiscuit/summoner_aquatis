package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.summoneraquatis.block.TinySpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.SpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.SmallSpinefruitBushBlock;
import net.mcreator.summoneraquatis.block.MediumSpinefruitBushBlock;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class SpinefruitGeneralBreakSelfProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure SpinefruitGeneralBreakSelf!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure SpinefruitGeneralBreakSelf!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure SpinefruitGeneralBreakSelf!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure SpinefruitGeneralBreakSelf!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!BlockTags.getCollection().getTagByID(new ResourceLocation("forge:valid_spinefruit_base"))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == TinySpinefruitBushBlock.block) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(TinySpinefruitBushBlock.block.getDefaultState()));
			} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmallSpinefruitBushBlock.block) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(SmallSpinefruitBushBlock.block.getDefaultState()));
			} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MediumSpinefruitBushBlock.block) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(MediumSpinefruitBushBlock.block.getDefaultState()));
			} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SpinefruitBushBlock.block) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(SpinefruitBushBlock.block.getDefaultState()));
			}
		}
	}
}
