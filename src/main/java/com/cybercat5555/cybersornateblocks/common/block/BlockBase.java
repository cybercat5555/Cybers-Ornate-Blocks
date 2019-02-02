package com.cybercat5555.cybersornateblocks.common.block;

import com.cybercat5555.cybersornateblocks.Reference;
import com.cybercat5555.cybersornateblocks.init.ModBlocks;
import com.cybercat5555.cybersornateblocks.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
	
	public BlockBase(String name, Material material) {
		super(material);
		this.setUnlocalizedName(Reference.MOD_ID + "." + name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

}
