name := "projeto-si1"

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"  

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
