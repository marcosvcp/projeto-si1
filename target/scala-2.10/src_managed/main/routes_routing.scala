// @SOURCE:C:/Users/HOME/projeto-si1/conf/routes
// @HASH:f0efd0defa9e2a483d858b4e0ab8492aa82e26e1
// @DATE:Sat Mar 22 04:38:10 BRT 2014


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
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:10
private[this] lazy val controllers_Application_remCadeira2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remCadeira/"),DynamicPart("cadeira", """[^/]+""",true))))
        

// @LINE:11
private[this] lazy val controllers_Application_remCadeira3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remCadeira/"),DynamicPart("cadeira", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_Application_addCadeira4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addCadeira/"),DynamicPart("cadeira", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Application_login5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:16
private[this] lazy val controllers_Application_cadastroPage6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:17
private[this] lazy val controllers_Application_cadastro7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:18
private[this] lazy val controllers_Application_authenticate8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:19
private[this] lazy val controllers_Application_logout9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>""","""controllers.Application.addCadeira(cadeira:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Application.cadastroPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Application.cadastro()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:10
case controllers_Application_remCadeira2(params) => {
   call(params.fromPath[String]("cadeira", None)) { (cadeira) =>
        invokeHandler(controllers.Application.remCadeira(cadeira), HandlerDef(this, "controllers.Application", "remCadeira", Seq(classOf[String]),"GET", """""", Routes.prefix + """remCadeira/$cadeira<[^/]+>"""))
   }
}
        

// @LINE:11
case controllers_Application_remCadeira3(params) => {
   call(params.fromPath[String]("cadeira", None)) { (cadeira) =>
        invokeHandler(controllers.Application.remCadeira(cadeira), HandlerDef(this, "controllers.Application", "remCadeira", Seq(classOf[String]),"POST", """""", Routes.prefix + """remCadeira/$cadeira<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_Application_addCadeira4(params) => {
   call(params.fromPath[String]("cadeira", None), params.fromPath[Int]("periodo", None)) { (cadeira, periodo) =>
        invokeHandler(controllers.Application.addCadeira(cadeira, periodo), HandlerDef(this, "controllers.Application", "addCadeira", Seq(classOf[String], classOf[Int]),"POST", """""", Routes.prefix + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Application_login5(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """Login""", Routes.prefix + """login"""))
   }
}
        

// @LINE:16
case controllers_Application_cadastroPage6(params) => {
   call { 
        invokeHandler(controllers.Application.cadastroPage(), HandlerDef(this, "controllers.Application", "cadastroPage", Nil,"GET", """""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:17
case controllers_Application_cadastro7(params) => {
   call { 
        invokeHandler(controllers.Application.cadastro(), HandlerDef(this, "controllers.Application", "cadastro", Nil,"POST", """""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:18
case controllers_Application_authenticate8(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:19
case controllers_Application_logout9(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        
}

}
     