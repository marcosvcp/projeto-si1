
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[PlanoDeCurso,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(plano: PlanoDeCurso):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.23*/("""

"""),format.raw/*4.1*/("""
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type='text/javascript' src=""""),_display_(Seq[Any](/*6.38*/routes/*6.44*/.Assets.at("javascripts/funcoes.js"))),format.raw/*6.80*/(""""></script>
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*7.31*/routes/*7.37*/.Assets.at("stylesheets/main.css"))),format.raw/*7.71*/("""">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<body style='background-image:url("""),_display_(Seq[Any](/*10.36*/routes/*10.42*/.Assets.at("images/bg-1.jpg"))),format.raw/*10.71*/(""");'>
"""),_display_(Seq[Any](/*11.2*/main("Plano de Curso")/*11.24*/ {_display_(Seq[Any](format.raw/*11.26*/("""
	<center><h2>"""),_display_(Seq[Any](/*12.15*/Messages("planoDeCurso"))),format.raw/*12.39*/("""</h2></center>
	
	<h3 style="position:absolute;left:60%;top:50px;">Períodos Do Curso</h3>
	<div id="periodos">
	"""),_display_(Seq[Any](/*16.3*/for(periodo <- plano.getPeriodos()) yield /*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
		<div id=""""),_display_(Seq[Any](/*17.13*/periodo/*17.20*/.getNumero())),format.raw/*17.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		
		<ul style="list-style:none;">
			<span class="label label-info" style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*21.121*/periodo/*21.128*/.getNumero())),format.raw/*21.140*/(""" """),_display_(Seq[Any](/*21.142*/Messages("nPeriodo"))),format.raw/*21.162*/(""" </span>
			"""),_display_(Seq[Any](/*22.5*/for(cadeira <- periodo.getCadeiras()) yield /*22.42*/ {_display_(Seq[Any](format.raw/*22.44*/("""
			"""),_display_(Seq[Any](/*23.5*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*23.56*/ {_display_(Seq[Any](format.raw/*23.58*/("""
		  			<div class="alocadas" id=""""),_display_(Seq[Any](/*24.35*/cadeira/*24.42*/.getNome())),format.raw/*24.52*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
		
			""")))}/*27.5*/else/*27.9*/{_display_(Seq[Any](format.raw/*27.10*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*28.39*/cadeira/*28.46*/.getNome())),format.raw/*28.56*/("""" 	draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
			""")))})),format.raw/*30.5*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*31.43*/cadeira/*31.50*/.getNome())),format.raw/*31.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*32.32*/cadeira/*32.39*/.getCreditos())),format.raw/*32.53*/(""" """),_display_(Seq[Any](/*32.55*/Messages("creditos"))),format.raw/*32.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*33.49*/cadeira/*33.56*/.getDificuldade())),format.raw/*33.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*37.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*39.34*/periodo/*39.41*/.getCreditos())),format.raw/*39.55*/(""" """),_display_(Seq[Any](/*39.57*/Messages("creditos"))),format.raw/*39.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*40.50*/periodo/*40.57*/.getDificuldadeTotal())),format.raw/*40.79*/("""</span>
		</div>
	""")))})),format.raw/*42.3*/("""
	</div>
	<h5 style="float:right;position:absolute;top:630px;left:60px;margin:0;color:#600;">
		Arraste a cadeira para o período que você quer alocá-la
	</h5>
""")))})),format.raw/*47.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Feb 28 16:17:37 GMT-03:00 2014
                    SOURCE: D:/Universidade/2013.2/PSI1/app/views/index.scala.html
                    HASH: 2be6f0fa643c9e44033fcc5cc70014fec76a87ef
                    MATRIX: 780->1|912->22|942->44|1080->147|1094->153|1151->189|1229->232|1243->238|1298->272|1471->409|1486->415|1537->444|1579->451|1610->473|1650->475|1702->491|1748->515|1900->632|1951->667|1991->669|2041->683|2057->690|2091->702|2404->978|2421->985|2456->997|2495->999|2538->1019|2587->1033|2640->1070|2680->1072|2721->1078|2781->1129|2821->1131|2893->1167|2909->1174|2941->1184|3042->1267|3054->1271|3093->1272|3169->1312|3185->1319|3217->1329|3328->1409|3408->1453|3424->1460|3456->1470|3549->1527|3565->1534|3601->1548|3639->1550|3681->1570|3775->1628|3791->1635|3830->1652|3943->1734|4024->1779|4040->1786|4076->1800|4114->1802|4156->1822|4250->1880|4266->1887|4310->1909|4362->1930|4558->2095
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|55->27|55->27|55->27|56->28|56->28|56->28|58->30|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|65->37|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47
                    -- GENERATED --
                */
            