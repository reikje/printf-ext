package me.rschatz

import org.scalatest.{Matchers, WordSpec}
import PrintfStringOps._

class PrintfStringOpsSpec extends WordSpec with Matchers {
  "PrintfStringOps" should {
    "support %u" in {
      "Foo %u Bar".formatx(1) shouldBe "Foo 1 Bar"
      "Foo%s %u Bar".formatx("s", 1) shouldBe "Foos 1 Bar"
      "Foo%s %u%s%u Bar".formatx("s", 1, "t", 2) shouldBe "Foos 1t2 Bar"
      "Foo%s %u%u".formatx("s", 1, 2) shouldBe "Foos 12"
      "Foo %u Bar".formatx(-1) shouldBe "Foo 18446744073709551615 Bar"
      "Foo %u Bar%s".formatx(-1, "s", 1) shouldBe "Foo 18446744073709551615 Bars"
    }
  }
}
