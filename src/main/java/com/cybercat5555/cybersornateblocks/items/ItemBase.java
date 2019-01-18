package com.cybercat5555.cybersornateblocks.items;

import com.cybercat5555.cybersornateblocks.Main;
import com.cybercat5555.cybersornateblocks.init.ModItems;
import com.cybercat5555.cybersornateblocks.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	} 

}
