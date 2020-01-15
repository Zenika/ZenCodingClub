package com.zenika.codingclub;

public class Path {

    private Point start;
    private Point end;

    public Path(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean connects(Point start, Point end) {
        return this.start.equals(start) && this.end.equals(end);
    }

    public boolean startsWith(Point start) {
        return this.start.equals(start);
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

    public boolean endsWith(Point end) {
        return this.end.equals(end);
    }
}
