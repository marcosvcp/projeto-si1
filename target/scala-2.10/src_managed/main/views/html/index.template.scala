
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
		<!--  BOTAO FECHAR DO PERIODO 
		"""),_display_(Seq[Any](/*20.4*/if(periodo.getNumero() != 1)/*20.32*/ {_display_(Seq[Any](format.raw/*20.34*/("""
			<span><a class="close" href="remPeriodo/"""),_display_(Seq[Any](/*21.45*/periodo/*21.52*/.getNumero())),format.raw/*21.64*/("""">X</a></span>
		""")))})),format.raw/*22.4*/("""
		 -->
		
		
		<ul style="list-style:none;">
			<span class="label label-info" style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*27.121*/periodo/*27.128*/.getNumero())),format.raw/*27.140*/(""" """),_display_(Seq[Any](/*27.142*/Messages("nPeriodo"))),format.raw/*27.162*/(""" </span>
			"""),_display_(Seq[Any](/*28.5*/for(cadeira <- periodo.getCadeiras()) yield /*28.42*/ {_display_(Seq[Any](format.raw/*28.44*/("""
			
		  	<div class="alocadas" id=""""),_display_(Seq[Any](/*30.33*/cadeira/*30.40*/.getNome())),format.raw/*30.50*/("""" title="remover" onclick="remCadeira('"""),_display_(Seq[Any](/*30.90*/cadeira/*30.97*/.getNome())),format.raw/*30.107*/("""', '"""),_display_(Seq[Any](/*30.112*/plano/*30.117*/.isPreRequisito(cadeira.getNome()))),format.raw/*30.151*/("""')">
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*31.43*/cadeira/*31.50*/.getNome())),format.raw/*31.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*32.32*/cadeira/*32.39*/.getCreditos())),format.raw/*32.53*/(""" """),_display_(Seq[Any](/*32.55*/Messages("creditos"))),format.raw/*32.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*33.49*/cadeira/*33.56*/.getDificuldade())),format.raw/*33.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		""")))})),format.raw/*36.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*38.34*/periodo/*38.41*/.getCreditos())),format.raw/*38.55*/(""" """),_display_(Seq[Any](/*38.57*/Messages("creditos"))),format.raw/*38.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*39.50*/periodo/*39.57*/.getDificuldadeTotal())),format.raw/*39.79*/("""</span>
		</div>
	""")))})),format.raw/*41.3*/("""
	</div>
	<h5 style="float:right;position:absolute;top:630px;left:760px;margin:0;color:#600;">
		Clique sobre uma cadeira para removê-la.
	</h5>
	
	<br/>
	<center><div class="separator"> </div> </center>
	
	<h3 style="float:left;position:relative;left:50px;">"""),_display_(Seq[Any](/*50.55*/Messages("cadeirasDisponiveis"))),format.raw/*50.86*/("""</h3>
	<h5 style="float:right;position:absolute;top:630px;left:60px;margin:0;color:#600;">
		Arraste a cadeira para o período que você quer alocá-la
	</h5>
	<div style="width:35%;height:500px;overflow-y:auto;margin-top:20px;margin-left:30px;">
	<ul style="list-style:none;overflow-y:auto;margin-top:20px;"> 
		"""),_display_(Seq[Any](/*56.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*56.57*/ {_display_(Seq[Any](format.raw/*56.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*57.33*/cadeira/*57.40*/.getNome())),format.raw/*57.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*59.35*/cadeira/*59.42*/.getNome())),format.raw/*59.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*60.31*/cadeira/*60.38*/.getCreditos())),format.raw/*60.52*/(""" """),_display_(Seq[Any](/*60.54*/Messages("creditos"))),format.raw/*60.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*61.48*/cadeira/*61.55*/.getDificuldade())),format.raw/*61.72*/("""</label>
	  	</div>
	""")))})),format.raw/*63.3*/(""" 
	</ul>
	</div>	
""")))})),format.raw/*66.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 26 22:56:15 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-si1/app/views/index.scala.html
                    HASH: 0a95c3b3eea60f372f0901a815cc1b429f681918
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1885->617|1936->652|1976->654|2025->667|2041->674|2075->686|2263->839|2300->867|2340->869|2421->914|2437->921|2471->933|2520->951|2723->1117|2740->1124|2775->1136|2814->1138|2857->1158|2905->1171|2958->1208|2998->1210|3071->1247|3087->1254|3119->1264|3195->1304|3211->1311|3244->1321|3286->1326|3301->1331|3358->1365|3441->1412|3457->1419|3489->1429|3581->1485|3597->1492|3633->1506|3671->1508|3713->1528|3806->1585|3822->1592|3861->1609|3964->1681|4043->1724|4059->1731|4095->1745|4133->1747|4175->1767|4268->1824|4284->1831|4328->1853|4378->1872|4674->2132|4727->2163|5073->2474|5142->2527|5182->2529|5251->2562|5267->2569|5299->2579|5440->2684|5456->2691|5488->2701|5572->2749|5588->2756|5624->2770|5662->2772|5704->2792|5796->2848|5812->2855|5851->2872|5904->2894|5954->2913
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|55->27|55->27|55->27|55->27|55->27|56->28|56->28|56->28|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|64->36|66->38|66->38|66->38|66->38|66->38|67->39|67->39|67->39|69->41|78->50|78->50|84->56|84->56|84->56|85->57|85->57|85->57|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|91->63|94->66
                    -- GENERATED --
                */
            