package de.seppel3210.sortVisualizer.sorts

import de.seppel3210.sortVisualizer.COMP_PS
import de.seppel3210.sortVisualizer.SWAP_PS
import de.seppel3210.sortVisualizer.visualizer
import java.util.*

interface Sort {
    fun run(array: Array<Int>)
}

interface Shuffle : Sort

object GnomeSort : Sort {
    override fun run(array: Array<Int>) {
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

}

object RandomShuffle : Shuffle {
    override fun run(array: Array<Int>) {
        val rand = Random()
        array.indices.forEach {
            swap(array, it, rand.nextInt(array.size))
        }
    }
}

object Reverse : Shuffle {
    override fun run(array: Array<Int>) {
        var indexA = 0
        var indexB = array.size - 1
        while (indexA < indexB) {
            swap(array, indexA++, indexB--)
        }
    }
}

fun compare(array: Array<Int>, indexA: Int, indexB: Int): Int {
    nanoDelay(1_000_000_000 / COMP_PS)
    visualizer.activeIndices = arrayOf(indexA, indexB)
    return array[indexA].compareTo(array[indexB])
}

fun swap(array: Array<Int>, indexA: Int, indexB: Int) {
    val temp = array[indexA]
    array[indexA] = array[indexB]
    array[indexB] = temp
    visualizer.activeIndices = arrayOf(indexA, indexB)
    nanoDelay(1_000_000_000 / SWAP_PS)
}

fun nanoDelay(delay: Double) {
    val start: Long = System.nanoTime()
    while (true) {
        if (start + delay < System.nanoTime())
            break
    }
}