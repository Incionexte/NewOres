package net.mcreator.newores.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newores.NewOresModElements;
import net.mcreator.newores.NewOresMod;

import java.util.Map;

@NewOresModElements.ModElement.Tag
public class SilverProtectionPotionProcedure extends NewOresModElements.ModElement {
	public SilverProtectionPotionProcedure(NewOresModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewOresMod.LOGGER.warn("Failed to load dependency entity for procedure SilverProtectionPotion!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 2400, (int) 2, (false), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 2400, (int) 4, (false), (true)));
	}
}
