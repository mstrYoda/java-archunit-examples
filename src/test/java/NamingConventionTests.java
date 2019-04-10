import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(JUnit4.class)
public class NamingConventionTests {

    @Test
    public void controllers_should_be_suffixed() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.test.controllers");

        ArchRule myRule = classes()
                .that().resideInAPackage("..controllers..")
                .should().haveSimpleNameEndingWith("Controller");

        myRule.check(importedClasses);
    }

}