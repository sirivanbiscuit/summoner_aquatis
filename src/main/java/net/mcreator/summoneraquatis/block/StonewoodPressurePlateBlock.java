
package net.mcreator.summoneraquatis.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.summoneraquatis.itemgroup.SummonerAquatisItemGroup;
import net.mcreator.summoneraquatis.SummonerAquatisModElements;

import java.util.List;
import java.util.Collections;

@SummonerAquatisModElements.ModElement.Tag
public class StonewoodPressurePlateBlock extends SummonerAquatisModElements.ModElement {
	@ObjectHolder("summoner_aquatis:stonewood_pressure_plate")
	public static final Block block = null;

	public StonewoodPressurePlateBlock(SummonerAquatisModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(SummonerAquatisItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends PressurePlateBlock {
		public CustomBlock() {
			super(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(9f, 9f).setLightLevel(s -> 0));
			setRegistryName("stonewood_pressure_plate");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
