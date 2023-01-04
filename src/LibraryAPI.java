import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LibraryAPI {

    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle){

        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
                .body(payload.AddBook(isbn , aisle))
                .when().post("/Library/Addbook.php").then()
                .assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        //System.out.println("js = " + js.prettyPrint());
        System.out.println("Added Book ID = " + js.get("ID"));

    }
    @DataProvider(name="BooksData")
    public Object[][] getData(){
        return new Object[][] {{"awdf","12434"} , {"fdaxj","653211"} , {"ytwqre","654211"}};

    }
    @Test
    public void getBook(){

        RestAssured.baseURI = "http://216.10.245.166";
        String responseGetBook = given().log().all().queryParam("author", "Russel foeee")
                .when().get("/Library/GetBook.php")
                .then().log().all().assertThat().statusCode(200)
                .body("isbn", equalTo("abcd"))
                .extract().response().asString();
        //.body("name", equalTo("Phyton"))
        JsonPath jsGet = new JsonPath(responseGetBook);
       // jsGet.prettyPrint();
        System.out.println("js= " +jsGet);
        System.out.println("author name = " + jsGet.getString("isbn"));
    }
}