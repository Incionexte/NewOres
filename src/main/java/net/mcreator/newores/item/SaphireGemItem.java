
package net.mcreator.newores.item;

@NewOresModElements.ModElement.Tag
public class SaphireGemItem extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:saphire_gem")
	public static final Item block = null;

	public SaphireGemItem(NewOresModElements instance) {
		super(instance, 33);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("saphire_gem");
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
