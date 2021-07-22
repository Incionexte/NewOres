
package net.mcreator.newores.enchantment;

@NewOresModElements.ModElement.Tag
public class RubyEnchantmentEnchantment extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:ruby_enchantment")
	public static final Enchantment enchantment = null;

	public RubyEnchantmentEnchantment(NewOresModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("ruby_enchantment"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.POWER)
				return true;
			if (ench == Enchantments.MULTISHOT)
				return true;
			if (ench == Enchantments.KNOCKBACK)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(Items.STONE_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_SWORD, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

	}

}
