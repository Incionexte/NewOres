package net.mcreator.newores.procedures;

@NewOresModElements.ModElement.Tag
public class RubyPotionPotionStartedappliedProcedure extends NewOresModElements.ModElement {

	public RubyPotionPotionStartedappliedProcedure(NewOresModElements instance) {
		super(instance, 63);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewOresMod.LOGGER.warn("Failed to load dependency entity for procedure RubyPotionPotionStartedapplied!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 60, (int) 1, (false), (false)));

	}

}
