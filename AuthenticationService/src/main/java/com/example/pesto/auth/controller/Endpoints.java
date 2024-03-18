package com.example.pesto.auth.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Auth {

        public static final String BASE_URL = "/api/auth/";

        public static final String AUTHENTICATE = "/authenticate";

    }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class User {

        public static final String BASE_URL = "/api/user/v1";

        public static final String CREATE = "/create";
    }
}
