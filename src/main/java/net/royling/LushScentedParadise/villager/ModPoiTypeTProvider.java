package net.royling.LushScentedParadise.villager;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.royling.LushScentedParadise.LushScentedParadise;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTProvider extends PoiTypeTagsProvider {

    public ModPoiTypeTProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, LushScentedParadise.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(LushScentedParadise.MODID,"flower_poi"));
    }
}
