package me.rschatz.specifiers

import java.math.BigInteger

/**
  * Adds support for '''%u''' specifiers.
  *
  * @author rschatz
  */
object UnsignedDecimalInteger extends SupportedStringConversion {
  private val thirtytwo = BigInteger.ONE.shiftLeft(32)

  /**
    * Returns the specifier which the subclass can convert, i.e. '''%u'''.
    *
    * @return String
    */
  override val specifier: String = "%u"

  override def convert(value: Any): String = {
    val x = new BigInteger(value.toString)
    val out = if (x.compareTo(BigInteger.ZERO) < 0) {
      x.add(thirtytwo)
    } else {
      x
    }
    out.toString
  }
}
