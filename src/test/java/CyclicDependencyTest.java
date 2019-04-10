import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.test.services")
public class CyclicDependencyTest {

    @ArchTest
    public static final ArchRule rule = slices().matching("")
            .should().notDependOnEachOther();

}
