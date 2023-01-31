package mod.gottsch.forge.treasure2_blood_magic_lp.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure2.api.TreasureApi;
import com.someguyssoftware.treasure2.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Mark Gottschling Jan 30, 2023
 *
 */
@Mod(modid = TreasureBloodMagicLP.MODID, 
name = TreasureBloodMagicLP.NAME, 
version = TreasureBloodMagicLP.VERSION, 
dependencies = "required-after:gottschcore@[1.14.0,);required-after:treasure2@[2.0.0,);required-after:bloodmagic@[1.12.2-1.0.0,)", 
acceptedMinecraftVersions = "[1.12.2]", 
updateJSON = TreasureBloodMagicLP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Blood Magic Loot Pack was first developed by Mark Gottschling on Jan 30, 2023."})
public class TreasureBloodMagicLP extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_atum2_lp";
	protected static final String NAME = "Treasure2Atum2LP";
	protected static final String VERSION = "2.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-Blood-Magic-Loot-Pack/1.12.2-main/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureBloodMagicLP.NAME);

	@Instance(value = TreasureBloodMagicLP.MODID)
	public static TreasureBloodMagicLP instance;

	/**
	 * 
	 */
	public TreasureBloodMagicLP() {

	}

	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);

		// create the treasure registries
		TreasureApi.registerLootTables(MODID);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (!getConfig().isModEnabled()) {
			return;
		}

		// perform any post init
		super.postInit(event);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return ModConfig.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return TreasureBloodMagicLP.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return TreasureBloodMagicLP.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return TreasureBloodMagicLP.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return TreasureBloodMagicLP.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return TreasureBloodMagicLP.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		TreasureBloodMagicLP.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return TreasureBloodMagicLP.UPDATE_JSON_URL;
	}
}