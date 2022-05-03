
package net.mcreator.summoneraquatis.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.summoneraquatis.itemgroup.SummonerAquatisItemGroup;
import net.mcreator.summoneraquatis.SummonerAquatisModElements;

import java.util.List;

@SummonerAquatisModElements.ModElement.Tag
public class PetrifiedStonewoodSaplingItem extends SummonerAquatisModElements.ModElement {
	@ObjectHolder("summoner_aquatis:petrified_stonewood_sapling")
	public static final Item block = null;

	public PetrifiedStonewoodSaplingItem(SummonerAquatisModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SummonerAquatisItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("petrified_stonewood_sapling");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Remains extremely durable"));
			list.add(new StringTextComponent("Needs orichalcum and genetic material to revive"));
		}
	}
}