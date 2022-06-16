package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.args.ArgumentProcessor;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static final String VERSION = "0.0.2";
    public static void main(final String[] args) {
        ArgumentProcessor.getInstance().process(args); // Process the arguments
        try {
            System.out.println(new CurrentDirectoryInfo());
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).severe(e.getMessage());
            System.exit(1);
        }
    }
}
