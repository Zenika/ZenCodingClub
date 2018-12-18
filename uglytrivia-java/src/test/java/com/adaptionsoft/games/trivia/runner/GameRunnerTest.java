package com.adaptionsoft.games.trivia.runner;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void shouldGenerateTheGoldenMaster() {
        final Random rand = new Random(1234);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        GameRunner.run(rand);

        try {
            final FileOutputStream goldenMaster = new FileOutputStream("src/test/resources/data/golden_master.txt");
            goldenMaster.write(out.toByteArray());
            goldenMaster.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}