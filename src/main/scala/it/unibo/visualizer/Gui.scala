package it.unibo.visualizer

import java.awt.Dimension
import javax.swing.{JFrame, SwingUtilities, WindowConstants}

class Gui(w: Int, h: Int) extends JFrame:
  self =>

  private val canvas: Canvas = Canvas(w, h)
  canvas.setPreferredSize(Dimension(w, h))
  canvas.setVisible(true)

  self.setSize(w, h)
  self.setLocationRelativeTo(null)
  self.setResizable(false)
  self.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  self.add(canvas)

  self.setVisible(true)

  def updateRender(agents: List[(Double, Double)]): Unit =
    SwingUtilities.invokeLater{
      () =>
        canvas.setAgents(agents)
        canvas.invalidate()
        canvas.repaint()
    }

