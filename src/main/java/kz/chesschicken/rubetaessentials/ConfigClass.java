package kz.chesschicken.rubetaessentials;

import kz.chesschicken.rubetaessentials.utils.configapi.ConfigInstance;
import kz.chesschicken.rubetaessentials.utils.configapi.instance.Group;
import kz.chesschicken.rubetaessentials.utils.configapi.instance.Property;

public class ConfigClass extends ConfigInstance {
    public enum EnumConfigBooleans {
        STAIRS_MINING_FIX("stairs_mining","fixes", true, false),
        FAST_BLOCK_MINING_FIX("click_fix","fixes", true, false),

        PING_SERVER_CLIENT("ping_server","client", true, true),
        AUTO_LOGIN_CLIENT("auto_login","client", true, false);
        private boolean value;
        private final boolean requires;
        private final String name;
        private final String group;
        EnumConfigBooleans(String s, String s1, boolean b, boolean r) {
            this.name = s;
            this.group = s1;
            this.value = b;
            this.requires = r;
        }

        public void setValue(boolean b) {
            this.value = b;
        }

        public boolean getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }

        public String getGroup() {
            return this.group;
        }

        public boolean requiresReconnect() {
            return this.requires;
        }
    }

    public ConfigClass() {
        super("rubetaessentials");
    }

    private void create(EnumConfigBooleans configBooleans) {
        instance.getGroup(configBooleans.getGroup()).add(Property.createProperty(configBooleans.getName(), configBooleans.getValue()));
    }

    private void set(EnumConfigBooleans configBooleans) {
        configBooleans.setValue((boolean) getValue(configBooleans.getGroup(), configBooleans.getName()));
    }

    @Override
    public void saveConfig() {
        instance.add(Group.createGroup("fixes"));
        instance.add(Group.createGroup("client"));

        for(EnumConfigBooleans booleans : EnumConfigBooleans.values())
            create(booleans);
    }

    @Override
    public void applyConfig() {
        for(EnumConfigBooleans booleans : EnumConfigBooleans.values())
            set(booleans);
    }
}