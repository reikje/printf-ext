package com.github.reikje.specifiers

import org.scalatest.{Matchers, WordSpec}

class PointerAddressSpec extends WordSpec with Matchers {
  "PointerAddress" should {
    "support conversion of unsigned 64-bit numbers" in {
      PointerAddress.convert(1L) shouldBe "0000000000000001"
      PointerAddress.convert(1) shouldBe "0000000000000001"
      PointerAddress.convert(10) shouldBe "000000000000000a"
      PointerAddress.convert(16) shouldBe "0000000000000010"
      PointerAddress.convert(Long.MinValue) shouldBe "8000000000000000"
      PointerAddress.convert(-1) shouldBe "ffffffffffffffff"
    }
  }
}
