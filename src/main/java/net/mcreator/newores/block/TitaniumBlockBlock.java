
package net.mcreator.newores.block;

import net.minecraft.block.material.Material;

@NewOresModElements.ModElement.Tag
public class TitaniumBlockBlock extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:titanium_block")
	public static final Block block = null;

	public TitaniumBlockBlock(NewOresModElements instance) {
		super(instance, 36);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("titanium_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
