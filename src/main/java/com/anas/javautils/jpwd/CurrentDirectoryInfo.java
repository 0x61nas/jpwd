package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.args.ArgumentProcessor;
import com.anas.javautils.jpwd.args.CLIOption;
import com.anas.javautils.jpwd.lanterna.TextColor;

import java.io.File;

public class CurrentDirectoryInfo {
    private final ColoredString separator;
    private ColoredString[] dirs;

    public CurrentDirectoryInfo() {
        separator = new ColoredString(File.separator);
        setupDirs();
        if (!ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS))
            setupColors();
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

    private TextColor.RGB generateRandomColor() {
        return new TextColor.RGB((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    private void setupDirs() {
        final var parentDirs = new File("").getAbsolutePath().split(separator.getNormalString());
        dirs = new ColoredString[parentDirs.length];
        for (int i = 0; i < parentDirs.length; i++) {
            dirs[i] = new ColoredString(parentDirs[i]);
        }
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder();
        for (final var dir : dirs) {
            sb.append(dir.toString());
            sb.append(separator.toString());
        }
        sb.delete(sb.length() - separator.toString().length(), sb.length()); // Remove last separator
        return sb.toString();
    }
}
