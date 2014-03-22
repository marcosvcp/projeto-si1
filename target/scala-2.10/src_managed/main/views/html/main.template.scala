
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
        
        
        
        <header>
   
    <dl id="user">
        <dt>"""),_display_(Seq[Any](/*27.14*/user/*27.18*/.getEmail())),format.raw/*27.29*/("""</dt>
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
    
    def render(title:String,user:User,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,user)(content)
    
    def f:((String,User) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,user) => (content) => apply(title,user)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 21 23:57:00 BRT 2014
                    SOURCE: /home/marcos/Documents/putoProjeto/app/views/main.scala.html
                    HASH: 96edfcff4c67197156da97afb2cc11b1b4ecbe77
                    MATRIX: 783->1|919->43|1007->96|1033->101|1130->163|1144->169|1199->203|1295->264|1309->270|1362->302|1423->327|1438->333|1505->378|1638->475|1653->481|1714->520|1806->576|1821->582|1887->625|1979->681|1994->687|2066->736|2158->792|2173->798|2241->843|2311->877|2326->883|2390->925|2483->982|2498->988|2558->1026|2732->1164|2745->1168|2778->1179|2855->1220|2870->1226|2913->1247|3005->1303|3034->1310
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|55->27|55->27|55->27|57->29|57->29|57->29|61->33|61->33
                    -- GENERATED --
                */
            