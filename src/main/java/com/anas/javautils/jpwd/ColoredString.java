package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.lanterna.TextColor;

import java.nio.charset.StandardCharsets;

public class ColoredString {
    private final byte[] strBytes;
    private TextColor textColor;
    public ColoredString(String str) {
        strBytes = str.getBytes(StandardCharsets.UTF_8);
        textColor = null;
    }

    public void setForegroundColor(TextColor textColor) {
        this.textColor = textColor;
    }

    public void setForegroundColor(String color) {
        this.setForegroundColor(TextColor.Factory.fromString(color));
    }

    public String getNormalString() {
        return new String(strBytes, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (textColor != null) {
            sb.append("\033[");
            sb.append(new String(textColor.getForegroundSGRSequence(), StandardCharsets.UTF_8));
            sb.append("m");
        }
        sb.append(new String(strBytes, StandardCharsets.UTF_8));

        if (textColor != null) {
            sb.append("\033[m");
        }

        return sb.toString();
    }
}
