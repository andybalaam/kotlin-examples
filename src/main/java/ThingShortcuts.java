import java.util.Objects;

public class ThingShortcuts {
    private final String name;
    private final String desc;

    public ThingShortcuts(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ThingShortcuts other = (ThingShortcuts)obj;
        return (
            Objects.equals(name, other.name) &&
            Objects.equals(desc, other.desc)
        );
    }

    @Override
    public String toString() {
        return "ThingShortcuts(name=" + name + ", desc=" + desc + ")";
    }
}
