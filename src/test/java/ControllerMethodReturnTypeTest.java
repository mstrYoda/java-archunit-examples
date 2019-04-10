import com.test.BaseResponse;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.test.controllers")
public class ControllerMethodReturnTypeTest {

    @ArchTest
    public ArchRule controller_public_methods_should_return = methods()
            .that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
            .and().arePublic()
            .should().haveRawReturnType(BaseResponse.class)
            .because("here is the explanation");

}
