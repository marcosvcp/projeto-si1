
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
	
	<!-- BOTAO ADD PERIODO 
    <span id="addPeriodo">
		<a href="/addPeriodo">"""),_display_(Seq[Any](/*16.26*/Messages("addPeriodo"))),format.raw/*16.48*/("""</a>
	</span>
	 -->
	<h3 style="position:absolute;left:60%;top:50px;">Períodos Do Curso</h3>
	<div id="periodos">
	"""),_display_(Seq[Any](/*21.3*/for(periodo <- plano.getPeriodos()) yield /*21.38*/ {_display_(Seq[Any](format.raw/*21.40*/("""
		<div id=""""),_display_(Seq[Any](/*22.13*/periodo/*22.20*/.getNumero())),format.raw/*22.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		<!--  BOTAO FECHAR DO PERIODO 
		"""),_display_(Seq[Any](/*25.4*/if(periodo.getNumero() != 1)/*25.32*/ {_display_(Seq[Any](format.raw/*25.34*/("""
			<span><a class="close" href="remPeriodo/"""),_display_(Seq[Any](/*26.45*/periodo/*26.52*/.getNumero())),format.raw/*26.64*/("""">X</a></span>
		""")))})),format.raw/*27.4*/("""
		 -->
		
		
		<ul style="list-style:none;">
			<span class="label label-info" style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*32.121*/periodo/*32.128*/.getNumero())),format.raw/*32.140*/(""" """),_display_(Seq[Any](/*32.142*/Messages("nPeriodo"))),format.raw/*32.162*/(""" </span>
			"""),_display_(Seq[Any](/*33.5*/for(cadeira <- periodo.getCadeiras()) yield /*33.42*/ {_display_(Seq[Any](format.raw/*33.44*/("""
			
		  	<div class="alocadas" id=""""),_display_(Seq[Any](/*35.33*/cadeira/*35.40*/.getNome())),format.raw/*35.50*/("""" title="remover" onclick="remCadeira('"""),_display_(Seq[Any](/*35.90*/cadeira/*35.97*/.getNome())),format.raw/*35.107*/("""', '"""),_display_(Seq[Any](/*35.112*/plano/*35.117*/.isPreRequisito(cadeira.getNome()))),format.raw/*35.151*/("""')">
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*36.43*/cadeira/*36.50*/.getNome())),format.raw/*36.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*37.32*/cadeira/*37.39*/.getCreditos())),format.raw/*37.53*/(""" """),_display_(Seq[Any](/*37.55*/Messages("creditos"))),format.raw/*37.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*38.49*/cadeira/*38.56*/.getDificuldade())),format.raw/*38.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		""")))})),format.raw/*41.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*43.34*/periodo/*43.41*/.getCreditos())),format.raw/*43.55*/(""" """),_display_(Seq[Any](/*43.57*/Messages("creditos"))),format.raw/*43.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*44.50*/periodo/*44.57*/.getDificuldadeTotal())),format.raw/*44.79*/("""</span>
		</div>
	""")))})),format.raw/*46.3*/("""
	</div>
	<h5 style="float:right;position:absolute;top:630px;left:760px;margin:0;color:#600;">
		Clique sobre uma cadeira para removê-la.
	</h5>
	
	<br/>
	<center><div class="separator"> </div> </center>
	
	<h3 style="float:left;position:relative;left:50px;">"""),_display_(Seq[Any](/*55.55*/Messages("cadeirasDisponiveis"))),format.raw/*55.86*/("""</h3>
	<h5 style="float:right;position:absolute;top:630px;left:60px;margin:0;color:#600;">
		Arraste a cadeira para o período que você quer alocá-la
	</h5>
	<div style="width:35%;height:500px;overflow-y:auto;margin-top:20px;margin-left:30px;">
	<ul style="list-style:none;overflow-y:auto;margin-top:20px;"> 
		"""),_display_(Seq[Any](/*61.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*61.57*/ {_display_(Seq[Any](format.raw/*61.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*62.33*/cadeira/*62.40*/.getNome())),format.raw/*62.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*64.35*/cadeira/*64.42*/.getNome())),format.raw/*64.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*65.31*/cadeira/*65.38*/.getCreditos())),format.raw/*65.52*/(""" """),_display_(Seq[Any](/*65.54*/Messages("creditos"))),format.raw/*65.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*66.48*/cadeira/*66.55*/.getDificuldade())),format.raw/*66.72*/("""</label>
	  	</div>
	""")))})),format.raw/*68.3*/(""" 
	</ul>
	</div>	
""")))})),format.raw/*71.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 22 11:15:11 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-si1/app/views/index.scala.html
                    HASH: da1367d106db792fc55ebfb2c6402718756dfbd9
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1867->598|1911->620|2062->736|2113->771|2153->773|2202->786|2218->793|2252->805|2440->958|2477->986|2517->988|2598->1033|2614->1040|2648->1052|2697->1070|2900->1236|2917->1243|2952->1255|2991->1257|3034->1277|3082->1290|3135->1327|3175->1329|3248->1366|3264->1373|3296->1383|3372->1423|3388->1430|3421->1440|3463->1445|3478->1450|3535->1484|3618->1531|3634->1538|3666->1548|3758->1604|3774->1611|3810->1625|3848->1627|3890->1647|3983->1704|3999->1711|4038->1728|4141->1800|4220->1843|4236->1850|4272->1864|4310->1866|4352->1886|4445->1943|4461->1950|4505->1972|4555->1991|4851->2251|4904->2282|5250->2593|5319->2646|5359->2648|5428->2681|5444->2688|5476->2698|5617->2803|5633->2810|5665->2820|5749->2868|5765->2875|5801->2889|5839->2891|5881->2911|5973->2967|5989->2974|6028->2991|6081->3013|6131->3032
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|49->21|49->21|49->21|50->22|50->22|50->22|53->25|53->25|53->25|54->26|54->26|54->26|55->27|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|69->41|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|74->46|83->55|83->55|89->61|89->61|89->61|90->62|90->62|90->62|92->64|92->64|92->64|93->65|93->65|93->65|93->65|93->65|94->66|94->66|94->66|96->68|99->71
                    -- GENERATED --
                */
            