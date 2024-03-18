package com.example.pesto.commons.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpUtils {

    public static boolean is2xx(final int statusCode) {

        return statusCode >= 200 && statusCode < 300;

    }

}
