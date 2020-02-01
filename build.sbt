scalaVersion := "2.13.0"

libraryDependencies := Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.11.714",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.scalacheck" %% "scalacheck" % "1.14.3" % Test
)
