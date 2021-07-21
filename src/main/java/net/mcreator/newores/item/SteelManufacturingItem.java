
package net.mcreator.newores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.newores.NewOresModElements;

@NewOresModElements.ModElement.Tag
public class SteelManufacturingItem extends NewOresModElements.ModElement {
	@ObjectHolder("new_ores:steel_manufacturing")
	public static final Item block = null;
	public SteelManufacturingItem(NewOresModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NewOresModElements.sounds.get(new ResourceLocation("new_ores:steel_disc")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("steel_manufacturing");
		}
	}
}
