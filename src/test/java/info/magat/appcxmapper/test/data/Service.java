package info.magat.appcxmapper.test.data;

public class Service extends AbstractService {

    private final ExternalDependency dependency;
    private final ExternalDependency anotherDep;

    public Service(Repo repo, ExternalDependency dependency, ExternalDependency anotherDep) {
        super(repo);
        this.dependency = dependency;
        this.anotherDep = anotherDep;
    }
}
