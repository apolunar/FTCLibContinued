package org.poten.ftclibcontinued.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.poten.ftclibcontinued.geometry.Vector2d;

public class Vector2dTest {

    Vector2d vec = new Vector2d(1, 0);

    @Test
    public void testRotateBy() {
        assertEquals(Math.PI / 2, vec.rotateBy(Math.toDegrees(Math.PI / 2)).angle());
    }

}
