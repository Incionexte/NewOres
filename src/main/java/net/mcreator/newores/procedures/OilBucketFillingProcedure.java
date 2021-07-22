package net.mcreator.newores.procedures;

@NewOresModElements.ModElement.Tag
public class OilBucketFillingProcedure extends NewOresModElements.ModElement {

	public OilBucketFillingProcedure(NewOresModElements instance) {
		super(instance, 57);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewOresMod.LOGGER.warn("Failed to load dependency entity for procedure OilBucketFilling!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewOresMod.LOGGER.warn("Failed to load dependency x for procedure OilBucketFilling!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewOresMod.LOGGER.warn("Failed to load dependency y for procedure OilBucketFilling!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewOresMod.LOGGER.warn("Failed to load dependency z for procedure OilBucketFilling!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewOresMod.LOGGER.warn("Failed to load dependency world for procedure OilBucketFilling!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.BUCKET, (int) (1)).getItem())
				&& (entity.world
						.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity))
						.getType() == RayTraceResult.Type.BLOCK))) {
			if ((/*@BlockState*/(world
					.getFluidState(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(
											new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
															entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity))
											.getPos().getX()),
									(int) (entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f)
															.add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity))
											.getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
													entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getZ())))
					.getBlockState()).getBlock() == OilBlock.block.getDefaultState().getBlock())) {
				if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
						_setstack.setCount(
								(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getCount()) - 1));
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(OilBucketItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		}

	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("direction", event.getFace());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

}
