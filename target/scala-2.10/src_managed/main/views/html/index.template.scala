
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
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Informacoes Uteis</span>
			<ul style="list-style:none;"> 
			<nome>Periodo Atual</nome>
			<select class="selectpicker" data-width="100px" name="periodo" >
				"""),_display_(Seq[Any](/*21.6*/for(periodo <- plano.getPeriodos()) yield /*21.41*/{_display_(Seq[Any](format.raw/*21.42*/("""
					<option value="""),_display_(Seq[Any](/*22.21*/periodo/*22.28*/.getNumero())),format.raw/*22.40*/(""" name="periodo" >"""),_display_(Seq[Any](/*22.58*/periodo/*22.65*/.getNumero())),format.raw/*22.77*/("""</option><br>
				""")))})),format.raw/*23.6*/("""
			</select><button type="submit" class="btn btn-primary" type="button">Alterar periodo</button>
				
			</ul>
			<strong><span class="periodoCreditos">Periodo Atual: """),_display_(Seq[Any](/*27.58*/plano/*27.63*/.getPeriodoAtual())),format.raw/*27.81*/("""</span></strong><br>
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
	

	
	<div class="periodo">
	<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:0px;"> Cadeiras disponiveis</span>
	<ul style="list-style:none;"> 
		"""),_display_(Seq[Any](/*45.4*/for(cadeira <- plano.getCadeiraDispniveisOrdenadas()) yield /*45.57*/ {_display_(Seq[Any](format.raw/*45.59*/("""
		<div class="disponiveis" id=""""),_display_(Seq[Any](/*46.33*/cadeira/*46.40*/.getNome())),format.raw/*46.50*/(""""	draggable="true" 
		ondragstart="drag(event)" ondragend="dragEnd()">
	  		<center><label class="nome">"""),_display_(Seq[Any](/*48.35*/cadeira/*48.42*/.getNome())),format.raw/*48.52*/("""</label></center>
		  	<label class="creditos">"""),_display_(Seq[Any](/*49.31*/cadeira/*49.38*/.getCreditos())),format.raw/*49.52*/(""" """),_display_(Seq[Any](/*49.54*/Messages("creditos"))),format.raw/*49.74*/("""</label>
		  	<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*50.48*/cadeira/*50.55*/.getDificuldade())),format.raw/*50.72*/("""</label>
	  	</div>
	""")))})),format.raw/*52.3*/(""" 
	
	</ul>
	<span class="periodoCreditos">Arraste para alocar</span>
	</div>
	
	<div >
	
	"""),_display_(Seq[Any](/*60.3*/for(periodo <- plano.getPeriodos()) yield /*60.38*/ {_display_(Seq[Any](format.raw/*60.40*/("""
		<div id=""""),_display_(Seq[Any](/*61.13*/periodo/*61.20*/.getNumero())),format.raw/*61.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		
		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*65.96*/periodo/*65.103*/.getNumero())),format.raw/*65.115*/(""" """),_display_(Seq[Any](/*65.117*/Messages("nPeriodo"))),format.raw/*65.137*/(""" </span>
			"""),_display_(Seq[Any](/*66.5*/for(cadeira <- periodo.getCadeiras()) yield /*66.42*/ {_display_(Seq[Any](format.raw/*66.44*/("""
				"""),_display_(Seq[Any](/*67.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*67.57*/ {_display_(Seq[Any](format.raw/*67.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*68.34*/cadeira/*68.41*/.getNome())),format.raw/*68.51*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*69.75*/cadeira/*69.82*/.getNome())),format.raw/*69.92*/("""','true')">
				""")))}/*70.7*/else/*70.12*/{_display_(Seq[Any](format.raw/*70.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*71.39*/cadeira/*71.46*/.getNome())),format.raw/*71.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*72.75*/cadeira/*72.82*/.getNome())),format.raw/*72.92*/("""','true')">
				""")))})),format.raw/*73.6*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*74.43*/cadeira/*74.50*/.getNome())),format.raw/*74.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*75.32*/cadeira/*75.39*/.getCreditos())),format.raw/*75.53*/(""" """),_display_(Seq[Any](/*75.55*/Messages("creditos"))),format.raw/*75.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*76.49*/cadeira/*76.56*/.getDificuldade())),format.raw/*76.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*80.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*82.34*/periodo/*82.41*/.getCreditos())),format.raw/*82.55*/(""" """),_display_(Seq[Any](/*82.57*/Messages("creditos"))),format.raw/*82.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*83.50*/periodo/*83.57*/.getDificuldadeTotal())),format.raw/*83.79*/("""</span>
		</div>
	""")))})),format.raw/*85.3*/("""
	</div>
""")))})),format.raw/*87.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso,user:User): play.api.templates.HtmlFormat.Appendable = apply(plano,user)
    
    def f:((PlanoDeCurso,User) => play.api.templates.HtmlFormat.Appendable) = (plano,user) => apply(plano,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 22 04:37:41 BRT 2014
                    SOURCE: C:/Users/HOME/projeto-si1/app/views/index.scala.html
                    HASH: 8973b1b89bc3455c1d9307e395b0954b0d5e822d
                    MATRIX: 785->1|929->34|959->56|1097->159|1111->165|1168->201|1246->244|1260->250|1315->284|1488->421|1503->427|1554->456|1596->463|1633->491|1673->493|1725->509|1771->533|2145->872|2196->907|2235->908|2293->930|2309->937|2343->949|2397->967|2413->974|2447->986|2498->1006|2707->1179|2721->1184|2761->1202|2888->1293|2902->1298|2960->1333|3071->1408|3085->1413|3137->1443|3244->1514|3258->1519|3306->1545|3419->1622|3433->1627|3484->1656|3611->1747|3625->1752|3683->1787|3815->1884|3890->1943|3929->1944|4011->1990|4027->1997|4060->2008|4117->2034|4352->2234|4421->2287|4461->2289|4531->2323|4547->2330|4579->2340|4722->2447|4738->2454|4770->2464|4855->2513|4871->2520|4907->2534|4945->2536|4987->2556|5080->2613|5096->2620|5135->2637|5190->2661|5324->2760|5375->2795|5415->2797|5465->2811|5481->2818|5515->2830|5802->3081|5819->3088|5854->3100|5893->3102|5936->3122|5985->3136|6038->3173|6078->3175|6120->3182|6180->3233|6220->3235|6291->3270|6307->3277|6339->3287|6470->3382|6486->3389|6518->3399|6554->3418|6567->3423|6606->3424|6682->3464|6698->3471|6730->3481|6861->3576|6877->3583|6909->3593|6958->3611|7038->3655|7054->3662|7086->3672|7179->3729|7195->3736|7231->3750|7269->3752|7311->3772|7405->3830|7421->3837|7460->3854|7573->3936|7654->3981|7670->3988|7706->4002|7744->4004|7786->4024|7880->4082|7896->4089|7940->4111|7992->4132|8035->4144
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|51->23|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|64->36|64->36|64->36|65->37|73->45|73->45|73->45|74->46|74->46|74->46|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|78->50|78->50|78->50|80->52|88->60|88->60|88->60|89->61|89->61|89->61|93->65|93->65|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|108->80|110->82|110->82|110->82|110->82|110->82|111->83|111->83|111->83|113->85|115->87
                    -- GENERATED --
                */
            