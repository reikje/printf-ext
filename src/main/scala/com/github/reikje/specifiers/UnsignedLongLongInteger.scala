package com.github.reikje.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%llu''' specifiers.
  *
  * @author rschatz
  */
object UnsignedLongLongInteger extends UnsignedNumericConversion {
  override protected val complement: BigInteger = BigInteger.ONE.shiftLeft(64)

  /**
    * Returns '''%llu'''.
    *
    * @return String
    */
  override val specifier: String = "%llu"
}
