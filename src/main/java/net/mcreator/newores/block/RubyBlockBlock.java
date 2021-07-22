
package net.mcreator.newores.block;

import net.minecraft.block.material.Material;

@NewOresModElements.ModElement.Tag
public class RubyBlockBlock extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:ruby_block")
	public static final Block block = null;

	public RubyBlockBlock(NewOresModElements instance) {
		super(instance, 37);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));

			setRegistryName("ruby_block");
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
