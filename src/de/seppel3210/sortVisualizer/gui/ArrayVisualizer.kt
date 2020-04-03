package de.seppel3210.sortVisualizer.gui

import java.awt.Canvas
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics

class ArrayVisualizer(private val array: Array<Int>) : Canvas() {
    private val largestElement: Int

    private val backgroundColor = Color.BLACK

    init {
        preferredSize = Dimension(1000, 800)

        var largestElement = array[0]
        array.forEach {
            if (largestElement < it) {
                largestElement = it
            }
        }
        this.largestElement = largestElement
    }

    private var g: Graphics? = null
    fun init() {
        createBufferStrategy(2)
        g = bufferStrategy.drawGraphics

        preferredSize = Dimension(800, 1000)
    }

    fun render() {
        if (g == null) {
            throw IllegalStateException("ArrayVisualizer.init() has to be called before calling ArrayVisualizer.update()")
        }
        val g = g!!
        g.color = backgroundColor
        g.fillRect(0, 0, width, height)

        barGraph(g)

        bufferStrategy.show()
    }

    private fun barGraph(g: Graphics) {
        val yScale = size.height / largestElement.toDouble()
        val xScale = size.width / array.size.toDouble()
        g.color = Color.WHITE

        val xBarGap = if (array.size < 500) 1 else 0

        array.withIndex().forEach { (x, y) ->
            g.fillRect(
                (x * xScale).toInt(),
                height - (y * yScale).toInt() + 1,
                xScale.toInt() - xBarGap,
                (y * yScale).toInt() - 1
            )
        }
    }
}