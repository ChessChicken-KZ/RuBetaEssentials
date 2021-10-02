package kz.chesschicken.rubetaessentials.utils.configapi.instance;


import kz.chesschicken.rubetaessentials.utils.configapi.EnumPropertyType;

public class Property extends ConfigPart
{
    private EnumPropertyType type;
    private Object value;
    public Property(String s, Object o) {
        super(s);
        value = o;
        type = EnumPropertyType.parseObject(o);
    }

    public void setOther(Object o, boolean f)
    {
        value = o;
        if(f) type = EnumPropertyType.parseObject(o);
    }

    public Object getValue()
    {
        return value;
    }

    public EnumPropertyType getType() {
        return this.type;
    }

    public static Property createProperty(String s, Object instance) {
        return new Property(s, instance);
    }
}