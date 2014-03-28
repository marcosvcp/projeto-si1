
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
	<center><h2>"""),_display_(Seq[Any](/*12.15*/Messages("planoDeCurso"))),format.raw/*12.39*/("""</h2></center>


<div class="periodo">
		<form action=""""),_display_(Seq[Any](/*16.18*/routes/*16.24*/.Application.atualizaPeriodo)),format.raw/*16.52*/("""" method="post">
			<ul style="list-style:none;">
            	<span style="float:left;margin-left:0px;font-size:20px;">Periodo Atual:</span>
            	<input type="number" style="margin-bot:10px;height:25px;width:35px" min="1" max="10" name="periodo" title="Periodo entre 1 e 10" required value=""""),_display_(Seq[Any](/*19.160*/plano/*19.165*/.periodoAtual)),format.raw/*19.178*/("""" ><br/>
                <input type="submit" style="position:center;margin-top=10px;float:center;" title="Periodo entre 1 e 10"  value="Alterar">
			</ul>
		</form>
			<div><br/>
           <span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Informacoes Uteis</span><br></br>
                        			<strong><span class="periodoCreditos">Periodo Atual: """),_display_(Seq[Any](/*25.82*/plano/*25.87*/.getPeriodoAtual())),format.raw/*25.105*/("""</span></strong><br>
			<span class="periodoCreditos">Creditos disciplinas nao alocadas: """),_display_(Seq[Any](/*26.70*/plano/*26.75*/.totalCreditosCadeirasNaoAlocadas())),format.raw/*26.110*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos passados: """),_display_(Seq[Any](/*27.63*/plano/*27.68*/.getCreditosPeriodosPassados())),format.raw/*27.98*/("""</span><br>
			<span class="periodoCreditos">Creditos periodo atual: """),_display_(Seq[Any](/*28.59*/plano/*28.64*/.getCreditosPeriodoAtual())),format.raw/*28.90*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos Planejados: """),_display_(Seq[Any](/*29.65*/plano/*29.70*/.getCreditosPeriodosFuturos())),format.raw/*29.99*/("""</span><br>
			<span class="periodoCreditos">Creditos minimos que faltam para me formar: """),_display_(Seq[Any](/*30.79*/plano/*30.84*/.getCreditosQueFaltamParaSeFormar())),format.raw/*30.119*/("""</span><br>

			<strong><nome>Periodos abaixo do minimo de creditos:</nome></strong><br>
			"""),_display_(Seq[Any](/*33.5*/for(periodo <- plano.periodosComMenosQueMinimoDeCreditos()) yield /*33.64*/{_display_(Seq[Any](format.raw/*33.65*/("""
				<strong><span class="periodoCreditos"> """),_display_(Seq[Any](/*34.45*/periodo/*34.52*/.toString())),format.raw/*34.63*/("""</span></strong><br>
			""")))})),format.raw/*35.5*/("""
			</div>
		</div>



	<div class="periodo">
	<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Cadeiras disponiveis</span>
	<ul style="list-style:none;"> 
		"""),_display_(Seq[Any](/*44.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*44.57*/ {_display_(Seq[Any](format.raw/*44.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*45.33*/cadeira/*45.40*/.getNome())),format.raw/*45.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*47.35*/cadeira/*47.42*/.getNome())),format.raw/*47.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*48.31*/cadeira/*48.38*/.getCreditos())),format.raw/*48.52*/(""" """),_display_(Seq[Any](/*48.54*/Messages("creditos"))),format.raw/*48.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*49.48*/cadeira/*49.55*/.getDificuldade())),format.raw/*49.72*/("""</label>
	  	</div>
	""")))})),format.raw/*51.3*/(""" 

	</ul>
	<span class="periodoCreditos">Arraste para alocar</span>
	</div>

	<div>
	"""),_display_(Seq[Any](/*58.3*/for(periodo <- plano.getPeriodos()) yield /*58.38*/ {_display_(Seq[Any](format.raw/*58.40*/("""
	
		<div id=""""),_display_(Seq[Any](/*60.13*/periodo/*60.20*/.getNumero())),format.raw/*60.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">

		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*64.96*/periodo/*64.103*/.getNumero())),format.raw/*64.115*/(""" """),_display_(Seq[Any](/*64.117*/Messages("nPeriodo"))),format.raw/*64.137*/(""" </span>
			"""),_display_(Seq[Any](/*65.5*/for(cadeira <- periodo.getCadeiras()) yield /*65.42*/ {_display_(Seq[Any](format.raw/*65.44*/("""
				"""),_display_(Seq[Any](/*66.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*66.57*/ {_display_(Seq[Any](format.raw/*66.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*67.34*/cadeira/*67.41*/.getNome())),format.raw/*67.51*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*68.75*/cadeira/*68.82*/.getNome())),format.raw/*68.92*/("""','true')">
				""")))}/*69.7*/else/*69.12*/{_display_(Seq[Any](format.raw/*69.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*70.39*/cadeira/*70.46*/.getNome())),format.raw/*70.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*71.75*/cadeira/*71.82*/.getNome())),format.raw/*71.92*/("""','true')">
				""")))})),format.raw/*72.6*/("""
		  		<center> <span>"""),_display_(Seq[Any](/*73.23*/cadeira/*73.30*/.getNome())),format.raw/*73.40*/("""</span></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*74.32*/cadeira/*74.39*/.getCreditos())),format.raw/*74.53*/(""" """),_display_(Seq[Any](/*74.55*/Messages("creditos"))),format.raw/*74.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*75.49*/cadeira/*75.56*/.getDificuldade())),format.raw/*75.73*/("""</label>
		  	</div>

		""")))})),format.raw/*78.4*/(""" 
		
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*81.34*/periodo/*81.41*/.getCreditos())),format.raw/*81.55*/(""" """),_display_(Seq[Any](/*81.57*/Messages("creditos"))),format.raw/*81.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*82.50*/periodo/*82.57*/.getDificuldadeTotal())),format.raw/*82.79*/("""</span>
		</div>
	""")))})),format.raw/*84.3*/("""
	</div>
""")))})),format.raw/*86.2*/("""
</body>"""))}
    }
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 04:15:37 BRT 2014
                    SOURCE: C:/Users/Igor/si1/PSI1/app/views/index.scala.html
                    HASH: ba8845c8274f0828019215f6efae7c50b1a4b823
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1461->395|1498->423|1538->425|1590->441|1636->465|1732->525|1747->531|1797->559|2138->863|2153->868|2189->881|2627->1283|2641->1288|2682->1306|2809->1397|2823->1402|2881->1437|2992->1512|3006->1517|3058->1547|3165->1618|3179->1623|3227->1649|3340->1726|3354->1731|3405->1760|3532->1851|3546->1856|3604->1891|3735->1987|3810->2046|3849->2047|3931->2093|3947->2100|3980->2111|4037->2137|4281->2346|4350->2399|4390->2401|4460->2435|4476->2442|4508->2452|4651->2559|4667->2566|4699->2576|4784->2625|4800->2632|4836->2646|4874->2648|4916->2668|5009->2725|5025->2732|5064->2749|5119->2773|5247->2866|5298->2901|5338->2903|5391->2920|5407->2927|5441->2939|5726->3188|5743->3195|5778->3207|5817->3209|5860->3229|5909->3243|5962->3280|6002->3282|6044->3289|6104->3340|6144->3342|6215->3377|6231->3384|6263->3394|6394->3489|6410->3496|6442->3506|6478->3525|6491->3530|6530->3531|6606->3571|6622->3578|6654->3588|6785->3683|6801->3690|6833->3700|6882->3718|6942->3742|6958->3749|6990->3759|7075->3808|7091->3815|7127->3829|7165->3831|7207->3851|7301->3909|7317->3916|7356->3933|7415->3961|7500->4010|7516->4017|7552->4031|7590->4033|7632->4053|7726->4111|7742->4118|7786->4140|7838->4161|7881->4173
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|40->12|40->12|44->16|44->16|44->16|47->19|47->19|47->19|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|61->33|61->33|61->33|62->34|62->34|62->34|63->35|72->44|72->44|72->44|73->45|73->45|73->45|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|77->49|77->49|77->49|79->51|86->58|86->58|86->58|88->60|88->60|88->60|92->64|92->64|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|101->73|101->73|101->73|102->74|102->74|102->74|102->74|102->74|103->75|103->75|103->75|106->78|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|112->84|114->86
                    -- GENERATED --
                */
            