
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
           <span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Informacoes Uteis</span><br></br>
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
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*47.33*/cadeira/*47.40*/.getNome())),format.raw/*47.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*49.35*/cadeira/*49.42*/.getNome())),format.raw/*49.52*/("""</label></center>
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
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*69.34*/cadeira/*69.41*/.getNome())),format.raw/*69.51*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*70.75*/cadeira/*70.82*/.getNome())),format.raw/*70.92*/("""','true')">
				""")))}/*71.7*/else/*71.12*/{_display_(Seq[Any](format.raw/*71.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*72.39*/cadeira/*72.46*/.getNome())),format.raw/*72.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*73.75*/cadeira/*73.82*/.getNome())),format.raw/*73.92*/("""','true')">
				""")))})),format.raw/*74.6*/("""
		  		<center> <span>"""),_display_(Seq[Any](/*75.23*/cadeira/*75.30*/.getNome())),format.raw/*75.40*/("""</span></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*76.32*/cadeira/*76.39*/.getCreditos())),format.raw/*76.53*/(""" """),_display_(Seq[Any](/*76.55*/Messages("creditos"))),format.raw/*76.75*/("""</label>
		  		<label class="dificuldade"> Dificuldade: """),_display_(Seq[Any](/*77.49*/cadeira/*77.56*/.getDificuldade())),format.raw/*77.73*/("""</label>
		  	</div>

		""")))})),format.raw/*80.4*/(""" 
		
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*83.34*/periodo/*83.41*/.getCreditos())),format.raw/*83.55*/(""" """),_display_(Seq[Any](/*83.57*/Messages("creditos"))),format.raw/*83.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*84.50*/periodo/*84.57*/.getDificuldadeTotal())),format.raw/*84.79*/("""</span>
		</div>
	""")))})),format.raw/*86.3*/("""
	</div>
""")))})),format.raw/*88.2*/("""
</body>"""))}
    }
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 28 16:54:14 BRT 2014
                    SOURCE: C:/Users/Igor/si1/PSI1/app/views/index.scala.html
                    HASH: 7810e421562f91ea061455ac30224a3c3b9e9bd4
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1461->395|1498->423|1538->425|1598->449|1644->473|1755->548|1770->554|1820->582|2161->886|2176->891|2212->904|2650->1306|2664->1311|2705->1329|2832->1420|2846->1425|2904->1460|3015->1535|3029->1540|3081->1570|3188->1641|3202->1646|3250->1672|3363->1749|3377->1754|3428->1783|3555->1874|3569->1879|3627->1914|3758->2010|3833->2069|3872->2070|3954->2116|3970->2123|4003->2134|4060->2160|4304->2369|4373->2422|4413->2424|4483->2458|4499->2465|4531->2475|4674->2582|4690->2589|4722->2599|4807->2648|4823->2655|4859->2669|4897->2671|4939->2691|5032->2748|5048->2755|5087->2772|5142->2796|5270->2889|5321->2924|5361->2926|5414->2943|5430->2950|5464->2962|5749->3211|5766->3218|5801->3230|5840->3232|5883->3252|5932->3266|5985->3303|6025->3305|6067->3312|6127->3363|6167->3365|6238->3400|6254->3407|6286->3417|6417->3512|6433->3519|6465->3529|6501->3548|6514->3553|6553->3554|6629->3594|6645->3601|6677->3611|6808->3706|6824->3713|6856->3723|6905->3741|6965->3765|6981->3772|7013->3782|7098->3831|7114->3838|7150->3852|7188->3854|7230->3874|7324->3932|7340->3939|7379->3956|7438->3984|7523->4033|7539->4040|7575->4054|7613->4056|7655->4076|7749->4134|7765->4141|7809->4163|7861->4184|7904->4196
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|46->18|46->18|46->18|49->21|49->21|49->21|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|64->36|64->36|64->36|65->37|74->46|74->46|74->46|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|81->53|88->60|88->60|88->60|90->62|90->62|90->62|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|103->75|103->75|103->75|104->76|104->76|104->76|104->76|104->76|105->77|105->77|105->77|108->80|111->83|111->83|111->83|111->83|111->83|112->84|112->84|112->84|114->86|116->88
                    -- GENERATED --
                */
            