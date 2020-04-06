package de.seppel3210.sortVisualizer

import de.seppel3210.sortVisualizer.gui.BarGraph
import de.seppel3210.sortVisualizer.gui.Window
import de.seppel3210.sortVisualizer.sorts.*
import de.seppel3210.sortVisualizer.util.generateSortedArray

//swaps per second
const val SWAP_PS = 1000.0
//comparisons per second
const val COMP_PS = 1000.0

private val array = generateSortedArray(100)
val visualizer = BarGraph(array)
val shuffle: Shuffle = Reverse
val sort: Sort = GnomeSort

fun main() {
    val window = Window("Sort Visualizer")
    window.add(visualizer)

    visualizer.init()
    Thread {
        //Setup
        var lastTime = System.nanoTime()
        val amountOfTicks = 60.0
        val ns = 1_000_000_000 / amountOfTicks
        var delta = 0.0

        //Update Loop
        while (true) {
            val now = System.nanoTime()
            delta += (now - lastTime) / ns
            lastTime = now
            while (delta >= 1) {
                visualizer.render()
                delta--
            }
        }
    }.start()
    Thread.sleep(1000)
    shuffle.run(array)
    sort.run(array)
}