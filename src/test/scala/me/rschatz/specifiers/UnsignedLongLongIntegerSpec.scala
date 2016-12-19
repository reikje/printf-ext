package me.rschatz.specifiers

import org.scalatest.{Matchers, WordSpec}

class UnsignedLongLongIntegerSpec extends WordSpec with Matchers {
  "UnsignedLongLongInteger" should {
    "support conversion of unsigned 64-bit numbers" in {
      UnsignedLongLongInteger.convert(1L) shouldBe "1"
      UnsignedLongLongInteger.convert(1) shouldBe "1"
      UnsignedLongLongInteger.convert(Long.MinValue) shouldBe "9223372036854775808"
      UnsignedLongLongInteger.convert(-1) shouldBe "18446744073709551615"
    }
  }
}
