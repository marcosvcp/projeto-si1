
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
			"""),_display_(Seq[Any](/*29.5*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*29.56*/ {_display_(Seq[Any](format.raw/*29.58*/("""
		  			<div class="alocadas" id=""""),_display_(Seq[Any](/*30.35*/cadeira/*30.42*/.getNome())),format.raw/*30.52*/("""" title="remover" onclick="remCadeira('"""),_display_(Seq[Any](/*30.92*/cadeira/*30.99*/.getNome())),format.raw/*30.109*/("""', '"""),_display_(Seq[Any](/*30.114*/plano/*30.119*/.isPreRequisito(cadeira.getNome()))),format.raw/*30.153*/("""')" 	draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
		
			""")))}/*33.5*/else/*33.9*/{_display_(Seq[Any](format.raw/*33.10*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*34.39*/cadeira/*34.46*/.getNome())),format.raw/*34.56*/("""" title="remover" onclick="remCadeira('"""),_display_(Seq[Any](/*34.96*/cadeira/*34.103*/.getNome())),format.raw/*34.113*/("""', '"""),_display_(Seq[Any](/*34.118*/plano/*34.123*/.isPreRequisito(cadeira.getNome()))),format.raw/*34.157*/("""')" 	draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()">
			""")))})),format.raw/*36.5*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*37.43*/cadeira/*37.50*/.getNome())),format.raw/*37.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*38.32*/cadeira/*38.39*/.getCreditos())),format.raw/*38.53*/(""" """),_display_(Seq[Any](/*38.55*/Messages("creditos"))),format.raw/*38.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*39.49*/cadeira/*39.56*/.getDificuldade())),format.raw/*39.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*43.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*45.34*/periodo/*45.41*/.getCreditos())),format.raw/*45.55*/(""" """),_display_(Seq[Any](/*45.57*/Messages("creditos"))),format.raw/*45.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*46.50*/periodo/*46.57*/.getDificuldadeTotal())),format.raw/*46.79*/("""</span>
		</div>
	""")))})),format.raw/*48.3*/("""
	</div>
	<h5 style="float:right;position:absolute;top:630px;left:760px;margin:0;color:#600;">
		Clique sobre uma cadeira para removê-la.
	</h5>
	
	<br/>
	<center><div class="separator"> </div> </center>
	
	<h3 style="float:left;position:relative;left:50px;">"""),_display_(Seq[Any](/*57.55*/Messages("cadeirasDisponiveis"))),format.raw/*57.86*/("""</h3>
	<h5 style="float:right;position:absolute;top:630px;left:60px;margin:0;color:#600;">
		Arraste a cadeira para o período que você quer alocá-la
	</h5>
	<div style="width:35%;height:500px;overflow-y:auto;margin-top:20px;margin-left:30px;">
	<ul style="list-style:none;overflow-y:auto;margin-top:20px;"> 
		"""),_display_(Seq[Any](/*63.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*63.57*/ {_display_(Seq[Any](format.raw/*63.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*64.33*/cadeira/*64.40*/.getNome())),format.raw/*64.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*66.35*/cadeira/*66.42*/.getNome())),format.raw/*66.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*67.31*/cadeira/*67.38*/.getCreditos())),format.raw/*67.52*/(""" """),_display_(Seq[Any](/*67.54*/Messages("creditos"))),format.raw/*67.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*68.48*/cadeira/*68.55*/.getDificuldade())),format.raw/*68.72*/("""</label>
	  	</div>
	""")))})),format.raw/*70.3*/(""" 
	</ul>
	</div>	
""")))})),format.raw/*73.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 14:42:45 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-si1/app/views/index.scala.html
                    HASH: 610a0c74b714b4281c7fcd34b1f80b852d6cab25
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1885->617|1936->652|1976->654|2025->667|2041->674|2075->686|2263->839|2300->867|2340->869|2421->914|2437->921|2471->933|2520->951|2723->1117|2740->1124|2775->1136|2814->1138|2857->1158|2905->1171|2958->1208|2998->1210|3038->1215|3098->1266|3138->1268|3209->1303|3225->1310|3257->1320|3333->1360|3349->1367|3382->1377|3424->1382|3439->1387|3496->1421|3597->1504|3609->1508|3648->1509|3723->1548|3739->1555|3771->1565|3847->1605|3864->1612|3897->1622|3939->1627|3954->1632|4011->1666|4122->1746|4201->1789|4217->1796|4249->1806|4341->1862|4357->1869|4393->1883|4431->1885|4473->1905|4566->1962|4582->1969|4621->1986|4730->2064|4809->2107|4825->2114|4861->2128|4899->2130|4941->2150|5034->2207|5050->2214|5094->2236|5144->2255|5440->2515|5493->2546|5839->2857|5908->2910|5948->2912|6017->2945|6033->2952|6065->2962|6206->3067|6222->3074|6254->3084|6338->3132|6354->3139|6390->3153|6428->3155|6470->3175|6562->3231|6578->3238|6617->3255|6670->3277|6720->3296
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|55->27|55->27|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|64->36|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|67->39|67->39|67->39|71->43|73->45|73->45|73->45|73->45|73->45|74->46|74->46|74->46|76->48|85->57|85->57|91->63|91->63|91->63|92->64|92->64|92->64|94->66|94->66|94->66|95->67|95->67|95->67|95->67|95->67|96->68|96->68|96->68|98->70|101->73
                    -- GENERATED --
                */
            