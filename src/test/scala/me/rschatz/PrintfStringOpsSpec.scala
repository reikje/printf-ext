package me.rschatz

import org.scalatest.{Matchers, WordSpec}
import PrintfStringOps._

class PrintfStringOpsSpec extends WordSpec with Matchers {
  "PrintfStringOps" should {
    "support %u" in {
      "Foo %u Bar".formatx(1) shouldBe "Foo 1 Bar"
      "Foo %u Bar".formatx(-1) shouldBe "Foo 18446744073709551615 Bar"
    }
  }
}
