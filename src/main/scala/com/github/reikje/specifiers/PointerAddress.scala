package com.github.reikje.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%p''' specifiers.
  *
  * @author rschatz
  */
object PointerAddress extends UnsignedNumericConversion {
  override protected val complement: BigInteger = BigInteger.ONE.shiftLeft(64)

  private lazy val pad = "0000000000000000"

  /**
    * Returns '''%p'''.
    *
    * @return String
    */
  override val specifier: String = "%p"

  override protected def asString(value: BigInteger): String = {
    val converted = s"${value.toString(16)}"
    pad.substring(converted.length) + converted
  }
}
