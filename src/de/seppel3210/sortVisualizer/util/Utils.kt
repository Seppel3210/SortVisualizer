package de.seppel3210.sortVisualizer.util

import java.util.*

fun generateRandomArray(size: Int, bound: Int): Array<Int> {
    val rnd = Random()
    return Array(size) {
        rnd.nextInt(bound) + 1
    }
}

fun generateSortedArray(size: Int) = Array(size) { it }