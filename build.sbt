scalaVersion := "2.13.0"

libraryDependencies := Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.11.714",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "com.auth0" % "java-jwt" % "3.3.0",
  "org.typelevel" %% "cats-core" % "2.1.0",
  "org.scalacheck" %% "scalacheck" % "1.14.3" % Test
)
