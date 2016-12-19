package me.rschatz.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%x''' specifiers.
  *
  * @author rschatz
  */
object UnsignedHexadecimalInteger extends UnsignedNumericConversion {
  override protected val complement: BigInteger = BigInteger.ONE.shiftLeft(32)

  /**
    * Returns '''%x'''.
    *
    * @return String
    */
  override val specifier: String = "%x"

  override protected def asString(value: BigInteger): String = value.toString(16)
}
