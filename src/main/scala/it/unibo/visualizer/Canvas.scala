package it.unibo.visualizer

import javax.swing.JPanel
import java.awt.{Color, Dimension, Graphics}

class Canvas(w: Int, h: Int, scale: Double) extends JPanel:
  private var agents: List[(List[(Double, Double)], Color, Int)] = List.empty

  def getAgents: List[(List[(Double, Double)], Color, Int)] = agents
  def setAgents(a: List[(List[(Double, Double)], Color, Int)]): Unit = agents = a

  override def getPreferredSize: Dimension = new Dimension(w, h)

  override def paintComponent(g: Graphics): Unit =
    super.paintComponent(g)
    agents.foreach(ag =>
      g.setColor(ag._2)
      val agents = ag._1
      agents.foreach(agent =>
        g.drawOval(Math.floor(agent._1.toInt * scale + (w/2)).toInt, Math.floor(agent._2.toInt * scale + (h/2)).toInt, Math.floor(ag._3 * scale).toInt, Math.floor(ag._3 * scale).toInt)
      )
    )