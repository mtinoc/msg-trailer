package com.matinoc.messages.builders

/**
  * Created by ajenoui on 21/06/16.
  */
object build{

  val xmlMessageBuilder = new XmlMessageBuilder

  def from(templateName:String):XmlMessageBuilder = {
    xmlMessageBuilder.apply(templateName)
  }
}
