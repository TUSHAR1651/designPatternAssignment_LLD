package com.example.render;

import java.util.Objects;

public final class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font);
        this.size = size;
        this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextStyle)) return false;
        TextStyle ts = (TextStyle) o;
        return size == ts.size && bold == ts.bold && font.equals(ts.font);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, size, bold);
    }
}
