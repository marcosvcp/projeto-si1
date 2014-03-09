
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
	
	<div >
	"""),_display_(Seq[Any](/*15.3*/for(periodo <- plano.getPeriodos()) yield /*15.38*/ {_display_(Seq[Any](format.raw/*15.40*/("""
		<div id=""""),_display_(Seq[Any](/*16.13*/periodo/*16.20*/.getNumero())),format.raw/*16.32*/("""" class="periodo" ondrop="drop(event, this)"
			ondragover="allowDrop(event,this)" ondragleave="leave(event, this)">
		
		<ul style="list-style:none;">
			<span style="width:190px;height:30px;font-size:20px;margin-bottom:10px;margin-left:-40px;">"""),_display_(Seq[Any](/*20.96*/periodo/*20.103*/.getNumero())),format.raw/*20.115*/(""" """),_display_(Seq[Any](/*20.117*/Messages("nPeriodo"))),format.raw/*20.137*/(""" </span>
			"""),_display_(Seq[Any](/*21.5*/for(cadeira <- periodo.getCadeiras()) yield /*21.42*/ {_display_(Seq[Any](format.raw/*21.44*/("""
				"""),_display_(Seq[Any](/*22.6*/if(plano.isAlocadaNoLugarCorreto(cadeira, periodo))/*22.57*/ {_display_(Seq[Any](format.raw/*22.59*/("""
		  		<div class="alocadas" id=""""),_display_(Seq[Any](/*23.34*/cadeira/*23.41*/.getNome())),format.raw/*23.51*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*24.75*/cadeira/*24.82*/.getNome())),format.raw/*24.92*/("""','true')">
				""")))}/*25.7*/else/*25.12*/{_display_(Seq[Any](format.raw/*25.13*/("""
				<div class="alocadas-errada" id=""""),_display_(Seq[Any](/*26.39*/cadeira/*26.46*/.getNome())),format.raw/*26.56*/("""" draggable="true" 
				ondragstart="drag(event)" ondragend="dragEnd()" onclick="remCadeira('"""),_display_(Seq[Any](/*27.75*/cadeira/*27.82*/.getNome())),format.raw/*27.92*/("""','true')">
				""")))})),format.raw/*28.6*/("""
		  		<center><label class="nome"> <span>"""),_display_(Seq[Any](/*29.43*/cadeira/*29.50*/.getNome())),format.raw/*29.60*/("""</span></label></center>
		  		<label class="creditos">"""),_display_(Seq[Any](/*30.32*/cadeira/*30.39*/.getCreditos())),format.raw/*30.53*/(""" """),_display_(Seq[Any](/*30.55*/Messages("creditos"))),format.raw/*30.75*/("""</label>
		  		<label class="dificuldade"> dificuldade: """),_display_(Seq[Any](/*31.49*/cadeira/*31.56*/.getDificuldade())),format.raw/*31.73*/("""</label>
		  		<span style="margin-top: 20px;" ></span>	
		  	</div>
		  	
		""")))})),format.raw/*35.4*/(""" 
		</ul>
		<span class="periodoCreditos">"""),_display_(Seq[Any](/*37.34*/periodo/*37.41*/.getCreditos())),format.raw/*37.55*/(""" """),_display_(Seq[Any](/*37.57*/Messages("creditos"))),format.raw/*37.77*/("""</span>
		<span class="periodoDificuldade">Dificuldade: """),_display_(Seq[Any](/*38.50*/periodo/*38.57*/.getDificuldadeTotal())),format.raw/*38.79*/("""</span>
		</div>
	""")))})),format.raw/*40.3*/("""
	</div>
""")))})),format.raw/*42.2*/("""
</body>
"""))}
    }
    
    def render(plano:PlanoDeCurso): play.api.templates.HtmlFormat.Appendable = apply(plano)
    
    def f:((PlanoDeCurso) => play.api.templates.HtmlFormat.Appendable) = (plano) => apply(plano)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 09 18:52:14 BRT 2014
                    SOURCE: /home/marcos/Documents/projeto-atualizado/app/views/index.scala.html
                    HASH: f036f8ba974c921a0ce42498e4c0a41c42148bd3
                    MATRIX: 780->1|911->22|939->41|1075->142|1089->148|1146->184|1223->226|1237->232|1292->266|1462->400|1477->406|1528->435|1569->441|1600->463|1640->465|1691->480|1737->504|1799->531|1850->566|1890->568|1939->581|1955->588|1989->600|2272->847|2289->854|2324->866|2363->868|2406->888|2454->901|2507->938|2547->940|2588->946|2648->997|2688->999|2758->1033|2774->1040|2806->1050|2936->1144|2952->1151|2984->1161|3019->1179|3032->1184|3071->1185|3146->1224|3162->1231|3194->1241|3324->1335|3340->1342|3372->1352|3420->1369|3499->1412|3515->1419|3547->1429|3639->1485|3655->1492|3691->1506|3729->1508|3771->1528|3864->1585|3880->1592|3919->1609|4028->1687|4107->1730|4123->1737|4159->1751|4197->1753|4239->1773|4332->1830|4348->1837|4392->1859|4442->1878|4483->1888
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|43->15|43->15|43->15|44->16|44->16|44->16|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|63->35|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|68->40|70->42
                    -- GENERATED --
                */
            