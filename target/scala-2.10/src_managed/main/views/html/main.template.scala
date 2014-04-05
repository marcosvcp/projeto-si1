
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
        <dt style="color:#ffffff">Bem vindo(a), """),_display_(Seq[Any](/*24.50*/user/*24.54*/.getName())),format.raw/*24.64*/("""</dt>
        <dd>
            <a href=""""),_display_(Seq[Any](/*26.23*/routes/*26.29*/.Application.logout())),format.raw/*26.50*/("""">Logout</a>
        </dd>
        <dd>
            <a href=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Application.mostraPlanosDosUsuarios())),format.raw/*29.67*/("""">Rede Social</a>
        </dd>
        
    </dl>
    
        """),_display_(Seq[Any](/*34.10*/content)),format.raw/*34.17*/("""
        
        
        
        
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
                    DATE: Fri Apr 04 01:38:21 BRT 2014
                    SOURCE: C:/Users/HOME/projeto-si1/app/views/main.scala.html
                    HASH: f15189cd03b32d95ed0fbd5ff4d635d262833cdb
                    MATRIX: 783->1|919->43|1010->99|1036->104|1103->136|1117->142|1183->187|1325->293|1340->299|1397->334|1472->373|1487->379|1546->416|1621->455|1636->461|1692->495|1999->766|2012->770|2044->780|2123->823|2138->829|2181->850|2282->915|2297->921|2357->959|2463->1029|2492->1036
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|52->24|52->24|52->24|54->26|54->26|54->26|57->29|57->29|57->29|62->34|62->34
                    -- GENERATED --
                */
            