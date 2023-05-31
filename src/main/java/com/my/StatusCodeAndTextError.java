package com.my;

public class StatusCodeAndTextError {
    private static int SUCCESS_CREATE_USER_STATUS_CODE = 200;
    private static int DUPLICATE_CREATE_USER_STATUS_CODE = 403;
    private static String DUPLICATE_CREATE_USER_TEXT_MESSAGE = "User already exists";
    private static int REGISTRATED_WITHOUT_REQUIRED_FIELD_STATUS_CODE = 403;
    private static String REGISTRATED_WITHOUT_REQUIRED_FIELD_TEXT_MESSAGE = "Email, password and name are required fields";
    private static int EMAIL_OR_PASSWORD_ARE_INCORRECT_STATUS_CODE = 401;
    private static String EMAIL_OR_PASSWORD_ARE_INCORRECT_TEXT_MESSAGE = "email or password are incorrect";
    private static int SUCCESS_LOGIN_STATUS_CODE = 200;
    private static int SUCCESS_CHANGE_USER_STATUS_CODE = 200;
    private static int UNSUCCESSFUL_CHANGE_WITHOUT_AUTHORIZATION_STATUS_CODE=401;
    private static String UNSUCCESSFUL_CHANGE_WITHOUT_AUTHORIZATION_TEXT_MESSAGE="You should be authorised";
    private static int SUCCESS_CREATE_ORDER_STATUS_CODE = 200;
    private static int CREATE_ORDER_WITHOUT_INGREDIENT_STATUS_CODE = 400;
    private static String CREATE_ORDER_WITHOUT_INGREDIENT_TEXT_MESSAGE = "Ingredient ids must be provided";
    private static int CREATE_ORDER_WITH_INCORRECT_HASH_STATUS_CODE = 400;
    private static String CREATE_ORDER_WITH_INCORRECT_HASH_TEXT_MESSAGE = "One or more ids provided are incorrect";
    private static int USER_ORDER_WITH_AUTHORIZATION_STATUS_CODE = 200;
    private static int USER_ORDER_WITHOUT_AUTHORIZATION_STATUS_CODE = 401;
    private static String USER_ORDER_WITHOUT_AUTHORIZATION_TEXT_MESSAGE = "You should be authorised";
    public static int getUserOrderWithAuthorizationStatusCode(){
        return USER_ORDER_WITH_AUTHORIZATION_STATUS_CODE;
    }
    public static int getUserOrderWithoutAuthorizationStatusCode(){
        return USER_ORDER_WITHOUT_AUTHORIZATION_STATUS_CODE;
    }
    public static String getUserOrderWithoutAuthorizationTextMessage(){
        return USER_ORDER_WITHOUT_AUTHORIZATION_TEXT_MESSAGE;
    }
    public static int getCreateOrderWithoutIngredientStatusCode(){
        return CREATE_ORDER_WITHOUT_INGREDIENT_STATUS_CODE;
    }
    public static String getCreateOrderWithoutIngredientTextMessage(){
        return CREATE_ORDER_WITHOUT_INGREDIENT_TEXT_MESSAGE;
    }
    public static int getCreateOrderWithIncorrectHashStatusCode(){
        return CREATE_ORDER_WITH_INCORRECT_HASH_STATUS_CODE;
    }
    public static String getCreateOrderWithIncorrectHashTextMessage(){
        return CREATE_ORDER_WITH_INCORRECT_HASH_TEXT_MESSAGE;
    }
    public static int getSuccessCreateOrderStatusCode() {
        return SUCCESS_CREATE_ORDER_STATUS_CODE;
    }

    public static int getUnsuccessfulChangeWithoutAuthorizationStatusCode(){
        return UNSUCCESSFUL_CHANGE_WITHOUT_AUTHORIZATION_STATUS_CODE;
    }
    public static String getUnsuccessfulChangeWithoutAuthorizationTextMessage(){
        return UNSUCCESSFUL_CHANGE_WITHOUT_AUTHORIZATION_TEXT_MESSAGE;
    }
    public static int getSuccessChangeUserStatusCode(){
        return SUCCESS_CHANGE_USER_STATUS_CODE;
    }

    public static int getEmailOrPasswordAreIncorrectStatusCode(){
        return EMAIL_OR_PASSWORD_ARE_INCORRECT_STATUS_CODE;
    }
    public static String getEmailOrPasswordAreIncorrectTextMessage(){
        return EMAIL_OR_PASSWORD_ARE_INCORRECT_TEXT_MESSAGE;
    }
    public static int getSuccessLoginStatusCode(){
        return SUCCESS_LOGIN_STATUS_CODE;
    }
    public static int getSuccessCreateUserStatusCode() {
        return SUCCESS_CREATE_USER_STATUS_CODE;
    }

    public static int getDuplicateCreateUserStatusCode() {
        return DUPLICATE_CREATE_USER_STATUS_CODE;
    }
    public static String getDuplicateCreateUserTextMessage(){
        return DUPLICATE_CREATE_USER_TEXT_MESSAGE;
    }
    public static int getRegistratedWithoutRequiredFieldStatusCode() {
        return REGISTRATED_WITHOUT_REQUIRED_FIELD_STATUS_CODE;
    }
    public static String getRegistratedWithoutRequiredFieldTextMessage(){
        return REGISTRATED_WITHOUT_REQUIRED_FIELD_TEXT_MESSAGE;
    }
}

