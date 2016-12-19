package me.rschatz.specifiers

import org.scalatest.{Matchers, WordSpec}

class PointerAddressSpec extends WordSpec with Matchers {
  "PointerAddress" should {
    "support conversion of unsigned 64-bit numbers" in {
      PointerAddress.convert(1L) shouldBe "0x1"
      PointerAddress.convert(1) shouldBe "0x1"
      PointerAddress.convert(Long.MinValue) shouldBe "0x8000000000000000"
      PointerAddress.convert(-1) shouldBe "0xffffffffffffffff"
    }
  }
}
