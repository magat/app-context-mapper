package info.magat.appcxmapper;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bean {

    private final String name;
    private final Class clazz;
    private final Set<Bean> dependencies = new HashSet<>();

    public Bean(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public Set<Bean> getDependencies() {
        return dependencies;
    }

    public void addDependency(Bean dep){
        this.dependencies.add(dep);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return Objects.equals(name, bean.name) &&
                Objects.equals(clazz, bean.clazz);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, clazz);
    }
}
