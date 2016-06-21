package com.matinoc.messages.builders

import java.io.{File, StringWriter}

import freemarker.template.{Configuration, Template, TemplateExceptionHandler}

import scala.collection.JavaConverters._
import com.matinoc.messages.helpers._


import scala.collection.mutable
import scala.io.Source


/**
  * Created by ajenoui on 20/06/16.
  */
class XmlMessageBuilder()  {

  var t:Template = _

  def apply(templateName: String): XmlMessageBuilder ={

    // get Template
    val cfg = new Configuration()
    cfg.setDirectoryForTemplateLoading(new File(Context.tempalteDirectory))
    cfg.setDefaultEncoding("UTF-8")
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    val template = cfg.getTemplate(templateName)
    this.t = template
    this


  }

    def using(csvDataFileName:String): String ={


      val out = new StringWriter
      val stringBuilder = new StringBuilder
        val data = new mutable.HashMap[String, String]
        val it = Source.fromFile(Context.csvDataDirectory+File.separator+csvDataFileName).getLines()
        val headers:Array[String] = it.next().split(";")
        it.foreach(line => {
              // todo if (line.isEmpty) continue
              val values = line.split(";")
              values.indices.foreach(i => data(headers(i)) = values(i) )
              t.process(data.asJava, out)

        })
      out.toString

    }


}
