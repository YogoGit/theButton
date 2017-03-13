name := "theButton"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  "javax.inject" % "javax.inject" % "1",
  "mysql" % "mysql-connector-java" % "5.1.40",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "org.springframework" % "spring-aop"        % "4.1.6.RELEASE",
  "org.springframework" % "spring-context"    % "4.1.6.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.6.RELEASE",
  "org.springframework" % "spring-orm"        % "4.1.6.RELEASE",
  "org.springframework" % "spring-jdbc"       % "4.1.6.RELEASE",
  "org.springframework" % "spring-tx"         % "4.1.6.RELEASE",
  "org.webjars" % "bootstrap" % "2.1.1",
  "org.webjars" % "jquery" % "1.11.2",
  "org.springframework" % "spring-test"       % "4.1.6.RELEASE" % "test",
  "javax.el" % "el-api" % "2.2" % "test",
  "org.glassfish.web" % "el-impl" % "2.2" % "test"
)

// More verbose JUnit test output
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
