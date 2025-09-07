package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextStyleFactory {
    private static final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    public static TextStyle get(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "N");
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
