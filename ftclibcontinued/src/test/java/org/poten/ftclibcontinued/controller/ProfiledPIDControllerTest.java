package org.poten.ftclibcontinued.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.poten.ftclibcontinued.controller.wpilibcontroller.ProfiledPIDController;
import org.poten.ftclibcontinued.trajectory.TrapezoidProfile;

public class ProfiledPIDControllerTest {
    @Test
    public void testStartFromNonZeroPosition() {
        ProfiledPIDController controller = new ProfiledPIDController(1.0, 0.0, 0.0,
                new TrapezoidProfile.Constraints(1.0, 1.0));

        controller.reset(20);

        assertEquals(0, controller.calculate(20, 20), 0.05);
    }
}