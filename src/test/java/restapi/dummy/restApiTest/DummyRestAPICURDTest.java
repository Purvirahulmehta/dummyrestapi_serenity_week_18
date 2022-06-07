package restapi.dummy.restApiTest;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import restapi.dummy.info.DummyRestApiSteps;
import restapi.dummy.testBase.TestBase;

@RunWith(SerenityRunner.class)
public class DummyRestAPICURDTest extends TestBase {
    static String status = "success";
    static String name = "John";
    static String salary = "35000";
    static String age = "30";
    static int id = 21;

    @Steps
    DummyRestApiSteps dummyRestAPISteps;

    @Title("This will create a new employee")
    @Test
    public void test001() {
        ValidatableResponse response = dummyRestAPISteps.createUser(status, name, salary, age, id);
        response.log().all().statusCode(200);

    }

    @Title("This will getting single user by id")
    @Test
    public void test002() {
        ValidatableResponse response = dummyRestAPISteps.gettingSingleEmployee(id);
        response.log().all().statusCode(200);
    }

    @Title("This will updating user by Id")
    @Test
    public void test003() {
        ValidatableResponse response = dummyRestAPISteps.updatingEmployeeId(id);
        response.log().all().statusCode(200);
    }

    @Title("This will deleting user")
    @Test
    public void test004() {
        ValidatableResponse response = dummyRestAPISteps.deletingEmployeeId(id);
        response.log().all().statusCode(200);
    }
}


