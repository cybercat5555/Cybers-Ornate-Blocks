package com.cybercat5555.cybersornateblocks.client;

import com.cybercat5555.cybersornateblocks.Reference;
import com.cybercat5555.cybersornateblocks.common.block.BlockGenericSkull;
import com.cybercat5555.cybersornateblocks.common.item.ItemBlockSkull;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class HeadItemMeshDefinition implements ItemMeshDefinition
{
    public final ModelResourceLocation defaultModelResourceLocation;

    public HeadItemMeshDefinition(BlockGenericSkull head)
    {
        this.defaultModelResourceLocation = new ModelResourceLocation(head.getRegistryName(), "inventory");
    }

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack)
    {
        if(stack != null && stack.getItem() instanceof ItemBlockSkull && stack.hasTagCompound())
        {
            return new ModelResourceLocation(Reference.MOD_ID + ":" + this.defaultModelResourceLocation.getResourcePath() + "_" + stack.getTagCompound().getInteger("TYPENUM"), "inventory");
        }
        return this.defaultModelResourceLocation;
    }
}