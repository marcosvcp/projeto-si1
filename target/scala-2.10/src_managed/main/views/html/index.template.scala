
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
		"""),_display_(Seq[Any](/*61.4*/if(periodo.getNumero() < plano.getPeriodoAtual())/*61.53*/{_display_(Seq[Any](format.raw/*61.54*/("""
		<div id=""""),_display_(Seq[Any](/*62.13*/periodo/*62.20*/.getNumero())),format.raw/*62.32*/("""" class="periodoPassado" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">			
		""")))})),format.raw/*64.4*/("""
		"""),_display_(Seq[Any](/*65.4*/if(periodo.getNumero() == plano.getPeriodoAtual())/*65.54*/{_display_(Seq[Any](format.raw/*65.55*/("""
		<div id=""""),_display_(Seq[Any](/*66.13*/periodo/*66.20*/.getNumero())),format.raw/*66.32*/("""" class="periodoAtual" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">			
		""")))})),format.raw/*68.4*/("""
		"""),_display_(Seq[Any](/*69.4*/if(periodo.getNumero() > plano.getPeriodoAtual())/*69.53*/{_display_(Seq[Any](format.raw/*69.54*/("""
		<div id=""""),_display_(Seq[Any](/*70.13*/periodo/*70.20*/.getNumero())),format.raw/*70.32*/("""" class="periodoFuturo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">			
		""")))})),format.raw/*72.4*/("""

		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*75.96*/periodo/*75.103*/.getNumero())),format.raw/*75.115*/(""" """),_display_(Seq[Any](/*75.117*/Messages("nPeriodo"))),format.raw/*75.137*/(""" </span>
			"""),_display_(Seq[Any](/*76.5*/for(cadeira <- periodo.getCadeiras()) yield /*76.42*/ {_display_(Seq[Any](format.raw/*76.44*/("""
				"""),_display_(Seq[Any](/*77.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*77.57*/ {_display_(Seq[Any](format.raw/*77.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*78.34*/cadeira/*78.41*/.getNome())),format.raw/*78.51*/("""" draggable="true" title=""""),_display_(Seq[Any](/*78.78*/cadeira/*78.85*/.toString())),format.raw/*78.96*/(""""
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*79.75*/cadeira/*79.82*/.getNome())),format.raw/*79.92*/("""','true')">
				""")))}/*80.7*/else/*80.12*/{_display_(Seq[Any](format.raw/*80.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*81.39*/cadeira/*81.46*/.getNome())),format.raw/*81.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*82.75*/cadeira/*82.82*/.getNome())),format.raw/*82.92*/("""','true')">
				
				""")))})),format.raw/*84.6*/("""
		  		<center> <label class="nome"><span>"""),_display_(Seq[Any](/*85.43*/cadeira/*85.50*/.getNome())),format.raw/*85.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*86.32*/cadeira/*86.39*/.getCreditos())),format.raw/*86.53*/(""" """),_display_(Seq[Any](/*86.55*/Messages("creditos"))),format.raw/*86.75*/("""</label>
		  		<label class="dificuldade"> Dificuldade: """),_display_(Seq[Any](/*87.49*/cadeira/*87.56*/.getDificuldade())),format.raw/*87.73*/("""</label>
		  		<span class="remove" style="margin-top: 15px;margin-left:140px;" title="remover"></span>
		  	</div>

		""")))})),format.raw/*91.4*/(""" 
		
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*94.34*/periodo/*94.41*/.getCreditos())),format.raw/*94.55*/(""" """),_display_(Seq[Any](/*94.57*/Messages("creditos"))),format.raw/*94.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*95.50*/periodo/*95.57*/.getDificuldadeTotal())),format.raw/*95.79*/("""</span>
		</div>
	""")))})),format.raw/*97.3*/("""
	</div>
""")))})),format.raw/*99.2*/("""
</body>"""))}
    }
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Apr 06 02:12:13 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/index.scala.html
                    HASH: d075ff0761c903be7ac58d01794b1d579adaf6ef
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1461->395|1498->423|1538->425|1598->449|1644->473|1755->548|1770->554|1820->582|2161->886|2176->891|2212->904|2650->1306|2664->1311|2705->1329|2832->1420|2846->1425|2904->1460|3015->1535|3029->1540|3081->1570|3188->1641|3202->1646|3250->1672|3363->1749|3377->1754|3428->1783|3555->1874|3569->1879|3627->1914|3758->2010|3833->2069|3872->2070|3954->2116|3970->2123|4003->2134|4060->2160|4304->2369|4373->2422|4413->2424|4483->2458|4499->2465|4531->2475|4577->2485|4593->2492|4626->2503|4776->2617|4792->2624|4824->2634|4916->2690|4932->2697|4968->2711|5006->2713|5048->2733|5141->2790|5157->2797|5196->2814|5251->2838|5379->2931|5430->2966|5470->2968|5510->2973|5568->3022|5607->3023|5657->3037|5673->3044|5707->3056|5870->3188|5910->3193|5969->3243|6008->3244|6058->3258|6074->3265|6108->3277|6269->3407|6309->3412|6367->3461|6406->3462|6456->3476|6472->3483|6506->3495|6668->3626|6836->3758|6853->3765|6888->3777|6927->3779|6970->3799|7019->3813|7072->3850|7112->3852|7154->3859|7214->3910|7254->3912|7325->3947|7341->3954|7373->3964|7436->3991|7452->3998|7485->4009|7598->4086|7614->4093|7646->4103|7682->4122|7695->4127|7734->4128|7810->4168|7826->4175|7858->4185|7989->4280|8005->4287|8037->4297|8092->4321|8172->4365|8188->4372|8220->4382|8313->4439|8329->4446|8365->4460|8403->4462|8445->4482|8539->4540|8555->4547|8594->4564|8749->4688|8834->4737|8850->4744|8886->4758|8924->4760|8966->4780|9060->4838|9076->4845|9120->4867|9172->4888|9215->4900
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|46->18|46->18|46->18|49->21|49->21|49->21|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|64->36|64->36|64->36|65->37|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|81->53|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|92->64|93->65|93->65|93->65|94->66|94->66|94->66|96->68|97->69|97->69|97->69|98->70|98->70|98->70|100->72|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|115->87|115->87|115->87|119->91|122->94|122->94|122->94|122->94|122->94|123->95|123->95|123->95|125->97|127->99
                    -- GENERATED --
                */
            