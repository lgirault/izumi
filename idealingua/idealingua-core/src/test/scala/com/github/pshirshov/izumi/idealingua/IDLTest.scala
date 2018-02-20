package com.github.pshirshov.izumi.idealingua

import java.nio.file.Paths

import com.github.pshirshov.izumi.idealingua.model.finaldef._
import com.github.pshirshov.izumi.idealingua.translator.IDLCompiler
import com.github.pshirshov.izumi.idealingua.translator.IDLCompiler.IDLSuccess
import com.github.pshirshov.izumi.idealingua.translator.toscala.FinalTranslatorScalaImpl
import org.scalatest.WordSpec


class IDLTest extends WordSpec {
  "IDL rendered" should {
    "be able to produce scala source code" in {
      assert(compiles(Model01.domain))
    }

    "support inheritance" in {
      assert(compiles(Model02.domain))
    }
  }

  private def compiles(d: DomainDefinition): Boolean = {
    val modules = new FinalTranslatorScalaImpl().translate(d)

    val compiler = new IDLCompiler(d)
    compiler.compile(Paths.get("target", "idl-" + System.currentTimeMillis())) match {
      case IDLSuccess(files) =>
        println(files.toList)
        assert(files.toSet.size == files.size)

      {
        import scala.tools.nsc.{Global, Settings}
        val settings = new Settings()
        settings.embeddedDefaults(getClass.getClassLoader)
        val isSbt = Option(System.getProperty("java.class.path")).exists(_.contains("sbt-launch.jar"))
        if (!isSbt) {
          settings.usejavacp.value = true
        }
        val g = new Global(settings)
        val run = new g.Run
        run.compile(files.map(_.toFile.getCanonicalPath).toList)
        run.runIsAt(run.jvmPhase.next)
      }

    }


  }
}
