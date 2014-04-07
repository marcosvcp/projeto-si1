
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
			<span class="periodoCreditos">"""),_display_(Seq[Any](/*28.35*/Messages("disciplinasNaoAlocadas"))),format.raw/*28.69*/(""" """),_display_(Seq[Any](/*28.71*/plano/*28.76*/.totalCreditosCadeirasNaoAlocadas())),format.raw/*28.111*/("""</span><br>
			<span class="periodoCreditos">"""),_display_(Seq[Any](/*29.35*/Messages("creditosUltrapassados"))),format.raw/*29.68*/(""" """),_display_(Seq[Any](/*29.70*/plano/*29.75*/.getCreditosPeriodosPassados())),format.raw/*29.105*/("""</span><br>
			<span class="periodoCreditos">"""),_display_(Seq[Any](/*30.35*/Messages("periodoAtual"))),format.raw/*30.59*/(""" """),_display_(Seq[Any](/*30.61*/plano/*30.66*/.getCreditosPeriodoAtual())),format.raw/*30.92*/("""</span><br>
			<span class="periodoCreditos">"""),_display_(Seq[Any](/*31.35*/Messages("creditosPlanejados"))),format.raw/*31.65*/(""" """),_display_(Seq[Any](/*31.67*/plano/*31.72*/.getCreditosPeriodosFuturos())),format.raw/*31.101*/("""</span><br>
			<span class="periodoCreditos">"""),_display_(Seq[Any](/*32.35*/Messages("minimosPraSeFormar"))),format.raw/*32.65*/(""" """),_display_(Seq[Any](/*32.67*/plano/*32.72*/.getCreditosQueFaltamParaSeFormar())),format.raw/*32.107*/("""</span><br>

			<strong><nome>"""),_display_(Seq[Any](/*34.19*/Messages("periodosErrados"))),format.raw/*34.46*/("""</nome></strong><br>
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
				<div class="alocadas-errada" title=""""),_display_(Seq[Any](/*81.42*/cadeira/*81.49*/.toString())),format.raw/*81.60*/("""" id=""""),_display_(Seq[Any](/*81.67*/cadeira/*81.74*/.getNome())),format.raw/*81.84*/("""" draggable="true" 
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
                    DATE: Mon Apr 07 12:49:30 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-heroku/app/views/index.scala.html
                    HASH: 07ccb3dda0a92d023d4fc7fec7fc99186b2d2b90
                    MATRIX: 785->1|928->34|956->53|1092->154|1106->160|1163->196|1240->238|1254->244|1309->278|1451->385|1488->413|1528->415|1586->437|1632->461|1738->531|1753->537|1803->565|2141->866|2156->871|2192->884|2624->1280|2638->1285|2679->1303|2770->1358|2826->1392|2864->1394|2878->1399|2936->1434|3018->1480|3073->1513|3111->1515|3125->1520|3178->1550|3260->1596|3306->1620|3344->1622|3358->1627|3406->1653|3488->1699|3540->1729|3578->1731|3592->1736|3644->1765|3726->1811|3778->1841|3816->1843|3830->1848|3888->1883|3955->1914|4004->1941|4064->1966|4139->2025|4178->2026|4259->2071|4275->2078|4308->2089|4364->2114|4599->2314|4668->2367|4708->2369|4777->2402|4793->2409|4825->2419|4871->2429|4887->2436|4920->2447|5068->2559|5084->2566|5116->2576|5207->2631|5223->2638|5259->2652|5297->2654|5339->2674|5431->2730|5447->2737|5486->2754|5539->2776|5660->2862|5711->2897|5751->2899|5790->2903|5848->2952|5887->2953|5936->2966|5952->2973|5986->2985|6147->3115|6186->3119|6245->3169|6284->3170|6333->3183|6349->3190|6383->3202|6542->3330|6581->3334|6639->3383|6678->3384|6727->3397|6743->3404|6777->3416|6937->3545|7102->3674|7119->3681|7154->3693|7193->3695|7236->3715|7284->3728|7337->3765|7377->3767|7418->3773|7478->3824|7518->3826|7588->3860|7604->3867|7636->3877|7699->3904|7715->3911|7748->3922|7860->3998|7876->4005|7908->4015|7943->4033|7956->4038|7995->4039|8073->4081|8089->4088|8122->4099|8165->4106|8181->4113|8213->4123|8343->4217|8359->4224|8391->4234|8444->4256|8523->4299|8539->4306|8571->4316|8663->4372|8679->4379|8715->4393|8753->4395|8795->4415|8888->4472|8904->4479|8943->4496|9094->4616|9176->4662|9192->4669|9228->4683|9266->4685|9308->4705|9401->4762|9417->4769|9461->4791|9511->4810|9552->4820
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|46->18|46->18|46->18|49->21|49->21|49->21|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|81->53|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|92->64|93->65|93->65|93->65|94->66|94->66|94->66|96->68|97->69|97->69|97->69|98->70|98->70|98->70|100->72|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|115->87|115->87|115->87|119->91|122->94|122->94|122->94|122->94|122->94|123->95|123->95|123->95|125->97|127->99
                    -- GENERATED --
                */
            