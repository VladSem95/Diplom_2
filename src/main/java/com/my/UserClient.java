package com.my;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class UserClient extends RestClient{
    private static final String CREATE_USER_PATH = "api/auth/register";
    private static final String LOGIN_USER_PATH = "api/auth/login";
    private static final String DELETE_USER_PATH = "api/auth/user";
    private static final String CHANGE_USER_PATH = "api/auth/user";


    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then()
                .assertThat();
    }
    public ValidatableResponse login(UserCredentials credential, String bearerToken) {
        return given()
                .spec(getBaseSpec())
                .auth().oauth2(bearerToken)
                .body(credential)
                .when()
                .post(LOGIN_USER_PATH)
                .then()
                .assertThat();
    }
    public ValidatableResponse delete(String bearerToken) {
        return given()
                .spec(getBaseSpec())
                .auth().oauth2(bearerToken)
                .when()
                .delete(DELETE_USER_PATH)
                .then()
                .assertThat();
    }
    public ValidatableResponse change(UserCredentials userCredentials,String bearerToken){
        return given()
                .spec(getBaseSpec())
                .auth().oauth2(bearerToken)
                .body(userCredentials)
                .when()
                .patch(CHANGE_USER_PATH)
                .then()
                .assertThat();
    }
}
