
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostmanEchoTest {
    @BeforeEach
    public void configureRestAssured() {
        RequestSpecification requestSpec;
        requestSpec = given()
                .log().all()
                .baseUri("https://postman-echo.com");
        RestAssured.requestSpecification = requestSpec;
        ResponseSpecification responseSpec;
        responseSpec = expect()
                .statusCode(200);
        RestAssured.responseSpecification = responseSpec;

    }
    @Test
    public void testGet() {
        given()
                .contentType("application/json")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")

                .when().get("/get")

                .then().log().body()
                .contentType("application/json")
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.cookie", nullValue())
                .and().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }
    @Test
    public void testPostRawText() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().post("/post")

                .then().log().body()
                .contentType("application/json")
                .and().body("args", equalTo(Collections.emptyMap()))
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))
                .and().body("files", equalTo(Collections.emptyMap()))
                .and().body("form", equalTo(Collections.emptyMap()))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.cookie", nullValue())
                .and().body("json", nullValue())
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams("foo1", "bar1", "foo2", "bar2")
                .when().post("/post")

                .then().log().body()
                .and().body("args", equalTo(Collections.emptyMap()))
                .and().body("data", equalTo(""))
                .and().body("files", equalTo(Collections.emptyMap()))
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("19"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .and().body("headers.cookie", nullValue())
                .and().body("json.foo1", equalTo("bar1"))
                .and().body("json.foo2", equalTo("bar2"))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void testPut() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().put("/put")

                .then().log().body()
                .contentType("application/json")
                .and().body("args", equalTo(Collections.emptyMap()))
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))
                .and().body("files", equalTo(Collections.emptyMap()))
                .and().body("form", equalTo(Collections.emptyMap()))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.cookie", nullValue())
                .and().body("json", nullValue())
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }
    @Test
    public void testPatch() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().patch("/patch")

                .then().log().body()
                .contentType("application/json")
                .and().body("args", equalTo(Collections.emptyMap()))
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))
                .and().body("files", equalTo(Collections.emptyMap()))
                .and().body("form", equalTo(Collections.emptyMap()))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.cookie", nullValue())
                .and().body("json", nullValue())
                .and().body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    public void testDelete() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete")

                .then().log().body()
                .contentType("application/json")
                .and().body("args", equalTo(Collections.emptyMap()))
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))
                .and().body("files", equalTo(Collections.emptyMap()))
                .and().body("form", equalTo(Collections.emptyMap()))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.accept-encoding", equalTo("gzip, br"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.user-agent", notNullValue())
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("headers.postman-token", nullValue())
                .and().body("headers.cookie", nullValue())
                .and().body("json", nullValue())
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }

}
