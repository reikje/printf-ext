package com.github.reikje.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%p''' specifiers.
  *
  * @author rschatz
  */
object PointerAddress extends UnsignedNumericConversion {
  override protected val complement: BigInteger = BigInteger.ONE.shiftLeft(64)

  /**
    * Returns '''%p'''.
    *
    * @return String
    */
  override val specifier: String = "%p"

  override protected def asString(value: BigInteger): String = s"0x${value.toString(16)}"
}
