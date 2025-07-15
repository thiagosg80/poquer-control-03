package com.app.poquer_control_03;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FullPathService {
    public static Path get(final String fragment) {
        final String systemDir = System.getProperty("user.dir");

        return Paths.get(systemDir.concat(File.separator).concat(fragment));
    }
}
