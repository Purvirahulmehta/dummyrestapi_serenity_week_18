package restapi.dummy.testBase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import restapi.dummy.constants.Path;
import restapi.dummy.utils.PropertyReader;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath = Path.API;
    }
}
