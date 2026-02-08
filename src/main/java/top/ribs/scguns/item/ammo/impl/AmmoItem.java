package top.ribs.scguns.item.ammo.impl;

import net.minecraft.world.item.Item;
import top.ribs.scguns.item.ammo.IAmmo;

/**
 * A basic item class that implements {@link IAmmo} to indicate this item is ammunition
 *
 * Author: MrCrayfish
 */
public class AmmoItem extends Item implements IAmmo
{
    public AmmoItem(Properties properties)
    {
        super(properties);
    }
}
