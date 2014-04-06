
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
	  		<center> <label class="nome"><span>"""),_display_(Seq[Any](/*49.42*/cadeira/*49.49*/.getNome())),format.raw/*49.59*/("""</span></label></center>
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
                    DATE: Sun Apr 06 00:19:28 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-test/app/views/index.scala.html
                    HASH: 67b44c6a4753668df861c5c67a5877a0629001e8
                    MATRIX: 785->1|928->34|956->53|1092->154|1106->160|1163->196|1240->238|1254->244|1309->278|1451->385|1488->413|1528->415|1586->437|1632->461|1738->531|1753->537|1803->565|2141->866|2156->871|2192->884|2624->1280|2638->1285|2679->1303|2805->1393|2819->1398|2877->1433|2987->1507|3001->1512|3053->1542|3159->1612|3173->1617|3221->1643|3333->1719|3347->1724|3398->1753|3524->1843|3538->1848|3596->1883|3724->1976|3799->2035|3838->2036|3919->2081|3935->2088|3968->2099|4024->2124|4259->2324|4328->2377|4368->2379|4437->2412|4453->2419|4485->2429|4531->2439|4547->2446|4580->2457|4728->2569|4744->2576|4776->2586|4867->2641|4883->2648|4919->2662|4957->2664|4999->2684|5091->2740|5107->2747|5146->2764|5199->2786|5320->2872|5371->2907|5411->2909|5462->2924|5478->2931|5512->2943|5793->3188|5810->3195|5845->3207|5884->3209|5927->3229|5975->3242|6028->3279|6068->3281|6109->3287|6169->3338|6209->3340|6279->3374|6295->3381|6327->3391|6390->3418|6406->3425|6439->3436|6551->3512|6567->3519|6599->3529|6634->3547|6647->3552|6686->3553|6761->3592|6777->3599|6809->3609|6939->3703|6955->3710|6987->3720|7040->3742|7119->3785|7135->3792|7167->3802|7259->3858|7275->3865|7311->3879|7349->3881|7391->3901|7484->3958|7500->3965|7539->3982|7690->4102|7772->4148|7788->4155|7824->4169|7862->4171|7904->4191|7997->4248|8013->4255|8057->4277|8107->4296|8148->4306
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|46->18|46->18|46->18|49->21|49->21|49->21|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|64->36|64->36|64->36|65->37|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|81->53|88->60|88->60|88->60|90->62|90->62|90->62|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|103->75|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|106->78|106->78|106->78|110->82|113->85|113->85|113->85|113->85|113->85|114->86|114->86|114->86|116->88|118->90
                    -- GENERATED --
                */
            