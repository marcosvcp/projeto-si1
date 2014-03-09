
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
	
	<div >
	"""),_display_(Seq[Any](/*15.3*/for(periodo <- plano.getPeriodos()) yield /*15.38*/ {_display_(Seq[Any](format.raw/*15.40*/("""
		<div id=""""),_display_(Seq[Any](/*16.13*/periodo/*16.20*/.getNumero())),format.raw/*16.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		
		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*20.96*/periodo/*20.103*/.getNumero())),format.raw/*20.115*/(""" """),_display_(Seq[Any](/*20.117*/Messages("nPeriodo"))),format.raw/*20.137*/(""" </span>
			"""),_display_(Seq[Any](/*21.5*/for(cadeira <- periodo.getCadeiras()) yield /*21.42*/ {_display_(Seq[Any](format.raw/*21.44*/("""
			"""),_display_(Seq[Any](/*22.5*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*22.56*/ {_display_(Seq[Any](format.raw/*22.58*/("""
		  			<div class="alocadas" id=""""),_display_(Seq[Any](/*23.35*/cadeira/*23.42*/.getNome())),format.raw/*23.52*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
		
			""")))}/*26.5*/else/*26.9*/{_display_(Seq[Any](format.raw/*26.10*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*27.39*/cadeira/*27.46*/.getNome())),format.raw/*27.56*/("""" 	draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
			""")))})),format.raw/*29.5*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*30.43*/cadeira/*30.50*/.getNome())),format.raw/*30.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*31.32*/cadeira/*31.39*/.getCreditos())),format.raw/*31.53*/(""" """),_display_(Seq[Any](/*31.55*/Messages("creditos"))),format.raw/*31.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*32.49*/cadeira/*32.56*/.getDificuldade())),format.raw/*32.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*36.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*38.34*/periodo/*38.41*/.getCreditos())),format.raw/*38.55*/(""" """),_display_(Seq[Any](/*38.57*/Messages("creditos"))),format.raw/*38.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*39.50*/periodo/*39.57*/.getDificuldadeTotal())),format.raw/*39.79*/("""</span>
		</div>
	""")))})),format.raw/*41.3*/("""
	</div>
""")))})),format.raw/*43.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 16:12:39 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-atualizado/app/views/index.scala.html
                    HASH: a3ac86d973e919e59e90f19ae16c489fa316d5b0
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1799->531|1850->566|1890->568|1939->581|1955->588|1989->600|2272->847|2289->854|2324->866|2363->868|2406->888|2454->901|2507->938|2547->940|2587->945|2647->996|2687->998|2758->1033|2774->1040|2806->1050|2904->1130|2916->1134|2955->1135|3030->1174|3046->1181|3078->1191|3187->1269|3266->1312|3282->1319|3314->1329|3406->1385|3422->1392|3458->1406|3496->1408|3538->1428|3631->1485|3647->1492|3686->1509|3795->1587|3874->1630|3890->1637|3926->1651|3964->1653|4006->1673|4099->1730|4115->1737|4159->1759|4209->1778|4250->1788
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|43->15|43->15|43->15|44->16|44->16|44->16|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|54->26|54->26|54->26|55->27|55->27|55->27|57->29|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|60->32|60->32|60->32|64->36|66->38|66->38|66->38|66->38|66->38|67->39|67->39|67->39|69->41|71->43
                    -- GENERATED --
                */
            