
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
        
        
        
 <head>   
    <dl id="user">
        <dt>"""),_display_(Seq[Any](/*26.14*/user/*26.18*/.getEmail())),format.raw/*26.29*/("""</dt>
        <dd>
            <a href=""""),_display_(Seq[Any](/*28.23*/routes/*28.29*/.Application.logout())),format.raw/*28.50*/("""">Logout</a>
        </dd>
    </dl>
    
    </head>
        """),_display_(Seq[Any](/*33.10*/content)),format.raw/*33.17*/("""
        
        
        
        
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
                    DATE: Fri Mar 28 14:52:14 BRT 2014
                    SOURCE: C:/Users/Igor/si1/PSI1/app/views/main.scala.html
                    HASH: 5775804aa619c9c2dff5ea15cad305bf8708e8e9
                    MATRIX: 783->1|919->43|1013->102|1039->107|1137->170|1151->176|1206->210|1303->272|1317->278|1370->310|1432->336|1447->342|1514->387|1649->486|1664->492|1725->531|1818->588|1833->594|1899->637|1992->694|2007->700|2079->749|2172->806|2187->812|2255->857|2327->893|2342->899|2406->941|2500->999|2515->1005|2575->1043|2747->1179|2760->1183|2793->1194|2872->1237|2887->1243|2930->1264|3034->1332|3063->1339
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|54->26|54->26|54->26|56->28|56->28|56->28|61->33|61->33
                    -- GENERATED --
                */
            