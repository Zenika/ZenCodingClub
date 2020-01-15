package com.zenika.codingclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Route {

    private List<Point> points;

    public Route(Point... points) {
        this.points = List.of(points);
    }

    public Route startingWith(Point start) {
        List<Point> points = new ArrayList<>();
        points.add(start);
        points.addAll(this.points);
        return new Route(points.toArray(new Point[0]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;
        Route route = (Route) o;
        return Objects.equals(points, route.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Route{" +
                "points=" + points +
                '}';
    }

    public int legCount() {
        return this.points.size() - 1;
    }
}
