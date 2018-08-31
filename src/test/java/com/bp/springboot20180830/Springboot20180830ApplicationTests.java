package com.bp.springboot20180830;

import com.bp.springboot20180830.entity.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Springboot20180830Application.class},
	webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class Springboot20180830ApplicationTests {

	private static final String API_ROOT = "http://localhost:8089/api/books";

	private Book createRandomBook(){
		Book book = new Book();
		book.setTitle(randomAlphabetic(10)	);
		book.setAuthor(randomAlphabetic(15));
		return book;
	}

	private String createBookAsUri(Book book){
		Response response = RestAssured.given()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(book)
			.post(API_ROOT);
		return API_ROOT+"/"+response.jsonPath().get("id");
	}

	@Test
	public void whenGetAllBooks_thenOK(){
		Response response = RestAssured.get(API_ROOT);
		assertEquals(HttpStatus.OK.value(),response.getStatusCode());
	}

	@Test
	public void whenGetBookByTitle_thenOK(){
		Book book = createRandomBook();
		String sUri = createBookAsUri(book);
		Response response = RestAssured.get(API_ROOT+"/title/"+book.getTitle());
		assertEquals(HttpStatus.OK.value(),response.getStatusCode());
		assertTrue(response.as(List.class).size()>0);
	}

	@Test
	public void whenGetCreatedBookById_thenOK(){
		Book book = createRandomBook();
		String sUri = createBookAsUri(book);
		Response response = RestAssured.get(sUri);
		assertEquals(HttpStatus.OK.value(),response.getStatusCode());
		assertEquals(book.getTitle(),response.jsonPath().getString("title"));
	}


}
