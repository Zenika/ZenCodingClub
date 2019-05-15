package com.zenikata.coding.rover;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class MarsRoverTest {

    Grid grid = new Grid(Collections.emptyList());

    @Test
    void rover_initial_position_is_at_the_grid_origin_and_facing_north() {
        MarsRover rover = new MarsRover(grid);

        assertThat(rover.position()).isEqualTo("0:0:N");
    }

    @Test
    void move_command_moves_the_rover_one_square_forward() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("M");

        assertThat(rover.position()).isEqualTo("0:1:N");
    }

    @Test
    void right_command_rotates_the_rover_right() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("R");

        assertThat(rover.position()).isEqualTo("0:0:E");

        rover.execute("R");

        assertThat(rover.position()).isEqualTo("0:0:S");

        rover.execute("R");

        assertThat(rover.position()).isEqualTo("0:0:W");

        rover.execute("R");

        assertThat(rover.position()).isEqualTo("0:0:N");
    }

    @Test
    void left_command_rotates_the_rover_left() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("L");

        assertThat(rover.position()).isEqualTo("0:0:W");

        rover.execute("L");

        assertThat(rover.position()).isEqualTo("0:0:S");

        rover.execute("L");

        assertThat(rover.position()).isEqualTo("0:0:E");

        rover.execute("L");

        assertThat(rover.position()).isEqualTo("0:0:N");
    }

    @Test
    void commands_are_executed_sequentially() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("MM");

        assertThat(rover.position()).isEqualTo("0:2:N");
    }

    @Test
    void each_move_command_moves_the_rover_in_the_compass_direction() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("MMRMMLM");

        assertThat(rover.position()).isEqualTo("2:3:N");
    }

    @Test
    void rover_wraps_around_when_reaching_the_grid_top_end() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("MMMMMMMMMM");

        assertThat(rover.position()).isEqualTo("0:0:N");
    }

    @Test
    void rover_wraps_around_when_reaching_the_grid_left_end() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("LMMMMMMMMMM");

        assertThat(rover.position()).isEqualTo("0:0:W");
    }

    @Test
    void rover_wraps_around_when_reaching_the_grid_right_end() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("RMMMMMMMMMM");

        assertThat(rover.position()).isEqualTo("0:0:E");
    }

    @Test
    void rover_wraps_around_when_reaching_the_grid_bottom_end() {
        MarsRover rover = new MarsRover(grid);

        rover.execute("RRMMMMMMMMMM");

        assertThat(rover.position()).isEqualTo("0:0:S");
    }

    @Test
    void rover_moves_up_to_the_last_possible_position_and_reports_the_obstacle() {
        Grid grid = new Grid(Collections.singletonList(new Coordinates(0, 3)));
        MarsRover rover = new MarsRover(grid);

        rover.execute("MMMMRM");

        assertThat(rover.position()).isEqualTo("O:0:2:N");
    }

}
