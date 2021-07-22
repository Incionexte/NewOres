
package net.mcreator.newores.block;

import net.minecraft.block.material.Material;

@NewOresModElements.ModElement.Tag
public class AcidBlock extends NewOresModElements.ModElement {

	@ObjectHolder("new_ores:acid")
	public static final FlowingFluidBlock block = null;

	@ObjectHolder("new_ores:acid_bucket")
	public static final Item bucket = null;

	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;

	private ForgeFlowingFluid.Properties fluidproperties = null;

	public AcidBlock(NewOresModElements instance) {
		super(instance, 40);

		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	private static class FluidRegisterHandler {

		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("new_ores:blocks/acid_flow"), new ResourceLocation("new_ores:blocks/acid_still"))
						.luminosity(0).density(1200).viscosity(1000)).bucket(() -> bucket).block(() -> block);

		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("acid");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("acid_flowing");

		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.LAVA)) {

		}.setRegistryName("acid"));

		elements.items.add(() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(ItemGroup.MISC))
				.setRegistryName("acid_bucket"));
	}

	private static Feature<BlockStateFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static class FeatureRegisterHandler {

		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new LakesFeature(BlockStateFeatureConfig.field_236455_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

					if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("new_ores:deleted_mod_element")))
						dimensionCriteria = true;

					if (!dimensionCriteria)
						return false;

					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
					.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(1)));

			event.getRegistry().register(feature.setRegistryName("acid_lakes"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("new_ores:acid_lakes"), configuredFeature);
		}

	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {

		event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS).add(() -> configuredFeature);
	}

}
