name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"), 
  "org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final",
  "com.google.guava" % "guava" % "18.0",
  "commons-io" % "commons-io" % "2.4",
  "com.google.code.gson" % "gson" % "2.3.1",
  "mysql" % "mysql-connector-java" % "5.1.35"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true

fork in run := true

fork in run := true