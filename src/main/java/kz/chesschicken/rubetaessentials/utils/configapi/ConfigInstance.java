package kz.chesschicken.rubetaessentials.utils.configapi;

public abstract class ConfigInstance {
    protected Configuration instance;

    public ConfigInstance(String name)
    {
        instance = new Configuration(name);
    }

    public void start()
    {
        if(!instance.exists()) {
            saveConfig();
            instance.save();
        }
        else {
            instance.load();
            applyConfig();
        }
    }

    public void saveToFile() {
        instance.cleanup();
        saveConfig();
        instance.save();
    }

    public Object getValue(String group, String property)
    {
        return instance.getGroup(group).getProperty(property).getValue();
    }

    public abstract void saveConfig();
    public void applyConfig() { }
}
