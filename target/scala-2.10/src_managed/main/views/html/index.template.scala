
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
	
	<div class="separator"> </div>

	
	<div class="periodo">
	<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Cadeiras disponiveis</span>
	<ul style="list-style:none;"> 
		"""),_display_(Seq[Any](/*20.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*20.57*/ {_display_(Seq[Any](format.raw/*20.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*21.33*/cadeira/*21.40*/.getNome())),format.raw/*21.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*23.35*/cadeira/*23.42*/.getNome())),format.raw/*23.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*24.31*/cadeira/*24.38*/.getCreditos())),format.raw/*24.52*/(""" """),_display_(Seq[Any](/*24.54*/Messages("creditos"))),format.raw/*24.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*25.48*/cadeira/*25.55*/.getDificuldade())),format.raw/*25.72*/("""</label>
	  	</div>
	""")))})),format.raw/*27.3*/(""" 
	
	</ul>
	<span class="periodoCreditos">Arraste para alocar</span>
	</div>
	
	<div >
	
	"""),_display_(Seq[Any](/*35.3*/for(periodo <- plano.getPeriodos()) yield /*35.38*/ {_display_(Seq[Any](format.raw/*35.40*/("""
		<div id=""""),_display_(Seq[Any](/*36.13*/periodo/*36.20*/.getNumero())),format.raw/*36.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		
		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*40.96*/periodo/*40.103*/.getNumero())),format.raw/*40.115*/(""" """),_display_(Seq[Any](/*40.117*/Messages("nPeriodo"))),format.raw/*40.137*/(""" </span>
			"""),_display_(Seq[Any](/*41.5*/for(cadeira <- periodo.getCadeiras()) yield /*41.42*/ {_display_(Seq[Any](format.raw/*41.44*/("""
				"""),_display_(Seq[Any](/*42.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*42.57*/ {_display_(Seq[Any](format.raw/*42.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*43.34*/cadeira/*43.41*/.getNome())),format.raw/*43.51*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*44.75*/cadeira/*44.82*/.getNome())),format.raw/*44.92*/("""','true')">
				""")))}/*45.7*/else/*45.12*/{_display_(Seq[Any](format.raw/*45.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*46.39*/cadeira/*46.46*/.getNome())),format.raw/*46.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*47.75*/cadeira/*47.82*/.getNome())),format.raw/*47.92*/("""','true')">
				""")))})),format.raw/*48.6*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*49.43*/cadeira/*49.50*/.getNome())),format.raw/*49.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*50.32*/cadeira/*50.39*/.getCreditos())),format.raw/*50.53*/(""" """),_display_(Seq[Any](/*50.55*/Messages("creditos"))),format.raw/*50.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*51.49*/cadeira/*51.56*/.getDificuldade())),format.raw/*51.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*55.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*57.34*/periodo/*57.41*/.getCreditos())),format.raw/*57.55*/(""" """),_display_(Seq[Any](/*57.57*/Messages("creditos"))),format.raw/*57.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*58.50*/periodo/*58.57*/.getDificuldadeTotal())),format.raw/*58.79*/("""</span>
		</div>
	""")))})),format.raw/*60.3*/("""
	</div>
""")))})),format.raw/*62.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 14 12:42:33 BRT 2014
                    SOURCE: /home/celiorcbf/projeto-si1/app/views/index.scala.html
                    HASH: 258694b54a0c9dedf8fbc6a800bb39fb3958a976
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|2001->733|2070->786|2110->788|2179->821|2195->828|2227->838|2368->943|2384->950|2416->960|2500->1008|2516->1015|2552->1029|2590->1031|2632->1051|2724->1107|2740->1114|2779->1131|2832->1153|2958->1244|3009->1279|3049->1281|3098->1294|3114->1301|3148->1313|3431->1560|3448->1567|3483->1579|3522->1581|3565->1601|3613->1614|3666->1651|3706->1653|3747->1659|3807->1710|3847->1712|3917->1746|3933->1753|3965->1763|4095->1857|4111->1864|4143->1874|4178->1892|4191->1897|4230->1898|4305->1937|4321->1944|4353->1954|4483->2048|4499->2055|4531->2065|4579->2082|4658->2125|4674->2132|4706->2142|4798->2198|4814->2205|4850->2219|4888->2221|4930->2241|5023->2298|5039->2305|5078->2322|5187->2400|5266->2443|5282->2450|5318->2464|5356->2466|5398->2486|5491->2543|5507->2550|5551->2572|5601->2591|5642->2601
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|55->27|63->35|63->35|63->35|64->36|64->36|64->36|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|83->55|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|88->60|90->62
                    -- GENERATED --
                */
            