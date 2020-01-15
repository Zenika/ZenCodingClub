package com.zenika.codingclub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gps {
    private GpsMap gpsMap;

    public Gps(GpsMap gpsMap) {
        this.gpsMap = gpsMap;
    }

    public Route findShortestRoute(Point start, Point end) {
        List<Route> routeCandidates = findRoutes(start, end);
        return routeCandidates.stream()
                .min(Comparator.comparing(Route::legCount))
                .orElse(null);
    }

    private List<Route> findRoutes(Point start, Point end) {
        List<Route> candidates = new ArrayList<>();
        for (Path path : gpsMap.paths()) {
            if (path.startsWith(start)) {
                if (path.endsWith(end)) {
                    candidates.add(new Route(start, end));
                }
                Route route = findShortestRoute(path.getEnd(), end);
                if (route != null) {
                    candidates.add(route.startingWith(path.getStart()));
                }
            }
        }
        return candidates;
    }
}
