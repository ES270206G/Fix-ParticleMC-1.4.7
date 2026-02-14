package emi.coremod;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class EmiLoadingPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"emi.coremod.EmiParticleFixer"};
    }

    @Override 
    public String getModContainerClass() { return null; }

    @Override 
    public String getSetupClass() { return null; }

    @Override 
    public void injectData(Map<String, Object> data) { }

    @Override 
    public String getLibraryRequestClass() { return null; }

    @Override 
    public String getModPropertyClass() { return null; }
}
