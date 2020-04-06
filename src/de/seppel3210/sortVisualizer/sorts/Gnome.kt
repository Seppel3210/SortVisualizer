package de.seppel3210.sortVisualizer.sorts

import de.seppel3210.sortVisualizer.COMP_PS
import de.seppel3210.sortVisualizer.SWAP_PS

fun gnomeSort(array: Array<Int>) {
    var pos = 0
    while (pos < array.size) {
        if (pos == 0 || compare(array, pos, pos - 1) >= 0)
            pos += 1
        else {
            swap(array, pos, pos - 1)
            pos -= 1
        }
    }
}

fun compare(array: Array<Int>, indexA: Int, indexB: Int): Int {
    nanoDelay(1_000_000_000 / COMP_PS)
    return array[indexA].compareTo(array[indexB])
}

fun swap(array: Array<Int>, indexA: Int, indexB: Int) {
    val temp = array[indexA]
    array[indexA] = array[indexB]
    array[indexB] = temp

    nanoDelay(1_000_000_000 / SWAP_PS)
}

fun nanoDelay(delay: Double) {
    val start: Long = System.nanoTime()
    while (true) {
        if (start + delay < System.nanoTime())
            break
    }
}