
package net.mcreator.newores.item;

@NewOresModElements.ModElement.Tag
public class CoalishDiamondItem extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:coalish_diamond")
	public static final Item block = null;

	public CoalishDiamondItem(NewOresModElements instance) {
		super(instance, 50);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("coalish_diamond");
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
