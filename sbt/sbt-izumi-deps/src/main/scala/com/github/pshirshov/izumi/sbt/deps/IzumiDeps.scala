package com.github.pshirshov.izumi.sbt.deps

import sbt._



object IzumiDeps {

  object V {
    // foundation
    val scala_212 = "2.12.6"
    val scala_213 = "2.13.0-M3"

    val scala_java8_compat = "0.9.0"
    val kind_projector = "0.9.6"
    val scalatest = "3.0.5"

    val cats = "1.1.0"
    val cats_effect = "0.10.1"
    val circe = "0.9.3"
    val circe_derivation = "0.9.0-M3"
    val shapeless = "2.3.3"
    val http4s = "0.18.11"

    val scalameta = "3.7.4"
    val fast_classpath_scanner = "2.21"
    val fastparse = "1.0.0"

    val slf4j = "1.7.25"
    val typesafe_config = "1.3.3"

    // good to drop
    val cglib_nodep = "3.2.6"
    val json4s = "3.5.3"
    val scopt = "3.7.0"

    // unused
    val better_files = "3.4.0"
    val kamon_core = "1.0.0"
    val kamon_jmx = "0.6.7"
  }

  object R {
    val scala_compiler = "org.scala-lang" % "scala-compiler" % V.scala_212
    val scala_library = "org.scala-lang" % "scala-library" % V.scala_212
    val scala_reflect = "org.scala-lang" % "scala-reflect" % V.scala_212

    //val scala_asm = "org.scala-lang.modules" % "scala-asm" % "6.0.0-scala-1"
    //val scala_arm = "com.jsuereth" %% "scala-arm" % "2.0"

    private val scala_java8_compat = "org.scala-lang.modules" %% "scala-java8-compat" % V.scala_java8_compat
    val essentials = Seq(scala_java8_compat)


    val kind_projector = "org.spire-math" % "kind-projector" % V.kind_projector cross CrossVersion.binary

    val better_files = "com.github.pathikrit" %% "better-files" % V.better_files

    val fast_classpath_scanner = "io.github.lukehutch" % "fast-classpath-scanner" % V.fast_classpath_scanner

    val typesafe_config = "com.typesafe" % "config" % V.typesafe_config

    val kamon = Seq(
      "io.kamon" %% "kamon-core" % V.kamon_core
      , "io.kamon" %% "kamon-jmx" % V.kamon_jmx
    )

    val cats_kernel = "org.typelevel" %% "cats-kernel" % V.cats
    val cats_all: Seq[ModuleID] = Seq(
      "org.typelevel" %% "cats-core"
    ).map(_ % V.cats) ++ Seq(
      "org.typelevel" %% "cats-effect"
    ).map(_ % V.cats_effect)


    val scalameta = "org.scalameta" %% "scalameta" % V.scalameta

    // TODO: can't shade scalameta https://github.com/coursier/coursier/issues/801
    val cglib_nodep = "cglib" % "cglib-nodep" % V.cglib_nodep
    // TODO: It would be good to completely get rid of cglib and build our own proxy generator on top of scala-asm
    val fastparse = "com.lihaoyi" %% "fastparse" % V.fastparse % "shaded"


    val json4s_native = "org.json4s" %% "json4s-native" % V.json4s
    val shapeless = "com.chuusai" %% "shapeless" % V.shapeless


    val circe: Seq[ModuleID] = Seq(
      "io.circe" %% "circe-core"
      , "io.circe" %% "circe-generic"
      , "io.circe" %% "circe-generic-extras"
      , "io.circe" %% "circe-parser"
      , "io.circe" %% "circe-java8"
    ).map(_ % V.circe) ++ Seq(
      "io.circe" %% "circe-derivation" % V.circe_derivation)

    val http4s_client: Seq[ModuleID] = Seq(
      "org.http4s" %% "http4s-blaze-client"
    ).map(_ % V.http4s)
    val http4s_server: Seq[ModuleID] = Seq(
      "org.http4s" %% "http4s-dsl"
      , "org.http4s" %% "http4s-circe"
      , "org.http4s" %% "http4s-blaze-server"
    ).map(_ % V.http4s)

    val http4s_all: Seq[ModuleID] = http4s_server ++ http4s_client


    val slf4j_api = "org.slf4j" % "slf4j-api" % V.slf4j
    val slf4j_simple = "org.slf4j" % "slf4j-simple" % V.slf4j

    val scopt = "com.github.scopt" %% "scopt" % V.scopt

  }

  object T {
    private val scalatest = "org.scalatest" %% "scalatest" % V.scalatest % "test"

    val scala_compiler = R.scala_compiler % "test"
    val slf4j_simple = R.slf4j_simple % "test"

    val essentials = Seq(scalatest)

    val circe: Seq[ModuleID] = R.circe.map(_ % "test")
    val cats_all: Seq[ModuleID] = R.cats_all.map(_ % "test")
  }

}

object IzumiDepsPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val IzumiRootDeps: IzumiDeps.type = com.github.pshirshov.izumi.sbt.deps.IzumiDeps
  }
}
