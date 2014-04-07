// @SOURCE:C:/Users/Dinho/si1/projeto-si1/conf/routes
// @HASH:6514e2144d714b419fe0418562aea14a593659a9
// @DATE:Mon Apr 07 00:28:08 GMT-03:00 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:7
private[this] lazy val controllers_Application_atualizaPeriodo1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("atualizaPeriodo"))))
        

// @LINE:8
private[this] lazy val controllers_Application_atualizaPeriodo2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("atualizaPeriodo"))))
        

// @LINE:11
private[this] lazy val controllers_Application_login3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:12
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:13
private[this] lazy val controllers_Application_remCadeira5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remCadeira/"),DynamicPart("cadeira", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Application_remCadeira6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remCadeira/"),DynamicPart("cadeira", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Application_addCadeira7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addCadeira/"),DynamicPart("cadeira", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Application_cadastroPage8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:19
private[this] lazy val controllers_Application_cadastro9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:20
private[this] lazy val controllers_Application_authenticate10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:21
private[this] lazy val controllers_Application_logout11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:24
private[this] lazy val controllers_Application_mostraPlanosDosUsuarios12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("RedeSocial"))))
        

// @LINE:25
private[this] lazy val controllers_Application_mostraGradeUsuario13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("GradeDoUsuario"))))
        

// @LINE:26
private[this] lazy val controllers_Application_pesquisa14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("RedeSocial"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """atualizaPeriodo""","""controllers.Application.atualizaPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """atualizaPeriodo""","""controllers.Application.atualizaPeriodo()"""),("""GET""", prefix,"""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>""","""controllers.Application.addCadeira(cadeira:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Application.cadastroPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Application.cadastro()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """RedeSocial""","""controllers.Application.mostraPlanosDosUsuarios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """GradeDoUsuario""","""controllers.Application.mostraGradeUsuario(email:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """RedeSocial""","""controllers.Application.pesquisa()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """home"""))
   }
}
        

// @LINE:7
case controllers_Application_atualizaPeriodo1(params) => {
   call { 
        invokeHandler(controllers.Application.atualizaPeriodo(), HandlerDef(this, "controllers.Application", "atualizaPeriodo", Nil,"POST", """""", Routes.prefix + """atualizaPeriodo"""))
   }
}
        

// @LINE:8
case controllers_Application_atualizaPeriodo2(params) => {
   call { 
        invokeHandler(controllers.Application.atualizaPeriodo(), HandlerDef(this, "controllers.Application", "atualizaPeriodo", Nil,"GET", """""", Routes.prefix + """atualizaPeriodo"""))
   }
}
        

// @LINE:11
case controllers_Application_login3(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """"""))
   }
}
        

// @LINE:12
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:13
case controllers_Application_remCadeira5(params) => {
   call(params.fromPath[String]("cadeira", None)) { (cadeira) =>
        invokeHandler(controllers.Application.remCadeira(cadeira), HandlerDef(this, "controllers.Application", "remCadeira", Seq(classOf[String]),"GET", """""", Routes.prefix + """remCadeira/$cadeira<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Application_remCadeira6(params) => {
   call(params.fromPath[String]("cadeira", None)) { (cadeira) =>
        invokeHandler(controllers.Application.remCadeira(cadeira), HandlerDef(this, "controllers.Application", "remCadeira", Seq(classOf[String]),"POST", """""", Routes.prefix + """remCadeira/$cadeira<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Application_addCadeira7(params) => {
   call(params.fromPath[String]("cadeira", None), params.fromPath[Int]("periodo", None)) { (cadeira, periodo) =>
        invokeHandler(controllers.Application.addCadeira(cadeira, periodo), HandlerDef(this, "controllers.Application", "addCadeira", Seq(classOf[String], classOf[Int]),"POST", """""", Routes.prefix + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Application_cadastroPage8(params) => {
   call { 
        invokeHandler(controllers.Application.cadastroPage(), HandlerDef(this, "controllers.Application", "cadastroPage", Nil,"GET", """Login""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:19
case controllers_Application_cadastro9(params) => {
   call { 
        invokeHandler(controllers.Application.cadastro(), HandlerDef(this, "controllers.Application", "cadastro", Nil,"POST", """""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:20
case controllers_Application_authenticate10(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:21
case controllers_Application_logout11(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:24
case controllers_Application_mostraPlanosDosUsuarios12(params) => {
   call { 
        invokeHandler(controllers.Application.mostraPlanosDosUsuarios(), HandlerDef(this, "controllers.Application", "mostraPlanosDosUsuarios", Nil,"GET", """RedeSocial""", Routes.prefix + """RedeSocial"""))
   }
}
        

// @LINE:25
case controllers_Application_mostraGradeUsuario13(params) => {
   call(params.fromQuery[String]("email", None)) { (email) =>
        invokeHandler(controllers.Application.mostraGradeUsuario(email), HandlerDef(this, "controllers.Application", "mostraGradeUsuario", Seq(classOf[String]),"GET", """""", Routes.prefix + """GradeDoUsuario"""))
   }
}
        

// @LINE:26
case controllers_Application_pesquisa14(params) => {
   call { 
        invokeHandler(controllers.Application.pesquisa(), HandlerDef(this, "controllers.Application", "pesquisa", Nil,"POST", """""", Routes.prefix + """RedeSocial"""))
   }
}
        
}

}
     