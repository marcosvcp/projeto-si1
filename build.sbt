name := "projeto-si1"

version := "1.0-SNAPSHOT"

libraryDependencies += "postgresql" % "postgresql" % "8.4-702.jdbc4"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
