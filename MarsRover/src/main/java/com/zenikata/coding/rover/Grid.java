package com.zenikata.coding.rover;

import java.util.List;

public class Grid {

    public static final int GRID_SIZE = 10;
    private final List<Coordinates> obstacles;

    public Grid(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean presentsObstacleAt(Coordinates coordinates) {
        return obstacles.contains(coordinates);
    }

    public Coordinates inDirection(Coordinates origin, CardinalDirection direction) {
        switch (direction) {
            case NORTH:
                return new Coordinates(origin.getX(), (origin.getY() + 1) % GRID_SIZE);
            case EAST:
                return new Coordinates((origin.getX() + 1) % GRID_SIZE, origin.getY());
            case SOUTH:
                return new Coordinates(origin.getX(), (origin.getY() - 1) % GRID_SIZE);
            case WEST:
                return new Coordinates((origin.getX() - 1) % GRID_SIZE, origin.getY());
            default:
                throw new IllegalStateException("ZIZ IZ IMPOZIBLE");
        }
    }
}
