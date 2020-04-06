package de.seppel3210.sortVisualizer.gui

import java.awt.Color
import java.awt.Graphics
import kotlin.math.ceil

class BarGraph(array: Array<Int>) : ArrayVisualizer(array) {
    override fun drawArray(g: Graphics) {
        val yScale = size.height / largestElement.toDouble()
        val xScale = size.width / array.size.toDouble()

        val xBarGap = if (array.size < 500) 1 else 0

        array.withIndex().forEach { (x, y) ->
            if(x in activeIndices)
                g.color = Color.RED
            else
                g.color = Color.WHITE
            g.fillRect(
                (x * xScale).toInt(),
                height - (y * yScale).toInt() + 1,
                (ceil(xScale) - xBarGap).toInt(),
                (y * yScale).toInt() - 1
            )

        }
    }
}