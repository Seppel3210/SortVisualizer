package de.seppel3210.sortVisualizer

import de.seppel3210.sortVisualizer.gui.ArrayVisualizer
import de.seppel3210.sortVisualizer.gui.Window
import de.seppel3210.sortVisualizer.util.generateRandomArray

fun main() {
    val window = Window("Sort Visualizer")
    val visualizer = ArrayVisualizer(generateRandomArray(1000, 100))
    window.add(visualizer)

    visualizer.init()
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
}