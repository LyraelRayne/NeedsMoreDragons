package au.lyrael.stacywolves.entity.wolf;

import au.lyrael.stacywolves.annotation.WolfMetadata;
import au.lyrael.stacywolves.annotation.WolfSpawn;
import au.lyrael.stacywolves.annotation.WolfSpawnBiome;
import au.lyrael.stacywolves.client.render.IRenderableWolf;
import au.lyrael.stacywolves.item.WolfPeriodicItemDrop;
import au.lyrael.stacywolves.registry.ItemRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static au.lyrael.stacywolves.entity.SpawnWeights.SPAWN_PROBABILITY_RARE;
import static au.lyrael.stacywolves.registry.WolfType.MOB;
import static net.minecraftforge.common.BiomeDictionary.Type.END;
import static net.minecraftforge.common.BiomeDictionary.Type.NETHER;

@WolfMetadata(name = "EntityEndWolf", primaryColour = 0xF9F9C5, secondaryColour = 0xC3BD89, type = MOB, probability = SPAWN_PROBABILITY_RARE,
        spawns = {
                @WolfSpawn(spawnBiomes = {
                        @WolfSpawnBiome(requireBiomeTypes = {END}, excludeBiomeTypes = {NETHER}, excludeBiomeNames = "Eldritch"),
                }, weight = 10, min = 1, max = 2),
        })
public class EntityEndWolf extends EntityWolfBase implements IRenderableWolf {

    public EntityEndWolf(World worldObj) {
        super(worldObj);
        addLikedItem(ItemRegistry.getWolfFood("end_bone"));
		setPeriodicDrop(new WolfPeriodicItemDrop(600, 20, new ItemStack(Items.ender_pearl)));
	}

    @Override
    public EntityWolfBase createChild(EntityAgeable parent) {
        EntityWolfBase child = new EntityEndWolf(this.worldObj);
        return createChild(parent, child);
    }

    @Override
    public String getTextureFolderName() {
        return "end";
    }

    @Override
    public boolean canSpawnNow(World world, float x, float y, float z) {
        return true;
    }

    @Override
    protected boolean isStandingOnSuitableFloor() {
        return true;
    }
}
