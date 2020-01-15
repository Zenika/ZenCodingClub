package com.zenika.codingclub;

import java.util.List;

public class GpsMap {
    private final List<Path> paths;

    public GpsMap(final Path... paths) {
        this.paths = List.of(paths);
    }

    public List<Path> paths() {
        return paths;
    }
}
