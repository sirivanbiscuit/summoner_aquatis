
package net.mcreator.summoneraquatis.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.itemgroup.SummonerAquatisItemGroup;
import net.mcreator.summoneraquatis.SummonerAquatisModElements;

@SummonerAquatisModElements.ModElement.Tag
public class AgarJellyBerriesItem extends SummonerAquatisModElements.ModElement {
	@ObjectHolder("summoner_aquatis:agar_jelly_berries")
	public static final Item block = null;

	public AgarJellyBerriesItem(SummonerAquatisModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SummonerAquatisItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("agar_jelly_berries");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}