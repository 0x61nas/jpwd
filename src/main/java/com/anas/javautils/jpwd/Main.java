package com.anas.javautils.jpwd;

import com.anas.javautils.jpwd.args.ArgumentProcessor;

public class Main {
    public static final String VERSION = "0.0.1";
    public static void main(final String[] args) {
        ArgumentProcessor.getInstance().process(args); // Process the arguments
       System.out.println(new CurrentDirectoryInfo());
    }
}
