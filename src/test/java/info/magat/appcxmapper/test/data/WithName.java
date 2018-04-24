package info.magat.appcxmapper.test.data;

public abstract class WithName {

    private final String name;

    protected WithName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
