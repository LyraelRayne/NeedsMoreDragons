package au.lyrael.stacywolves.entity.wolf;

import au.lyrael.stacywolves.annotation.WolfMetadata;
import au.lyrael.stacywolves.annotation.WolfSpawn;
import au.lyrael.stacywolves.annotation.WolfSpawnBiome;
import au.lyrael.stacywolves.client.render.IRenderableWolf;
import au.lyrael.stacywolves.registry.ItemRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

import static au.lyrael.stacywolves.entity.SpawnWeights.SPAWN_WEIGHT_COMMON;
import static net.minecraftforge.common.BiomeDictionary.Type.MESA;

@WolfMetadata(name = "EntityMesaWolf", primaryColour = 0x9A6147, secondaryColour = 0x4D3424,
        spawns = {
                @WolfSpawn(spawnBiomes = {
                        @WolfSpawnBiome(requireBiomeTypes = {MESA}),
                }, weight = SPAWN_WEIGHT_COMMON, min = 1, max = 4),
        })
public class EntityMesaWolf extends EntityWolfBase implements IRenderableWolf {

    public EntityMesaWolf(World worldObj) {
        super(worldObj);
        addLikedItem(ItemRegistry.getWolfFood("mesa_bone"));
    }

    @Override
    public EntityWolfBase createChild(EntityAgeable parent) {
        EntityWolfBase child = new EntityMesaWolf(this.worldObj);
        return createChild(parent, child);
    }

    @Override
    public String getTextureFolderName() {
        return "mesa";
    }

    @Override
    protected boolean isStandingOnSuitableFloor() {
        return true;
    }
}
