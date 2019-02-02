package com.cybercat5555.cybersornateblocks.init;

import java.util.HashMap;

import com.cybercat5555.cybersornateblocks.common.block.BlockGenericSkull;
import com.cybercat5555.cybersornateblocks.common.item.ItemBlockSkull;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
@ObjectHolder(com.cybercat5555.cybersornateblocks.Reference.MOD_ID)
public class RegistryHandler {
	
	public static HashMap<BlockGenericSkull, ItemBlockSkull> genericskulls = new HashMap<BlockGenericSkull, ItemBlockSkull>();

	public static void addGenericSkull(BlockGenericSkull block) {
		genericskulls.put(block, new ItemBlockSkull(block, block.allowFloor));
	}

	public static ItemBlockSkull getSkullItemForBlock(BlockGenericSkull block) {
		return genericskulls.get(block);
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		// Register all the ModItems
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
		// Head item registration
		
		for (final ItemBlock item : genericskulls.values()) {
			final Block block = item.getBlock();
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
			event.getRegistry().register(item.setRegistryName(registryName));
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		// Register all the ModBlocks
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		
		
		// Head registration
		
		genericskulls.keySet().forEach(b -> event.getRegistry().register(b));

		for(BlockGenericSkull block : genericskulls.keySet()) {
			GameRegistry.registerTileEntity(block.teClass, new ResourceLocation(block.getRegistryName() + "tileentity"));
		}
		
	}
	

}
