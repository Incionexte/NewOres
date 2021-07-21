
package net.mcreator.newores.item;

@NewOresModElements.ModElement.Tag
public class TitaniumIngotItem extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:titanium_ingot")
	public static final Item block = null;

	public TitaniumIngotItem(NewOresModElements instance) {
		super(instance, 33);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("titanium_ingot");
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