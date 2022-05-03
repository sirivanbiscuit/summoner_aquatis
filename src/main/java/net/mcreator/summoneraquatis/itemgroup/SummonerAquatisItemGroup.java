
package net.mcreator.summoneraquatis.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.summoneraquatis.block.OrichalcumOreBlock;
import net.mcreator.summoneraquatis.SummonerAquatisModElements;

@SummonerAquatisModElements.ModElement.Tag
public class SummonerAquatisItemGroup extends SummonerAquatisModElements.ModElement {
	public SummonerAquatisItemGroup(SummonerAquatisModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsummoner_aquatis") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OrichalcumOreBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
