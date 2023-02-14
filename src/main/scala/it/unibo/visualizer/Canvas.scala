package it.unibo.visualizer

import javax.swing.JPanel
import java.awt.{Color, Dimension, Graphics}

class Canvas(w: Int, h: Int) extends JPanel:
  private var agents: List[(Double, Double)] = List.empty

  def getAgents: List[(Double, Double)] = agents
  def setAgents(a: List[(Double, Double)]): Unit = agents = a

  override def getPreferredSize: Dimension = new Dimension(w, h)

  override def paintComponent(g: Graphics): Unit =
    super.paintComponent(g)
    g.setColor(Color.BLUE)
    agents.foreach(ag => g.drawOval(ag._1.toInt + (w/2), ag._2.toInt + (h/2), 5, 5))
    