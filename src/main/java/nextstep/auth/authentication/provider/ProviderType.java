package nextstep.auth.authentication.provider;

public enum ProviderType {

    USER_PASSWORD,
    JWT_TOKEN;

    public boolean isUserPasswordType() {
        return this == USER_PASSWORD;
    }

    public boolean isJwtTokenType() {
        return this == JWT_TOKEN;
    }
}
