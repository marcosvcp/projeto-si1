
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,User,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, user: User)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

<!DOCTYPE html>

<html>
	<head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <script src=""""),_display_(Seq[Any](/*8.23*/routes/*8.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*8.74*/("""" type="text/javascript"></script>
        
        <!-- CSS -->
 
	    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*12.36*/routes/*12.42*/.Assets.at("stylesheets/reset.css"))),format.raw/*12.77*/("""">
	    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*13.36*/routes/*13.42*/.Assets.at("stylesheets/animate.css"))),format.raw/*13.79*/("""">
	    <link rel="stylesheet" href=""""),_display_(Seq[Any](/*14.36*/routes/*14.42*/.Assets.at("stylesheets/main.css"))),format.raw/*14.76*/("""">
	     
	     <!-- Basics -->
 
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	</head>        
    <body>
        
        
    <dl id="user" style="background:#27408B">
        <dt style="color:#ffffff">Bem vindo, """),_display_(Seq[Any](/*25.47*/user/*25.51*/.getName())),format.raw/*25.61*/("""</dt>
        <dd>
            <a href=""""),_display_(Seq[Any](/*27.23*/routes/*27.29*/.Application.logout())),format.raw/*27.50*/("""">Logout</a>
        </dd>
    </dl>
    
        """),_display_(Seq[Any](/*31.10*/content)),format.raw/*31.17*/("""
        
        
        
        
    </body>
</html>
"""))}
    }
    
    def render(title:String,user:User,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,user)(content)
    
    def f:((String,User) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,user) => (content) => apply(title,user)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 22:02:57 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/main.scala.html
                    HASH: c47956d78cd4d743f7dcf05b71c5eb8e990778e7
                    MATRIX: 783->1|919->43|1010->99|1036->104|1103->136|1117->142|1183->187|1325->293|1340->299|1397->334|1472->373|1487->379|1546->416|1621->455|1636->461|1692->495|2007->774|2020->778|2052->788|2131->831|2146->837|2189->858|2280->913|2309->920
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|53->25|53->25|53->25|55->27|55->27|55->27|59->31|59->31
                    -- GENERATED --
                */
            