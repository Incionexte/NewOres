
package net.mcreator.newores.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.newores.NewOresModElements;

@NewOresModElements.ModElement.Tag
public class SteelPainting extends NewOresModElements.ModElement {
	public SteelPainting(NewOresModElements instance) {
		super(instance, 6);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(80, 64).setRegistryName("steel"));
	}
}
