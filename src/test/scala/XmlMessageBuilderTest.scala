/**
  * Created by ajenoui on 21/06/16.
  */

import com.matinoc.messages.helpers._
import com.matinoc.messages.builders._
import org.scalatest._


class XmlMessageBuilderTest extends FunSuite {

  test("Xml builds from a template") {

    val expectedValue= "<html><balise><h1>welcome user1 </h1> you have 3 days to ...</balise></html><html><balise><h1>welcome ajenoui </h1> you have 5 days to ...</balise></html>"

    val result =  build from "xml_template.ftl" using "xml_data.csv"

    assert(expectedValue==result)

  }


}



