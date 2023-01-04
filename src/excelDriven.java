import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class excelDriven {
@Test

    public void addBook(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name", "sadsa");
        map.put("isbn", "asa");
        map.put("aisle", "5656");
        map.put("author", "dsa");

        RestAssured.baseURI = "http://216.10.245.166";
        String resp = given()
                .log().all().header("Content-Type", "application/json")
                .body(map).when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).log().all()
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(resp);
        String id = js.get("ID");
        System.out.println("id = " + id);

    }
}
