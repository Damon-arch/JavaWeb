package com.sks.util;

public class PathUtil {
    private static final String PATH_PREFIX = "WEB-INF/jsp/";
    private static final String PATH_SUFFIX = ".jsp";

    public static String getPath(String pageName) {
        return PATH_PREFIX + pageName + PATH_SUFFIX;
    }
}
