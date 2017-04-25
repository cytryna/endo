package com.diligentia.model;

/**
 * Created by lpochodaj on 24.04.17.
 */
public class SessionLoginRequest {
    private final String email;
    private final String password;
    private final boolean remember;

    public SessionLoginRequest(String email, String password, boolean remember) {
        this.email = email;
        this.password = password;
        this.remember = remember;
    }
}
