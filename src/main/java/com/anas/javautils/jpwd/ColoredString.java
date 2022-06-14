package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.lanterna.TextColor;

import java.nio.charset.StandardCharsets;

public class ColoredString {
    private final byte[] strBytes;
    private TextColor.RGB foregroundColor;
    public ColoredString(String str) {
        strBytes = str.getBytes(StandardCharsets.UTF_8);
        foregroundColor = null;
    }

    public void setForegroundColor(TextColor.RGB foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setForegroundColor(String hexColor) {

    }

    public String getNormalString() {
        return new String(strBytes, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (foregroundColor != null) {
            sb.append("\033[");
            sb.append(new String(foregroundColor.getForegroundSGRSequence(), StandardCharsets.UTF_8));
            sb.append("m");
        }
        sb.append(new String(strBytes, StandardCharsets.UTF_8));

        if (foregroundColor != null) {
            sb.append("\033[m");
        }

        return sb.toString();
    }
}
