package it.unibo.visualizer

import it.unibo.visualizer.Logic.gui

import java.awt.Color
import scala.io.Source
import scala.concurrent.{ExecutionContext, Future}

given context: ExecutionContext = ExecutionContext.global

def readPositions(path: String): List[List[(Double, Double)]] =
  Source
    .fromFile(path)
    .getLines().toList.filter(_.length<20)
    .map(_.drop(1).dropRight(1))
    .map(l => List((l.split(",")(0).toDouble, l.split(",")(1).toDouble)))

def readDusts(path: String): List[List[(Double, Double)]] =
  Source.fromFile(path).getLines().toList.map(line => line.split(" ").toList.map(_.drop(1).dropRight(1)).map(l => (l.split(",")(0).toDouble, l.split(",")(1).toDouble)))

object Logic extends App:
  val gui = Gui(1000, 700, 4.0)

  val positions1 = readPositions("agent-1.txt")
  val positions2 = readPositions("agent-2.txt")
  val positions3 = readPositions("agent-3.txt")
  var dusts = readDusts("dusts.txt")

  positions1
    .zip(positions2)
    .zip(positions3)
    .map { case ((a, b), c) => (a, b, c) }
    .foreach(
      pos =>
        Thread.sleep(10)
        gui.updateRender((List(pos._1(0), pos._2(0), pos._3(0)), Color.BLUE, 2), (dusts.head, Color.GREEN, 2))
        dusts = dusts.drop(1)
    )