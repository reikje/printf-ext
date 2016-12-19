package me.rschatz.specifiers

import java.math.BigInteger

/**
  * Converts unsigned numerics.
  *
  * @author rschatz
  */
trait UnsignedNumericConversion extends SupportedStringConversion {
  protected val complement: BigInteger

  override def convert(value: Any): String = {
    val x = new BigInteger(value.toString)
    val out = if (x.compareTo(BigInteger.ZERO) < 0) {
      x.add(complement)
    } else {
      x
    }
    out.toString
  }
}
