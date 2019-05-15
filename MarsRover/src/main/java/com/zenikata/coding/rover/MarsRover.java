package com.zenikata.coding.rover;

import java.util.Arrays;

class MarsRover {

    private Coordinates position;
    private CardinalDirection compassDirection;
    private Grid grid;
    private boolean blockedByObstacle;


    public MarsRover(Grid grid) {
        this.grid = grid;
        this.position = new Coordinates(0, 0);
        this.compassDirection = CardinalDirection.NORTH;
        this.blockedByObstacle = false;
    }

    public void execute(String commands) {

        try {
            Arrays.stream(commands.split("")).forEach(command -> {
                switch (command) {
                    case "M":
                        moveForward();
                        break;
                    case "R":
                        rotateRight();
                        break;
                    case "L":
                        rotateLeft();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid command");
                }
            });
        } catch (RoverBlockedByObstacleException e) {
            System.out.println("Blocked by obstacle.");
            this.blockedByObstacle = true;
        }
    }

    private void moveForward() throws RoverBlockedByObstacleException {
        Coordinates potentialPosition = this.grid.inDirection(this.position, this.compassDirection);
        if (grid.presentsObstacleAt(potentialPosition)) {
            throw new RoverBlockedByObstacleException();
        }
        this.position = potentialPosition;
    }

    private void rotateLeft() {
        this.compassDirection = this.compassDirection.atLeft();
    }

    private void rotateRight() {
        this.compassDirection = this.compassDirection.atRight();
    }

    public String position() {
        return (this.blockedByObstacle ? "O:" : "")
                + this.position.getX() + ":"
                + this.position.getY() + ":"
                + this.compassDirection.getSymbol();
    }

    private static class RoverBlockedByObstacleException extends RuntimeException {
    }
}
