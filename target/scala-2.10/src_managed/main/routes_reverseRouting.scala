// @SOURCE:/home/marcos/Documents/projeto-test/conf/routes
// @HASH:020b4988901de67faeca0577f7e795657f850533
// @DATE:Sun Apr 06 00:19:24 BRT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def atualizaPeriodo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "atualizaPeriodo")
}
                                                

// @LINE:24
def mostraGradeUsuario(email:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "GradeDoUsuario" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("email", email)))))
}
                                                

// @LINE:17
def cadastroPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cadastro")
}
                                                

// @LINE:23
def mostraPlanosDosUsuarios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "RedeSocial")
}
                                                

// @LINE:13
def addCadeira(cadeira:String, periodo:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addCadeira/" + implicitly[PathBindable[String]].unbind("cadeira", dynamicString(cadeira)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:20
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:18
def cadastro(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cadastro")
}
                                                

// @LINE:12
// @LINE:11
def remCadeira(cadeira:String): Call = {
   (cadeira: @unchecked) match {
// @LINE:11
case (cadeira) if true => Call("GET", _prefix + { _defaultPrefix } + "remCadeira/" + implicitly[PathBindable[String]].unbind("cadeira", dynamicString(cadeira)))
                                                        
// @LINE:12
case (cadeira) if true => Call("POST", _prefix + { _defaultPrefix } + "remCadeira/" + implicitly[PathBindable[String]].unbind("cadeira", dynamicString(cadeira)))
                                                        
   }
}
                                                

// @LINE:25
def pesquisa(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "RedeSocial")
}
                                                

// @LINE:19
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:16
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def atualizaPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.atualizaPeriodo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "atualizaPeriodo"})
      }
   """
)
                        

// @LINE:24
def mostraGradeUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.mostraGradeUsuario",
   """
      function(email) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "GradeDoUsuario" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email)])})
      }
   """
)
                        

// @LINE:17
def cadastroPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.cadastroPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastro"})
      }
   """
)
                        

// @LINE:23
def mostraPlanosDosUsuarios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.mostraPlanosDosUsuarios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "RedeSocial"})
      }
   """
)
                        

// @LINE:13
def addCadeira : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addCadeira",
   """
      function(cadeira,periodo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addCadeira/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cadeira", encodeURIComponent(cadeira)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:20
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:18
def cadastro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.cadastro",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastro"})
      }
   """
)
                        

// @LINE:12
// @LINE:11
def remCadeira : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.remCadeira",
   """
      function(cadeira) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remCadeira/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cadeira", encodeURIComponent(cadeira))})
      }
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remCadeira/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("cadeira", encodeURIComponent(cadeira))})
      }
      }
   """
)
                        

// @LINE:25
def pesquisa : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.pesquisa",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "RedeSocial"})
      }
   """
)
                        

// @LINE:19
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:16
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def atualizaPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.atualizaPeriodo(), HandlerDef(this, "controllers.Application", "atualizaPeriodo", Seq(), "POST", """""", _prefix + """atualizaPeriodo""")
)
                      

// @LINE:24
def mostraGradeUsuario(email:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.mostraGradeUsuario(email), HandlerDef(this, "controllers.Application", "mostraGradeUsuario", Seq(classOf[String]), "GET", """""", _prefix + """GradeDoUsuario""")
)
                      

// @LINE:17
def cadastroPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.cadastroPage(), HandlerDef(this, "controllers.Application", "cadastroPage", Seq(), "GET", """""", _prefix + """cadastro""")
)
                      

// @LINE:23
def mostraPlanosDosUsuarios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.mostraPlanosDosUsuarios(), HandlerDef(this, "controllers.Application", "mostraPlanosDosUsuarios", Seq(), "GET", """RedeSocial""", _prefix + """RedeSocial""")
)
                      

// @LINE:13
def addCadeira(cadeira:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addCadeira(cadeira, periodo), HandlerDef(this, "controllers.Application", "addCadeira", Seq(classOf[String], classOf[Int]), "POST", """""", _prefix + """addCadeira/$cadeira<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:20
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:18
def cadastro(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.cadastro(), HandlerDef(this, "controllers.Application", "cadastro", Seq(), "POST", """""", _prefix + """cadastro""")
)
                      

// @LINE:11
def remCadeira(cadeira:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.remCadeira(cadeira), HandlerDef(this, "controllers.Application", "remCadeira", Seq(classOf[String]), "GET", """""", _prefix + """remCadeira/$cadeira<[^/]+>""")
)
                      

// @LINE:25
def pesquisa(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.pesquisa(), HandlerDef(this, "controllers.Application", "pesquisa", Seq(), "POST", """""", _prefix + """RedeSocial""")
)
                      

// @LINE:19
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:16
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """Login""", _prefix + """login""")
)
                      
    
}
                          
}
        
    