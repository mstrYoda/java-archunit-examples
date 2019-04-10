import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(JUnit4.class)
public class ControllerOutsideAccessTest {

    @Test
    public void controllers_should_not_accessed_by_any_other_classes() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.test");

        ArchRule rule = classes()
                .that().resideInAPackage("..controllers..")
                .should().onlyBeAccessed().byClassesThat().resideInAPackage("..controllers..");

        rule.check(importedClasses);
    }
}
