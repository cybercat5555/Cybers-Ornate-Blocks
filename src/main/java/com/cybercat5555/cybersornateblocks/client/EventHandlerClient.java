package com.cybercat5555.cybersornateblocks.client;

import com.cybercat5555.cybersornateblocks.common.block.BlockBase;
import com.cybercat5555.cybersornateblocks.common.block.BlockGenericSkull;
import com.cybercat5555.cybersornateblocks.common.item.ItemBase;
import com.cybercat5555.cybersornateblocks.common.item.ItemBlockSkull;
import com.cybercat5555.cybersornateblocks.init.ModBlocks;
import com.cybercat5555.cybersornateblocks.init.ModItems;
import com.cybercat5555.cybersornateblocks.init.RegistryHandler;
import com.cybercat5555.cybersornateblocks.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class EventHandlerClient {

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof ItemBase) {
				registerItemRenderer(item, 0, "inventory");
			}
		}

		for(Block block : ModBlocks.BLOCKS) {
			if(block instanceof BlockBase) {
				registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");		
			}
		}
		
		// generics
		for(BlockGenericSkull skull : RegistryHandler.genericskulls.keySet()) {
			HeadItemMeshDefinition meshDefinition = new HeadItemMeshDefinition(skull);
			ItemBlockSkull item = (ItemBlockSkull) skull.getItemBlock();
			ModelBakery.registerItemVariants(item, meshDefinition.defaultModelResourceLocation);
			for (int i = 1; i <= skull.texCount; i++)
			{
				ItemStack stack = new ItemStack(item);
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setInteger("TYPENUM", i);
				ModelBakery.registerItemVariants(item, meshDefinition.getModelLocation(stack));
			}
			ModelLoader.setCustomMeshDefinition(item, meshDefinition);
		}
		
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

}
