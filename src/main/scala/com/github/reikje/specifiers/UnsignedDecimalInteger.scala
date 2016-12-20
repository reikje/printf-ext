package com.github.reikje.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%u''' specifiers.
  *
  * @author rschatz
  */
object UnsignedDecimalInteger extends UnsignedNumericConversion {
  override protected val complement: BigInteger = BigInteger.ONE.shiftLeft(32)

  /**
    * Returns '''%u'''.
    *
    * @return String
    */
  override val specifier: String = "%u"
}
