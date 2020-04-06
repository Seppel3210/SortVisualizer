package de.seppel3210.sortVisualizer.gui

import java.awt.Canvas
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import kotlin.math.ceil

abstract class ArrayVisualizer(protected val array: Array<Int>) : Canvas() {
    protected val largestElement: Int
    var activeIndices: Array<Int> = arrayOf()

    private val backgroundColor = Color.BLACK

    init {
        preferredSize = Dimension(1000, 700)

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

        drawArray(g)

        bufferStrategy.show()
    }

    protected abstract fun drawArray(g: Graphics)
}