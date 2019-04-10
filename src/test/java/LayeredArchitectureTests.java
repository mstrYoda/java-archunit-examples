import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(JUnit4.class)
public class LayeredArchitectureTests {

    @Test
    public void layer_dependencies_are_respected() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("..com.test..");

        ArchRule myRule = layeredArchitecture()
                .layer("Controllers").definedBy("..com.test.controllers..")
                .layer("Services").definedBy("..com.test.services..")
                .layer("Infrastructure").definedBy("..com.test.infrastructure..")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
                .whereLayer("Infrastructure").mayOnlyBeAccessedByLayers("Services");

        myRule.check(importedClasses);
    }
}
