import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void dragAndDropWithActionsFirstTest() {
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        actions()
                .moveToElement($("#column-a header"))
                .clickAndHold()
                .moveByOffset(200, 0)
                .release()
                .perform();
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }

    @Test
    void dragAndDropWithActionsSecondTest() {
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        actions()
                .dragAndDropBy($("#column-a header"), 200, 0)
                .perform();
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }

    @Test
    void dragAndDropWithoutActionsTest() {
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        $("#column-a header").dragAndDrop(to("#column-b header"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}

