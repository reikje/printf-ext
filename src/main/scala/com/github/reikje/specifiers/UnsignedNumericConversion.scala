package com.github.reikje.specifiers

import java.math.BigInteger

import scala.util.Try

/**
  * Converts unsigned numerics.
  *
  * @author rschatz
  */
trait UnsignedNumericConversion extends SupportedStringConversion {
  protected val complement: BigInteger

  override def convert(value: Any): String = {
    Try(new BigInteger(value.toString)).map { x =>
      val out = if (x.compareTo(BigInteger.ZERO) < 0) {
        x.add(complement)
      } else {
        x
      }
      asString(out)
    }.getOrElse(throw new IllegalArgumentException(s"Cannot format $value using $specifier"))
  }

  protected def asString(value: BigInteger): String = value.toString
}
