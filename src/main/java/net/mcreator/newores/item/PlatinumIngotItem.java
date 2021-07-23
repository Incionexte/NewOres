
package net.mcreator.newores.item;

@NewOresModElements.ModElement.Tag
public class PlatinumIngotItem extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:platinum_ingot")
	public static final Item block = null;

	public PlatinumIngotItem(NewOresModElements instance) {
		super(instance, 65);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("platinum_ingot");
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
