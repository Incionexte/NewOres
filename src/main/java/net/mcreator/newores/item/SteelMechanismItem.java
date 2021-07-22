
package net.mcreator.newores.item;

@NewOresModElements.ModElement.Tag
public class SteelMechanismItem extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:steel_mechanism")
	public static final Item block = null;

	public SteelMechanismItem(NewOresModElements instance) {
		super(instance, 55);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("steel_mechanism");
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
