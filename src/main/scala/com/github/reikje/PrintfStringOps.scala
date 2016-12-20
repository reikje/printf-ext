package com.github.reikje

import com.github.reikje.specifiers._

import scala.collection.mutable

/**
  * [[com.github.reikje.PrintfStringOps]] adds a new method '''formatx''' to the String class via implicit conversions.
  *
  * @author rschatz
  */
object PrintfStringOps {
  private val pattern = "\\%[\\w]+".r

  private lazy val conversions: Iterable[SupportedStringConversion] = {
    UnsignedDecimalInteger :: UnsignedLongLongInteger :: UnsignedHexadecimalInteger :: PointerAddress :: Nil
  }

  private val stringSpecifier = "%s"

  implicit class AdditionalSpecifiers(val s: String) {
    def formatx(args: Any*): String = {
      if (args != null) {
        val occurences = mutable.Map.empty[String, Int]
        var arguments = args.toList
        pattern.findAllIn(s).zipWithIndex.foreach {
          case (specifier, i) =>
            if (i < arguments.size) {
              conversions.find(conversion => conversion.specifier == specifier) match {
                case Some(conversion) =>
                  val count = occurences.getOrElse(specifier, 0)
                  occurences.put(specifier, count + 1)
                  arguments = arguments.updated(i, conversion.convert(arguments(i)))
                case _ =>
                  // do nothing
              }
            }
        }

        // for each of the supported specifiers replace as many we had arguments for with %s, so we get
        // the correct MissingFormatArgumentException if the user didn't specify enough args
        val patched = occurences.keys.foldLeft(s) {
          case (current, key) =>
            Range(0, occurences.getOrElse(key, 0)).foldLeft(current) {
              case (now, _) => now.replaceFirst(key, stringSpecifier)
            }
        }
        patched.format(arguments :_ *)
      } else {
        s.format(args)
      }
    }
  }
}
