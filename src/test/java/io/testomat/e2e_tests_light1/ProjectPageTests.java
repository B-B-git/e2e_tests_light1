package io.testomat.e2e_tests_light1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.testomat.e2e_tests_light_1.utils.StringParsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light_1.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest{

     static String baseUrl = env.get("BASE_URL");
     static String username = env.get("USERNAME_");
     static String password = env.get("PASSWORD");
     String targetProjectName = "Manufacture light";

    @Test
    public void userCanFindProject () {

        open(baseUrl);

        loginUser(username, password);

        searchProgect(targetProjectName);

        conditionSize1();

        shouldHaveText1();

        redexpAssertTrueInteger();

        redexpAssertEqualslInteger();

        selectForProject(targetProjectName);

        waitForProjectIsLoaded(targetProjectName);
    }

    private static void waitForProjectIsLoaded(String targetProjectName) {
        $("h2").shouldHave(text(targetProjectName));
        $(".first [href*=\"/readme\"]").shouldHave(text("Readme"));
    }

    private static void selectForProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
        Selenide.sleep(10000);
    }

    private static void searchProgect(String targetProjectName) {
        $("#search").setValue(targetProjectName);
    }

    public static void loginUser(String username, String password) {
        $("#content-desktop #user_email").setValue(username);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }

    private void shouldHaveText1() {
        $(String.format("[title='%s'] p", targetProjectName)).shouldHave(text("0 test"));
    }

    private static void conditionSize1() {
        $$("#grid ul li").filter(visible).shouldHave(CollectionCondition.size(1));
    }

    private void redexpAssertTrueInteger() {
        String countOfTests = $(String.format("[title='%s'] p", targetProjectName)).getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertTrue(actualCountOfTests<1);
    }

    private void redexpAssertEqualslInteger() {
        String countOfTests = $(String.format("[title='%s'] p", targetProjectName)).getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(0, actualCountOfTests);
    }

    public void exampleAssertDouble () {
        var text = "15.4 coverage";
        double actualDouble = StringParsers.parseDoubleFromString(text);
        Assertions.assertEquals(15.4, actualDouble);
    }

    public void exampleParselBoolean () {
        var text = "true";
        Boolean actual = Boolean.parseBoolean(text);
        Assertions.assertEquals(true, actual);
    }

}
