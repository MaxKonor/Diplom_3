package praktikum.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AppConfig {
    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";
    public static final String URL_MAIN = "https://stellarburgers.nomoreparties.site/";
    public static final String URL_REGISTER = "https://stellarburgers.nomoreparties.site/register";
    public static final String AUTHORISATION_PATH = "api/auth/";

    public RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL_MAIN)
                .setContentType(ContentType.JSON)
                .build();
    }
}
