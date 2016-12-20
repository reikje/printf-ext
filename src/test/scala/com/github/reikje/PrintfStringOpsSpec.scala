package com.github.reikje

import java.util.UnknownFormatConversionException

import com.github.reikje.PrintfStringOps._
import org.scalatest.{Matchers, WordSpec}

class PrintfStringOpsSpec extends WordSpec with Matchers {
  "PrintfStringOps" should {
    "support %u" in {
      "Foo %u Bar".formatx(1) shouldBe "Foo 1 Bar"
      "Foo%s %u Bar".formatx("s", 1) shouldBe "Foos 1 Bar"
      "Foo%s %u%s%u Bar".formatx("s", 1, "t", 2) shouldBe "Foos 1t2 Bar"
      "Foo%s %u%u".formatx("s", 1, 2) shouldBe "Foos 12"
      "Foo %u Bar".formatx(-1) shouldBe "Foo 4294967295 Bar"
      "Foo %u Bar%s".formatx(-1, "s", 1) shouldBe "Foo 4294967295 Bars"
    }

    "support %u, %p, %x, %llu" in {
      "A %s brown fox jumps %u+%llu times over a lazy dog at %x (%p)".formatx("quick", 10, 2000L, 4, 4) shouldBe "A quick brown fox jumps 10+2000 times over a lazy dog at 4 (0x4)"
    }

    "retain the original specifier if not enough arguments are given" in {
      val caught = intercept[UnknownFormatConversionException] {
        "Foo%s %u%s%u Bar".formatx("s", 1)
      }
      caught.getMessage should include ("'u'")
    }
  }
}
