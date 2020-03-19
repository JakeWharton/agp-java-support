package com.jakewharton.javaversions

import com.google.common.truth.StringSubject
import com.google.common.truth.Truth.assertThat
import com.jakewharton.javaversions.AgpVersion.AGP_3_4
import com.jakewharton.javaversions.AgpVersion.AGP_3_5
import com.jakewharton.javaversions.AgpVersion.AGP_3_6
import org.gradle.testkit.runner.GradleRunner
import org.junit.Assume.assumeTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import java.io.File

@RunWith(Parameterized::class)
class AgpTest(private val agpVersion: AgpVersion) {
  companion object {
    @JvmStatic
    @Parameters(name = "{0}")
    fun parameters() = AgpVersion.values()
  }

  @Test fun java7() {
    gradleRunner("java7") {
      run("clean", "assembleRelease")
    }
  }

  @Test fun java8() {
    gradleRunner("java8") {
      run("clean", "assembleRelease")
    }
  }

  @Test fun java9() {
    assumeTrue(javaVersion() >= 9)

    gradleRunner("java9") {
      run("clean", "assembleRelease")
    }
  }

  @Test fun java10() {
    assumeTrue(javaVersion() >= 10)

    gradleRunner("java10") {
      run("clean", "assembleRelease")
    }
  }

  @Test fun java11() {
    assumeTrue(javaVersion() >= 11)

    gradleRunner("java11") {
      run("clean", "assembleRelease")
    }
  }

  @Test fun java12() {
    assumeTrue(javaVersion() >= 12)

    gradleRunner("java12") {
      run("clean", "compileReleaseJavaWithJavac")
      if (agpVersion < AGP_3_6) {
        run("assembleRelease")
      } else {
        runAndFail("assembleRelease") {
          contains("Unsupported class file version: 56")
        }
      }
    }
  }

  @Test fun java12WithPreview() {
    assumeTrue(javaVersion() == 12)

    gradleRunner("java12-with-preview") {
      run("clean", "compileReleaseJavaWithJavac")
      if (agpVersion < AGP_3_6) {
        run("assembleRelease")
      } else {
        runAndFail("assembleRelease") {
          contains("Unsupported class file version: 56")
        }
      }
    }
  }

  @Test fun java13() {
    assumeTrue(javaVersion() >= 13)

    gradleRunner("java13") {
      run("clean", "compileReleaseJavaWithJavac")
      if (agpVersion == AGP_3_5) {
        run("assembleRelease")
      } else {
        runAndFail("assembleRelease") {
          if (agpVersion == AGP_3_4) {
            contains("Unsupported class file major version 57")
          } else {
            contains("Unsupported class file version: 57")
          }
        }
      }
    }
  }

  @Test fun java13WithPreview() {
    assumeTrue(javaVersion() == 13)

    gradleRunner("java13-with-preview") {
      run("clean", "compileReleaseJavaWithJavac")
      if (agpVersion == AGP_3_5) {
        run("assembleRelease")
      } else {
        runAndFail("assembleRelease") {
          if (agpVersion == AGP_3_4) {
            contains("Unsupported class file major version 57")
          } else {
            contains("Unsupported class file version: 57")
          }
        }
      }
    }
  }

  @Test fun java14() {
    assumeTrue(javaVersion() >= 14)

    gradleRunner("java14") {
      run("clean", "compileReleaseJavaWithJavac")
      runAndFail("assembleRelease") {
        contains("Unsupported class file major version 58")
      }
    }
  }

  @Test fun java14WithPreview() {
    assumeTrue(javaVersion() == 14)

    gradleRunner("java14-with-preview") {
      run("clean", "compileReleaseJavaWithJavac")
      runAndFail("assembleRelease") {
        contains("Unsupported class file major version 58")
      }
    }
  }

  private fun gradleRunner(dir: String, dsl: GradleDsl.() -> Unit) {
    val runner = GradleRunner.create()
        .withProjectDir(File("projects/$dir"))
    GradleDsl(runner).dsl()
  }

  inner class GradleDsl(private val runner: GradleRunner) {
    private val commonArguments = arrayOf(
        "-DagpVersion=${agpVersion.fullVersion}"
    )

    fun run(vararg tasks: String) {
      val result = runner
          .withArguments(*tasks, *commonArguments)
          .build()
      assertThat(result.output).doesNotContain("Defaulting to latest AGP")
    }

    fun runAndFail(vararg tasks: String, assert: StringSubject.() -> Unit) {
      val result = runner
          .withArguments(*tasks, *commonArguments)
          .buildAndFail()
      assertThat(result.output).apply {
        doesNotContain("Defaulting to latest AGP")
        assert()
      }
    }
  }

  private fun javaVersion(): Int {
    val full = System.getProperty("java.version")
    val major = if (full.startsWith("1.")) {
      full.substring(2, 3)
    } else {
      full.substringBefore('.')
    }
    return major.toInt()
  }
}
