
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
                    DATE: Sun Mar 09 22:35:29 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/index.scala.html
                    HASH: 8fd3b631892ebc9359e3e2f9cd1ea7653ed923d8
                    MATRIX: 780->1|912->22|942->44|1080->147|1094->153|1151->189|1229->232|1243->238|1298->272|1471->409|1486->415|1537->444|1579->451|1610->473|1650->475|1702->491|1748->515|2020->752|2089->805|2129->807|2199->841|2215->848|2247->858|2390->965|2406->972|2438->982|2523->1031|2539->1038|2575->1052|2613->1054|2655->1074|2748->1131|2764->1138|2803->1155|2858->1179|2992->1278|3043->1313|3083->1315|3133->1329|3149->1336|3183->1348|3470->1599|3487->1606|3522->1618|3561->1620|3604->1640|3653->1654|3706->1691|3746->1693|3788->1700|3848->1751|3888->1753|3959->1788|3975->1795|4007->1805|4138->1900|4154->1907|4186->1917|4222->1936|4235->1941|4274->1942|4350->1982|4366->1989|4398->1999|4529->2094|4545->2101|4577->2111|4626->2129|4706->2173|4722->2180|4754->2190|4847->2247|4863->2254|4899->2268|4937->2270|4979->2290|5073->2348|5089->2355|5128->2372|5241->2454|5322->2499|5338->2506|5374->2520|5412->2522|5454->2542|5548->2600|5564->2607|5608->2629|5660->2650|5703->2662
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|55->27|63->35|63->35|63->35|64->36|64->36|64->36|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|83->55|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|88->60|90->62
                    -- GENERATED --
                */
            