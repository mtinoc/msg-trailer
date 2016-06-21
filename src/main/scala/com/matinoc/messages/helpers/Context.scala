package com.matinoc.messages.helpers

import java.io.{File, FileInputStream, FileNotFoundException}
import java.util.Properties

import sun.org.mozilla.javascript.ast.ThrowStatement

import scala.io.Source

/**
  * Created by ajenoui on 21/06/16.
  */
object Context {

  val p = new Properties();
  var tempalteDirectory= ""
  var csvDataDirectory= ""

  {
    p.load(getClass.getClassLoader.getResourceAsStream(Constants.fileConfigName))
    // set the templateDirectory
    this.tempalteDirectory = getWithcheckPath(Constants.tempalteDirectory_propertyNmae)

    // set the csvData directory
    this.csvDataDirectory = getWithcheckPath(Constants.csvData_propertyNmae)

  }


  def getWithcheckPath(key:String): String ={
    val filePath = p.getProperty(key)
    if (null != filePath) {
      if (!new File(filePath).exists())
      throw new FileNotFoundException(filePath)
      filePath
    } else {
      throw new IllegalArgumentException(key + " not found in " + Constants.fileConfigName)
    }
  }


}
