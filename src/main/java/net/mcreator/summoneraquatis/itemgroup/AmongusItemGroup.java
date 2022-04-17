
package net.mcreator.summoneraquatis.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.summoneraquatis.SummonerAquatisModElements;

@SummonerAquatisModElements.ModElement.Tag
public class AmongusItemGroup extends SummonerAquatisModElements.ModElement {
	public AmongusItemGroup(SummonerAquatisModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabamongus") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.YELLOW_BED);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
