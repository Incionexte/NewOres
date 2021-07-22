package net.mcreator.newores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newores.block.UraniumOreBlock;
import net.mcreator.newores.NewOresModElements;
import net.mcreator.newores.NewOresMod;

import java.util.Map;

@NewOresModElements.ModElement.Tag
public class UraniumEffectProcedure extends NewOresModElements.ModElement {
	public UraniumEffectProcedure(NewOresModElements instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewOresMod.LOGGER.warn("Failed to load dependency entity for procedure UraniumEffect!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewOresMod.LOGGER.warn("Failed to load dependency x for procedure UraniumEffect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewOresMod.LOGGER.warn("Failed to load dependency y for procedure UraniumEffect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewOresMod.LOGGER.warn("Failed to load dependency z for procedure UraniumEffect!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewOresMod.LOGGER.warn("Failed to load dependency world for procedure UraniumEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		while ((1 == 1)) {
			sx = (double) (-3);
			found = (boolean) (false);
			for (int index1 = 0; index1 < (int) (8); index1++) {
				sy = (double) (-3);
				for (int index2 = 0; index2 < (int) (8); index2++) {
					sz = (double) (-3);
					for (int index3 = 0; index3 < (int) (8); index3++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == UraniumOreBlock.block.getDefaultState().getBlock())) {
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (true))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 2, (false), (false)));
			}
		}
	}
}
