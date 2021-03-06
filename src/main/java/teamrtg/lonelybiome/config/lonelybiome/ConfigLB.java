package teamrtg.lonelybiome.config.lonelybiome;

import java.io.File;

import teamrtg.lonelybiome.util.Logger;
import net.minecraftforge.common.config.Configuration;

public class ConfigLB
{
	public static Configuration config;
	
	public static int singleBiomeId = -1;
	public static boolean enableDebugging = false;
    
	public static void init(File configFile)
	{
		config = new Configuration(configFile);
		
		try 
		{
			config.load();
            
            singleBiomeId = config.getInt(
                "Lonely Biome ID", 
                "General", 
                singleBiomeId, 
                -1, 255, 
                "If you enter a biome ID here, the whole world will consist of only that biome." +
        		Configuration.NEW_LINE +
        		"Set to -1 to generate the world normally." +
                Configuration.NEW_LINE +
                "Vanilla biome IDs can be found here: http://goo.gl/WqlAfV" +
                Configuration.NEW_LINE +
                "For modded biome IDs, use NEI and go [Options] > [Tools] > [Data Dumps] > Biomes > [Dump], and then refer to the 'biome.csv' file which can be found in your '/.minecraft/dumps' folder." +
                Configuration.NEW_LINE
            );
            
            enableDebugging = config.getBoolean("Enable Debugging", "General", enableDebugging, "Logs helpful debug messages to the console." + Configuration.NEW_LINE);
		}
		catch (Exception e) 
		{
		    Logger.error("Lonely Biome has had a problem loading its configuration.");	
		}
		finally 
		{
			if (config.hasChanged())
			{
				config.save();
			}
		}
	}
}