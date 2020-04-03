package de.seppel3210.sortVisualizer.gui

import java.awt.Component
import javax.swing.JFrame

class Window(name: String) : JFrame(name) {
    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        isResizable = false
        isVisible = true
    }

    override fun add(comp: Component?): Component {
        val temp = super.add(comp)
        pack()
        setLocationRelativeTo(null)
        return temp
    }
}