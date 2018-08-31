package com.bp.springboot20180830;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dzy on 2018/8/30
 */

public class RestAssuredTest {
  @Before
  public void setup(){
    RestAssured.baseURI = "https://api.douban.com/v2/book";
//    RestAssured.config.getSSLConfig().relaxedHTTPSValidation();
  }

  @Test
  public void testGetBook(){
    Response res = get("/1220562");
    res.then().body("title", equalTo("满月之夜白鲸现"))
    .body("rating.max",equalTo(10))
    .body("tags.size()",is(8))
    .body("tags[0].name",equalTo("片山恭一"))
    .body("author",hasItems("[日] 片山恭一"));
    System.out.println(res.asString());
  }
}
