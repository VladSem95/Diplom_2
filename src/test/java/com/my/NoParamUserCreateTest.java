package com.my;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NoParamUserCreateTest {
    private UserClient userClient;
    private String clientBearerToken;
    private User user;
    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserGenerator.getRandom();
    }
    @After
    public void cleanUp() {
        try {
            clientBearerToken = clientBearerToken.replace("Bearer ","");
            userClient.delete(clientBearerToken);
        }
        catch(NullPointerException Exception){
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void userCanBeCreate() {
        ValidatableResponse createResponse = userClient.create(user);
        clientBearerToken = createResponse.extract().path("accessToken");
        int statusCodeCreateUser = createResponse.extract().statusCode();
        boolean successCreate = createResponse.extract().path("success");
        assertTrue(successCreate);
        assertEquals(StatusCodeAndTextError.getSuccessCreateUserStatusCode(),statusCodeCreateUser);
    }

    @Test
    @DisplayName("Регистрация дубликата")
    public void userDuplicateCreate() {
        userClient.create(user);
        ValidatableResponse createResponse = userClient.create(user);
        int statusCodeDuplicateCreateUser = createResponse.extract().statusCode();
        String textMessage = createResponse.extract().path("message");
        assertEquals(StatusCodeAndTextError.getDuplicateCreateUserStatusCode(),statusCodeDuplicateCreateUser);
        assertEquals(StatusCodeAndTextError.getDuplicateCreateUserTextMessage(),textMessage);
    }
}
