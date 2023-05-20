package com.my;
import org.apache.commons.lang3.RandomStringUtils;
import com.github.javafaker.Faker;
public class UserGenerator {
    public static User getRandom(){
        Faker faker = new Faker();
        final String email = (faker.name().firstName() + "@yandex.ru");
        final String password = faker.toString();
        final String name = faker.name().firstName();
        return new User(email, password, name);
    }
    public static User getRandomWithoutEmail() {
        Faker faker = new Faker();
        final String password = faker.toString();
        final String name = faker.name().firstName();
        return new User("", password, name);
    }
    public static User getRandomWithoutPassword() {
        Faker faker = new Faker();
        final String email = (faker.name().firstName() + "@yandex.ru");
        final String name = faker.name().firstName();
        return new User(email, "", name);
    }
    public static User getRandomWithoutName() {
        Faker faker = new Faker();
        final String email = (faker.name().firstName() + "@yandex.ru");
        final String password = faker.toString();
        return new User(email, password, "");
    }
}
