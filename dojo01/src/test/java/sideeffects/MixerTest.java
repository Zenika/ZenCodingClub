package sideeffects;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MixerTest {

    @Test
    public void mixinTwoPaints() {
        Paint paint = new Paint(1, 0, 0, 10);
        Paint otherPaint = new Paint(0, 0, 1, 10);
        // Quel est le probleme avec ca ? Comment refactorer ?
        new Mixer().mixin(paint, otherPaint);

        assertThat(otherPaint.getVolume()).isEqualTo(20);
    }

}