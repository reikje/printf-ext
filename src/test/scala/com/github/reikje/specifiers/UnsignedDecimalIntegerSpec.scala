package com.github.reikje.specifiers

import org.scalatest.{Matchers, WordSpec}

class UnsignedDecimalIntegerSpec extends WordSpec with Matchers {
  "UnsignedDecimalInteger" should {
    "support conversion of unsigned 32-bit numbers" in {
      UnsignedDecimalInteger.convert(1) shouldBe "1"
      UnsignedDecimalInteger.convert(100) shouldBe "100"
      UnsignedDecimalInteger.convert(Integer.MIN_VALUE) shouldBe s"${Integer.MAX_VALUE + 1L}"
      UnsignedDecimalInteger.convert(-1) shouldBe "4294967295"
    }
  }
}
