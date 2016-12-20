package com.github.reikje.specifiers

import org.scalatest.{Matchers, WordSpec}

class UnsignedHeximalIntegerSpec extends WordSpec with Matchers {
  "UnsignedHexadecimalInteger" should {
    "support conversion of unsigned 32-bit numbers" in {
      UnsignedHexadecimalInteger.convert(1) shouldBe "1"
      UnsignedHexadecimalInteger.convert(100) shouldBe "64"
      UnsignedHexadecimalInteger.convert(-1) shouldBe "ffffffff"
    }
  }
}
