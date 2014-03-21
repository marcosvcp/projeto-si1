
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
        
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.54*/routes/*12.60*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*12.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.54*/routes/*13.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*13.103*/("""">
       	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*14.54*/routes/*14.60*/.Assets.at("stylesheets/bootstrap-theme.min.css"))),format.raw/*14.109*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*15.54*/routes/*15.60*/.Assets.at("stylesheets/bootstrap-theme.css"))),format.raw/*15.105*/("""">
        
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*17.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*18.67*/("""" type="text/javascript"></script>
    </head>
    <body>
        
        
        
        <header>
   
    <dl id="user">
        <dt>User</dt>
        <dd>
            <a href=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Application.logout())),format.raw/*29.50*/("""">Logout</a>
        </dd>
    </dl>
</header>
        """),_display_(Seq[Any](/*33.10*/content)),format.raw/*33.17*/("""
        
        
        
        
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 21 00:10:45 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/main.scala.html
                    HASH: 61183ab9d7f7805ace9cc929449663cfaa1ddad8
                    MATRIX: 778->1|902->31|996->90|1022->95|1120->158|1134->164|1189->198|1286->260|1300->266|1353->298|1415->324|1430->330|1497->375|1632->474|1647->480|1708->519|1801->576|1816->582|1882->625|1975->682|1990->688|2062->737|2155->794|2170->800|2238->845|2310->881|2325->887|2389->929|2483->987|2498->993|2558->1031|2787->1224|2802->1230|2845->1251|2941->1311|2970->1318
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|57->29|57->29|57->29|61->33|61->33
                    -- GENERATED --
                */
            