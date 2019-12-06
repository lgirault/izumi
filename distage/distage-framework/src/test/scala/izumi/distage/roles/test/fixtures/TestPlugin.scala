package izumi.distage.roles.test.fixtures

import cats.effect.IO
import izumi.distage.config.ConfigModuleDef
import izumi.distage.model.definition.StandardAxis._
import izumi.distage.effect.modules.CatsDIEffectModule
import izumi.distage.plugins.PluginDef
import izumi.distage.roles.internal.{ConfigWriter, Help}
import izumi.distage.roles.test.fixtures.Fixture._
import izumi.distage.roles.test.fixtures.TestPlugin.{InheritedCloseable, NotCloseable}
import izumi.distage.roles.test.fixtures.TestRole00.{IntegrationOnlyCfg, TestRole00Resource, TestRole00ResourceIntegrationCheck}
import izumi.fundamentals.platform.resources.ArtifactVersion

class TestPlugin extends CatsDIEffectModule with PluginDef with ConfigModuleDef {
  tag(Env.Prod)

  private val version = Option(System.getProperty(TestPlugin.versionProperty)) match {
    case Some(value) =>
      value
    case None =>
      s"0.0.0-${System.currentTimeMillis()}"
  }

  make[ArtifactVersion].named("launcher-version").from(ArtifactVersion(version))
  many[Dummy]

  make[TestTask00[IO]]
  make[TestRole00[IO]]
  make[TestRole01[IO]]
  make[TestRole02[IO]]

  make[TestRole00Resource[IO]]
  make[TestRole00ResourceIntegrationCheck]

  make[NotCloseable].from[InheritedCloseable]
  make[ConfigWriter[IO]]
  make[Help[IO]]

  makeConfig[TestServiceConf]("testservice")
  makeConfig[IntegrationOnlyCfg]("integrationOnlyCfg")
}

object TestPlugin {
  trait NotCloseable
  final val versionProperty = "launcher-version-test"

  class InheritedCloseable extends NotCloseable with AutoCloseable {
    override def close(): Unit = {}
  }
}
