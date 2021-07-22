
package net.mcreator.newores.block;

import net.minecraft.block.material.Material;

@NewOresModElements.ModElement.Tag
public class ReinforcedSilverBlockBlock extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:reinforced_silver_block")
	public static final Block block = null;

	public ReinforcedSilverBlockBlock(NewOresModElements instance) {
		super(instance, 46);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public static final DirectionProperty FACING = DirectionalBlock.FACING;

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(4.6f, 7f).setLightLevel(s -> 0)
					.slipperiness(0.8f).speedFactor(1.4f).jumpFactor(0.8f));

			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

			setRegistryName("reinforced_silver_block");
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
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
