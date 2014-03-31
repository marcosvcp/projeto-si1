
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

<body>
"""),_display_(Seq[Any](/*11.2*/main("Plano de Curso", user)/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""
	<div>
	<center><h3>"""),_display_(Seq[Any](/*13.15*/Messages("planoDeCurso"))),format.raw/*13.39*/("""</h3></center>
	<br/>
	</div>

<div class="periodo">
		<form action=""""),_display_(Seq[Any](/*18.18*/routes/*18.24*/.Application.atualizaPeriodo)),format.raw/*18.52*/("""" method="post">
			<ul style="list-style:none;">
            	<span style="float:left;margin-left:0px;font-size:20px;">Periodo Atual:</span>
            	<input type="number" style="margin-bot:10px;height:25px;width:35px" min="1" max="10" name="periodo" title="Periodo entre 1 e 10" required value=""""),_display_(Seq[Any](/*21.160*/plano/*21.165*/.periodoAtual)),format.raw/*21.178*/("""" ><br/>
                <input type="submit" style="position:center;margin-top=10px;float:center;" title="Periodo entre 1 e 10"  value="Alterar">
			</ul>
		</form>
			<div><br/>
           <span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Informacoes uteis</span><br></br>
                        			<strong><span class="periodoCreditos">Periodo Atual: """),_display_(Seq[Any](/*27.82*/plano/*27.87*/.getPeriodoAtual())),format.raw/*27.105*/("""</span></strong><br>
			<span class="periodoCreditos">Creditos disciplinas nao alocadas: """),_display_(Seq[Any](/*28.70*/plano/*28.75*/.totalCreditosCadeirasNaoAlocadas())),format.raw/*28.110*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos passados: """),_display_(Seq[Any](/*29.63*/plano/*29.68*/.getCreditosPeriodosPassados())),format.raw/*29.98*/("""</span><br>
			<span class="periodoCreditos">Creditos periodo atual: """),_display_(Seq[Any](/*30.59*/plano/*30.64*/.getCreditosPeriodoAtual())),format.raw/*30.90*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos Planejados: """),_display_(Seq[Any](/*31.65*/plano/*31.70*/.getCreditosPeriodosFuturos())),format.raw/*31.99*/("""</span><br>
			<span class="periodoCreditos">Creditos minimos que faltam para me formar: """),_display_(Seq[Any](/*32.79*/plano/*32.84*/.getCreditosQueFaltamParaSeFormar())),format.raw/*32.119*/("""</span><br>

			<strong><nome>Periodos abaixo do minimo de creditos:</nome></strong><br>
			"""),_display_(Seq[Any](/*35.5*/for(periodo <- plano.periodosComMenosQueMinimoDeCreditos()) yield /*35.64*/{_display_(Seq[Any](format.raw/*35.65*/("""
				<strong><span class="periodoCreditos"> """),_display_(Seq[Any](/*36.45*/periodo/*36.52*/.toString())),format.raw/*36.63*/("""</span></strong><br>
			""")))})),format.raw/*37.5*/("""
			</div>
		</div>



	<div class="periodo">
	<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Cadeiras disponiveis</span>
	<ul style="list-style:none;"> 
		"""),_display_(Seq[Any](/*46.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*46.57*/ {_display_(Seq[Any](format.raw/*46.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*47.33*/cadeira/*47.40*/.getNome())),format.raw/*47.50*/("""" title=""""),_display_(Seq[Any](/*47.60*/cadeira/*47.67*/.toString())),format.raw/*47.78*/("""" draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label>"""),_display_(Seq[Any](/*49.22*/cadeira/*49.29*/.getNome())),format.raw/*49.39*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*50.31*/cadeira/*50.38*/.getCreditos())),format.raw/*50.52*/(""" """),_display_(Seq[Any](/*50.54*/Messages("creditos"))),format.raw/*50.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*51.48*/cadeira/*51.55*/.getDificuldade())),format.raw/*51.72*/("""</label>
	  	</div>
	""")))})),format.raw/*53.3*/(""" 

	</ul>
	<span class="periodoCreditos">Arraste para alocar</span>
	</div>

	<div>
	"""),_display_(Seq[Any](/*60.3*/for(periodo <- plano.getPeriodos()) yield /*60.38*/ {_display_(Seq[Any](format.raw/*60.40*/("""
	
		<div id=""""),_display_(Seq[Any](/*62.13*/periodo/*62.20*/.getNumero())),format.raw/*62.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">

		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*66.96*/periodo/*66.103*/.getNumero())),format.raw/*66.115*/(""" """),_display_(Seq[Any](/*66.117*/Messages("nPeriodo"))),format.raw/*66.137*/(""" </span>
			"""),_display_(Seq[Any](/*67.5*/for(cadeira <- periodo.getCadeiras()) yield /*67.42*/ {_display_(Seq[Any](format.raw/*67.44*/("""
				"""),_display_(Seq[Any](/*68.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*68.57*/ {_display_(Seq[Any](format.raw/*68.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*69.34*/cadeira/*69.41*/.getNome())),format.raw/*69.51*/("""" draggable="true" title=""""),_display_(Seq[Any](/*69.78*/cadeira/*69.85*/.toString())),format.raw/*69.96*/(""""
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*70.75*/cadeira/*70.82*/.getNome())),format.raw/*70.92*/("""','true')">
				""")))}/*71.7*/else/*71.12*/{_display_(Seq[Any](format.raw/*71.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*72.39*/cadeira/*72.46*/.getNome())),format.raw/*72.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*73.75*/cadeira/*73.82*/.getNome())),format.raw/*73.92*/("""','true')">
				
				""")))})),format.raw/*75.6*/("""
		  		<center> <label class="nome"><span>"""),_display_(Seq[Any](/*76.43*/cadeira/*76.50*/.getNome())),format.raw/*76.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*77.32*/cadeira/*77.39*/.getCreditos())),format.raw/*77.53*/(""" """),_display_(Seq[Any](/*77.55*/Messages("creditos"))),format.raw/*77.75*/("""</label>
		  		<label class="dificuldade"> Dificuldade: """),_display_(Seq[Any](/*78.49*/cadeira/*78.56*/.getDificuldade())),format.raw/*78.73*/("""</label>
		  		<span class="remove" style="margin-top: 15px;margin-left:140px;" title="remover"></span>
		  	</div>

		""")))})),format.raw/*82.4*/(""" 
		
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*85.34*/periodo/*85.41*/.getCreditos())),format.raw/*85.55*/(""" """),_display_(Seq[Any](/*85.57*/Messages("creditos"))),format.raw/*85.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*86.50*/periodo/*86.57*/.getDificuldadeTotal())),format.raw/*86.79*/("""</span>
		</div>
	""")))})),format.raw/*88.3*/("""
	</div>
""")))})),format.raw/*90.2*/("""
</body>"""))}
    }
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 30 22:11:04 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/index.scala.html
                    HASH: 4b5d7785411e74c734bd5a55384ddf02ff35f347
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1461->395|1498->423|1538->425|1598->449|1644->473|1755->548|1770->554|1820->582|2161->886|2176->891|2212->904|2650->1306|2664->1311|2705->1329|2832->1420|2846->1425|2904->1460|3015->1535|3029->1540|3081->1570|3188->1641|3202->1646|3250->1672|3363->1749|3377->1754|3428->1783|3555->1874|3569->1879|3627->1914|3758->2010|3833->2069|3872->2070|3954->2116|3970->2123|4003->2134|4060->2160|4304->2369|4373->2422|4413->2424|4483->2458|4499->2465|4531->2475|4577->2485|4593->2492|4626->2503|4756->2597|4772->2604|4804->2614|4889->2663|4905->2670|4941->2684|4979->2686|5021->2706|5114->2763|5130->2770|5169->2787|5224->2811|5352->2904|5403->2939|5443->2941|5496->2958|5512->2965|5546->2977|5831->3226|5848->3233|5883->3245|5922->3247|5965->3267|6014->3281|6067->3318|6107->3320|6149->3327|6209->3378|6249->3380|6320->3415|6336->3422|6368->3432|6431->3459|6447->3466|6480->3477|6593->3554|6609->3561|6641->3571|6677->3590|6690->3595|6729->3596|6805->3636|6821->3643|6853->3653|6984->3748|7000->3755|7032->3765|7087->3789|7167->3833|7183->3840|7215->3850|7308->3907|7324->3914|7360->3928|7398->3930|7440->3950|7534->4008|7550->4015|7589->4032|7744->4156|7829->4205|7845->4212|7881->4226|7919->4228|7961->4248|8055->4306|8071->4313|8115->4335|8167->4356|8210->4368
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|46->18|46->18|46->18|49->21|49->21|49->21|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|64->36|64->36|64->36|65->37|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|81->53|88->60|88->60|88->60|90->62|90->62|90->62|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|103->75|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|106->78|106->78|106->78|110->82|113->85|113->85|113->85|113->85|113->85|114->86|114->86|114->86|116->88|118->90
                    -- GENERATED --
                */
            