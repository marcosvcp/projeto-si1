
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
                    DATE: Fri Feb 28 14:04:59 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-si1/app/views/index.scala.html
                    HASH: 016a31166a0be378fe0d86d650b0eadd445f8c5f
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1885->617|1936->652|1976->654|2025->667|2041->674|2075->686|2384->958|2401->965|2436->977|2475->979|2518->999|2566->1012|2619->1049|2659->1051|2699->1056|2759->1107|2799->1109|2870->1144|2886->1151|2918->1161|3016->1241|3028->1245|3067->1246|3142->1285|3158->1292|3190->1302|3299->1380|3378->1423|3394->1430|3426->1440|3518->1496|3534->1503|3570->1517|3608->1519|3650->1539|3743->1596|3759->1603|3798->1620|3907->1698|3986->1741|4002->1748|4038->1762|4076->1764|4118->1784|4211->1841|4227->1848|4271->1870|4321->1889|4512->2049
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|55->27|55->27|55->27|56->28|56->28|56->28|58->30|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|65->37|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47
                    -- GENERATED --
                */
            