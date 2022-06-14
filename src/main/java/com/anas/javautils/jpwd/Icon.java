package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.lanterna.TextColor;

import java.io.File;
import java.nio.charset.StandardCharsets;

public enum Icon {
    GIT_DIR('\uE5FB', new TextColor.RGB(229, 77, 58), ".git"),   // git dir
    CONFIG_DIR('\ue5fc', new TextColor.RGB(32, 173, 194), ".config"),   // config dir
    CONTROLLER_DIR('\ue5fc', new TextColor.RGB(255, 194, 61), "controllers"),   // controller dir
    GITHUB_DIR('\ue5fd', new TextColor.RGB(84, 110, 122), ".github"),   // github dir
    NPM_DIR('\ue5fa', new TextColor.RGB(203, 56, 55), ".npm"),   // npm dir
    INCLUDE_DIR('\uf756', new TextColor.RGB(3, 155, 229), "include"),   // include dir
    IMPORT_DIR('\uf756', new TextColor.RGB(175, 180, 43), "import"),   // import dir
    UPLOAD_DIR('\uf758', new TextColor.RGB(250, 111, 66), "upload"),   // upload dir
    DOWNLOAD_DIR('\uf74c', new TextColor.RGB(76, 175, 80), "Downloads"),   // download dir
    SECURE_DIR('\uf74f', new TextColor.RGB(249, 169, 60), "secure"),   // secure dir
    IMAGES_DIR('\uf74e', new TextColor.RGB(43, 150, 137), "Pictures"),   // images dir
    ENVIRONMENT_DIR('\uf74e', new TextColor.RGB(102, 187, 106), "environment"),   // environment dir
    IDEA_DIR('\uE7B5', new TextColor.RGB(224, 177, 77), ".idea"),   // idea dir

    // Default icons
    DIR_OPEN('\ufc6e', new TextColor.RGB(224, 177, 77), ""),   // dir open
    HIDDEN_DIR('\uf755', new TextColor.RGB(224, 177, 77), ""),   // hidden dir
    ;
    private final char icon;
    private final TextColor color;
    private final String pattern;

    Icon(final char icon, final TextColor.RGB color, final String pattern) {
        this.icon = icon;
        this.color = color;
        this.pattern = pattern;
    }


    public static Icon getCorrectIcon(final File dir) {
        for (Icon icon : values())
            if (icon.matches(dir.getName()))
                return icon;

        Icon icon = DIR_OPEN;
        if (dir.isHidden())
            icon = HIDDEN_DIR;

        return icon;
    }


    private boolean matches(final String fileName) {
        for (String pat : pattern.split("\\|"))
            if (fileName.equalsIgnoreCase(pat))
                return true;
        return false;
    }


    @Override
    public String toString() {
        return "\033[" +
                new String(color.getForegroundSGRSequence(), StandardCharsets.UTF_8) + "m" +
                icon + "\033[0m";
    }


    public String getNoColoredIcon() {
        return icon + "";
    }
}
