package org.poten.ftclibcontinued.kotlin.extensions.geometry

import org.poten.ftclibcontinued.geometry.Rotation2d
import org.poten.ftclibcontinued.geometry.Translation2d

/**
 * @author Jaran Chao
 *
 * Add quality of life update to be able to call rotateBy in infix notation
 */
infix fun Translation2d.rotateBy(other: Rotation2d): Translation2d =
        this.rotateBy(other)
