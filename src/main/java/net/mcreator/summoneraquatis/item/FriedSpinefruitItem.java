
package net.mcreator.summoneraquatis.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.summoneraquatis.itemgroup.SummonerAquatisItemGroup;
import net.mcreator.summoneraquatis.SummonerAquatisModElements;

import java.util.List;

@SummonerAquatisModElements.ModElement.Tag
public class FriedSpinefruitItem extends SummonerAquatisModElements.ModElement {
	@ObjectHolder("summoner_aquatis:fried_spinefruit")
	public static final Item block = null;

	public FriedSpinefruitItem(SummonerAquatisModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SummonerAquatisItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(12.5f).setAlwaysEdible()

							.build()));
			setRegistryName("fried_spinefruit");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Smells funny"));
			list.add(new StringTextComponent("but oddly filling"));
		}
	}
}
