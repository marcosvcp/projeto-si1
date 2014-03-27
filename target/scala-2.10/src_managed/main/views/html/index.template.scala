
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
		<form action=""""),_display_(Seq[Any](/*17.18*/routes/*17.24*/.Application.atualizaPeriodo)),format.raw/*17.52*/("""" method="post">
			<ul style="list-style:none;">
            	<label for="periodo">Periodo Atual</label>
            	<input type="number" name="periodo" value=""""),_display_(Seq[Any](/*20.58*/plano/*20.63*/.periodoAtual)),format.raw/*20.76*/("""" >
                <input type="submit" class="btn btn-primary" value="Alterar periodo">
			</ul>
		</form>

           <span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Informacoes Uteis</span>
                        			<strong><span class="periodoCreditos">Periodo Atual: """),_display_(Seq[Any](/*26.82*/plano/*26.87*/.getPeriodoAtual())),format.raw/*26.105*/("""</span></strong><br>
			<span class="periodoCreditos">Creditos disciplinas nao alocadas: """),_display_(Seq[Any](/*27.70*/plano/*27.75*/.totalCreditosCadeirasNaoAlocadas())),format.raw/*27.110*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos passados: """),_display_(Seq[Any](/*28.63*/plano/*28.68*/.getCreditosPeriodosPassados())),format.raw/*28.98*/("""</span><br>
			<span class="periodoCreditos">Creditos periodo atual: """),_display_(Seq[Any](/*29.59*/plano/*29.64*/.getCreditosPeriodoAtual())),format.raw/*29.90*/("""</span><br>
			<span class="periodoCreditos">Creditos periodos Planejados: """),_display_(Seq[Any](/*30.65*/plano/*30.70*/.getCreditosPeriodosFuturos())),format.raw/*30.99*/("""</span><br>
			<span class="periodoCreditos">Creditos minimos que faltam para me formar: """),_display_(Seq[Any](/*31.79*/plano/*31.84*/.getCreditosQueFaltamParaSeFormar())),format.raw/*31.119*/("""</span><br>

			<strong><nome>Periodos abaixo do minimo de creditos:</nome></strong><br>
			"""),_display_(Seq[Any](/*34.5*/for(periodo <- plano.periodosComMenosQueMinimoDeCreditos()) yield /*34.64*/{_display_(Seq[Any](format.raw/*34.65*/("""
				<strong><span class="periodoCreditos"> """),_display_(Seq[Any](/*35.45*/periodo/*35.52*/.toString())),format.raw/*35.63*/("""</span></strong><br>
			""")))})),format.raw/*36.5*/("""
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

	<div >

	"""),_display_(Seq[Any](/*59.3*/for(periodo <- plano.getPeriodos()) yield /*59.38*/ {_display_(Seq[Any](format.raw/*59.40*/("""
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
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*73.43*/cadeira/*73.50*/.getNome())),format.raw/*73.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*74.32*/cadeira/*74.39*/.getCreditos())),format.raw/*74.53*/(""" """),_display_(Seq[Any](/*74.55*/Messages("creditos"))),format.raw/*74.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*75.49*/cadeira/*75.56*/.getDificuldade())),format.raw/*75.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>

		""")))})),format.raw/*79.4*/(""" 
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
                    DATE: Wed Mar 26 21:06:33 GMT-03:00 2014
                    SOURCE: C:/Users/Dinho/si1/projeto-si1/app/views/index.scala.html
                    HASH: 907406089b9e89dc9127c7f96d051927769e281f
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1488->421|1503->427|1554->456|1596->463|1633->491|1673->493|1725->509|1771->533|1900->626|1915->632|1965->660|2167->826|2181->831|2216->844|2575->1167|2589->1172|2630->1190|2757->1281|2771->1286|2829->1321|2940->1396|2954->1401|3006->1431|3113->1502|3127->1507|3175->1533|3288->1610|3302->1615|3353->1644|3480->1735|3494->1740|3552->1775|3683->1871|3758->1930|3797->1931|3879->1977|3895->1984|3928->1995|3985->2021|4218->2219|4287->2272|4327->2274|4397->2308|4413->2315|4445->2325|4588->2432|4604->2439|4636->2449|4721->2498|4737->2505|4773->2519|4811->2521|4853->2541|4946->2598|4962->2605|5001->2622|5056->2646|5187->2742|5238->2777|5278->2779|5328->2793|5344->2800|5378->2812|5663->3061|5680->3068|5715->3080|5754->3082|5797->3102|5846->3116|5899->3153|5939->3155|5981->3162|6041->3213|6081->3215|6152->3250|6168->3257|6200->3267|6331->3362|6347->3369|6379->3379|6415->3398|6428->3403|6467->3404|6543->3444|6559->3451|6591->3461|6722->3556|6738->3563|6770->3573|6819->3591|6899->3635|6915->3642|6947->3652|7040->3709|7056->3716|7092->3730|7130->3732|7172->3752|7266->3810|7282->3817|7321->3834|7429->3911|7510->3956|7526->3963|7562->3977|7600->3979|7642->3999|7736->4057|7752->4064|7796->4086|7848->4107|7891->4119
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|45->17|45->17|45->17|48->20|48->20|48->20|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|62->34|62->34|62->34|63->35|63->35|63->35|64->36|72->44|72->44|72->44|73->45|73->45|73->45|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|77->49|77->49|77->49|79->51|87->59|87->59|87->59|88->60|88->60|88->60|92->64|92->64|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|101->73|101->73|101->73|102->74|102->74|102->74|102->74|102->74|103->75|103->75|103->75|107->79|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|112->84|114->86
                    -- GENERATED --
                */
            