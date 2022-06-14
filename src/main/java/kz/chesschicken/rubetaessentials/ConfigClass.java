package kz.chesschicken.rubetaessentials;

import kz.chesschicken.rubetaessentials.utils.configapi.ConfigInstance;
import kz.chesschicken.rubetaessentials.utils.configapi.instance.Group;
import kz.chesschicken.rubetaessentials.utils.configapi.instance.Property;
import net.minecraft.client.Minecraft;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConfigClass extends ConfigInstance {
    public enum EnumConfigBooleans {
        STAIRS_MINING_FIX("stairs_mining","fixes", true, false),
        FAST_BLOCK_MINING_FIX("click_fix","fixes", true, false),

        PING_SERVER_CLIENT("ping_server","client", true, true),
        AUTO_LOGIN_CLIENT("auto_login","client", true, false),

        INVENTORY_BUTTONS("inv_buttons", "client", true, false),

        DYNAMIC_DYNMAP("dynamic_dynmap", "client", false, false);

        private boolean value;
        private final boolean requires;
        private final String name;
        private final String group;
        private final Function<Minecraft, Boolean> apply;
        EnumConfigBooleans(String s, String s1, boolean b, boolean r) {
            this.name = s;
            this.group = s1;
            this.value = b;
            this.requires = r;
            this.apply = null;
        }

        EnumConfigBooleans(String s, String s1, boolean b, boolean r, Function<Minecraft, Boolean> f) {
            this.name = s;
            this.group = s1;
            this.value = b;
            this.requires = r;
            this.apply = f;
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

        public boolean applyUpdate(Minecraft mc) {
            if(this.apply != null)
                return this.apply.apply(mc);
            return false;
        }
    }

    public ConfigClass() {
        super("rubetaessentials");
    }

    @Override
    public void saveConfig() {
        instance.add(Group.createGroup("fixes"));
        instance.add(Group.createGroup("client"));

        for(EnumConfigBooleans booleans : EnumConfigBooleans.values())
            instance.getGroup(booleans.getGroup()).add(Property.createProperty(booleans.getName(), booleans.getValue()));
    }

    @Override
    public void applyConfig() {
        for(EnumConfigBooleans booleans : EnumConfigBooleans.values())
            booleans.setValue((boolean) getValue(booleans.getGroup(), booleans.getName()));
    }
}
