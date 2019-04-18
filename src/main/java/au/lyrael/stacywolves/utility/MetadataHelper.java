package au.lyrael.stacywolves.utility;

import au.lyrael.stacywolves.StacyWolves;
import net.minecraftforge.fml.common.ModMetadata;

public class MetadataHelper {
    public static ModMetadata transformMetadata(ModMetadata meta) {
        meta.authorList.clear();
        meta.authorList.add("LyraelRayne");
        meta.modId = StacyWolves.MOD_ID;
        meta.name = StacyWolves.MOD_NAME;
        meta.version = StacyWolves.VERSION;
        meta.description = StacyWolves.DESC;
        meta.url = StacyWolves.URL;
        meta.credits = StacyWolves.CREDITS;
        meta.logoFile = StacyWolves.LOGO_PATH;
        meta.autogenerated = false;
        return meta;
    }
}
