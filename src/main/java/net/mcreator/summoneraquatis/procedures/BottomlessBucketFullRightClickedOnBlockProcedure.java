package net.mcreator.summoneraquatis.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.item.BottomlessBucketFullItem;
import net.mcreator.summoneraquatis.SummonerAquatisMod;

import java.util.Map;

public class BottomlessBucketFullRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency world for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency x for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency y for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency z for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency blockstate for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency direction for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SummonerAquatisMod.LOGGER.warn("Failed to load dependency entity for procedure BottomlessBucketFullRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof IWaterLoggable && !(new Object() {
			public boolean get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get(blockstate, "waterlogged"))) {
			{
				BlockPos _pos = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateContainer().getProperty("waterlogged");
				if (_property instanceof BooleanProperty)
					world.setBlockState(_pos, _bs.with((BooleanProperty) _property, (true)), 3);
			}
			if (world instanceof World)
				((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
						((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock());
			world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
					world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 0);
			if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem()) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
			} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getHeldItemOffhand()
					: ItemStack.EMPTY).getItem()) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
			}
			if (!world.isRemote()) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof IWaterLoggable && (new Object() {
			public boolean get(BlockState _bs, String property) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
				return _prop instanceof BooleanProperty ? _bs.get((BooleanProperty) _prop) : false;
			}
		}.get(blockstate, "waterlogged")) || !((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof IWaterLoggable)) {
			if (direction == Direction.DOWN && ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y - 1), (int) z),
							((World) world).getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
			if (direction == Direction.UP && ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y + 1), (int) z),
							((World) world).getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
			if (direction == Direction.NORTH && ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) (z - 1)),
							((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
			if (direction == Direction.SOUTH && ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) (z + 1)),
							((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
			if (direction == Direction.EAST && ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x + 1), (int) y, (int) z),
							((World) world).getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
			if (direction == Direction.WEST && ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR
					|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.WATER.getDefaultState(), 3);
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x - 1), (int) y, (int) z),
							((World) world).getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)).getBlock());
				if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemMainhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				} else if (BottomlessBucketFullItem.block == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHeldItemOffhand()
						: ItemStack.EMPTY).getItem()) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
				}
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
		}
	}
}
