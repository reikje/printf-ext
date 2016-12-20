package com.github.reikje.specifiers

trait SupportedStringConversion {
  /**
    * Returns the specifier which the subclass can convert, i.e. '''%u'''.
    * @return String
    */
  val specifier: String

  /**
    * Converts the given value into a String representation.
    * @param value a value that the subclass can convert
    * @return String
    */
  def convert(value: Any): String
}
