package serialize;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.LoginRequest;
import pojo.LoginResponse;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest2 {
    public static void main(String[] args) {
        //RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("mustafaustuner1972@gmail.com");
        loginRequest.setUserPassword("Apexon1972");

        RestAssured.baseURI ="https://rahulshettyacademy.com";
        LoginResponse loginResponseNew = given().log().all().contentType("application/json").
                accept(ContentType.JSON).body(loginRequest)
                .when().post("/api/ecom/auth/login")
                .then().log().all().statusCode(200).extract().response().as(LoginResponse.class);


        //RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);

        System.out.println("Message = " + loginResponseNew.getMessage());
        System.out.println("Token = " + loginResponseNew.getToken());
        System.out.println("UserId = " + loginResponseNew.getUserId());
        String token = loginResponseNew.getToken();
        String userId = loginResponseNew.getUserId();

        LoginResponse loginResponseAddProduct = (LoginResponse) given().log().all().header("authorization", token)
                .param("productName","Laptop")
                .param("productAddedBy", userId)
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "11500")
                .param("productDescription", "Lenova")
                .param("productFor","men")
                .multiPart("productImage",new File("C:\\Users\\User\\OneDrive\\Desktop\\Flowers-flower.png"));

        /*
        //Add Product
        RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization", token).build();

        RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq)
                .param("productName","Laptop")
                .param("productAddedBy", userId)
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "11500")
                .param("productDescription", "Lenova")
                .param("productFor","men")
                . multiPart("productImage",new File("C:\\Users\\User\\OneDrive\\Desktop\\Flowers-flower.png"));

        String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product")
                .then().log().all().extract().response().asString();

        JsonPath js = new JsonPath(addProductResponse);
        String productId = js.get("productId");*/
    }
}
