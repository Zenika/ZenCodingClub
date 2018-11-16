package sideeffects;

public class Mixer {

    public void mixin(Paint addedPaint, Paint finalPaint) {
        double volume = finalPaint.getVolume() + addedPaint.getVolume();
        finalPaint.setVolume(volume);
        // complexe logic ...
    }
}
