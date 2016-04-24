package au.lyrael.stacywolves.entity.wolf;

import au.lyrael.stacywolves.annotation.WolfMetadata;
import au.lyrael.stacywolves.annotation.WolfSpawn;
import au.lyrael.stacywolves.client.render.IRenderableWolf;
import au.lyrael.stacywolves.registry.ItemRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

@WolfMetadata(name = "EntitySkeletonWolf", primaryColour = 0xDBD8D8, secondaryColour = 0x737373,
        spawns = {
                @WolfSpawn(biomeTypes = PLAINS, probability = 6, min = 1, max = 4),
                @WolfSpawn(biomeTypes = FOREST, probability = 6, min = 1, max = 4),
                @WolfSpawn(biomeTypes = HILLS, probability = 6, min = 1, max = 4),
        })
public class EntitySkeletonWolf extends EntityWolfBase implements IRenderableWolf {

    public EntitySkeletonWolf(World worldObj) {
        super(worldObj);
        addLikedItem(ItemRegistry.getWolfFood("skeleton_bone"));
        this.addEdibleItem(new ItemStack(Items.beef));
        this.addEdibleItem(new ItemStack(Items.chicken));
    }

    @Override
    public EntityWolfBase createChild(EntityAgeable parent) {
        EntityWolfBase child = new EntitySkeletonWolf(this.worldObj);
        return createChild(parent, child);
    }

    @Override
    public String getTextureFolderName() {
        return "skeleton";
    }

    @Override
    public void onLivingUpdate() {
        if (!this.worldObj.isRemote) {
            this.burnIfInSunlight();
        }

        super.onLivingUpdate();
    }

    @Override
    public boolean canSpawnNow(World world, float x, float y, float z) {
        return !world.isDaytime();
    }
}
