package it.unibo.visualizer

import java.awt.{Color, Dimension}
import javax.swing.{JFrame, SwingUtilities, WindowConstants}

class Gui(w: Int, h: Int, scale: Double) extends JFrame:
  self =>

  private val canvas: Canvas = Canvas(w, h, scale)
  canvas.setPreferredSize(Dimension(w, h))
  canvas.setVisible(true)

  self.setSize(w, h)
  self.setLocationRelativeTo(null)
  self.setResizable(false)
  self.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  self.add(canvas)

  self.setVisible(true)

  def updateRender(args: (List[(Double, Double)], Color, Int)*): Unit =
    SwingUtilities.invokeLater{
      () =>
        canvas.setAgents(args.toList)
        canvas.invalidate()
        canvas.repaint()
    }

