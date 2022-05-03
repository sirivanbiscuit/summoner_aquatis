package net.mcreator.summoneraquatis.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class StonewoodGrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure StonewoodGrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure StonewoodGrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure StonewoodGrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure StonewoodGrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean found = false;
		double randomizedRotation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		found = (false);
		sx = (-5);
		for (int index0 = 0; index0 < (int) (10); index0++) {
			sy = 0;
			for (int index1 = 0; index1 < (int) (11); index1++) {
				sz = (-5);
				for (int index2 = 0; index2 < (int) (10); index2++) {
					if (!BlockTags.getCollection().getTagByID(new ResourceLocation("forge:stonewood_replaceable_blocks"))
							.contains((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock())) {
						found = (true);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		if (found == false) {
			if (!world.isRemote()) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("summoner_aquatisRandomGrowChance", Math.random());
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "summoner_aquatisRandomGrowChance") >= 0.875) {
				randomizedRotation = Math.random();
				if (randomizedRotation < 0.25) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("summoner_aquatis", "stonewood_tree_final"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 5), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if (randomizedRotation > 0.25 && randomizedRotation < 0.5) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("summoner_aquatis", "stonewood_tree_final"));
						if (template != null) {
							template.func_237144_a_(
									(ServerWorld) world, new BlockPos((int) (x - 5), (int) y, (int) (z - 4)), new PlacementSettings()
											.setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if (randomizedRotation > 0.5 && randomizedRotation < 0.75) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("summoner_aquatis", "stonewood_tree_final"));
						if (template != null) {
							template.func_237144_a_(
									(ServerWorld) world, new BlockPos((int) (x - 5), (int) y, (int) (z - 4)), new PlacementSettings()
											.setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("summoner_aquatis", "stonewood_tree_final"));
						if (template != null) {
							template.func_237144_a_(
									(ServerWorld) world, new BlockPos((int) (x - 5), (int) y, (int) (z - 4)), new PlacementSettings()
											.setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
		}
	}
}
