package com.cybercat5555.cybersornateblocks.proxy;

import com.cybercat5555.cybersornateblocks.client.renderer.tileentity.RenderGenericHead;
import com.cybercat5555.cybersornateblocks.client.renderer.tileentity.RenderGenericHeadFloor;
import com.cybercat5555.cybersornateblocks.common.block.BlockGenericSkull;
import com.cybercat5555.cybersornateblocks.common.tileentity.TileEntityHead;
import com.cybercat5555.cybersornateblocks.init.RegistryHandler;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements ISidedProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
		for(BlockGenericSkull block : RegistryHandler.genericskulls.keySet()) {
			if(block.allowFloor) {
				ClientRegistry.bindTileEntitySpecialRenderer(block.teClass.asSubclass(TileEntityHead.class), new RenderGenericHeadFloor());
			}
		}
	}

	@Override
	public void init(FMLInitializationEvent e) {

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

	}

}
