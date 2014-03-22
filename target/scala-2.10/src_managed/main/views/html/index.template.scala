
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[PlanoDeCurso,User,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(plano: PlanoDeCurso, user: User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.35*/("""

"""),format.raw/*4.1*/("""
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type='text/javascript' src=""""),_display_(Seq[Any](/*6.38*/routes/*6.44*/.Assets.at("javascripts/funcoes.js"))),format.raw/*6.80*/(""""></script>
<link rel="stylesheet" href=""""),_display_(Seq[Any](/*7.31*/routes/*7.37*/.Assets.at("stylesheets/main.css"))),format.raw/*7.71*/("""">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<body style='background-image:url("""),_display_(Seq[Any](/*10.36*/routes/*10.42*/.Assets.at("images/bg-1.jpg"))),format.raw/*10.71*/(""");'>
"""),_display_(Seq[Any](/*11.2*/main("Plano de Curso", user)/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""
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
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 21 23:57:01 BRT 2014
                    SOURCE: /home/marcos/Documents/putoProjeto/app/views/index.scala.html
                    HASH: d2359ed447cad103a7bd55ea8aa1f7699459429e
                    MATRIX: 785->1|928->34|956->53|1092->154|1106->160|1163->196|1240->238|1254->244|1309->278|1479->412|1494->418|1545->447|1586->453|1623->481|1663->483|1714->498|1760->522|2024->751|2093->804|2133->806|2202->839|2218->846|2250->856|2391->961|2407->968|2439->978|2523->1026|2539->1033|2575->1047|2613->1049|2655->1069|2747->1125|2763->1132|2802->1149|2855->1171|2981->1262|3032->1297|3072->1299|3121->1312|3137->1319|3171->1331|3454->1578|3471->1585|3506->1597|3545->1599|3588->1619|3636->1632|3689->1669|3729->1671|3770->1677|3830->1728|3870->1730|3940->1764|3956->1771|3988->1781|4118->1875|4134->1882|4166->1892|4201->1910|4214->1915|4253->1916|4328->1955|4344->1962|4376->1972|4506->2066|4522->2073|4554->2083|4602->2100|4681->2143|4697->2150|4729->2160|4821->2216|4837->2223|4873->2237|4911->2239|4953->2259|5046->2316|5062->2323|5101->2340|5210->2418|5289->2461|5305->2468|5341->2482|5379->2484|5421->2504|5514->2561|5530->2568|5574->2590|5624->2609|5665->2619
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|55->27|63->35|63->35|63->35|64->36|64->36|64->36|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|83->55|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|88->60|90->62
                    -- GENERATED --
                */
            