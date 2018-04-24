package info.magat.appcxmapper.test.data;

public abstract class AbstractService {

    private final Repo repo;

    protected AbstractService(Repo repo) {
        this.repo = repo;
    }
}
