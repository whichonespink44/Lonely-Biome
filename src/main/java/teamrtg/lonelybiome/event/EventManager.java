package teamrtg.lonelybiome.event;

import teamrtg.lonelybiome.config.lonelybiome.ConfigLB;
import teamrtg.lonelybiome.world.gen.genlayer.GenLayerConstant;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventManager
{

    public EventManager()
    {

    }
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onBiomeGenInit(WorldTypeEvent.InitBiomeGens event) {
        if (ConfigLB.singleBiomeId == -1) return;
        GenLayer[] replacement = new GenLayer[2];
        replacement[0] = new GenLayerConstant(ConfigLB.singleBiomeId);
        replacement[1] = replacement[0];
        event.newBiomeGens = replacement;
    }
}