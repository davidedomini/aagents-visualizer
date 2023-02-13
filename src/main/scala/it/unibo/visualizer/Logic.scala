package it.unibo.visualizer

import it.unibo.visualizer.Logic.gui

import scala.io.Source
import scala.concurrent.{ExecutionContext, Future}

given context: ExecutionContext = ExecutionContext.global

def readPositions(path: String): List[(Double, Double)] =
  Source
    .fromFile(path)
    .getLines()
    .map(_.drop(1).dropRight(1))
    .map(l => (l.split(", ")(0).toDouble, l.split(", ")(1).toDouble))
    .toList


object Logic extends App:
  val gui = Gui(500, 350)

  val positions1 = readPositions("agent-1.txt")
  val positions2 = readPositions("agent-2.txt")
  val positions3 = readPositions("agent-3.txt")

  positions1
    .zip(positions2)
    .zip(positions3)
    .map { case ((a, b), c) => (a, b, c) }
    .foreach(
      pos =>
        Thread.sleep(1000)
        gui.updateRender(List(pos._1, pos._2, pos._3))
    )