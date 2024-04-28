import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class PageLoadingTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void solutionPageLoadingTest() {
        open("https://github.com");
        $(withTagAndText("button","Solutions")).hover();
        $("[href='https://github.com/enterprise']").click();
        $(".enterprise-hero").shouldHave(text("GitHub Galaxy: A global enterprise event tour"));

    }
}
