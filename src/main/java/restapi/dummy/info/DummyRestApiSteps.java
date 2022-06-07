package restapi.dummy.info;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import restapi.dummy.constants.EndPoint;
import restapi.dummy.model.Pojo;

import java.util.HashMap;

public class DummyRestApiSteps {
    @Step("Creating Employee with status : {0}, name: {1}")
    public ValidatableResponse createUser(String status,String name,String salary,String age,int id
                                         ) {
       Pojo pojo = new Pojo();
       pojo.setStatus(status);
       pojo.setName(name);
       pojo.setSalary(salary);
       pojo.setAge(age);
       pojo.setId(id);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(pojo)
                .when()
                .post(EndPoint.CREATE_NEW_EMPLOYEE)
                .then();
    }
    @Step("Getting Single Employee Id: 21" )
    public ValidatableResponse gettingSingleEmployee(int id){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",21)
                .when()
                .get(EndPoint.GET_SINGLE_EMPLOYEE_BY_ID)
                .then();

    }
    @Step("Updating Employee Id: 21")
    public ValidatableResponse updatingEmployeeId(int id){
                return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",21)
                .when()
                .put(EndPoint.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("Deleting Employee id: 21")
    public ValidatableResponse deletingEmployeeId(int id){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",21)
                .when()
                .delete(EndPoint.DELETE_EMPLOYEE_BY_ID)
                .then();
    }
}
