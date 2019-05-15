package com.zenikata.coding.rover;

public enum CardinalDirection {
    NORTH("N"),
    WEST("W"),
    EAST("E"),
    SOUTH("S");

    private final String symbol;

    CardinalDirection(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public CardinalDirection atRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("ZIZ IZ IMPOZIBLE");
        }
    }

    public CardinalDirection atLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("ZIZ IZ IMPOZIBLE");
        }
    }
}
