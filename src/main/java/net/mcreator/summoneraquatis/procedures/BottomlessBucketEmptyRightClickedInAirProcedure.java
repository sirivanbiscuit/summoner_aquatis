package net.mcreator.summoneraquatis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.item.BottomlessBucketEmptyItem;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class BottomlessBucketEmptyRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure BottomlessBucketEmptyRightClickedInAir!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency entity for procedure BottomlessBucketEmptyRightClickedInAir!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double localRayTraceDistance = 0;
		if (BottomlessBucketEmptyItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem()) {
			localRayTraceDistance = 0.5;
			for (int index0 = 0; index0 < (int) (5); index0++) {
				if (((world
						.getFluidState(new BlockPos(
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
												entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
												entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
								(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
												entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.getBlockState()).getBlock() == Blocks.WATER
						|| (world
								.getFluidState(new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlockState()).getBlock() == Blocks.WATER
						|| (world
								.getFluidState(new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlockState()).getBlock() == Blocks.BUBBLE_COLUMN)
						&& (world
								.getFluidState(new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.getBlockState()).getFluidState().isSource() == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					if ((world.getBlockState(new BlockPos(
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
											entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
											entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
											entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
											.getBlock() instanceof IWaterLoggable
							&& (new Object() {
								public boolean get(BlockState _bs, String property) {
									Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
									return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
								}
							}.get((world.getBlockState(new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))),
									"waterlogged"))) {
						{
							BlockPos _pos = new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
							BlockState _bs = world.getBlockState(_pos);
							Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
							if (_property instanceof BooleanProperty)
								world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (false)), 3);
						}
					} else {
						world.setBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
														entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
								Blocks.AIR.getDefaultState(), 3);
					}
					if (!world.isRemote()) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * localRayTraceDistance,
													entity.getLook(1f).y * localRayTraceDistance, entity.getLook(1f).z * localRayTraceDistance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
					}
					break;
				}
				localRayTraceDistance = (localRayTraceDistance + 1);
			}
		}
	}
}
