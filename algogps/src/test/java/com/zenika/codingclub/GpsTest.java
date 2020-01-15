package com.zenika.codingclub;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GpsTest {

    @Test
    void find_route() {
        Point pointA = new Point();
        Point pointB = new Point();
        Point pointC = new Point();
        Path path1 = new Path(pointA, pointB);
        Path path2 = new Path(pointA, pointC);
        GpsMap gpsMap = new GpsMap(path1, path2);
        Gps gps = new Gps(gpsMap);

        Route route = gps.findShortestRoute(pointA, pointC);

        assertThat(route).isEqualTo(new Route(pointA, pointC));
    }

    @Test
    void find_route_in_multiple_steps() {
        Point pointA = new Point();
        Point pointB = new Point();
        Point pointC = new Point();
        Point pointD = new Point();
        Path path1 = new Path(pointA, pointB);
        Path path2 = new Path(pointA, pointC);
        Path path3 = new Path(pointC, pointD);
        GpsMap gpsMap = new GpsMap(path1, path2, path3);
        Gps gps = new Gps(gpsMap);

        Route route = gps.findShortestRoute(pointA, pointD);

        assertThat(route).isEqualTo(new Route(pointA, pointC, pointD));
    }

    @Test
    void no_route() {
        Point pointA = new Point();
        Point pointB = new Point();
        GpsMap gpsMap = new GpsMap();
        Gps gps = new Gps(gpsMap);

        Route route = gps.findShortestRoute(pointA, pointB);

        assertThat(route).isEqualTo(null);
    }

    @Test
    void least_number_of_legs() {
        Point pointA = new Point();
        Point pointB = new Point();
        Point pointC = new Point();
        Path path1 = new Path(pointA, pointB);
        Path path2 = new Path(pointB, pointC);
        Path path3 = new Path(pointA, pointC);
        GpsMap gpsMap = new GpsMap(path1, path2, path3);
        Gps gps = new Gps(gpsMap);

        Route route = gps.findShortestRoute(pointA, pointC);

        assertThat(route).isEqualTo(new Route(pointA, pointC));
    }
}
