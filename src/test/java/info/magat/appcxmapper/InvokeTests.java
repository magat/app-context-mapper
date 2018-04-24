package info.magat.appcxmapper;

import info.magat.appcxmapper.test.data.ExternalDependency;
import info.magat.appcxmapper.test.data.Repo;
import info.magat.appcxmapper.test.data.Service;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is a playground to learn java.lang.invoke usage
 */
public class InvokeTests {

    @Test
    public void testLookupPrivateField() throws NoSuchFieldException, IllegalAccessException {
        Service target = buildService();
        MethodHandles.Lookup classSpecificLookup = getClassSpecificLookup(target);

        VarHandle varHandle = classSpecificLookup.findVarHandle(target.getClass(), "dependency", ExternalDependency.class);

        ExternalDependency result = (ExternalDependency) varHandle.get(target);
        assertEquals(result.getName(), "fakeDep1");
    }

    @Test
    public void testLookupAllClassFields() throws IllegalAccessException, NoSuchFieldException {
        Service target = buildService();

        MethodHandles.Lookup classSpecificLookup = getClassSpecificLookup(target);

        Set<String> result = new HashSet<>();

        for (var f : target.getClass().getDeclaredFields()) {
            var varHandle = classSpecificLookup.findVarHandle(target.getClass(), f.getName(), f.getType());
            result.add(((ExternalDependency) varHandle.get(target)).getName());
        }

        assertTrue(result.contains("fakeDep1"));
        assertTrue(result.contains("fakeDep2"));
    }

    /**
     * A class specific lookup is needed for private field access
     */
    private MethodHandles.Lookup getClassSpecificLookup(Service target) throws IllegalAccessException {
        var lookup = MethodHandles.lookup();
        return MethodHandles.privateLookupIn(target.getClass(), lookup);
    }

    private Service buildService() {
        return new Service(new Repo("fakeRepo"), new ExternalDependency("fakeDep1"), new ExternalDependency("fakeDep2"));
    }
}
