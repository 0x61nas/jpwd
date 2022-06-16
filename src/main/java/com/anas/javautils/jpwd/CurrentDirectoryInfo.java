package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.args.ArgumentProcessor;
import com.anas.javautils.jpwd.args.CLIOption;
import com.anas.jcolorfulconsole.ColoredString;
import com.anas.jcolorfulconsole.lanterna.TextColor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CurrentDirectoryInfo {
    private final ColoredString separator;
    private ColoredString[] dirs;
    private String[] colors;
    private ArrayList<TextColor> blockedColors;

    public CurrentDirectoryInfo() throws IOException {
        final var args = ArgumentProcessor.getInstance();
        separator = setupSeparator();
        if (args.hasOption(CLIOption.COLORS_LIST)) {
            colors = args.getOptionValue(CLIOption.COLORS_LIST).split(",");
        }
        if (args.hasOption(CLIOption.BLOCK_COLORS)) {
            blockedColors = new ArrayList<>();
            setupBlockedColors();
        }
        setupDirs();
        if (!args.hasOption(CLIOption.NO_COLORS))
            setupColors();
    }

    private void setupBlockedColors() {
        String[] blockedColorsStr = ArgumentProcessor.getInstance().getOptionValue(CLIOption.BLOCK_COLORS).split(",");
        for (String blockedColorStr : blockedColorsStr) {
            blockedColors.add(TextColor.Factory.fromString(blockedColorStr));
        }
    }

    private ColoredString setupSeparator() {
        if (ArgumentProcessor.getInstance().hasOption(CLIOption.SEPARATOR))
            return new ColoredString(ArgumentProcessor
                    .getInstance()
                    .getOptionValue(CLIOption.SEPARATOR));

        return new ColoredString(File.separator);
    }

    private void setupColors() {
        setupSeparatorColor();
        setupDirsColors();
    }

    private void setupDirsColors() {
       for (final var dir : dirs) {
           dir.setForegroundColor(generateRandomColor());
       }
    }

    private void setupSeparatorColor() {
        if (ArgumentProcessor.getInstance().hasOption(CLIOption.SEPARATOR_COLOR)) {
            separator.setForegroundColor(ArgumentProcessor.getInstance().getOptionValue(CLIOption.SEPARATOR_COLOR));
        } else {
            separator.setForegroundColor(generateRandomColor());
        }
    }

    private TextColor generateRandomColor() {
        if (colors != null) {
            final var random = (int) (Math.random() * colors.length);
            return TextColor.Factory.fromString(colors[random]);
        }
        TextColor color;
        do {
            color = new TextColor.RGB((int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255));
        } while (blockedColors != null && blockedColors.contains(color));
        return color;
    }

    private void setupDirs() throws IOException {
        final var parentDirs = Path.of(".").toRealPath().toUri().getPath().split(File.separator);
        dirs = new ColoredString[parentDirs.length == 0 ? 1 : parentDirs.length];
        int i = 0;
        if (parentDirs.length == 0 || parentDirs[0].isBlank()) { // Means is the root directory
            dirs[0] = new ColoredString("/");
            i++;
        }
        for (; i < parentDirs.length; i++) {
            dirs[i] = new ColoredString(parentDirs[i]);
        }
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder();
        final var hasCustomSeparator = ArgumentProcessor.getInstance().hasOption(CLIOption.SEPARATOR);

        if (!ArgumentProcessor.getInstance().hasOption(CLIOption.NO_ICONS)) {
            try {
                sb.append(Icon.getCorrectIcon(Path.of(".").toRealPath().toFile()))
                        .append(" ");
            } catch (IOException ignored) { }
        }

        for (final var dir : dirs) {
            sb.append(dir.toString());
            if (!dir.toNormalStringString().equals("/") || hasCustomSeparator)
                sb.append(separator.toString());
        }
        if (dirs.length > 1)
            sb.delete(sb.length() - separator.toString().length(), sb.length()); // Remove last separator
        return sb.toString();
    }
}
