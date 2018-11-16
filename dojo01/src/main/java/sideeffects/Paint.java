package sideeffects;

public class Paint {

    private double volume;
    private int red;
    private int green;
    private int yellow;
    private int blue;

    public Paint(int red , int green, int blue, int volume) {

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.volume = volume;
    }


    public double getVolume() {
        return volume;
    }

    public int getRed() {
        return red;
    }

    public int getYellow() {
        return yellow;
    }

    public int getBlue() {
        return blue;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
