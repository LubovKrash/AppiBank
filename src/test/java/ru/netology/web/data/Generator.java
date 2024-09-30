package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class Generator {
    private static final Faker FAKER = new Faker(new Locale("en"));
    private Generator() {
        }

    public static String addRandomLogin() {
        return FAKER.name().username();
        }

    public static String addRandomPassword() {
        return FAKER.internet().password();
        }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationApi addUser(String status) {
            return new RegistrationApi(addRandomLogin(), addRandomPassword(), status);
        }

        public static RegistrationApi getRegisteredUser(String status) {
            return ApiSend.sendRequset(addUser(status));
        }
    }

    @Value
    public static class RegistrationApi {
        String login;
        String password;
        String status;
    }


}
