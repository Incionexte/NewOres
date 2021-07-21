package net.mcreator.newores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.newores.NewOresModElements;
import net.mcreator.newores.NewOresMod;

import java.util.Map;

@NewOresModElements.ModElement.Tag
public class RubyLighterRightClickedOnBlockProcedure extends NewOresModElements.ModElement {
	public RubyLighterRightClickedOnBlockProcedure(NewOresModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewOresMod.LOGGER.warn("Failed to load dependency x for procedure RubyLighterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewOresMod.LOGGER.warn("Failed to load dependency y for procedure RubyLighterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewOresMod.LOGGER.warn("Failed to load dependency z for procedure RubyLighterRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewOresMod.LOGGER.warn("Failed to load dependency world for procedure RubyLighterRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
	}
}
