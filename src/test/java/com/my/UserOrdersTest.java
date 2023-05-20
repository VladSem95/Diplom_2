package com.my;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserOrdersTest {
    private UserClient userClient;
    private String clientBearerToken;
    private User user;
    OrderClient orderClient;

    private UserCredentials credentials;

    @Before
    public void setUp(){
        userClient = new UserClient();
        user = UserGenerator.getRandom();
        orderClient = new OrderClient();
    }
    @After
    public void cleanUp() {
        try {
            userClient.delete(clientBearerToken);
        }
        catch(NullPointerException Exception){
        }
    }
    @DisplayName("Успешное получение заказа по конкретному клиенту")
    @Test
    public void getUserOrdersWithAuthorization(){
        ValidatableResponse createResponse = userClient.create(user);
        clientBearerToken = createResponse.extract().path("accessToken");
        clientBearerToken = clientBearerToken.replace("Bearer ","");
        ValidatableResponse getUserOrders = orderClient.getForUser(clientBearerToken);
        int statusCodeGetUserOrders = getUserOrders.extract().statusCode();
        boolean success = getUserOrders.extract().path("success");
        assertTrue(success);
        assertEquals(StatusCodeAndTextError.getUserOrderWithAuthorizationStatusCode(),statusCodeGetUserOrders);
    }

    @Test
    @DisplayName("Получение заказа по конкретному клиенту без авторизации")
    public void getUserOrdersWithoutAuthorization() {
        clientBearerToken="";
        ValidatableResponse getUserOrders = orderClient.getForUser(clientBearerToken);
        int statusCodeGetUserOrders = getUserOrders.extract().statusCode();
        String textMessage = getUserOrders.extract().path("message");
        assertEquals(StatusCodeAndTextError.getUserOrderWithoutAuthorizationStatusCode(),statusCodeGetUserOrders);
        assertEquals(StatusCodeAndTextError.getUserOrderWithoutAuthorizationTextMessage(),textMessage);
    }
}
