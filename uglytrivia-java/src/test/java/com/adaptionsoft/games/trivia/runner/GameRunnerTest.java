package com.adaptionsoft.games.trivia.runner;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRunnerTest {

    private String GOLDEN_MASTER_NAME = "src/test/resources/data/golden_master.txt";

    @Test
    public void shouldEqualTheGoldenMaster() throws IOException {
        final Random rand = new Random(1234);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        GameRunner.run(rand);

        Path path = Paths.get(GOLDEN_MASTER_NAME);
        final String goldenMaster = new String(Files.readAllBytes(path));

        assertThat(out.toString()).isEqualTo(goldenMaster);

    }

    @Test
    @Ignore
    public void shouldGenerateTheGoldenMaster() {
        final Random rand = new Random(1234);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        GameRunner.run(rand);

        try {
            final FileOutputStream goldenMaster = new FileOutputStream(GOLDEN_MASTER_NAME);
            goldenMaster.write(out.toByteArray());
            goldenMaster.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}