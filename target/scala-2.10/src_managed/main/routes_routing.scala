// @SOURCE:C:/Users/Dinho/si1/projeto-si1/conf/routes
// @HASH:b2afa8d9a0198d4b712f7b435c655d610cfb9651
// @DATE:Thu Mar 20 23:30:49 GMT-03:00 2014


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
private[this] lazy val controllers_Application_authenticate6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:17
private[this] lazy val controllers_Application_logout7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remCadeira/$cadeira<[^/]+>""","""controllers.Application.remCadeira(cadeira:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>""","""controllers.Application.addCadeira(cadeira:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Application_authenticate6(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:17
case controllers_Application_logout7(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        
}

}
     