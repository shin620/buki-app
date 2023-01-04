package controllers

import scala.io.Source

class Csv(filePath: String, coding: String = "utf-8") {
  def readAll: Array[Array[String]] = {
    val source = Source.fromFile(filePath, coding)
    val lines = source.getLines
    lines.toArray.map(_.split(","))
  }
}

class BukiFormatCsv(filePath: String = "app/controllers/buki.csv")
    extends Csv(filePath, "utf-8") {
  def getRow(id: String): Array[String] = readAll.filter(_(0) == id)(0)
  def names: Array[String] = readAll.map(_(1))
}

class Buki(id: String) {
  private val bukiCsv = new BukiFormatCsv()
  private val bukiData = bukiCsv.getRow(id)

  def name: String = bukiData(1)
  def subWeapon: String = bukiData(2)
  def specialWeapon: String = bukiData(3)
}
