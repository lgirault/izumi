package izumi.distage.testkit.services.dstest

import izumi.fundamentals.platform.logging

object DebugProperties extends logging.DebugProperties {
  /** Scan classpath only once per test run */
  final val `izumi.distage.testkit.environment.memoize` = "izumi.distage.testkit.environment.memoize"
}